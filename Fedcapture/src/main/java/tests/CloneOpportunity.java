package tests;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.ExtentReportsClass;
import Library.Utility;
import pageObjects.AppLauncherPage;
import pageObjects.ChangeRecordTypePage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class CloneOpportunity extends ExtentReportsClass {

	

	public final String driverPath = "F://chromedriver/";
	public WebDriver driver;
	
	//----------------Page Objects ----------
	
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
	// LoginPage objlogin;
	SoftAssert softassert = new SoftAssert();

	
	@BeforeTest
	public void setCapabilities() throws FileNotFoundException {

//		PrintStream out = new PrintStream(new FileOutputStream("F://output.txt"));
//		System.setOut(out);
		// System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		// create chrome instance
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		
		//-----   Capabilities
	
		// System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		// driver2=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		// driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		System.out.println("Successfully opened the browser");
		driver.navigate().to(baseurl);

		driver.manage().window().maximize();
		

	}
	
	
	
	@Test(priority = 1)
	
	public void cloneOpportunity() throws InterruptedException {
		
		test = extent.createTest("CloneOpportunity");
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		editOpportunityPage=new EditOpportunityPage(driver);
		snapshot=new SnapshotPage(driver);
		changeRecordType = new ChangeRecordTypePage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		
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
		//driver.get(driver.getCurrentUrl());
		
		
		home.opportunitiesClick();
		
		opportunityPage.firstOpportunityClick();
	    
		System.out.println("first opportunity clicked");
		Thread.sleep(2000);
	    snapshot.dropdownClick();
	    System.out.println("dropdown opportunity clicked");
	    Thread.sleep(2000);
	    
	    snapshot.cloneButtonClick();
	    System.out.println("Clone button clicked");
	    Thread.sleep(2000);
	    
	   // newOpportunity.nextClick();
	    
	    
	   WebDriverWait wait =new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CloseDate']"))); 
	   
	   
	   Thread.sleep(2000);
		/*
		 * JavascriptExecutor jse2= (JavascriptExecutor)driver;
		 * jse2.executeScript("window.scrollBy(0,-550)", "");
		 */
	  
		  
		  editOpportunityPage.headerSaveButton();
		  
		 System.out.println("Save Button Clicked"); 
		  
		  WebDriverWait wait1 =new WebDriverWait(driver, 10);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='entityNameTitle']//span")));
		  WebElement rfp=driver.findElement(By.xpath("//nav[@class='entityNameTitle']//span")); 
		  String actual= rfp.getText(); String expected="Opportunity";
		  
		  
		  Assert.assertEquals(actual, expected);
		  System.out.println("Assert Passed");
	      Thread.sleep(3000);
	      
		  driver.quit();
	}


	
	 @AfterMethod
	 public void afterMethod(ITestResult result)
	 {
	     try
	  {
	     if(result.getStatus() == ITestResult.SUCCESS)
	     {

	         //Do something here
	         System.out.println("passed **********");
	     }

	     else if(result.getStatus() == ITestResult.FAILURE)
	     {
	          //Do something here
	         System.out.println("Failed ***********");
	         Utility.captureScreenshot(driver, result.getName());
	    		driver.quit();

	     }

	      else if(result.getStatus() == ITestResult.SKIP ){

	         System.out.println("Skiped***********");

	     }
	     
	     
	 }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }

	 }
	
	 
	
	
}
