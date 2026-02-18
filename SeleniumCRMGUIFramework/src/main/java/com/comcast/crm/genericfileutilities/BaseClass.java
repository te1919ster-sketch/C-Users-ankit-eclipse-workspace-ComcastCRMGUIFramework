package com.comcast.crm.genericfileutilities;

import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.comcast.crm.databaseutility.DataBaseUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.webdriverutility.JavaUtility;

public class BaseClass {
	public DataBaseUtility dLib= new DataBaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriver driver= null;
	public static WebDriver sdriver= null;
//	public ExtentSparkReporter spark;
//	public ExtentReports report;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("connect to db, report config");
		dLib.getDbconnection();
	
//	        //spark report config or high level configuration
//			ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
//			spark.config().setDocumentTitle("CRMTestSuiteResults");
//			spark.config().setReportName("CRM Report");
//			spark.config().setTheme(Theme.DARK);
//			
//			//add env info and create test
//			ExtentReports report= new ExtentReports();
//			report.attachReporter(spark);
//			report.setSystemInfo("OS", "Win10");
//			report.setSystemInfo("BROWSER", "CHROME100");
	}
			

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("close db, report backup");
		dLib.closeDbconnection();
		
//		report.flush();
	}
	//modifying the begfore class here
	@Parameters({"browser", "platform"})	
	@BeforeClass
	public void configBC(String browser, String platform) throws Throwable {
		System.out.println("launch browser");
		String bwsr= fLib.getDataFromPropertiesFile("browser");
		if (bwsr.equalsIgnoreCase("chrome")) {
			ChromeOptions option= new ChromeOptions();
			option.setPlatformName("window");
			driver= new RemoteWebDriver(new URL("\"http://3.27.63.39:4444"), option);
		} else if (bwsr.equalsIgnoreCase("firefox")) {
			FirefoxOptions option= new FirefoxOptions();
			option.setPlatformName("window");
			driver= new RemoteWebDriver(new URL("\"http://3.27.63.39:4444"), option);
		} else if (bwsr.equalsIgnoreCase("edge")) {
			EdgeOptions option= new EdgeOptions();
			option.setPlatformName("window");
			driver= new RemoteWebDriver(new URL("\"http://3.27.63.39:4444"), option);
		} else {
			driver = new ChromeDriver();
		}
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("close the browser");
		driver.quit();
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Logout"); 
		String url =fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("un");
		String pwd = fLib.getDataFromPropertiesFile("pwd");
		
		LoginPage lp= new LoginPage(url, un, pwd);
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("Logout"); 
		LoginPage hp= new LoginPage(driver);
		hp.logout();
	}
	
	@Test 
	public void createContact() {
		System.out.println("execute createContact");  
	}
	
	@Test 
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate");  
	}
}
