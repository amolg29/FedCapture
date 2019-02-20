package tests;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.CalenderHandle;
import Library.Utility;
import pageObjects.AppLauncherPage;

import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class SearchBoxEdit {

	

	public final String driverPath = "F://chromedriver/";
	public WebDriver driver;
	
	
	LoginPage login;
	DashboardPage dashboard;
	AppLauncherPage applaunch;
	HomePage home;
	OpportunityPage opportunityPage;
	SnapshotPage snapshot;
	EditOpportunityPage editOpportunityPage;
	
	
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
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("locationContextEnabled", false);
		
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
    public void searchOpportunityEdit() throws InterruptedException
    {
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		snapshot=new SnapshotPage(driver);
		editOpportunityPage=new EditOpportunityPage(driver);
		
		
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

		opportunityPage.searchBoxClick("WEBSTARTER");
		
		opportunityPage.firstOpportunityClick();
		
		  
		 Thread.sleep(3000);
		
		editOpportunityPage.editIconClick();
		
		Thread.sleep(3000);
		  
		editOpportunityPage.editOpportunityName("Edited Company");
		//snapshot.opportunitynameInput("TEST EDIT");
		
		/*
		 * System.out.println("Done"); try { Thread.sleep(5000);
		 * snapshot.stageDropdown(); }catch (Exception e) {e.printStackTrace();}
		 */
		
		editOpportunityPage.editStageDropdown();
		//snapshot.stageDropdown();
		
		editOpportunityPage.editAccountNameInput();
		//snapshot.accountNameInput();
		editOpportunityPage.editTotalContractInput("123");
		//snapshot.totalContractInput("10");
		
		editOpportunityPage.editRfpReleaseDateInput();
		CalenderHandle.calenderHandleDate(driver, "05/24/2018");
		
		editOpportunityPage.editProposalDueDateInput();
		CalenderHandle.calenderHandleDate(driver, "08/22/2019");
		
		editOpportunityPage.editAwardDateInput();
		CalenderHandle.calenderHandleDate(driver, "10/18/2019");
		
		
		 JavascriptExecutor jse2= (JavascriptExecutor)driver;
		  jse2.executeScript("window.scrollBy(0,500)", "");
		
		snapshot.saveClick(); 
		WebDriverWait wait =new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='RFP Release Date']")));		
	    WebElement rfp= driver.findElement(By.xpath("//h1[@title='RFP Release Date']"));
		String actual= rfp.getText(); 
	    String expected="RFP Release Date";
	  
		Assert.assertEquals(actual, expected);

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
