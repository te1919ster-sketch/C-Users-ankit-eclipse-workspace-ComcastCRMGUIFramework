package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericfileutilities.BaseClass;
import java.util.Date;

public class ListenersUtility implements ITestListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	ExtentTest test;
	
	    public void onStart(ISuite suite) {
	    	
	    	//spark report config or high level configuration
	    	System.out.println("Report configuration");
	    	String time= new Date().toString().replace(":", " ").replace(":", "_");
			ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("CRMTestSuiteResults");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add env info and create test
			ExtentReports report= new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Win10");
			report.setSystemInfo("BROWSER", "CHROME100");
	    }
	    
	    public void onFinish(ISuite suite) {
	    	System.out.println("Report backup");
	    	 report.flush();
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("=====" + result.getMethod().getMethodName() + " START=====");
	        test= report.createTest(result.getMethod().getMethodName());
	        test.log(Status.PASS,result.getMethod().getMethodName()+"====STARTED===");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("=====" + result.getMethod().getMethodName() + " END=====");
	        test.log(Status.PASS,result.getMethod().getMethodName()+"====COMPLETED===");
	        
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	
	        String testName = result.getMethod().getMethodName();
	        
	        TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;	
			String filePath= eDriver.getScreenshotAs(OutputType.BASE64);	        
	        
	        String time = new Date().toString().replace(" ", "_").replace(":", "_");
	        test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);	
	        test.log(Status.FAIL,result.getMethod().getMethodName()+"====ENDED===");
	        
//	        WebDriver driver = BaseClass.sdriver;
//
//	        File src = ((TakesScreenshot) driver)
//	                .getScreenshotAs(OutputType.FILE);

//	        try {
//	            FileUtils.copyFile(
//	                src,
//	                new File("./screenshots/" + testName + "_" + time + ".png")
//	            );
//	        } catch (IOException e) {
//	            e.printStackTrace();
	        
	        }
}

	

