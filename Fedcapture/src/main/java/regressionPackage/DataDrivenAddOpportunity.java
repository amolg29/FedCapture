package regressionPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.CalenderHandle;

import pageObjects.AppLauncherPage;

import pageObjects.DashboardPage;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class DataDrivenAddOpportunity {


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
    public void addOpportunityDatadriven() throws InterruptedException, IOException{
		
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		applaunch = new AppLauncherPage(driver);
		home= new HomePage(driver);
		opportunityPage= new OpportunityPage(driver);
		newOpportunity = new NewOpprtunityPage(driver);
		snapshot =new SnapshotPage(driver);
	
	
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
		
		
		/*
		 * home.opportunitiesClick(); System.out.println("clicked");
		 */
		
	    
	
		//------------ Excel sheet code -------------	
		
		File src = new File("E:\\Excel\\Opportunity.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wibii = new XSSFWorkbook(fis);
		 
		XSSFSheet sh1= wibii.getSheetAt(0);	
		
		Thread.sleep(5000);
		
		for(int i=1; i<=4 ; i++){
			

			driver.navigate().to("https://fedcapture-packaging-dev-ed.lightning.force.com/lightning/o/Opportunity/list?filterName=Recent");
			
			String oppName= sh1.getRow(i).getCell(1).getStringCellValue();
			System.out.println(oppName);
			
			Cell cell;
			cell=sh1.getRow(i).getCell(2);
			
			
			String contractamount= cell.toString();
			System.out.println(contractamount);
			
			
			String rfpDate= sh1.getRow(i).getCell(3).getStringCellValue();
			System.out.println(rfpDate);
			
			String proposalDate= sh1.getRow(i).getCell(4).getStringCellValue();
			System.out.println(proposalDate);
			
			String awardDate= sh1.getRow(i).getCell(5).getStringCellValue();
			System.out.println(awardDate);
			
		
			Thread.sleep(3000);
			
			
		

		
		
		opportunityPage.newOpportunityClick();

		newOpportunity.taskOrderClick();

		newOpportunity.nextClick();
		
		driver.get(driver.getCurrentUrl());

		Thread.sleep(5000);
		// snapshot.nameInput("HRT Crosworth");

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,-250)", "");

		Thread.sleep(3000);
		snapshot.opportunitynameInput(oppName);

		snapshot.stageDropdown();

		snapshot.accountNameInput();
		//

		snapshot.totalContractInput(contractamount);

		snapshot.rfpReleaseDateInput();
		CalenderHandle.calenderHandleDate(driver, rfpDate);

		snapshot.proposalDueDateInput();
		CalenderHandle.calenderHandleDate(driver, proposalDate);

		snapshot.awardDateInput();
		CalenderHandle.calenderHandleDate(driver, awardDate);

		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,500)", "");

		snapshot.saveClick();

		Thread.sleep(5000);
		
		driver.getCurrentUrl();
		
		// //div/h2[@class='title slds-text-heading--medium'] ------failed
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='RFP Release Date']")));
		WebElement rfp = driver.findElement(By.xpath("//h1[@title='RFP Release Date']"));
		String actual = rfp.getText();
		String expected = "RFP Release Date";

		Assert.assertEquals(actual, expected);

		Thread.sleep(3000);
		// driver.quit();
			
	
		
		}



		
	
	
	
	}




	
	
		
}
