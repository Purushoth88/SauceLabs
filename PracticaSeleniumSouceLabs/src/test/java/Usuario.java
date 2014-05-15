
import java.lang.*;
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

public class Usuario {
	
	private String nombre;
	private String password;
	//private WebDriver driver;
	//private String baseUrl;
	//private boolean acceptNextAlert = true;
	//private StringBuffer verificationErrors = new StringBuffer();
	
	public Usuario(String n, String p)
	{
		nombre= n;
		password = p;
	}
	public Usuario(){}
	
	public void login(WebDriver driver)
	{
		 driver.findElement(By.id("login")).clear();
		 driver.findElement(By.id("login")).sendKeys(nombre);
		 driver.findElement(By.id("login_password")).clear();
		 driver.findElement(By.id("login_password")).sendKeys(password);
	     driver.findElement(By.name("commit")).click();
		
	}

}
