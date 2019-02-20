package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	
	WebDriver driver;
	
	
	By appLauncher = By.xpath("//div[@class='tooltipTrigger tooltip-trigger uiTooltip']/div[@class='slds-icon-waffle']");
	
	By home = By.xpath("//li[@class='tabItem slds-context-bar__item borderRight slds-is-active active hideAnimation  oneConsoleTabItem']/a[@title='Home']");
	
	By objectManager = By.xpath("//li[@class='tabItem slds-context-bar__item borderRight hasActions oneConsoleTabItem']/a[@title='Object Manager']");
	
	By lastelementload = By.xpath("//div[@class='tileNavButton']/button/span[text()='Learn More']");
			
			
	public DashboardPage(WebDriver driver) {
		
		
		this.driver= driver;
		
		
		
	}
	
	
	
	public void appLauncherClick() {
		
		 WebDriverWait wait = new WebDriverWait(driver, 25);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(lastelementload));
		driver.findElement(appLauncher).click();
			
	}
	
	 
	
	
	
	
}
