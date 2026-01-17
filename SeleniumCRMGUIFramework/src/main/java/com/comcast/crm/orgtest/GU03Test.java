package com.comcast.crm.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GU03Test {

	 public static void main(String[] args) throws Exception {
		 
     // fetching the data from external .properties file
		 
         FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		 Properties p= new Properties();
		 p.load(fis);
		 
		 String bwsr= p.getProperty("browser");
		 String url= p.getProperty("url");
		 String un= p.getProperty("un");
		 String pwd= p.getProperty("pwd");
		 
     // genrate random no.
		 Random random= new Random();
		 int randomInt= random.nextInt(5000);
		 
	// read TestScript data from xl file
		 FileInputStream fis1= new FileInputStream("./testData/demoTC02.xlsx");
		 Workbook wb= WorkbookFactory.create(fis1);
		 Sheet sh= wb.getSheet("contact");
		 Row row= sh.getRow(1);
		 String lastName= row.getCell(2).toString();//+ randomInt;
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
		 
		 // navigate to contact module
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 // click on contact button 
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		 // enter all details & create contact
		 driver.findElement(By.name("lastname")).sendKeys(lastName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		 // verify header 
		 String actLastName= driver.findElement(By.xpath("//input[@name='lastname']")).getText();
		  if(actLastName.equals(lastName)) {
			  System.out.println(lastName + " information is verified == PASSED");
		  } else {
			  System.out.println(lastName + " information is not verified == FAILED");
		  }
		 
		 //logout
		 driver.quit();
		 
		 
}
}