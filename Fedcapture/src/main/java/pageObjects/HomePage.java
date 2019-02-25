package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
	
	WebDriver driver;
	
	
	By opportunities = By.xpath("//a[@title='Opportunities']");
	
	By contact = By.xpath("//li[@data-id='Contact']");
	
    By search = By.xpath("//input[@placeholder='Search Opportunities and more...']");	

	public HomePage(WebDriver driver) {
		
		
		this.driver = driver;
		
		
	}
	
   
	
	public void opportunitiesClick() {
		
		

		driver.findElement(opportunities).click();
	}
	
	
	public void contactClick() {
		
		
		driver.findElement(contact).click();
		
		
	}
	
	
   public void searchInput(String input) throws InterruptedException {
	   
	   
	   driver.findElement(search).sendKeys(input);
	  
	   Thread.sleep(6000);
	   
	   Actions mouse = new Actions(driver);
	   mouse.click();
	   mouse.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
	   
	   
   }	

	
	
	
	

}
