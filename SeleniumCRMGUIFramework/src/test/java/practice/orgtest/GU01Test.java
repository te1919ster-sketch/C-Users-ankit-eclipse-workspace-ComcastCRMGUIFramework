package practice.orgtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GU01Test {

	 public static void main(String[] args) throws Exception {
		 
     // here we are fetching tbe data from external .properties file
		 
         FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 Properties p= new Properties();
		 p.load(fis);
		 
		 String bwsr= p.getProperty("browser");
		 String url= p.getProperty("url");
		 String un= p.getProperty("un");
		 String pwd= p.getProperty("pwd");
		 
     // genrate random no
		 Random random= new Random();
		 int randomInt= random.nextInt(1000);
		 
	// read TestScript data from xl file
		 FileInputStream fis1= new FileInputStream("C:\\Users\\ankit\\OneDrive\\Documents\\demoTC02.xlsx");
		 Workbook wb= WorkbookFactory.create(fis1);
		 Sheet sh= wb.getSheet("org");
		 Row row= sh.getRow(1);
		 String orgName= row.getCell(2).toString() + randomInt;
		 wb.close();
		 
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
		 
		 // login to the app
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("user_name")).sendKeys(un);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
		 // navigate to Organization module
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 // click on create orgasnization button 
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		 // engter all details & create organization
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //logout
		 driver.quit();
		 
		 
}
}