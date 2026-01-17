package practiceTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNG05Test {
	
	@Test(dataProvider= "getData")
	public void getProductInfoTest(String brandName, String productName) {
//        WebDriver driver= new ChromeDriver();
		WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.in/");
        
        //search product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
        
        //capture product info
        String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
        String price= driver.findElement(By.xpath(x)).getText();
        System.out.println(price);  
        
        driver.quit();
	}   
	
	@DataProvider
	public Object[][] getData(){
	//creating 2D array
	Object[][] objArr= new Object[3][2];
	
	    //hard coding thre data
	//fetching the data for 1st row
	objArr[0][0]= "iphone";
	objArr[0][1]= "iPhone 15 (128 GB) - Black";
	//fetching the data for 2nd row
	objArr[1][0]= "iphone";
	objArr[1][1]= "iPhone 14 (256 GB) - Starlight";
	//fetching the data for 3rd row
	objArr[2][0]= "iphone";
	objArr[2][1]= "iPhone 15 (256 GB) - Black";
	
	return objArr;
  }
}
