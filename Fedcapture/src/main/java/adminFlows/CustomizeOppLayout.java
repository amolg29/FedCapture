package adminFlows;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AppLauncherPage;
import pageObjects.CustomizeGovConSuiteTabPage;
import pageObjects.CustomizeOppLayoutPage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class CustomizeOppLayout {


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
	CustomizeOppLayoutPage customopplayout;
	EditOpportunityPage editOppPage;
	CustomizeGovConSuiteTabPage custGovConLayout;
	
	String baseurl = "http://login.salesforce.com/";
	// LoginPage objlogin;
	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void setCapabilities() throws FileNotFoundException {

		//PrintStream out = new PrintStream(new FileOutputStream("F://output.txt"));
		//System.setOut(out);
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
		
	}


	

	@Test(priority = 1)
    public void customizeOppAddTab() throws Exception{
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		editOppPage = new EditOpportunityPage(driver);
		snapshot =new SnapshotPage(driver);
		customopplayout = new CustomizeOppLayoutPage(driver);
		custGovConLayout = new CustomizeGovConSuiteTabPage(driver);
		
		
		
		login.usernameInput();
		System.out.println("done1");
		login.passwordInput();
		System.out.println("done2");
		login.signInClick();
		
		
	    dashboard.appLauncherClick();
		System.out.println("done3");
		Thread.sleep(6000);
		
	
	    dashboard.searchInput("Customize GovCon Suite Tabs");
	    
	    Thread.sleep(3000);
	    dashboard.custGovConSuiteTab();
	    
	    
	    Thread.sleep(8000);
	    
		System.out.println("Timeout over");
		
		Thread.sleep(3000);
	    custGovConLayout.recordtypeSelect();
	    Thread.sleep(3000);
	   
	    custGovConLayout.dragAndDrop();
	    
	    Thread.sleep(3000);
	    custGovConLayout.clickSave();
	    
	    Thread.sleep(9000);
	    
	    driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
	    
	    
	    home.searchInput("TestToSucceed");
	    
	    
	    Thread.sleep(8000);
	    //opportunityPage.firstOpportunityClick();
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("window.scrollBy(0,300)", "");
	    
	    
	    Thread.sleep(3500);
	    
	    //editOppPage.testingTabVerify();
	    
	    editOppPage.snapshotTabVerify();
	    
	    driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/n/FedCapture__Customize_GovCon_Suite_Tabs");
	    
	    
	    
	    Thread.sleep(8000);
	    
		System.out.println("Timeout over");
		
		
	    custGovConLayout.recordtypeSelect();
	    Thread.sleep(3000);
	   
	    
	    custGovConLayout.revDragAndDrop();
	    
	    
	    custGovConLayout.clickSave();
	    
	    
	    

	    
	}   
	
	
	
	
	
	
	
}
