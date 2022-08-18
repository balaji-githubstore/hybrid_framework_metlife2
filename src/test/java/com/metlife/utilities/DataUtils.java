package com.metlife.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class DataUtils {

    @DataProvider
    public Object[][] commonDataProvider(Method method) throws IOException {
        //get current testMethodName which will be the sheetname
        String sheetName=method.getName();

        Object[][] main = ExcelUtils.getSheetIntoTwoDimensionalArray("test-data/orange_data.xlsx", sheetName);
        return main;
    }

//    @DataProvider
//    public Object[][] invalidCredentialData()
//    {
//        Object[][] main=new Object[2][3];
//        main[0][0]="John";
//        main[0][1]="john123";
//        main[0][2]="Invalid credentials";
//
//        main[1][0]="peter";
//        main[1][1]="peter123";
//        main[1][2]="Invalid credentials";
//
//        return main;
//    }
}
