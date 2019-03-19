package regressionPackage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AppLauncherPage;
import pageObjects.ChangeRecordTypePage;
import pageObjects.ContactPage;
import pageObjects.DashboardPage;
import pageObjects.DeleteOpportunityPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewContactPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.ResourceBudgetPage;
import pageObjects.SnapshotPage;
import Library.ExtentReportsClass;

public class RegressionSuiteNew2 extends ExtentReportsClass{

	
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
	ResourceBudgetPage resourceBudget;
	ContactPage contact;
	NewContactPage newContact;
	DeleteOpportunityPage deleteopportunity;
	
	
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
		deleteopportunity= new DeleteOpportunityPage(driver);
		
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

	@Test (priority = 1)
	public void deleteOpportunity() throws InterruptedException {
		
	
		
		driver.get(driver.getCurrentUrl());	  

		  Thread.sleep(3000);
		  
		driver.navigate().to(opportunityPageurl);
		  
		opportunityPage.firstOpportunityClick();
	    
		System.out.println("first opportunity clicked");
		
		Thread.sleep(2000);
	    
		editOpportunityPage.deleteButtonClick();
		
	    System.out.println("Clicked on delete button");
	
	    Thread.sleep(2000);
		deleteopportunity.deleteConfirm();
		
	    System.out.println("Confirmed delete");
	
		
	}

	
	
	
}
