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

public class DDT005Test {

	 public static void main(String[] args) throws Exception {
		 
		 // reading the data from xl sheet
		 
		 //s1: open the xl path loc & java obj of the physical xl file
		 FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\OneDrive\\Documents\\DOCS\\demotp.xlsx");
		 
		 //s2: open workbook in read mode/format
		 Workbook wb= WorkbookFactory.create(fis);
		 
		 //s3: get the control of the org sheet
		 Sheet sh= wb.getSheet("org");
		 
		 //s4: get the control of the 1st row
		 Row row= sh.getRow(1);
		 
		//s5: get the control of the 2nd cell & read the string data
		 String data= row.getCell(1).getStringCellValue();
		 System.out.println(data);
		 
		//s6: close the Workbook
		 wb.close();
		
	 }
}
