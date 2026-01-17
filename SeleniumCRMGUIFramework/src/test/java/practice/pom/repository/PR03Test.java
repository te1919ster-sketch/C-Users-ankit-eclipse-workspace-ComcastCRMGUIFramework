package practice.pom.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.genericfileutilities.ExcelUtility;
import com.comcast.crm.genericfileutilities.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.JavaUtility;

public class PR03Test {

	public static void main(String[] args) throws Throwable {
		//creating the object
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		

		// fetching the data from external .properties file
		String bwsr = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("un");
		String pwd = fLib.getDataFromPropertiesFile("pwd");

		// read TestScript data from xl file
		 String orgName= eLib.getdataFromExcelFile("org",1,2)+ jLib.getRandomNumber();

		WebDriver driver = null;

		if (bwsr.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (bwsr.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (bwsr.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// login to the app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToapp("admin","admin");
		
		// navigate to Organization module
		HomePage hp= new HomePage(driver);
		hp.getOrgLink().click();
		
		// click on create organization button
		OrganizationsPage cnp= new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// enter all details & create organization
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		cnop.createShippingAdd("kolkata");
		
		// verify header phn no info
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actOrgName= oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified == PASSED");
		}else {
			System.out.println(orgName + " name is not verified == FAILED");
		}

		// logout
		hp.logout();
		driver.quit();

	}
}
