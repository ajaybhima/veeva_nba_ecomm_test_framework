package com.veeva.nba.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class SeleniumTestUtils {

    public static void launchApplication(WebDriver driver,String applicationURL){
        try {
            driver.get(applicationURL);
            Reporter.log("Application has been launched = "+applicationURL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Issue while launching application url in browser");
        }
    }

    public static void waitForElement(WebDriver driver, By element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Element Not found");
        }
    }

    public static void clickOnElement(WebDriver driver, By element){
        try {
            WebElement webElement = driver.findElement(element);
            webElement.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Element Not found");
        }
    }
    public static void mouseHoverElement(WebDriver driver, By element){
        try {
            WebElement webElement = driver.findElement(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).build().perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Element Not found");
        }
    }
}
