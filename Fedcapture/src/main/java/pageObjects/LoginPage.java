package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	  
	WebDriver driver;
	
	
	
	By username = By.xpath("//input[@type='email']");
	
	By password = By.xpath("//input[@type='password']");
	
	By loginButton = By.xpath("//input[@type='submit']");
	
	By rememberMecheckbox = By.xpath("//input[@type='checkbox']");
	
	By forgotPassword = By.xpath("//a[text()='Forgot Your Password?']");
	
	
	
	
	public LoginPage(WebDriver driver) {
		
		
		
		this.driver = driver;
		
		
		
		
	}
	
	
	
	public void usernameInput() {
		
		driver.findElement(username).sendKeys("appexchange@technomile.com");
		
		
		
	}
	
	
	public void passwordInput() {
		
		
		driver.findElement(password).sendKeys("dev@20131");
		
		
	}
	
	
	public void signInClick() {
	
	
	 driver.findElement(loginButton).click();
	
	
    }

	
	public void forgotPasswordClick() {
		
		
	driver.findElement(forgotPassword).click();	
		
		
	}
	
	
}
