package com.metlife.test;

import com.metlife.base.AutomationWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserInterfaceTest extends AutomationWrapper {

    @Test(groups = {"UI","low"})
    public void validateTitleTest() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }

    @Test(groups = {"UI","high"})
    public void textboxPlaceHolderTest() {
        String actualUsernamePlaceholder = driver.findElement(By.name("username")).getAttribute("placeholder");
        String actualPasswordPlaceholder = driver.findElement(By.name("password")).getAttribute("placeholder");

        Assert.assertEquals(actualUsernamePlaceholder, "Username");
        Assert.assertEquals(actualPasswordPlaceholder, "Password");
    }

}


