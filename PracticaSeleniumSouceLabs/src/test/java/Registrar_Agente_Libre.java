import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Registrar_Agente_Libre  {


  public static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
//Nuestros metodos

public void acceder_RegistrarAgenteLibre(){
	
	driver.get("http://gamebattles.majorleaguegaming.com/xboxone" + "/");
    driver.findElement(By.xpath("//div[@id='subcontainer']/div[3]/div/div/div/table/tbody/tr/td[3]/a/img")).click();
    driver.findElement(By.cssSelector("div.blue-box > span")).click();    
    driver.findElement(By.linkText("Register as a Free Agent")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();	
}

public void RegistrarAgenteLibre(){
	
	new Select(driver.findElement(By.name("available_day"))).selectByVisibleText("Weekends");
    new Select(driver.findElement(By.name("available_time"))).selectByVisibleText("Late Night (11pm-5am)");
    driver.findElement(By.cssSelector("img.dhx_combo_img")).click();
    driver.findElement(By.cssSelector("div.dhx_combo_list > div")).click();
    new Select(driver.findElement(By.name("reason"))).selectByVisibleText("Friends & Fun");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();	
}

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegistrar_Agente_Libre() throws Exception{
	  
	 Usuario u = new Usuario("lexmin","Neserisiti360@#");  
	  
    driver.get(baseUrl + "/");
    u.login(driver);
    acceder_RegistrarAgenteLibre();
    RegistrarAgenteLibre();
 }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
