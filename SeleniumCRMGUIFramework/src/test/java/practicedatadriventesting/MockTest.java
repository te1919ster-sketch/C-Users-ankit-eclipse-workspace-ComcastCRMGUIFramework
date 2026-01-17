package practicedatadriventesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.genericfileutilities.ExcelUtility;

public class MockTest {
	public static void main(String[] agrs) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
    ExcelUtility eLib= new ExcelUtility();
    
    // launching th website
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.manage().window().maximize();
	 driver.get("https://open.spotify.com/");
	 
	// login to the app
	 driver.findElement(By.xpath("//span[text()='Log in']")).click();
	 
	 driver.findElement(By.xpath("(//a[@style='inline-size:100%'])[1]")).click();
     driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9566323105");
	 driver.findElement(By.xpath("//span[@data-encore-id='text']")).click();
	 //driver.findElement(By.xpath("id=\"phonelogin-code")).click();
	 Thread.sleep(30000);
	 //driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 klLdGL encore-bright-accent-set']")).click();
	 //homepage
	 //seaching singer 1 Atif Aslam + top songs + thier no. of playbacks
	 driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Atif Aslam");
	 
	 //top 5 songs list and no. of play
	// Search singer
	 driver.findElement(By.xpath("//input[@placeholder='What do you want to play?']")).sendKeys("Atif Aslam");

	 // Song 1
	 String song1 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//a[@data-testid='internal-track-link'])[1]")).getText();
	 String play1 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//span[contains(text(), ',')])[1]")).getText();
	 System.out.println("1. " + song1 + " --> " + play1);

	 // Song 2
	 String song2 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//a[@data-testid='internal-track-link'])[2]")).getText();
	 String play2 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//span[contains(text(), ',')])[2]" )).getText();
	 System.out.println("2. " + song2 + " --> " + play2);

	 // Song 3
	 String song3 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//a[@data-testid='internal-track-link'])[3]")).getText();
	 String play3 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//span[contains(text(), ',')])[3]")).getText();
	 System.out.println("3. " + song3 + " --> " + play3);

	 // Song 4
	 String song4 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//a[@data-testid='internal-track-link'])[4]")).getText();
     String play4 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//span[contains(text(), ',')])[4]")).getText();
	 System.out.println("4. " + song4 + " --> " + play4);

	 // Song 5
	 String song5 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//a[@data-testid='internal-track-link'])[5]")).getText();
	 String play5 = driver.findElement(By.xpath("(//section[.//h2[text()='Popular']]//div[@role='row']//span[contains(text(), ',')])[5]")).getText();
	 System.out.println("5. " + song5 + " --> " + play5);


	//seaching singer 2 Arijit Singh + top songs + thier no. of playbacks
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Arijit Singh");
	
	//sending top 5 songs list and no. of play data to excel file
	//eLib.getdataIntoExcelFile(charts, 1, 1);
	
	
	
}
}