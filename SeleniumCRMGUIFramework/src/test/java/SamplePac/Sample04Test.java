package SamplePac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample04Test {
	public static void main (String [] ags) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hubspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		/** accepting cookies **/
		driver.findElement(By.xpath("//button[@id='hs-eu-confirmation-button']")).click();
		/** logining **/
		driver.findElement(By.xpath("//a[@class='global-nav-utility-link cl-navLink-link ga_nav_link nav-utility-login']")).click();
		/** entering username**/
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ankit.rpee24@gmail.com");
		/** pressing contine button**/
		driver.findElement(By.xpath("//i18n-string[text()='Continue']")).click();
		//Thread.sleep(1000);
		/** entering password**/
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ankit@474747");
		/** pressing search button**/
		driver.findElement(By.xpath("(//i18n-string[text()='Sign in'])[2]")).click();
	
	
	}
}


