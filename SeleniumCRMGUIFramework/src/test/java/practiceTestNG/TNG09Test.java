package practiceTestNG;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TNG09Test {
	     //Assertation
	         @Test
	         public void homePageTest(Method mtd) {
	         System.out.println(mtd.getName() + "Test Starts");
	         String expectedPage= "Home Page";
	         
	         WebDriver driver=new ChromeDriver();
	         
	         // login to the app
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.get("http://49.249.28.218:8888/");
			 driver.manage().window().maximize();
			 
			 driver.findElement(By.name("user_name")).sendKeys("admin");
			 driver.findElement(By.name("user_password")).sendKeys("admin");
			 driver.findElement(By.id("submitButton")).click();
			
			 //verifying home page text
			 String actTitle= driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();	
			 
			 //hard assert
			 Assert.assertEquals(actTitle, expectedPage);
			 driver.close();
			 System.out.println(mtd.getName() + "Test Ends");
	         }
			 
			 @Test
	         public void logoHomePageTest(Method mtd) {
	         System.out.println(mtd.getName() + "Test Starts");
	         String expectedPage= "Home Page";
	         
	         WebDriver driver=new ChromeDriver();
	         
	         // login to the app
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.get("http://49.249.28.218:8888/");
			 driver.manage().window().maximize();
			 
			 driver.findElement(By.name("user_name")).sendKeys("admin");
			 driver.findElement(By.name("user_password")).sendKeys("admin");
			 driver.findElement(By.id("submitButton")).click();
			
			 // click on contact button 
			 String actTitle= driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();	
			 
			 //hard assert
			 Assert.assertEquals(actTitle, expectedPage);
			 driver.close();
			 System.out.println(mtd.getName() + "Test Ends");
			 
			 //verifying home page logo
			 boolean status= driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
			 
			 //Soft Assert 
			 Assert.assertTrue(status);
			 driver.close();
			 System.out.println(mtd.getName() + "Test Ends");
			 
             }
}
