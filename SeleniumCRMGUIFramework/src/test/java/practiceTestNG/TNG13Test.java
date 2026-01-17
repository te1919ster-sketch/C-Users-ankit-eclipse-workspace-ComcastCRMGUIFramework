package practiceTestNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TNG13Test {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		        //spark report config or high level configuration
				ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRMTestSuiteResults");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add env info and create test
				report= new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Win10");
				report.setSystemInfo("BROWSER", "CHROME100");	
	}
	
	@AfterSuite
	public void configAS() {
    report.flush();	
	}

	@Test
	public void createContactTest() {		
		//launching the browser
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		
		//taking screenshot base64 type
		TakesScreenshot eDriver=(TakesScreenshot)driver;	
		String filePath= eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test= report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFIC"))   {
				test.log(Status.PASS, "contact is created");
	    }else {
		        test.addScreenCaptureFromBase64String(filePath, "ErrorFile");	
	}
	   driver.quit();
	   System.out.println("login to app");
	   report.flush();
	}	
	
	@Test
	public void createContactWithORG() {		
		//
		ExtentTest test= report.createTest("createContactWithORG");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC"))   {
				test.log(Status.PASS, "contact is created");
	    }else {
		        test.log(Status.FAIL, "contact is not created");	
	}
	   System.out.println("login to app");
	}	
	
	@Test
	public void createContactWithPhoneNumber() {		
		//
		ExtentTest test= report.createTest("createContactWithPhoneNumber");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC"))   {
				test.log(Status.PASS, "contact is created");
	    }else {
		        test.log(Status.FAIL, "contact is not created");	
	}
	   System.out.println("login to app");
	}	
}

