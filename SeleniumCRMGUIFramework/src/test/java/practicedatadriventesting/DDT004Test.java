package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDT004Test {

	 public static void main(String[] args) throws Exception {
		 
		 //data driven testing example
		 //here we are fetching tbe data from external .properties file
		 //here we are also achieving cross platform testing
		 
         FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 Properties p= new Properties();
		 p.load(fis);
		 
		 String bwsr= p.getProperty("browser");
		 String url= p.getProperty("url");
		 String un= p.getProperty("un");
		 String pwd= p.getProperty("pwd");
		 
		 //reading the data from excel file
		 FileInputStream fis1= new FileInputStream("C:\\Users\\ankit\\OneDrive\\Documents\\DOCS\\demotp.xlsx"); 
		 Workbook wb= WorkbookFactory.create(fis1);
		 Sheet sh= wb.getSheet("org");
		 
		 WebDriver driver= null;
		 
		 if(bwsr.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		 } else if(bwsr.equalsIgnoreCase("firefox")) {
			 driver= new FirefoxDriver();
		 }else if(bwsr.equalsIgnoreCase("edge")) {
			 driver= new EdgeDriver();
		 }else {
			 driver= new ChromeDriver();
		 }
		
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("user_name")).sendKeys(un);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 
		//create a new organization by entering all the deatails &
		//verify organization name in the header of the msg
		 driver.findElement(By.xpath("(//img[@border='0'])[10]")).click();
		 //Thread.sleep(3000);
		 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("notInstagram23466");
		 driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys("ok");
		 driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
				 
		//logout
		// mouse actions
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
	    driver.quit();
	 }
}
