package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomizeGovConSuiteTabPage {

	WebDriver driver;
	
	
	By recordTypeDropdown = By.xpath("//select[@id='chooseRecordTypeId']");
	
	By goButton = By.xpath("//input[@value='Go']");
	
	By sourceSnapshot = By.xpath("//li[text()='Snapshot']");
	
	By target = By.xpath("//ul[@id='sortable2']");
	
	By save = By.xpath("//input[@value='Save']");
	
	By revsourceSnapshot= By.xpath("//li[text()='Snapshot']");
	
	By revTarget = By.xpath("//ul[@id='sortable1']"); 
	
	public CustomizeGovConSuiteTabPage(WebDriver driver){
		
		
		this.driver= driver;
		
		
		
	}
	
	
	
	public void recordtypeSelect() throws InterruptedException {
		
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		System.out.println(iFrame);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		System.out.println("Switched");
		
		
		driver.findElement(recordTypeDropdown).click();
		
		System.out.println("Clicked");
		Thread.sleep(3000);
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
		
		//driver.findElement(recordTypeDropdown).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(goButton).click();
	
		
	}
	
	
	public void dragAndDrop() {
		
		Actions actions = new Actions(driver);
		WebElement srcElement = driver.findElement(sourceSnapshot);
		WebElement targetElement = driver.findElement(target);
		actions.dragAndDrop(srcElement, targetElement); 
		actions.build().perform();
		
		
	}
	
	
	
	public void revDragAndDrop() {
		
		Actions actions = new Actions(driver);
		WebElement srcElement = driver.findElement(revsourceSnapshot);
		WebElement targetElement = driver.findElement(revTarget);
		actions.dragAndDrop(srcElement, targetElement); 
		actions.build().perform();
		
		
	}
	
	
	public void clickSave() {
		
		driver.findElement(save).click();
		
	}
	
	
	
	
	
	
	
}
