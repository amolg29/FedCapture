package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeRecordTypePage {

	
	WebDriver driver;
	
	By next = By.xpath("//button[@title='Next']");
	
	
	
	public ChangeRecordTypePage(WebDriver driver) {
		
		
		this.driver = driver;
	}
	
	
	
	
	public void nextButtonClick() {
		
		
		driver.findElement(next).click();
		
	}
	
	
}
