package com.metlife.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getSheetIntoTwoDimensionalArray(String fileDetail,String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(fileDetail);
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet(sheetName);

        int rowCount=sheet.getPhysicalNumberOfRows();
        int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] main=new Object[rowCount-1][cellCount];

        for (int r = 1; r < rowCount; r++) {
            for (int c = 0; c < cellCount; c++) {
                String value = sheet.getRow(r).getCell(c).getStringCellValue();
                System.out.println(value);
                main[r-1][c]=value;
            }
        }
        return main;
    }


}
