package Library;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import tests.StartTest;



public class Utility extends StartTest{
	WebDriver driver;
       
	public static void captureScreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		
		org.openqa.selenium.TakesScreenshot ts= (org.openqa.selenium.TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("./Screenshots/"+screenshotname+".png"));
		System.out.println("screenshot taken");		
		
	}
	
	
	
	
}
