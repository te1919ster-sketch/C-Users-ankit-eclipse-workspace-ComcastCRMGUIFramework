package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class GU04Test {

	 public static void main(String[] args) throws Exception {
		 
     // fetching the data from external .properties file
		 
		 FileInputStream fis= new FileInputStream("./configAppData/commondata.properties");
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
		 Row row= sh.getRow(4);
		 String lastName= row.getCell(2).toString()+ randomInt;
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
		 
		 // click on create orgasnization button 
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// when we want the date in system format and with the details
		 Date d= new Date();
		 
		// when we want the date in custom or simple format
		 SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		 String startDate= sim.format(d);
		 		 
		// when we want to specify the date period
		 Calendar cal= sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,30);
		 String endDate= sim.format(cal.getTime());
		 		 
		 // enter all details & create organization
		 driver.findElement(By.name("lastname")).sendKeys(lastName);
		 
		 // filling date
		 driver.findElement(By.name("support_start_date")).clear();
		 driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		 
		 driver.findElement(By.name("support_end_date")).clear();
		 driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		 // verify startdate and enddate 
		 String actStartDate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
				 //xpath("//input[@id='jscal_field_support_start_date']")).getText();
		  if(actStartDate.equals(startDate)) {
			  System.out.println(startDate + " information is verified == PASSED");
		  } else {
			  System.out.println(startDate + " information is not verified == FAILED");
		  }
		  
		  String actEndDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
				  //xpath("//input[@id='jscal_field_support_end_date']")).getText();
		  if(actEndDate.equals(endDate)) {
			  System.out.println(endDate + " information is verified == PASSED");
		  } else {
			  System.out.println(endDate + " information is not verified == FAILED");
		  }
		 
		 //logout
		 driver.quit();
		 
		 
}
}