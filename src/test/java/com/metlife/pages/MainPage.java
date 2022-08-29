package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private By adminLocator=By.xpath("//span[text()='Admin']");

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnAdminMenu()
    {
               driver.findElement(adminLocator).click();

    }

    public String getAdminMenuText()
    {
        return driver.findElement(adminLocator).getText();
    }
}
