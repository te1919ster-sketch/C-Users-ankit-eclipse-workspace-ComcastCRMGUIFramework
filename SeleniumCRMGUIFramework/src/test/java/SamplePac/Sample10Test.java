package SamplePac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample10Test {
	
public static void main (String [] args) throws InterruptedException {
		
	    /** navigating to the web application **/
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.lessannoyingcrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		/** accepting cookies **/
		driver.findElement(By.xpath("//a[@id='consentBtn']")).click();
		/** clickin on login btn **/
		driver.findElement(By.xpath("(//div[text()='Log in'])[4]")).click();
		/** un textfield **/   
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("ankit.rpee24@gmail.com");
		/** pwd textfield **/
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Ankit@4747447");
		/** pressing login button**/
		driver.findElement(By.xpath("//input[@id='Login']")).click();	
		
		/** Contact module
		 * clickin on plus btn **/
		driver.findElement(By.xpath("(//div[@class='NavItemText'])[2]")).click();
		/** clickin on contact btn **/   
		driver.findElement(By.xpath("(//span[text()='Contact'])[2]")).click();
		/** con name textfield **/   
		driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys("ooo");
		/** clickin on create btn **/   
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		/** Task module
		 *  clickin on plus btn **/
		driver.findElement(By.xpath("(//div[@class='NavItemText'])[2]")).click();
		/** clickin on task btn **/   
		driver.findElement(By.xpath("(//button[@title='Task'])[2]")).click();
		/** task name textfield **/   
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iii");
		/** clickin on create btn **/   
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/** Lead module
		 *  clickin on plus btn **/
		driver.findElement(By.xpath("(//div[@class='NavItemText'])[2]")).click();
		/** clickin on lead btn **/   
		driver.findElement(By.xpath("(//button[@title='Lead'])[2]")).click();
		/** clicking on lead name textfield **/   
		driver.findElement(By.xpath("//div[@class='ContactSearchBar UserPicker_DropdownWrapper']")).click();
		/** lead name textfield **/   
		driver.findElement(By.xpath("//input[@id='ContactFilter']")).sendKeys("kll");
		/** clickin on search btn **/   
		driver.findElement(By.xpath("//div[@class='UserPicker_UserList_Wrapper']")).click();  
		/** clickin on create btn **/   
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/** loging out
		 * clickin on home btn **/   
		driver.findElement(By.xpath("(//a)[1]")).click();
		/** clickin on profile btn **/
		driver.findElement(By.xpath("//div [@class='UserBadge_Image UserBadge_Initials GRAY_COLOR_0 Large UserBadge_Image_Wrapper']")).click();
		/** clickin on logout btn **/
		driver.findElement(By.xpath("(//a[@href='/account/logout.php'])[2]")).click();
		/** closing the browser **/   
		driver.quit();
		
	}
}
