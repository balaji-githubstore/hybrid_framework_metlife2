package com.metlife.pages;

import com.metlife.base.AutomationKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AutomationKeywords {

    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginLocator = By.xpath("//button[normalize-space()='Login']");
    private By forgotLocator = By.xpath("//*[contains(text(),'Forgot')]");
    private By errorLocator = By.xpath("//div[@role='alert']");

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    public void enterUsername(String username) {
        typeUsingLocator(usernameLocator,username);
    }

    public void enterPassword(String password) {
        typeUsingLocator(passwordLocator,password);
    }

    public void clickOnLogin() {
        clickUsingLocator(loginLocator);
    }

    public void clickOnForgotYourPassword(WebDriver driver) {

        clickUsingLocator(forgotLocator);
    }

    public String getInvalidErrorMessage() {
        return getTextUsingLocator(errorLocator);
    }

}
