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

    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login","high"})
    public void validCredentialTest(String username, String password, String expectedValue) {

      try {
          LoginPage loginPage=new LoginPage(driver);

          loginPage.enterUsername(username);
          loginPage.enterPassword(password);
          loginPage.clickOnLogin();

          MainPage mainPage=new MainPage(driver);
          String actualValue = mainPage.getAdminMenuText();

          Assert.assertTrue(actualValue.contains(expectedValue)); //must be true
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
          Assert.fail(); //mandatory if you handle exception on @Test method
      }


    }

    @Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login","high"})
    public void invalidCredentialTest(String username, String password, String expectedError) {

        LoginPage loginPage=new LoginPage(driver);

        loginPage.enterUsername(username);
        test.log(Status.INFO, "Entered Username :" + username);

        loginPage.enterPassword( password);
        test.log(Status.INFO, "Entered password :" + password);

        loginPage.clickOnLogin();
        test.log(Status.INFO, "Clicked on Login");

        String actualError = loginPage.getInvalidErrorMessage();

        test.log(Status.INFO, "Actual Error: " + actualError);
        Assert.assertEquals(actualError, expectedError);
    }
}
