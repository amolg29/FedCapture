package pageObjects;

import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OpportunityPage {
	
	
	WebDriver driver;
	
	
	By newOpportunity = By.xpath("//a[@title='New']");
	
	By firstOpprtunity = By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']");
	
	By searchBox = By.xpath("//lightning-input[@force-listviewmanagersearchbar_listviewmanagersearchbar]");
	
	
	
	public OpportunityPage(WebDriver driver) {
		
		
		this.driver=driver;
		
		
		
	}
	
	
	public void newOpportunityClick() {
		
		driver.findElement(newOpportunity).click();
		
		
	}
	
	
	
	public void firstOpportunityClick() {
		
		
		List<WebElement> myElements=driver.findElements(firstOpprtunity);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); 
		while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		System.out.println(myElements.get(0));
		((WebElement) myElements.get(0)).click();
			
	}
	
	
	public void searchBoxClick(String searchText) throws InterruptedException {
		
		driver.findElement(searchBox).sendKeys(searchText);
		
		Thread.sleep(3000);
		
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(3000);
	}
	
	
	
	

}
