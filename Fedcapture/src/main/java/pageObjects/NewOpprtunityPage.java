package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewOpprtunityPage {

	
	WebDriver driver;
	
	
	By taskOrder = By.xpath("//span[text()='Task Order']");
	
	By Commercial = By.xpath("//span[text()='Commercial']");
	
	By newRt = By.xpath("//span[text()='New RT']");
	
	By rfp = By.xpath("//span[text()='RFP']");
	
	By next = By.xpath("//span[text()='Next']");
	
	By cancel = By.xpath("//div[@data-aura-class='forceChangeRecordTypeFooter']/button/span[text()='Cancel']");
	
	
	
	public  NewOpprtunityPage(WebDriver driver) {
		
	
		this.driver=driver;
		
	}
	
	
	// -------------Actions----------------
	
	public void taskOrderClick() {
		
		driver.findElement(taskOrder).click();
		
	}
	
	
	public void commercialClick() {
		
		driver.findElement(Commercial).click();
		
	}
		
	
	public void newRtClick() {
		
		driver.findElement(newRt).click();
		
	}
	
	public void rfpClick() {
		
		driver.findElement(rfp).click();
	}
	

	
	public void nextClick() {
		
		driver.findElement(next).click();
		
	}
	
	
	public void cancelClick() {
		
		driver.findElement(cancel).click();
		
	}
	
	
}
