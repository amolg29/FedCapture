package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewContactPage {

	
	WebDriver driver;
	
  By lastName = By.xpath("//input[@placeholder='Last Name']");
	
  By saveButton = By.xpath("//button[@title='Save']/span");
  
  By message = By.xpath("//div[@id='auraAppcacheProgress']");
	
	public NewContactPage(WebDriver driver) {
		
		this.driver = driver;

				
	}
	
	
	public void lastNameInput(String lastname) {
		
		driver.findElement(lastName).sendKeys(lastname);
		
	} 
	
	
	public void saveButtonClick() {
		
		driver.findElement(saveButton).click();
		
	} 
	
    public void successMessage() {
    	
    	driver.findElement(lastName).getText();
    }

	
}
