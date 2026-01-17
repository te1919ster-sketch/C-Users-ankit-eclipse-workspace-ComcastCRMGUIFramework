package com.comcast.crm.genericfileutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getdataFromExcelFile(String sheetName, int rowNum, int cell) throws Exception{
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ankit\\Downloads\\demo03.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}


    public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
    	
    	FileInputStream fis= new FileInputStream("./configAppData/demoTC02.xlsx");
    	Workbook wb= WorkbookFactory.create(fis);
		int rowCount= wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
      }

   public void getdataIntoExcelFile(String sheetName, int rowNum, int cell) throws Exception{
	
	FileInputStream fis= new FileInputStream("./configAppData/demoTC02.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cell);
	
	FileOutputStream fos= new FileOutputStream("./configAppData/demoTC02.xlsx");
	wb.write(fos);
	wb.close();
}
}
