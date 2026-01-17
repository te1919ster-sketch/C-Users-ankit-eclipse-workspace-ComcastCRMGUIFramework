package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericfileutilities.BaseClass;

public class TNG12Test extends BaseClass {
	@Test
	//creating the report
	public void createContactTest() {
		//spark report config or high level configuration
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRMTestSuiteResults");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env info and create test
		ExtentReports report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win10");
		report.setSystemInfo("BROWSER", "CHROME100");
		
		//
		ExtentTest test= report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC"))   {
				test.log(Status.PASS, "contact is created");
	    }else {
		        test.log(Status.FAIL, "contact is not created");	
	}
	report.flush();
	System.out.println("login to app");
}
}
