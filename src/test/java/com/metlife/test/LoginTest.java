package com.metlife.test;

import com.aventstack.extentreports.Status;
import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import com.metlife.utilities.DataUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AutomationWrapper {

    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
    public void validCredentialTest(String username, String password, String expectedValue) {

        LoginPage.enterUsername(driver, username);
        LoginPage.enterPassword(driver, password);
        LoginPage.clickOnLogin(driver);

        String actualValue = MainPage.getAdminMenuText(driver);
        Assert.assertTrue(actualValue.contains(expectedValue)); //must be true
    }

    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
    public void invalidCredentialTest(String username, String password, String expectedError) {

        LoginPage.enterUsername(driver, username);
        test.log(Status.INFO, "Entered Username :" + username);

        LoginPage.enterPassword(driver, password);
        test.log(Status.INFO, "Entered password :" + password);

        LoginPage.clickOnLogin(driver);
        test.log(Status.INFO, "Clicked on Login");

        String actualError = LoginPage.getInvalidErrorMessage(driver);

        test.log(Status.INFO, "Actual Error: " + actualError);
        Assert.assertEquals(actualError, expectedError);
    }
}
