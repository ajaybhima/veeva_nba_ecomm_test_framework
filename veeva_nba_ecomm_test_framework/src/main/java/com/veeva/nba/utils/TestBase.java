package com.veeva.nba.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class TestBase {

    public static WebDriver driver = null;

    public void startBrowser(){
        try{
            String browser = FileReadWriteUtils.readDataFromPropertiesFile("./test.properties","Browser");
            if(browser.equalsIgnoreCase("chrome")){
                //System.setProperty("webdriver.chrome.driver","/src/test/resources/chromedirver.exe");
                //ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver();
                driver.manage().window().maximize();;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Issue while Initiating WebDriver or browser");
        }
    }
    public void takeScreenshotOnTestFailure(String testName){

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
            FileUtils.copyFile(srcFile, new File("./target/screenshots/"+testName+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Issue while while taking screenshot");
        }

    }

    public void closeBrowser(){

        try {
            if(driver != null){
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Issue while Closing the browser ");
        }
    }
}
