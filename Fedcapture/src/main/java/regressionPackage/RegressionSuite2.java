package regressionPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.CalenderHandle;
import Library.CalenderHandle2;
import Library.ExtentReportsClass;
import Library.Utility;
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

public class RegressionSuite2 extends ExtentReportsClass {
	
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
		resourceBudget =new ResourceBudgetPage(driver);
        
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

	
	 @Test(priority = 1)
	  
	  public void changeRecordType() throws InterruptedException {
	  
		 test = extent.createTest("Change Record Type");
		 
		 
		   

		  Thread.sleep(3000);
		  
		  driver.navigate().to(opportunityPageurl);
	  
			opportunityPage.firstOpportunityClick();
		    
			System.out.println("first opportunity clicked");
			Thread.sleep(3000);
		    snapshot.dropdownClick();
		    System.out.println("dropdown opportunity clicked");
		    Thread.sleep(2000);
		    
		    snapshot.changeRecordTypeButtonClick();
		    System.out.println("RecordType button clicked");
		    Thread.sleep(2000);
		    
		    
		    changeRecordType.nextButtonClick();
		    System.out.println("Next button clicked");
			
		    Thread.sleep(8000);
		    snapshot.requirementTabClick();
		    
		    snapshot.programSummaryInput("TEST TEST");
		    
			
		  
		   
		   Thread.sleep(4000);
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
			
	 }
	  
	  
	 @Test(priority = 2)
	 
	 public void cloneOpportunity() throws InterruptedException {
		 
		 test = extent.createTest("Clone Opportunity");
		  
		 driver.navigate().to(opportunityPageurl);
		 
		 
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

		    
	 }

	
	
		@Test (priority = 3)
		public void deleteOpportunity() throws InterruptedException {
			
			test = extent.createTest("DeleteOpportunity");
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
		
		
		@Test (priority = 4)
		public void addOpportunityRFP() throws InterruptedException{
			
			test = extent.createTest("Add Opportunity RFP");
			driver.get(driver.getCurrentUrl());
			
			driver.navigate().to(opportunityPageurl);
			
			
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

			
			
		}
		
		
		@Test (priority = 5)
		public void addOpportunityCommercial() throws InterruptedException{
			
			test = extent.createTest("Add Opportunity Commercial");
			
			driver.get(driver.getCurrentUrl());
			
			driver.navigate().to(opportunityPageurl);
			
			
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

			
			
		}

		
		
		
		 @AfterMethod
		 public void afterMethod(ITestResult result)
		 {
		     try
		  {
		     if(result.getStatus() == ITestResult.SUCCESS)
		     {

		         //Do something here
		         System.out.println(result.getName()+" passed **********");
		     }

		     else if(result.getStatus() == ITestResult.FAILURE)
		     {
		          //Do something here
		         System.out.println(result.getName()+"Failed ***********");
		        String path= Utility.captureScreenshot(driver, result.getName());
		     	System.out.println("This is path"+path);
				String imgPath=System.getProperty("user.dir") + File.separator+path;
				System.out.println("This is final path"+imgPath);
				test.addScreenCaptureFromPath(imgPath);

		     }

		      else if(result.getStatus() == ITestResult.SKIP ){

		         System.out.println(result.getName()+"Skiped***********");

		     }
		     
		     
		 }
		    catch(Exception e)
		    {
		      e.printStackTrace();
		    }

		 }
		

	
	
	
	
	

}
