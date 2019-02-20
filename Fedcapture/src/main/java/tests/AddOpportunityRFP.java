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
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class AddOpportunityRFP {
	
	
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
    public void addOpportunityRFP() throws InterruptedException{
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		snapshot =new SnapshotPage(driver);
		
		
		
		login.usernameInput();
		System.out.println("Input username success");
		login.passwordInput();
		System.out.println("Input Password success");
		login.signInClick();
		
		
	    Thread.sleep(8000);
		
		dashboard.appLauncherClick();
		System.out.println("Dots clicked");
		Thread.sleep(6000);
		applaunch.fedcaptureClick();
		
		System.out.println("Fedcapture app launch clicked.");
		
		
		driver.get(driver.getCurrentUrl());
		home.opportunitiesClick();
		
		
		opportunityPage.newOpportunityClick();
		
		newOpportunity.rfpClick();
		
		newOpportunity.nextClick();
		
		
		Thread.sleep(5000);
		//snapshot.nameInput("HRT Crosworth");
		
		
		  JavascriptExecutor jse1= (JavascriptExecutor)driver;
		  jse1.executeScript("window.scrollBy(0,-250)", "");
		 
		  Thread.sleep(3000);
		snapshot.opportunitynameInput("Damien Pipes 2");
		
		
		
		
		snapshot.stageDropdown();
		
		snapshot.accountNameInput();
		//
		
		snapshot.totalContractInput("200");
		
		snapshot.rfpReleaseDateInput();
		CalenderHandle.calenderHandleDate(driver, "01/28/2019");
		
		snapshot.proposalDueDateInput();
		CalenderHandle.calenderHandleDate(driver, "03/18/2019");
		
		
		snapshot.awardDateInput();
		CalenderHandle.calenderHandleDate(driver, "04/12/2019");
		
		
		Thread.sleep(2000);
		snapshot.requirementTabClick();
		System.out.println("Requirement tab clicked");
		
		snapshot.programSummaryInput("TEST TEXT");
		
		System.out.println("Input completed");
		 JavascriptExecutor jse2= (JavascriptExecutor)driver;
		  jse2.executeScript("window.scrollBy(0,500)", "");
		
		snapshot.saveClick();
		System.out.println("Save Clicked.");
		
		//-------------Verifying Test-------------
		// //div/h2[@class='title slds-text-heading--medium']  ------failed
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
