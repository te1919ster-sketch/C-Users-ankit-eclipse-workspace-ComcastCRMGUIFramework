package com.comcast.crm.contacttest;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GU06Test {

	public static void main(String[] args) throws Exception {

		// fetching the data from external .properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\ankit\\Java Files\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);

		String bwsr = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pwd = p.getProperty("pwd");

		// genrate random no.
		Random random = new Random();
		int randomInt = random.nextInt(50000);

		// read TestScript data from xl file
		 FileInputStream fis1= new FileInputStream("./testData/demoTC02.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString() + randomInt;
		String contactLastName = row.getCell(3).getStringCellValue();
		wb.close();

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
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		// navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// click on create orgasnization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// enter all details & create organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("kolkata");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify header phn no info
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " information is verified == PASSED");
		} else {
			System.out.println(orgName + " information is not verified == FAILED");
		}

		// navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		String parent = driver.getWindowHandle();

		// click on contact button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// enter all details & create contact
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switching to the child window
		Set<String> set = driver.getWindowHandles();
		System.out.println("s:" + set.size());
		for (String str : set) {
			driver.switchTo().window(str);
			if (!str.equals(parent))
				break;
		}
		// inside child window
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// driver.close();

		// switching back to parent window
		Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set.iterator();

		while (it2.hasNext()) {
			String windowID2 = it2.next();
			driver.switchTo().window(windowID2);

			String actUrl2 = driver.getCurrentUrl();
			if (actUrl2.contains("Contacts&action")) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify header phn no info
		String headerInfo2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo2.contains(orgName)) {
			System.out.println(orgName + " information is verified == PASSED");
		} else {
			System.out.println(orgName + " information is not verified == FAILED");
		}

		// verify header orgName
		String actOrgName = driver.findElement(By.id("dltview_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is verified == PASSED");
		} else {
			System.out.println(orgName + " information is not verified == FAILED");
		}

		// logout
		driver.quit();

	}
}
