package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//static page objects
public class LoginPage {

    private static By usernameLocator = By.name("username");
    private static By passwordLocator = By.name("password");
    private static By loginLocator = By.xpath("//button[normalize-space()='Login']");
    private static By forgotLocator = By.xpath("//*[contains(text(),'Forgot')]");
    private static By errorLocator = By.xpath("//div[@role='alert']");

    public static void enterUsername(WebDriver driver, String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public static void enterPassword(WebDriver driver, String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public static void clickOnLogin(WebDriver driver) {
        driver.findElement(loginLocator).click();
    }

    public static void clickOnForgotYourPassword(WebDriver driver) {

        driver.findElement(forgotLocator).click();
    }

    public static String getInvalidErrorMessage(WebDriver driver) {
        return driver.findElement(errorLocator).getText();
    }

}
