package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static By adminLocator=By.xpath("//span[text()='Admin']");

    public static void clickOnAdminMenu(WebDriver driver)
    {
        driver.findElement(adminLocator).click();
    }

    public static String getAdminMenuText(WebDriver driver)
    {
        return driver.findElement(adminLocator).getText();
    }
}
