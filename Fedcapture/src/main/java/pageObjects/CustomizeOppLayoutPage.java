package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomizeOppLayoutPage {

	WebDriver driver;
	
	
	By recordTypeDropdown = By.xpath("//select[@name='j_id0:j_id8:j_id132']");
	
	By goButton = By.xpath("//input[@value='Go']");
	
	By addTab= By.xpath("//input[@value='Add Tab']");
	
	By addSection = By.xpath("//div//input[@value='Add Section']");
	
	By addField= By.xpath("//div[@data-sectionname='My Section']//input[@class='button1 bluebtn']");
	
	By headername= By.xpath("//h2[text()='At a Glance']");
	
	By save = By.xpath("//input[@value='Save']");
	
	By deleteTab = By.xpath("//li//img[@src='/resource/1522654644000/fedcapture__CustomLayout/EditLayout/img/close.png']");
	
	By confirmDeleteTab= By.xpath("//div[@class='sa-confirm-button-container']");
	
	
	//----------------------Add Tab Popup---------------------
	
	By label= By.xpath("//input[@id='tab_Label_popup']");
	
	By backgroundcolor= By.xpath("//div[@class='sp-replacer sp-light']");
	
	By choose = By.xpath("//button[text()='choose']");
	
	By addtabbutton = By.xpath("//button[@onclick='saveTab();']");
	

	
	
	//---------------Add section Popup--------------------
	
	By labelInput = By.xpath("//input[@id='sec_Label_popup']");
	
	By addsectionbutton= By.xpath("//button[@onclick='saveSection();']");
	
	
	
	//---------------Add Field Popup----------------------
	
	By fieldlabel =By.xpath("//input[@id='field_Label_popup']");
	
	By fieldApiName = By.xpath("//input[@id='field_apiName_popup']");
	
	By add = By.xpath("//button[@onclick='saveField();']");
	
	
	public CustomizeOppLayoutPage(WebDriver driver) {
		
		
		this.driver= driver;
		
		
		
	}
	
	
	
	//--------------------Actions---------------------------

	
	public void recordtypeSelect() throws InterruptedException {
		
//		WebDriverWait wait =new WebDriverWait(driver, 10);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(headername));
//		
//		
//		System.out.println("visibility located");

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
	
	
	
	
	public void addTabClick() {
		
		driver.findElement(addTab).click();
		
	}
	
	
	
	public void addTabdetails(String labelname) throws InterruptedException {
		
		
		driver.findElement(label).sendKeys(labelname);
		
		Thread.sleep(3000);
		
		driver.findElement(backgroundcolor).click();
		
		Thread.sleep(3000);
		driver.findElement(choose).click();
		Thread.sleep(3000);
		
		driver.findElement(addtabbutton).click();
		
	
	}
	
	



	public void addSectionClick() {
		
List<WebElement> myElements=driver.findElements(addSection);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(myElements.size()-1)).click();
		
		
		
	}
	
	
	
	
	public void sectionlabelInput(String labelinput) throws InterruptedException {
		
		//driver.switchTo().defaultContent();
		driver.findElement(labelInput).sendKeys(labelinput);
		Thread.sleep(3000);
		driver.findElement(addsectionbutton).click();
	
	}
	
	
	
	public void addField() {
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		
		//driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/n/FedCapture__Customize_Opp_Layout");
		
List<WebElement> myElements=driver.findElements(addField);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(0)).click();
		
		
		
		
		
		//driver.findElement(addField).click();
	}
	
	
	public void addFieldPopup(String fieldname) throws InterruptedException {
		
		
		
		//driver.switchTo().defaultContent();
		
		driver.findElement(fieldlabel).sendKeys(fieldname);
		
		Thread.sleep(3000);
		
		Actions mouse = new Actions(driver);
		
		mouse.sendKeys(Keys.DOWN,Keys.ENTER).build().perform();
		
		
		driver.findElement(fieldApiName).click();
		
		Thread.sleep(3000);
		
		driver.findElement(add).click();
		
	}
	
	
	public void saveClick() {
		
		
		driver.findElement(save).click();
	}
	
	
	//public void 
	
	public void deleteTabClick() throws InterruptedException {
		
		List<WebElement> myElements=driver.findElements(deleteTab);
		
		System.out.println(myElements.size());
		
		Iterator<WebElement> itr = myElements.iterator(); while(itr.hasNext()) {
			
			
			System.out.println(itr.next().getText());
		}
	
		((WebElement) myElements.get(myElements.size()-1)).click();
		
		Thread.sleep(3000);
		
		driver.findElement(confirmDeleteTab).click();
	
		Thread.sleep(3000);
		
		driver.findElement(confirmDeleteTab).click();
		
		Thread.sleep(3000);
		
		driver.findElement(save).click();
		
	}
	
	
}
