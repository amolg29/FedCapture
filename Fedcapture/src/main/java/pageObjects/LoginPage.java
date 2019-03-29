package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.beust.jcommander.Parameter;

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
	
	
	@Parameter()
	public void usernameInput() {
		
		driver.findElement(username).sendKeys("");
		
		
		
	}
	
	
	public void passwordInput() {
		
		
		driver.findElement(password).sendKeys("");
		
		
	}
	
	
	public void signInClick() {
	
	
	 driver.findElement(loginButton).click();
	
	
    }

	
	public void forgotPasswordClick() {
		
		
	driver.findElement(forgotPassword).click();	
		
		
	}
	
	
}
