package pageObjects;




import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SnapshotPage {
	
	WebDriver driver;
	
	
	
	By knowledgetocustomer = By.xpath("//input[@name='Knowledge_of_Customer__c']"); 
	
	By name = By.xpath("//input[@id='input-4']");
	
	By oppportunityName = By.xpath("//input[@name='Name']");
	
	@FindBy (xpath="//input[@id='input-13']")
	WebElement oppportunityName1;
	
	By stage = By.xpath("//lightning-input-field[@class='customRequired StageName slds-form-element']//div[@role='combobox']");
	By calender= By.xpath("//*[@id='edit-OpportunityHealth']/div[5]/div/lightning-input-field");
	
	By accountName=By.xpath("//lightning-input-field[@class='customRequired AccountId slds-form-element']//lightning-base-combobox");
	
	By amount = By.xpath("//input[@name='Amount']");
	
	By rfpReleaseDate= By.xpath("//lightning-input-field[@class='customRequired FedCapture__Solicitation_Date__c slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	
	By proposalDueDate = By.xpath("//lightning-input-field[@class='customRequired FedCapture__Submission_Date__c slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	By awardDate= By.xpath("//lightning-input-field[@class='customRequired CloseDate slds-form-element']//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']");
	
	By todaysdate = By.xpath("//td[@class='slds-is-today']/span");
	
	By movedate = By.xpath("//div[@data-record='FedCapture__Period_of_Performance_Months__c']//div[@class='slds-form-element__control slds-grow']");
	
	By bottomPage = By.xpath("//div[@class='slds-modal__footer_custom']");
	
	By save = By.xpath("//div[@class='slds-modal__footer_custom']/button[@class='slds-button slds-button_brand']");
	
	By searchbox = By.xpath("//div[@class='slds-global-header__item slds-global-header__item--search']");
	
	By requirementTab = By.xpath("//li[@title='Requirements']");
	
	By programSummary = By.xpath("//div[@class='slds-form-element__control slds-grow']/textarea[@name='FedCapture__Program_Summary__c']");
	
	By saveEdit = By.xpath("//div[@class='slds-modal__footer_custom']/button[@class='slds-button slds-button_brand ']");
	
	By dropdown=By.xpath("//a[@role='button' and @title='Show 7 more actions']");
	
	By changeRecordTypeButton = By.xpath("//a[@title='Change Record Type']");
	
	By cloneButton = By.xpath("//a[@title='Clone']");
	
	By stageName= By.xpath("//a[@title='Proposal/Price Quote']");
	
	By markStageCompleteButton = By.xpath("//div[@class='slds-grid slds-path__action runtime_sales_pathassistantPathAssistantHeader']");
	
	By message = By.xpath("//div[@class='forceVisualMessageQueue']//span[text()='Stage changed successfully.']");
	
	By resourceBudgetTab = By.xpath("//li[@title='Resource Budget']");
	
	
	
	public SnapshotPage(WebDriver driver) {
		
		
		this.driver = driver;
		
	}
	
	
	
	//-----------------ACTIONS---------------------
	
	public void knowledgeToCustomerDropdown() {
		
		
	driver.findElement(knowledgetocustomer).click();
	
	Actions mouse = new Actions(driver);
		
	mouse.sendKeys(Keys.DOWN,Keys.DOWN).build().perform();	
		
	}
	
	
	public void nameInput(String Name) throws InterruptedException {
	
		
			driver.findElement(name).click();	
		driver.findElement(name).sendKeys(Name);
		
	}
	
	
	public void opportunitynameInput(String opportunityname) {
		
	
		
		driver.findElement(oppportunityName).sendKeys(opportunityname);
		 
		
	}
	
	public void stageDropdown() throws InterruptedException {
		
		
		
		
		driver.findElement(stage).click();
		
		Thread.sleep(2000);
		
		
		
		Thread.sleep(2000);
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		
		
	
		
	}
	
	
	public void accountNameInput() throws InterruptedException {
		
		
		
		driver.findElement(accountName).click();
		
		Thread.sleep(3000);
		
		driver.findElement(accountName).click();
		
		Thread.sleep(1000);
		
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		
		
	}
	
	
	public void totalContractInput(String Amount) {
		
		
		
		
		driver.findElement(amount).sendKeys(Amount);
		
		
		
	}
	
	
	public void rfpReleaseDateInput() throws InterruptedException {
		
		WebElement element3 = driver.findElement(movedate); 
		Actions actions3 = new Actions(driver); 
		actions3.moveToElement(element3);
		actions3.perform();
		
		driver.findElement(rfpReleaseDate).click();
		
	
		
	}
	
	
	public void proposalDueDateInput() throws InterruptedException {
	
	
		try {
		driver.findElement(proposalDueDate).click();
		
		Thread.sleep(3000);
		
		
		} catch (ElementNotSelectableException e) {e.printStackTrace();}
		
	}

	
	public void awardDateInput() throws InterruptedException {
		
	
		
		try {
		driver.findElement(awardDate).click();
		
		Thread.sleep(3000);
	
		} catch (ElementNotSelectableException e) {e.printStackTrace();}
		
	}
	
	
	
    public void requirementTabClick() {
    	
    	
    	
    	driver.findElement(requirementTab).click();
    	
    	
    	
    }
    
    
    
    public void programSummaryInput(String summary) {
    	
    	driver.findElement(programSummary).sendKeys(summary);
    	 	
    }
    
	
	public void saveClick() {
		
		
		
		driver.findElement(save).click();
		
	}
	
	
	public void footerSaveButton() {
		
		driver.findElement(saveEdit).click();
		
	}
	

	public void dropdownClick() {
		
		
		driver.findElement(dropdown).click();
		
	}
	
	
	public void changeRecordTypeButtonClick() {
		
		
		driver.findElement(changeRecordTypeButton).click();
		
	}
	
	
	public void cloneButtonClick() {
		
		
		driver.findElement(cloneButton).click();
		
	}
	
	
	
	public void markStageCompleteButtonClick() {
		
		
		driver.findElement(stageName).click();
		
		List<WebElement> myElements=driver.findElements(markStageCompleteButton);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(0)).click();
		
		
		
		
	}
	
	
	
	public void stageChangedVerify() {
	
	    	
		WebDriverWait wait =new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(message));
		
		System.out.println("located");
		//driver.findElement(message).getText();
		
		 WebElement successmesage= driver.findElement(By.xpath("message"));
			String actual= successmesage.getText(); 
			System.out.println("Actual.");
		    String expected="Stage changed successfully";
		    Assert.assertEquals(actual, expected);  
		System.out.println("success assert.");
		
	}
	
	
	public void resourceBudgetClick() {
		
		WebElement element3 = driver.findElement(By.xpath("//div/div[@id='OpportunityHealth']")); 
		Actions actions3 = new Actions(driver); 
		actions3.moveToElement(element3);
		actions3.perform();
		
		
		
		
		driver.findElement(resourceBudgetTab).click();
		
		
		
	}
	
	
	public void stageDropdownM() throws InterruptedException {
		
		
			driver.findElement(stage).click();
		
		Thread.sleep(2000);
		
	
		Actions mouse = new Actions(driver);
		mouse.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.ENTER)).build().perform();
		
		
		
	}
	
	
	
	
	
}
