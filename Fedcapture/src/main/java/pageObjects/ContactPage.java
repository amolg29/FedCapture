package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
	
WebDriver driver;
	
	
	By newButton = By.xpath("//div[@class='slds-col slds-no-flex slds-grid slds-align-top slds-p-bottom--xx-small test-lvmForceActionsContainer']/ul/li/a/div[@title='New']");
	
	
	public ContactPage(WebDriver driver) {
		
		
		this.driver = driver;
				
	}
	
	
	
	public void newContactClick() {
		/*
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].scrollIntoView();", element);
		 */
		driver.findElement(newButton).click();
		
	}
	
	
	
	
		
}
