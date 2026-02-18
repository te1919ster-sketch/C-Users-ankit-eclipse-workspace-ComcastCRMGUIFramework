package com.lessannoyingcrmAutomation.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    private static final String EXCEL_PATH = "./testData/TestData.xlsx";

    public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        String data = wb.getSheet(sheetName)
                        .getRow(rowNum)
                        .getCell(cellNum)
                        .getStringCellValue();

        wb.close();
        return data;
    }

    public int getRowCount(String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        int rowCount = wb.getSheet(sheetName)
                         .getLastRowNum();

        wb.close();
        return rowCount;
    }

    public void setDataToExcel(String sheetName, int rowNum, int cellNum, String value) throws Exception {

        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook wb = WorkbookFactory.create(fis);

        wb.getSheet(sheetName)
          .getRow(rowNum)
          .createCell(cellNum)
          .setCellValue(value);

        FileOutputStream fos = new FileOutputStream(EXCEL_PATH);

        wb.write(fos);
        wb.close();
    }
}
