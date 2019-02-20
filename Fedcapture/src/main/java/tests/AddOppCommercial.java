package tests;

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
import pageObjects.CommercialPage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class AddOppCommercial {

	

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
    CommercialPage commercialPage;
	
	
	String baseurl = "http://login.salesforce.com/";
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

		

		// System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
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
		commercialPage =new CommercialPage(driver);
		
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

	@Test(priority=1)
	public void addCommercialopportunity() throws InterruptedException {
		
		
		home.opportunitiesClick();

		opportunityPage.newOpportunityClick();

		newOpportunity.commercialClick();
		
		newOpportunity.nextClick();
		
		
		
		Thread.sleep(6000);
		
		commercialPage.forecastCatClick();
		Thread.sleep(2000);
		
		commercialPage.opportunityName();
		Thread.sleep(2000);
		
		commercialPage.stageClick();
		Thread.sleep(2000);
		
		
		
		commercialPage.addAccountName();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
//		
//		
//		
	}
	

	
}
