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
import pageObjects.CustomizeOppLayoutPage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class CustomizeOpp {

	
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
    public void customizeOppAddTab() throws InterruptedException{
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		editOppPage = new EditOpportunityPage(driver);
		snapshot =new SnapshotPage(driver);
		customopplayout = new CustomizeOppLayoutPage(driver);
		
		
		login.usernameInput();
		System.out.println("done1");
		login.passwordInput();
		System.out.println("done2");
		login.signInClick();
		
		
	    dashboard.appLauncherClick();
		System.out.println("done3");
		Thread.sleep(6000);
		
	
	    dashboard.searchInput("Customize Opp Layout");
	    
	    Thread.sleep(3000);
	    dashboard.custOppLayoutClick();
	    
	    
	    Thread.sleep(8000);
	    
		System.out.println("Timeout over");
		
		
	    customopplayout.recordtypeSelect();
	    
	    customopplayout.addTabClick();
	    
	    Thread.sleep(2000);
	    customopplayout.addTabdetails("Testing");
	    
	    Thread.sleep(2000);
	    JavascriptExecutor jse2= (JavascriptExecutor)driver;
		  jse2.executeScript("window.scrollBy(0,300)", "");
	    
		  Thread.sleep(2000);
	    customopplayout.addSectionClick();
	    
	    Thread.sleep(3000);
	    
	    customopplayout.sectionlabelInput("My Section");
	    
	    
	    //driver.getCurrentUrl();
	    
	    Thread.sleep(2000);
	    
	    customopplayout.addField();
	    
	    customopplayout.addFieldPopup("Name");
	    
	    
	    Thread.sleep(6000);
	    customopplayout.addField();
	    
	    customopplayout.addFieldPopup("Amount");
	
	    
	    Thread.sleep(3000);
	    jse2.executeScript("window.scrollBy(300,0)", "");
	    Thread.sleep(3000);
	    customopplayout.saveClick();
	    Thread.sleep(9000);
	    
	}   
	 
	
	
	@Test(priority = 2)
	public void verifyandDeleteTab() throws InterruptedException {
	    
		
	    driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
	    
	    
	    opportunityPage.searchBoxClick("TestToSucceed");
	    
	    opportunityPage.firstOpportunityClick();
	    
	    
	    Thread.sleep(8000);
	    //opportunityPage.firstOpportunityClick();
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("window.scrollBy(0,300)", "");
	    
	    Thread.sleep(3500);
	    editOppPage.testingTabVerify();
	    
	    Thread.sleep(3000);
	    System.out.println("Verified successfully");
	    
	    //home.opportunitiesClick();
	    
	    driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/n/FedCapture__Customize_Opp_Layout");
	 
	    Thread.sleep(5000);
	    //dashboard.custOppLayoutClick();
	    
	    customopplayout.recordtypeSelect();
	    
	    Thread.sleep(4000);
	    customopplayout.deleteTabClick();
	    
	    System.out.println("Success");
	    
	    
	    
	}
	
	
	
	
	
	
	
		
	
	
	
}
