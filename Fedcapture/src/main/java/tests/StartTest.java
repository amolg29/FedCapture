package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class StartTest  {


	public final String driverPath = "E:/chromedriver_win32/";
	public WebDriver driver;
	//public WebDriver driver2;
	 String baseurl="http://alpha.wigmoremedical.org/";

	 
	 @Parameters("browser")
		public void setup(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
			}
	 } 
			
			
			
	 @Test (priority = 1)
	public void openBrowser(){
		 
		
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	    driver=new ChromeDriver();
	   // driver2=new ChromeDriver(); 
	    driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS ); 
	    //driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
	    System.out.println("Successfully opened the browser");
	   
	}
	
    @Test (priority = 2)
	public void openLink(){
		
		driver.navigate().to(baseurl);
		//driver2.navigate().to("http://alpha.wigmoremedical.org/");
		
		
		String strPageTitle = driver.getTitle();
	    System.out.println("Page title: - "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("wigmore medical"), "Page title doesn't match");
        
		System.out.println("Successfully opened the link");
			
		
	}
	
	@Test (priority = 3)
	public void loginsession(){
		
		driver.findElement(By.xpath("id('hide')/ul[1]/li[4]/a[1]/span[1]")).click();
			
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		
		driver.findElement(By.xpath("id('ExistingCustomerEmail')")).sendKeys("anuja.tole@harriersys.com");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Email entered");
		//driver.findElement(By.xpath("id('ExistingCustomerDiv')/div[1]/div[2]/div[5]/div[2]/label[1]")).click();
		driver.findElement(By.xpath("id('ExistingCustomerDiv')/div[1]/div[2]/div[5]/div[2]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Select sele1 = new Select(driver.findElement(By.xpath("id('ddlUrn')")));
		sele1.selectByIndex(2);
		
		
		driver.findElement(By.xpath("id('ExistingCustomerDiv')")).click();
		driver.findElement(By.xpath("id('ExistingCustomerPassword')")).sendKeys("Wigmore@12");
		
		//String s=driver.findElement(By.xpath("//input[@placeholder='Gender']")).getAttribute("placeholder"); 
		//System.out.println(s);
		
		String s1=driver.findElement(By.xpath("//*[@id='TxtPinCode1']")).getAttribute("placeholder"); 
		System.out.println(s1);
		if (s1.equals("1st Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode1')")).sendKeys("1");
			System.out.println("1");
			
		}
		else if (s1.equals("2nd Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode1')")).sendKeys("2");
			System.out.println("2");
			
		}	
		else if (s1.equals("3rd Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode1')")).sendKeys("4");
			System.out.println("4");
		}
		else
		{
			driver.findElement(By.xpath("id('TxtPinCode1')")).sendKeys("5");
			System.out.println("5");
		}
		
		
		
		String s2=driver.findElement(By.xpath("//*[@id='TxtPinCode2']")).getAttribute("placeholder"); 
		System.out.println(s2);
		if (s2.equals("1st Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode2')")).sendKeys("1");
			System.out.println("1");
		}
		else if (s2.equals("2nd Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode2')")).sendKeys("2");
			System.out.println("2");
		}	
		else if (s2.equals("3rd Number"))
		{
			driver.findElement(By.xpath("id('TxtPinCode2')")).sendKeys("4");
			System.out.println("4");
		}
		else
		{
			driver.findElement(By.xpath("id('TxtPinCode2')")).sendKeys("5");
			System.out.println("5");
		}
		
		
		
		
		//driver.findElement(By.xpath("id('TxtPinCode1')")).sendKeys("2");
		//driver.findElement(By.xpath("id('TxtPinCode2')")).sendKeys("4");
//		try{
//		
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Error in PIN");
//		}
	
		
		driver.findElement(By.xpath("id('btnExistingCustomerLogin')")).click();
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize(); 
		
		//driver.findElement(By.xpath("//*[@id='pharmacy']")).click();
		
		System.out.println("Successfully opened the browser");
		
		System.out.println("Test complete");
		
		
		// TODO Auto-generated method stub

	}
	
	/* @AfterMethod
	    public void teardown(ITestResult result) throws IOException{
	    	
	    	if(ITestResult.FAILURE==result.getStatus()){
	    		
	    		Utility.captureScreenshot(driver, result.getName());
	    		driver.quit();
	    		
	    	}
	    
	    	
	    }*/
	 
	/* @AfterMethod
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
*/ 
	 /*@AfterMethod
	    public void teardown(ITestResult result) {
	    	
	         
	    	
	    	if(ITestResult.FAILURE==result.getStatus()){
	    		
	    		try {
					Utility.captureScreenshot(driver, result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		driver.quit();
	    	}
	    	else{
	    		driver.quit();
	    	}
	   
	    }*/

   
	
} 
