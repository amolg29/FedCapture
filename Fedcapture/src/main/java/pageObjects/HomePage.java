package pageObjects;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class HomePage {
	
	WebDriver driver;
	
	
	By opportunities = By.xpath("//a[@title='Opportunities']");
	
	By contact = By.xpath("//li[@data-id='Contact']");
	
	

	public HomePage(WebDriver driver) {
		
		
		this.driver = driver;
		
		
	}
	
   
	
	public void opportunitiesClick() {
		
		

		driver.findElement(opportunities).click();
	}
	
	
	public void contactClick() {
		
		
		driver.findElement(contact).click();
		
		
	}
	
	
	

	
	
	
	

}
