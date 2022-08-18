package com.metlife.test;

import com.metlife.base.AutomationWrapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends AutomationWrapper {

    @Test
    public void validCredentialTest() {

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //get the Quick Launch Text
        String actualValue = driver.findElement(By.xpath("//*[contains(text(),'Quick')]")).getText();

        Assert.assertTrue(actualValue.contains("Quick Launch")); //must be true
    }



    @Test
    public void invalidCredentialTest() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        String actualError = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(actualError, "Invalid credentials");
    }
}
