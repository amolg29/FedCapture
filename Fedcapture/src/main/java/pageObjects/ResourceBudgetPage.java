package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResourceBudgetPage {

   
	WebDriver driver;
	
	
	By startDate= By.xpath("//div[@class='slds-col--padded slds-size--12-of-12 slds-large-size--6-of-12']//div[@data-aura-class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']");
	
    By endDate = By.xpath("//div[@class='slds-col--padded slds-size--12-of-12 slds-large-size--6-of-12']//div[@data-aura-class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']"); 

    By goButton = By.xpath("//button[text()='Go']");
    
    By addOneButton = By.xpath("//div/button[text()='Add Row']");
    
    By saveRow = By.xpath("//div/button[text()='Save']");
    
    By saveExpense = By.xpath("//div/button[text()='Save Expense']");
    
    By addtwoButton = By.xpath("//div/button[text()='Add Row']");
    
    By row1Input = By.xpath("//table[@class='slds-table slds-table--bordered slds-table--cell-buffer']//input[@class='slds-input 1 0 input uiInput uiInputText uiInput--default uiInput--input']");
    
    By save = By.xpath("//button[text()='Save']");
    
    
    
    //             Add Row Pop Up
    
    
    By searchbox= By.xpath("//input[@placeholder='Search ']");
    
    By add = By.xpath("//button[text()='Add']");
    
    By emp1= By.xpath("//div[@class='slds-lookup__menu lookuplist']/ul/li");
    
    By empname = By.xpath("//div[@class='slds-lookup__menu lookuplist']/ul/li");
    
    public ResourceBudgetPage(WebDriver driver) {
		
		
		this.driver = driver;
		
	}
    
    
    
    
    public void startDateInput() {
    	
    	
    	
    	List<WebElement> myElements=driver.findElements(startDate);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(0)).click();
    	
    }
    
    
    public void endDateInput () {
    	
    	List<WebElement> myElements=driver.findElements(startDate);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(1)).click();
    	
    	
    }
    
    
    public void goButtonClick() {
    	
    	
    	driver.findElement(goButton).click();
    }
    
    
    public void addRowClick() {
    	
    	WebElement element3 = driver.findElement(saveExpense); 
		Actions actions3 = new Actions(driver); 
		actions3.moveToElement(element3);
		actions3.perform();
    	
    	
    	List<WebElement> myElements=driver.findElements(addOneButton);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(0)).click();
    
    	
    	
    }
    
    
    public void labourCategoryInput() throws InterruptedException {
    	
         List<WebElement> myElements=driver.findElements(searchbox);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(0)).click();
    	
		
		Thread.sleep(2000);
		
		driver.findElement(emp1).click();
    	
    }
    
    
    public void employeeInput() {
    	
        List<WebElement> myElements=driver.findElements(searchbox);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(1)).click();
   	
		
		driver.findElement(empname).click();
   	
   }
    
    
    
    public void Add() {
    	
    	driver.findElement(add).click();
    }
    
    
    public void rowInput() {
    	
    	
    	driver.findElement(row1Input).sendKeys("18");
    }
    
    
    public void savefirstClick() {
    	
    	
    	 List<WebElement> myElements=driver.findElements(save);
 		
 		System.out.println(myElements.size());
 		
 		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
 			
 			
 			System.out.println(itr.next().getText());
 		}
 	
 		((WebElement) myElements.get(0)).click();
    	
    	
    	
    }
    
    
    public void saveExpenseClick() {
    	
    	
    	driver.findElement(saveExpense).click();
    }
    
    
    
}
