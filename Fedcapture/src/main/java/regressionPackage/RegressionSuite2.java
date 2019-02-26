package regressionPackage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AppLauncherPage;
import pageObjects.ChangeRecordTypePage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class RegressionSuite2 {
	
	public final String driverPath = "F://chromedriver/";
	public WebDriver driver;

	// ----------------Page Objects ----------

	LoginPage login;
	DashboardPage dashboard;
	AppLauncherPage applaunch;
	HomePage home;
	OpportunityPage opportunityPage;
	NewOpprtunityPage newOpportunity;
	SnapshotPage snapshot;
	EditOpportunityPage editOpportunityPage;
	ChangeRecordTypePage changeRecordType;

	String baseurl = "http://login.salesforce.com/";
	String opportunityPageurl="https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent";
	
	// LoginPage objlogin;
	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void setCapabilities() throws FileNotFoundException, InterruptedException {

		/*
		 * PrintStream out = new PrintStream(new FileOutputStream("F://output.txt"));
		 * System.setOut(out);
		 */
		// System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		// create chrome instance
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable.notifications");

		// System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver(options);
		// driver2=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		// driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		System.out.println("Successfully opened the browser");
		driver.navigate().to(baseurl);

		driver.manage().window().maximize();
		
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home = new HomePage(driver);
		opportunityPage = new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		snapshot = new SnapshotPage(driver);
		editOpportunityPage = new EditOpportunityPage(driver);
        changeRecordType = new ChangeRecordTypePage(driver);
		
		
		login.usernameInput();
		System.out.println("done1");
		login.passwordInput();
		System.out.println("done2");
		login.signInClick();

		dashboard.appLauncherClick();
		System.out.println("done3");
		Thread.sleep(6000);
		applaunch.fedcaptureClick();
		System.out.println("done4");
		Thread.sleep(3000);

	}

	 @Test(priority = 1)
	  
	  public void changeRecordType() throws InterruptedException {
	  
		  driver.get(driver.getCurrentUrl());	  

		  Thread.sleep(3000);
		  
		  driver.navigate().to(opportunityPageurl);
	  
	  
	 opportunityPage.firstOpportunityClick();
	  
	  System.out.println("first opportunity clicked");
	  Thread.sleep(5000);
	  
	  snapshot.dropdownClick(); 
	  
	  System.out.println("dropdown opportunity clicked");
	  Thread.sleep(4000);
	  
	  snapshot.changeRecordTypeButtonClick();
	  System.out.println("RecordType button clicked"); 
	  Thread.sleep(4000);
	  
	  changeRecordType.nextButtonClick();
	  System.out.println("Next button clicked");
	  
	  Thread.sleep(7000);
	  
	  
	   snapshot.requirementTabClick();
	   Thread.sleep(3000);
	   
	   System.out.println("Clicked on tab");
	    
	    snapshot.programSummaryInput("TEST TEST");
	  
	    Thread.sleep(4000);
	  editOpportunityPage.headerSaveButton();
	  
	  System.out.println("Save Button Clicked");
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//nav[@class='entityNameTitle']"))); 
	  WebElement rfp = driver.findElement(By.xpath("//nav[@class='entityNameTitle']")); 
	  String actual = rfp.getText(); 
	  String expected = "Opportunity";
	 
	  Assert.assertEquals(actual, expected);
	
	  Thread.sleep(3000); // driver.quit(); 
	  }
	  
	  
	 @Test(priority = 2)
	 
	 public void cloneOpportunity() throws InterruptedException {
	 
		 driver.get(driver.getCurrentUrl());
	 
		 driver.navigate().to(opportunityPageurl);
	 
	 opportunityPage.firstOpportunityClick();
	 
	 System.out.println("first opportunity clicked");
	 Thread.sleep(4000);
	 
	 snapshot.dropdownClick(); 
	 System.out.println("dropdown opportunity clicked");
	 Thread.sleep(2000);
	 
	  snapshot.cloneButtonClick(); 
	  System.out.println("Clone button clicked");
	 Thread.sleep(2000);
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CloseDate']")));
	 
	 Thread.sleep(2000);
	  
	 JavascriptExecutor jse2= (JavascriptExecutor)driver;
	  jse2.executeScript("window.scrollBy(0,-550)", "");
	 
	 
	 editOpportunityPage.headerSaveButton();
	 
	  System.out.println("Save Button Clicked");
	 
	  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//nav[@class='entityNameTitle']//span"))); 
	  WebElement rfp =driver.findElement(By.xpath("//nav[@class='entityNameTitle']//span")); 
	  String actual = rfp.getText(); String expected = "Opportunity";
	  
	  Assert.assertEquals(actual, expected);
	  
	  Thread.sleep(3000);
	  
	  // driver.quit(); 
	  }

	
	
	
	
	
	
	

}
