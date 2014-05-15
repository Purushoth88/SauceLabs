

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Crear_Reto {
  public static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
//Nuestros metodos

public void acceder_CrearReto(){
	
	driver.get("http://gamebattles.majorleaguegaming.com/xboxone/titanfall/team/equipouca" + "/");
	driver.findElement(By.cssSelector("div > a > strong")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	driver.findElement(By.cssSelector("div > a > strong")).click();
	driver.findElement(By.linkText("Create a Match Finder Challenge")).click();    
}

public void CrearReto(){
	
	//driver.findElement(By.id);
	driver.findElement(By.id("field_43593_0")).click();
    driver.findElement(By.id("field_43594_0")).click();
    driver.findElement(By.id("field_43595_0")).click();
    driver.findElement(By.id("field_43596_0")).click();
    driver.findElement(By.id("field_43597_0")).click();
    driver.findElement(By.name("rules")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();	
}

public void VisualizarReto(){
	
	driver.findElement(By.linkText("View the Match Finder")).click();	
}

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCrear_Reto() throws Exception {
	  
	Usuario u = new Usuario("lexmin360","Neserisiti360@#");	  
	  
    driver.get(baseUrl + "/");
    u.login(driver);
    acceder_CrearReto();
    CrearReto();
    VisualizarReto();
    
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
