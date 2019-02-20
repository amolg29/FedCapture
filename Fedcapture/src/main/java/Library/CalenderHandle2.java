package Library;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalenderHandle2 {

	

	WebDriver driver;
	
	
	 
	 
	
    public static void calenderHandleDate(WebDriver driver,String selectdate) throws InterruptedException{
		
		  
		  System.out.println("Clicked on the date field");
		 
		
		// Please enter date in month/day/year : mm/dd/yy
					//String selectdate = "07/10/2018";
					
					@SuppressWarnings("deprecation")
					Date d =new Date(selectdate);
					SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");	
					String date =dt.format(d);
					
					System.out.println(date);
					
		            
					String split[]= date.split("/");
					System.out.println(split[0]+" "+split[1]+" "+split[2]);
					
					String month = split[0];
					System.out.println(month);
					String mon = month.toUpperCase();
					
					String day =split[1];
					System.out.println(day);

		            String year = split[2];  
		            System.out.println(year); 
		
		            String firstpart= "//table/tbody/tr/td[@aria-selected='false']/span[text()=";
		            
		            String secondpart =day+"]";
		         
		            String finalpart=firstpart+secondpart;
		            System.out.println(finalpart);
		          //------------------------------------------------
		            
		            
		            
		            ////select[@class='slds-select']
		            
		          //div[@class='slds-datepicker__filter slds-grid']//div//select
		            
		
		            
		            
		  WebElement element = driver.findElement(By.xpath("//h2[@aria-live='assertive']"));
		  
		  
		  
		  while(!element.getText().equals(mon)) {
		  
		  driver.findElement(By.xpath("//a[@class='navLink nextMonth']")).click();
		  Thread.sleep(1400); 
		  
		  }
		 
		            
		            
		   Select sel1= new Select(driver.findElement(By.xpath("//select[@class='slds-select picklist__label']")));         
		   sel1.selectByValue(year);  
		          
		          Thread.sleep(2000);
		
		          driver.findElement(By.xpath(finalpart)).click();   
		         
		          ////h2[@aria-live='assertive']
		            
		            
		            
		            
		            
		            //date pick
		            ////table/tbody/tr/td[@aria-disabled='false']/span[text()=1]
		            
		            
		
	}
	

	
}
