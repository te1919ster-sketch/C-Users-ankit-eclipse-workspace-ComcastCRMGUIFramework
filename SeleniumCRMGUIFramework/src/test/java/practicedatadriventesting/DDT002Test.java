package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT002Test {

	 public static void main(String[] args) throws Exception {
		 
		 //hardcoded data example
		 
         FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 Properties p= new Properties();
		 p.load(fis);
		 System.out.println(p.getProperty("browser"));
		 
		 WebDriver driver= new ChromeDriver();
		 driver.get("http://49.249.28.218:8888/");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.quit();
		 
	 }
}
