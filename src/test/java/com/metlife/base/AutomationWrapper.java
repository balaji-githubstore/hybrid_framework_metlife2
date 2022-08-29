package com.metlife.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.metlife.utilities.PropUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

@Listeners({TestNGListeners.class})
public class AutomationWrapper {
    protected WebDriver driver;

    private static ExtentReports extent;

    protected static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void init() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
            extent.attachReporter(spark);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void end() {
        extent.flush();
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("edge") String browserName, Method method) throws IOException {
        test = extent.createTest(method.getName());

        if (browserName.equalsIgnoreCase("ch")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {

        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl= PropUtils.getValue("url");
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }

        driver.quit();
    }
}
