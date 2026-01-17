package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT006Test {

	 public static void main(String[] args) throws Exception {
		 
		 // reading multiple (colums) data from xl sheet
		 
		 FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\OneDrive\\Documents\\DOCS\\demotp.xlsx"); 
		 Workbook wb= WorkbookFactory.create(fis);
		 Sheet sh= wb.getSheet("org");
		 
		 int rowCount= sh.getLastRowNum();
		 
		 for(int i=1; i<=rowCount; i++) {
			 
			 Row row= sh.getRow(i);
			 
			 String col1= row.getCell(0).toString();
			 String col2= row.getCell(1).toString();
			 String col3= row.getCell(2).toString();
			 
			 System.out.println(col1 + "\t"+ col2 + "\t"+ col3);
		 }
		 
		 wb.close();
	 }
	
}