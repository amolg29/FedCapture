package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommercialPage {

	WebDriver driver;
	
	//first
	By forcastCatandStage = By.xpath("//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']");
   
	//18th element
	
    By closeDate= By.xpath("//div[@class='slds-grid slds-gutters_small full cols-2 forcePageBlockSectionRow']//div[@class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']//a[@class='datePicker-openIcon display']");

    //14th
    By opportunityName = By.xpath("//div[@class='slds-grid slds-gutters_small full cols-2 forcePageBlockSectionRow']//div[@class='uiInput uiInputText uiInput--default uiInput--input']");
    
    
    By accountname= By.xpath("//div[@class='uiInput forceSearchInputLookupDesktop uiInput--default']");

    
    
    public CommercialPage(WebDriver driver) {
		
		
		this.driver = driver;
		
	}
	
    
    
    //-------------------------Actions----------------------
    
    
    
    public void forecastCatClick() throws InterruptedException {
    	
    	
    	
    	List<WebElement> myElements=driver.findElements(forcastCatandStage);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); 
		
		while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		Actions mouse = new Actions(driver);
		WebElement ele= ((WebElement) myElements.get(0));
		mouse.moveToElement(ele);
		
		System.out.println("Scrolled");
		Thread.sleep(10000);
		
		mouse.click();
		Thread.sleep(2000);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		mouse.build().perform();
		
    	
    }
    
    
    
    public void stageClick() {
    	
    	
    	
  
    	List<WebElement> myElements=driver.findElements(forcastCatandStage);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); 
		while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(1)).sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER);
    	
    
    }
    
    
    public void closedateInput() {
    	
    	
    	
    	List<WebElement> myElements=driver.findElements(closeDate);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(17)).click();
    	
    	
    }
    
    
    public void opportunityName() throws InterruptedException {
    	
    	List<WebElement> myElements=driver.findElements(opportunityName);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		Actions mouse = new Actions(driver);
		WebElement ele= ((WebElement) myElements.get(13));
		mouse.moveToElement(ele);
		Thread.sleep(2000);
		mouse.sendKeys("My Automation Test");
		
    }
    
    
    
    public void addAccountName() throws InterruptedException {
    	
    	List<WebElement> myElements=driver.findElements(accountname);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); 
		
		while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		Actions mouse = new Actions(driver);
		WebElement ele= ((WebElement) myElements.get(10));
		mouse.moveToElement(ele);
		
		
		mouse.click();
		Thread.sleep(2000);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		mouse.build().perform();
	    	
    	
    }


}
