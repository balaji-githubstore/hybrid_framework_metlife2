package com.metlife.base;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListeners extends TestListenerAdapter  implements ITestListener{
	Logger logger = Logger.getLogger(TestNGListeners.class.getName());
	FileHandler fh; 
	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }

	@Override
	public void onTestStart(ITestResult result) {
		  

		    try {  

		        // This block configure the logger with handler and formatter  
		        fh = new FileHandler("target/MyLogFile.log");  
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  

		        // the following statement is used to log any messages  
		        logger.info("My first log");  

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		    
		logger.log(Level.INFO, "I am in onTestStart method " +  getTestMethodName(result) + " start");
		 System.out.println("I am in onTestStart method " +  getTestMethodName(result) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Level.INFO,"I am in onTestSuccess method " +  getTestMethodName(result) + " succeed");
		System.out.println("I am in onTestSuccess method " +  getTestMethodName(result) + " succeed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("I am in onTestFailure method " +  getTestMethodName(result) + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 System.out.println("I am in onTestSkipped method "+  getTestMethodName(result) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(result));
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		 System.out.println("I am in onStart method " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		  System.out.println("I am in onFinish method " + context.getName());
		  logger.log(Level.INFO,"Completed!!!");
	}

}
