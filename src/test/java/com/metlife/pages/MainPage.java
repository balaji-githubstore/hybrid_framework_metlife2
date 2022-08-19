package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public static void clickOnAdmin(WebDriver driver)
    {
        driver.findElement(By.xpath("//*[contains(text(),'Admin')]")).click();
    }
}
