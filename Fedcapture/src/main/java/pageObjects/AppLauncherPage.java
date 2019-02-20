package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppLauncherPage {

	
	WebDriver driver;
	
	
	By fedcaptureApp = By.xpath("//p[text()='Default application for FedCapture Lightning users']");
	
	
	
	public AppLauncherPage(WebDriver driver) {
		
		
		this.driver = driver;
		
		
	}
	
	
	public void fedcaptureClick() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.findElement(fedcaptureApp).click();
	}
	
	
	
	
}
