package SamplePac;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample05Test {
	
public static void main (String [] ags) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.odoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		/** accepting cookies **/
		driver.findElement(By.xpath("//a[@id='cookies-consent-all']")).click();
		/** login  **/
		driver.findElement(By.xpath("//a[@class='nav-link']")).click();
		/** pressing contine button**/   
		driver.findElement(By.xpath("//i18n-string[text()='Continue']")).click();
		/** entering password**/
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ankit@474747");
		/** pressing search button**/
		driver.findElement(By.xpath("(//i18n-string[text()='Sign in'])[2]")).click();	
	}

}
