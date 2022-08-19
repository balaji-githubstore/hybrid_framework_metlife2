package com.metlife.test;

import com.aventstack.extentreports.Status;
import com.metlife.base.AutomationWrapper;
import com.metlife.utilities.DataUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AutomationWrapper {

    @Test
    public void validCredentialTest() {

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //get the Quick Launch Text
        String actualValue = driver.findElement(By.xpath("//*[contains(text(),'Employee List')]")).getText();

        Assert.assertTrue(actualValue.contains("Employee List")); //must be true
    }

    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
    public void invalidCredentialTest(String username, String password, String expectedError) {

        driver.findElement(By.name("username")).sendKeys(username);
        test.log(Status.INFO,"Entered Username :"+username);
        driver.findElement(By.name("password")).sendKeys(password);
        test.log(Status.INFO,"Entered password :"+password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        test.log(Status.INFO,"Clicked on Login");

        String actualError = driver.findElement(By.xpath("//div[@role='alert']")).getText();

        test.log(Status.INFO,"Actual Error: "+actualError);
        Assert.assertEquals(actualError, expectedError);
    }
}
