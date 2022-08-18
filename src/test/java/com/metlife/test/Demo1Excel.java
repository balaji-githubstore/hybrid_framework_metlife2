package com.metlife.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1Excel {

    public static void main(String[] args) throws IOException {

        //location
        FileInputStream file = new FileInputStream("test-data/orange_data.xlsx");

        //open
        XSSFWorkbook book = new XSSFWorkbook(file);

        //sheet
        XSSFSheet sheet = book.getSheet("invalidCredentialTest");

        int rowCount=sheet.getPhysicalNumberOfRows();
        int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] main=new Object[rowCount-1][cellCount];

        //r,c used for reading from excel
        for (int r = 1; r < rowCount; r++) {
            for (int c = 0; c < cellCount; c++) {
                String value = sheet.getRow(r).getCell(c).getStringCellValue();
                System.out.println(value);
                main[r-1][c]=value;
            }
        }

        System.out.println();
    }
}
