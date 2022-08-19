package com.metlife.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExtent {

    public static void main(String[] args) {
        //intializing the report // should run only once at first
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);


        //create test // before each test //@BeforeMethod
        ExtentTest test= extent.createTest("Valid Credential Test");

        //@Test
        test.log(Status.INFO,"Running  the method");

        //log test is passed or fail //after each test //@AfterMethod
        test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");


        //publish the report // should run only once at the end
        extent.flush();


    }
}
