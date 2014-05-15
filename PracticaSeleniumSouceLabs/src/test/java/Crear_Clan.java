

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.lang.Object;


public class Crear_Clan {

  public static WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
//Nuestros metodos


public void acceder_CrearClan()
{

    driver.findElement(By.linkText("PLAY")).click();
    driver.get("http://gamebattles.majorleaguegaming.com/xboxone" + "/");
    driver.findElement(By.xpath("//div[@id='subcontainer']/div[3]/div/div/div/table/tbody/tr[2]/td[2]/a/img")).click();
    driver.findElement(By.xpath("//div[@id='gb-arena-dashboard']/div/div[2]/div/div[2]/a/center/div/span")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
    driver.findElement(By.linkText("Join the Titanfall Singles Ladder")).click();
	
}

public void crearClan(String n)
{
	
	driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(n);
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    driver.findElement(By.cssSelector("img.dhx_combo_img")).click();
    driver.findElement(By.cssSelector("div.dhx_combo_list > div")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
  
  @Test
  public void testCrear_Clan() throws Exception {
    Usuario u = new Usuario("Xtactic_apache","apulmon");
	driver.get(baseUrl + "/");
	u.login(driver);
    acceder_CrearClan();
    crearClan("cochiwa");
    //WebElement element = driver.findElement(By.cssSelector("css=div.boxContent.clr"));
    //String b = element.getText();
    //Assert.isTrue(b.contains("text"));
    //Assert.assertTrue(b.equals("Congratulations !!!"));
    assertTrue((driver.findElements(By.cssSelector("css=div.boxContent.clr")).size() > 0) ? true:false); 
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


