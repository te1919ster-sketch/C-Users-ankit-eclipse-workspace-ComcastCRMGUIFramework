package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT003Test {

	 public static void main(String[] args) throws Exception {
		 
		 //data driven testing example
		 // here we are fetching tbe data from external .properties file
		 
         FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 Properties p= new Properties();
		 p.load(fis);
		 
		 String bwsr= p.getProperty("browser");
		 String url= p.getProperty("url");
		 String un= p.getProperty("un");
		 String pwd= p.getProperty("pwd");
		  
		 WebDriver driver= new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("user_name")).sendKeys(un);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.quit();
		 
	 }
}
