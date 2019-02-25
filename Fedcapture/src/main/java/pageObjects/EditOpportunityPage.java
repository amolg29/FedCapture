package pageObjects;


import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EditOpportunityPage {


	WebDriver driver;
	
	By knowledgetocustomer = By.xpath("//input[@name='Knowledge_of_Customer__c']"); 
	
	By name = By.xpath("//input[@id='input-4']");
	
	By oppportunityName = By.xpath("//input[@name='Name']");
	
	@FindBy (xpath="//input[@id='input-13']")
	WebElement oppportunityName1;
	
	By stage = By.xpath("//lightning-input-field[@class='customRequired StageName slds-form-element']//div[@role='combobox']");
	By calender= By.xpath("//*[@id='edit-OpportunityHealth']/div[5]/div/lightning-input-field");
	
	By accountName=By.xpath("//lightning-input-field[@class='customRequired AccountId slds-form-element']//lightning-base-combobox");
	
	By accountNameCancel=By.xpath("//lightning-input-field[@class='customRequired AccountId slds-form-element']//lightning-base-combobox//button");
	
	
	
	By amount = By.xpath("//input[@name='Amount']");
	
	By rfpReleaseDate= By.xpath("//lightning-input-field[@class='customRequired FedCapture__Solicitation_Date__c slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	
	By proposalDueDate = By.xpath("//lightning-input-field[@class='customRequired FedCapture__Submission_Date__c slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	By awardDate= By.xpath("//lightning-input-field[@class='customRequired CloseDate slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	By todaysdate = By.xpath("//td[@class='slds-is-today']/span");
	
	By movedate = By.xpath("//div[@data-record='FedCapture__Period_of_Performance_Months__c']//div[@class='slds-form-element__control slds-grow']");
	
	By bottomPage = By.xpath("//div[@class='slds-modal__footer_custom']");
	
	By save = By.xpath("//div[@class='slds-modal__footer_custom']/button[@class='slds-button slds-button_brand']");
	
	By saveEdit = By.xpath("//div[@class='slds-modal__footer_custom']/button[@class='slds-button slds-button_brand ']");
	
	By editButton =By.xpath("//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']/li/a[@title='Edit']");
	
	By editicon = By.xpath("//a[@class='editicon']");
	
	By saveTop = By.xpath("//div[@class='slds-modal__header_custom']/button[@class='slds-button slds-button_brand ']");
	
	By deleteButton= By.xpath("//a[@title='Delete']");
	
	By testingtab= By.xpath("//a[@data-firsttab='Testing']");
	
	
	
	public  EditOpportunityPage(WebDriver driver) {
	
	  this.driver=driver;
  
  }
  
  
  
  public void editOpportunityName(String newName) throws InterruptedException {
	  
	  
	  Thread.sleep(2000);
	 //element.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
	  
	  driver.findElement(oppportunityName).sendKeys(Keys.chord(Keys.CONTROL, "a"), newName);
	  
		/*
		 * driver.findElement(oppportunityName).sendKeys(newName); Thread.sleep(2000);
		 * driver.findElement(oppportunityName).clear();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(oppportunityName).sendKeys(newName);
		 */
	  
	  
	  
  }
  
  
  public void editAccountNameInput() throws InterruptedException {
		
	    driver.findElement(accountNameCancel).click();
	  
	    Thread.sleep(3000);
		driver.findElement(accountName).click();
		
		Thread.sleep(1000);
		
		
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		
		
	}
  
  
  public void editTotalContractInput(String Amount) throws InterruptedException {
		
		
	 
	  Thread.sleep(2000);
	  driver.findElement(amount).sendKeys(Keys.chord(Keys.CONTROL, "a"), Amount);
			
		
	}
	
	
  
  
  
  
  
  
  public void editStageDropdown() throws InterruptedException {
		
	
		
		driver.findElement(stage).click();
		
		Thread.sleep(2000);
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		
	}
	
	
  
  public void editButtonClick() {
	  
	  
	  
	  driver.findElement(editButton).click();
	  
  }
  
  public void editRfpReleaseDateInput() throws InterruptedException {
		
		WebElement element3 = driver.findElement(movedate); 
		Actions actions3 = new Actions(driver); 
		actions3.moveToElement(element3);
		actions3.perform();
		
		try {
		driver.findElement(rfpReleaseDate).click();
		
		Thread.sleep(2000);
		
		
		} catch (ElementNotSelectableException e) {e.printStackTrace();}
		
	}
	
	
	public void editProposalDueDateInput() throws InterruptedException {
	
	
		try {
		driver.findElement(proposalDueDate).click();
		
		Thread.sleep(2000);
		
		
		} catch (ElementNotSelectableException e) {e.printStackTrace();}
		
	}

	
	public void editAwardDateInput() throws InterruptedException {
		
	
		
		try {
		driver.findElement(awardDate).click();
		
		Thread.sleep(2000);
		
		
		} catch (ElementNotSelectableException e) {e.printStackTrace();}
		
	}
	

  
  
  
  
  public void editIconClick() throws InterruptedException {
	  
	  
	  List<WebElement> myElements=driver.findElements(editicon);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
		
		
	     Actions action =new Actions(driver);
		WebElement ele= myElements.get(16);
	     action.moveToElement(ele);
		action.perform();
		
		
		Thread.sleep(2500);
				
				
		((WebElement) myElements.get(7)).click();
	  
  }
	
	
  public void footerSaveButton() {
	
		
		driver.findElement(saveEdit).click();
		
	}
	
	
  public void headerSaveButton() {
		
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(saveTop));
	  
		driver.findElement(saveTop).click();
		
	}
	
	
  public void deleteButtonClick() {
	  
	  driver.findElement(deleteButton).click();
	  
  }
	
  
  public void testingTabVerify() {
	  
	 try {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(testingtab));
	 } catch (Exception e) {e.printStackTrace();}
	 
	 
	 
	 
	System.out.println("Verified successfully");
	 
	  
  }
  
  
  
  
	
}
