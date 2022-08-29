package com.metlife.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

public class AutomationKeywords {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public AutomationKeywords(WebDriver driver) {

        this.driver = driver;
        initFluentWait();
    }

    public void initFluentWait() {
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(Exception.class);
        wait.withMessage("Checked for 40 seconds by igoring all exceptions!!");
    }

//    public void clickUsingLocator(By locator) {
//
//        driver.findElement(locator).click();
//    }
//
//    public void typeUsingLocator(By locator, String text) {
//
//        driver.findElement(locator).sendKeys(text);
//    }
//
//    public String getTextUsingLocator(By locator) {
//
//        return driver.findElement(locator).getText();
//    }

    public void clickUsingLocator(By locator) {

        wait.until(x->x.findElement(locator)).click();

    }

    public void typeUsingLocator(By locator, String text) {

        wait.until(x->x.findElement(locator)).sendKeys(text);
    }

    public String getTextUsingLocator(By locator) {

        return wait.until(x->x.findElement(locator)).getText();
    }

    public String switchAndGetAlertText()
    {
        return wait.until(x->x.switchTo().alert()).getText();
    }

    public void switchToWindowWithTitle(String title) {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public void switchToWindowWithUrl(String url) {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals(url)) {
                break;
            }
        }
    }

}
