package tests;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.CalenderHandle2;
import pageObjects.AppLauncherPage;
import pageObjects.ChangeRecordTypePage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.ResourceBudgetPage;
import pageObjects.SnapshotPage;

public class BudgetHandleRed {
	
	
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
		
		
		

	}

	
	@Test (priority= 1)
	public void budgetHandleRed() throws InterruptedException {
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home = new HomePage(driver);
		opportunityPage = new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		snapshot = new SnapshotPage(driver);
		editOpportunityPage = new EditOpportunityPage(driver);
        changeRecordType = new ChangeRecordTypePage(driver);
		resourceBudget = new ResourceBudgetPage(driver);
		
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
		
		
		home.opportunitiesClick();
		
		opportunityPage.firstOpportunityClick();
		Thread.sleep(10000);
		
		
		
		
		snapshot.resourceBudgetClick();
		
		Thread.sleep(5000);
		
		resourceBudget.startDateInput();
		CalenderHandle2.calenderHandleDate(driver, "02/19/2019");
		
		Thread.sleep(4000);
		
		resourceBudget.endDateInput();
		CalenderHandle2.calenderHandleDate(driver, "02/05/2019");
		
		Thread.sleep(4000);
		resourceBudget.goButtonClick();
		
		Thread.sleep(4000);
		resourceBudget.addRowClick();
		
		Thread.sleep(4000);
		resourceBudget.labourCategoryInput();
		Thread.sleep(4000);
		
		resourceBudget.employeeInput();
		Thread.sleep(4000);
		
		resourceBudget.Add();
		Thread.sleep(4000);
		
		resourceBudget.row1Input("48");
		Thread.sleep(3000);
		
	    //resourceBudget.colorcheck();
		
		
		resourceBudget.row2Input("48");
		Thread.sleep(3000);
		
		
		
		
		resourceBudget.savefirstClick();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		resourceBudget.colorcheck();
		
		
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,500)");

		Thread.sleep(2000);
		resourceBudget.saveExpenseClick();
		
	}
	
	


}
