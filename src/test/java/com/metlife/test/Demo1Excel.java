package com.metlife.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1Excel {

    public static void main(String[] args) throws IOException {

        //location
        FileInputStream file=new FileInputStream("test-data/orange_data.xlsx");

        //open
        XSSFWorkbook book=new XSSFWorkbook(file);

        //sheet
        XSSFSheet sheet= book.getSheet("invalidCredentialTest");

        //Row //Cell
        String value=sheet.getRow(0).getCell(1).getStringCellValue();
        System.out.println(value);

        for(int r=0;r<3;r++)
        {
            for(int c=0;c<3;c++)
            {

            }
        }
    }
}
