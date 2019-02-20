package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteOpportunityPage {

	WebDriver driver;
	
	By deleteClick = By.xpath("//span[text()='Delete']");
	
	
	public  DeleteOpportunityPage(WebDriver driver) {
		
		  this.driver=driver;
	  
	  }
	
	
	public void deleteConfirm() {
		
		
		driver.findElement(deleteClick).click();
		
	}
	
	
	
}
