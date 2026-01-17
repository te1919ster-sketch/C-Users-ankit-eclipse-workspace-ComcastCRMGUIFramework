package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT008Test {

	 public static void main(String[] args) throws Exception {
		 
		 // reading data back to the xl file		 
		 FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\OneDrive\\Documents\\DOCS\\demotp.xlsx"); 
		 Workbook wb= WorkbookFactory.create(fis);
		 Sheet sh= wb.getSheet("org");
		 Row row= sh.getRow(1);
		 Cell cel= row.createCell(4);
		 cel.setCellType(CellType.STRING);
		 cel.setCellValue("FAIL");
		 
		 FileOutputStream fos= new FileOutputStream("C:\\Users\\ankit\\OneDrive\\Documents\\DOCS\\demotp.xlsx"); 
		 wb.write(fos);
		 wb.close();
		 System.err.println("Executed");
		 
	 }
}