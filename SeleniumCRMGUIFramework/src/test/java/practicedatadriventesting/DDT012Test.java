package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
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

import com.mysql.jdbc.Driver;

public class DDT012Test {

	 public static void main(String[] args) throws Exception {
		 
    	//create project in GUI using selenium code 
		 String projectName="Instagram_02";
		 
		 WebDriver driver= new ChromeDriver();
		 driver.get("http://49.249.28.218:8091/");
		 
		 driver.findElement(By.id("username")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 
		 
	 }
}