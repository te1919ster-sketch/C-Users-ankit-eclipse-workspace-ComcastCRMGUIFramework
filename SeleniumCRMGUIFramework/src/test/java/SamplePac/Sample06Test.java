package SamplePac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample06Test {
	
public static void main (String [] ags) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.onepagecrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		/** accepting cookies **/
		driver.findElement(By.xpath("//a[@id='wt-cli-accept-btn']")).click();
		System.out.println("1");
		/** clickin on login btn **/
		driver.findElement(By.xpath("//a[@href='https://secure.onepagecrm.com/']")).click();
		System.out.println("2");
		/** un textfield **/   
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ankit.rpee24@gmail.com");
		System.out.println("3");
		/** pwd textfield **/
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ankit@4747");
		System.out.println("4");
		/** pressing login button**/
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		System.out.println("5");
	}


}
