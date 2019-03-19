package tests;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.Utility;
import pageObjects.AppLauncherPage;
import pageObjects.ContactPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewContactPage;

public class Contact {

	public final String driverPath = "F://chromedriver/";
	public WebDriver driver;
	
	
	LoginPage login;
	DashboardPage dashboard;
	AppLauncherPage applaunch;
	HomePage home;
	ContactPage contact;
	NewContactPage newContact;
	
	
	String baseurl = "http://login.salesforce.com/";
	// LoginPage objlogin;
	SoftAssert softassert = new SoftAssert();

	
	@BeforeTest
	public void setCapabilities() throws FileNotFoundException {

		PrintStream out = new PrintStream(new FileOutputStream("F://output.txt"));
		System.setOut(out);
		// System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
		// create chrome instance
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("locationContextEnabled", false);

	}

	@Test(priority = 1)
	public void openBrowser() {

		// System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		// driver2=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		// driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		System.out.println("Successfully opened the browser");
		driver.navigate().to(baseurl);

		driver.manage().window().maximize();
		
		
		
	}

	
	@Test(priority = 2)
    public void contact() throws InterruptedException{
	
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
	    contact=new ContactPage(driver); 
	    newContact = new NewContactPage(driver);
	
	    
	    login.usernameInput();
		System.out.println("done");
		login.passwordInput();
		System.out.println("done");
		login.signInClick();
		
		
	
		
		dashboard.appLauncherClick();
		
		applaunch.fedcaptureClick();
	
	    home.contactClick();
	    
	    contact.newContactClick();
	    
	    
	    newContact.lastNameInput("TESTSCRIPT");
	    
	    newContact.saveButtonClick();
	    
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
