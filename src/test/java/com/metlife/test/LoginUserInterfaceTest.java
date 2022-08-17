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

public class LoginUserInterfaceTest extends AutomationWrapper {

    @Test
    public void validateTitleTest() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }

    @Test
    public void textboxPlaceHolderTest() {
        String actualUsernamePlaceholder = driver.findElement(By.name("username")).getAttribute("placeholder");
        String actualPasswordPlaceholder = driver.findElement(By.name("password")).getAttribute("placeholder");

        Assert.assertEquals(actualUsernamePlaceholder, "Username");
        Assert.assertEquals(actualPasswordPlaceholder, "Password");
    }

}


