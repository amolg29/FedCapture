package regressionPackage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.CalenderHandle;
import Library.Utility;
import pageObjects.AppLauncherPage;
import pageObjects.ChangeRecordTypePage;
import pageObjects.DashboardPage;
import pageObjects.EditOpportunityPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewOpprtunityPage;
import pageObjects.OpportunityPage;
import pageObjects.SnapshotPage;

public class RegressionSuiteM1 {

	public final String driverPath2 = "F://geckodriver/";

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

	String baseurl = "http://login.salesforce.com/";
	// LoginPage objlogin;
	SoftAssert softassert = new SoftAssert();

	@BeforeTest

	public void setCapabilities() throws FileNotFoundException, InterruptedException {

		/*
		 * PrintStream out = new PrintStream(new FileOutputStream("F://output.txt"));
		 * System.setOut(out);
		 */

		// create firefox instance
		System.setProperty("webdriver.gecko.driver", driverPath2 + "geckodriver.exe");
		driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");

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
	public void addOpportunityTask() throws InterruptedException {

		home.opportunitiesClick();

		opportunityPage.newOpportunityClick();

		newOpportunity.taskOrderClick();

		newOpportunity.nextClick();

		Thread.sleep(5000);
		// snapshot.nameInput("HRT Crosworth");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		snapshot.opportunitynameInput("WEBSTARTER");

		Thread.sleep(2000);
		snapshot.stageDropdownM();

		snapshot.accountNameInput();
		

		snapshot.totalContractInput("200");

		jse.executeScript("window.scrollBy(0,1000)", "");		
		snapshot.rfpReleaseDateInput();
		CalenderHandle.calenderHandleDate(driver, "01/28/2019");

		snapshot.proposalDueDateInput();
		CalenderHandle.calenderHandleDate(driver, "03/18/2019");

		snapshot.awardDateInput();
		CalenderHandle.calenderHandleDate(driver, "04/12/2019");

		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,500)", "");

		snapshot.saveClick();

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


//	  @Test(priority = 2)
//	  
//	  public void editTest() throws InterruptedException {
//	  
//	  
//	  Thread.sleep(3000);
//	 
//	  home.opportunitiesClick();
//	  
//	 opportunityPage.firstOpportunityClick();
//	  	  
//	 JavascriptExecutor jse1= (JavascriptExecutor)driver;
//	  jse1.executeScript("window.scrollBy(0,700)");
//	 
//	 
//	 
//	 Thread.sleep(3000);
//	 
//	 editOpportunityPage.editIconClick();
//	  
//	  Thread.sleep(3000);
//	 
//	  editOpportunityPage.editOpportunityName("first Edit");
//	  //snapshot.opportunitynameInput("TEST EDIT");
//	  
//	 
//	 System.out.println("Done"); try { Thread.sleep(5000);
//	 snapshot.stageDropdown(); }catch (Exception e) {e.printStackTrace();}
//	 
//	  
//	 editOpportunityPage.editStageDropdown(); //snapshot.stageDropdown();
//	 
//	  editOpportunityPage.editAccountNameInput(); //snapshot.accountNameInput();
//	 editOpportunityPage.editTotalContractInput("123");
//	  //snapshot.totalContractInput("10");
//	  
//	  editOpportunityPage.editRfpReleaseDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "05/24/2018");
//	  
//	  editOpportunityPage.editProposalDueDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "08/22/2019");
//	  
//	  editOpportunityPage.editAwardDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "10/18/2019");
//	  
//	  System.out.println("All data selectded" );
//	
//	 JavascriptExecutor jse2= (JavascriptExecutor)driver;
//	 jse2.executeScript("window.scrollBy(0,500)", "");
//	 
//	  Thread.sleep(3000); snapshot.saveClick(); WebDriverWait wait =new
//	  WebDriverWait(driver, 10);
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.
//	  xpath("//h1[@title='RFP Release Date']"))); WebElement rfp=
//	 driver.findElement(By.xpath("//h1[@title='RFP Release Date']")); 
//	  String actual= rfp.getText(); String expected="RFP Release Date";
//	 
//	 Assert.assertEquals(actual, expected);
//	 
//	 Thread.sleep(3000); 
//	  }
//	 
//
//	@Test(priority = 3)
//	public void editButtonTest() throws InterruptedException {
//
//		driver.get(driver.getCurrentUrl());
//
//		home.opportunitiesClick();
//
//		
//		opportunityPage.firstOpportunityClick();
//
//		System.out.println("Clicked first opportunity");
//       
//		Thread.sleep(8000);
//      
//		editOpportunityPage.editButtonClick();
//
//		System.out.println("Edit Button clicked.");
//		
//		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//		jse1.executeScript("window.scrollBy(0,-250)", "");
//
//		Thread.sleep(3000);
//
//		editOpportunityPage.editOpportunityName("My Edit");
//		// snapshot.opportunitynameInput("TEST EDIT");
//
//		/*
//		 * System.out.println("Done"); try { Thread.sleep(5000);
//		 * snapshot.stageDropdown(); }catch (Exception e) {e.printStackTrace();}
//		 */
//
//		editOpportunityPage.editStageDropdown();
//		// snapshot.stageDropdown();
//
//		editOpportunityPage.editAccountNameInput();
//		// snapshot.accountNameInput();
//		editOpportunityPage.editTotalContractInput("123");
//		// snapshot.totalContractInput("10");
//
//		editOpportunityPage.editRfpReleaseDateInput();
//		CalenderHandle.calenderHandleDate(driver, "05/24/2018");
//
//		editOpportunityPage.editProposalDueDateInput();
//		CalenderHandle.calenderHandleDate(driver, "08/22/2019");
//
//		editOpportunityPage.editAwardDateInput();
//		CalenderHandle.calenderHandleDate(driver, "10/18/2019");
//
//		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
//		jse2.executeScript("window.scrollBy(0,500)", "");
//
//		snapshot.footerSaveButton();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='RFP Release Date']")));
//		WebElement rfp = driver.findElement(By.xpath("//h1[@title='RFP Release Date']"));
//		String actual = rfp.getText();
//		String expected = "RFP Release Date";
//
//		Assert.assertEquals(actual, expected);
//
//		Thread.sleep(3000);
//		//driver.quit();
//	}
//
//	
//	  @Test(priority = 4)
//	  
//	  public void markStageComplete() throws InterruptedException {
//	  
//	  driver.get(driver.getCurrentUrl()); 
//	  
//	  home.opportunitiesClick();
//	  
//	  opportunityPage.firstOpportunityClick();
//	  
//	  snapshot.markStageCompleteButtonClick();
//	  
//	  // WebElement message= //
//	  driver.findElement(By.xpath("//div[@class='forceVisualMessageQueue']//span[ text()='Stage changed successfully.']")); 
//	  WebDriverWait wait = new WebDriverWait(driver, 10);
//	  wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='forceVisualMessageQueue']//span[text()='Stage changed successfully.']")));
//	  
//	  System.out.println("located"); // driver.findElement(message).getText();
//	  
//	 WebElement successmesage = driver.findElement(By. xpath("//div[@class='forceVisualMessageQueue']//span[text()='Stage changed successfully.']")); 
//	 String actual = successmesage.getText(); 
//	 System.out.println(actual);
//	 String expected = "Stage changed successfully."; 
//	 Assert.assertEquals(actual,expected); 
//	 System.out.println("success assert.");
//	  
//	  Thread.sleep(3000); 
//	 
//	  }
//	  
//	  
//	 	  
//	
//	 
//	@Test(priority = 5) 
//	  
//	public void searchOpportunityEdit() throws InterruptedException {
//	  
//	  driver.get(driver.getCurrentUrl());
//		  
//	  home.opportunitiesClick();
//	  
//	  opportunityPage.searchBoxClick("WEBSTARTER");
//	  
//	  driver.get(driver.getCurrentUrl());
//	  
//	  opportunityPage.firstOpportunityClick();
//	  
//	  Thread.sleep(3000);
//	  
//	  JavascriptExecutor jse1= (JavascriptExecutor)driver;
//	  jse1.executeScript("window.scrollBy(0,700)");
//	 
//	 
//	 
//	 Thread.sleep(3000);
//	 
//	 editOpportunityPage.editIconClick();
//	  
//	  Thread.sleep(3000);
//	 
//	  editOpportunityPage.editOpportunityName("first Edit");
//	  //snapshot.opportunitynameInput("TEST EDIT");
//	  
//	 
//	 System.out.println("Done"); try { Thread.sleep(5000);
//	 snapshot.stageDropdown(); }catch (Exception e) {e.printStackTrace();}
//	 
//	  
//	 editOpportunityPage.editStageDropdown(); //snapshot.stageDropdown();
//	 
//	  editOpportunityPage.editAccountNameInput(); //snapshot.accountNameInput();
//	 editOpportunityPage.editTotalContractInput("123");
//	  //snapshot.totalContractInput("10");
//	  
//	  editOpportunityPage.editRfpReleaseDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "05/24/2018");
//	  
//	  editOpportunityPage.editProposalDueDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "08/22/2019");
//	  
//	  editOpportunityPage.editAwardDateInput();
//	  CalenderHandle.calenderHandleDate(driver, "10/18/2019");
//	  
//	  System.out.println("All data selectded" );
//	
//	 JavascriptExecutor jse2= (JavascriptExecutor)driver;
//	 jse2.executeScript("window.scrollBy(0,500)", "");
//	 
//	  Thread.sleep(3000); snapshot.saveClick(); WebDriverWait wait =new
//	  WebDriverWait(driver, 10);
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.
//	  xpath("//h1[@title='RFP Release Date']"))); WebElement rfp=
//	 driver.findElement(By.xpath("//h1[@title='RFP Release Date']")); 
//	  String actual= rfp.getText(); String expected="RFP Release Date";
//	 
//	 Assert.assertEquals(actual, expected);
//	 
//	 Thread.sleep(3000); 
//	  
//	  driver.quit();
//	  
//	  }
	  
	

}
