package com.veeva.nba.pages;

import com.veeva.nba.utils.SeleniumTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    String preSalePopupClose = "//div[@role='dialog']/div/div[text()='x']";
    String shopMenu = "//div[@id='nba-nav']//nav[@aria-label='Golden State Warriors navigation']//li/a/span[text()='Shop']";
    String mensSubMenu ="//nav[@aria-label='Golden State Warriors navigation']//li/a/span[text()='Shop']/following::nav[@aria-label='submenu'][1]//a[contains(text(),'Men')]";
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void closePreSalePopupClose(){
        SeleniumTestUtils.waitForElement(driver, By.xpath(preSalePopupClose));
        SeleniumTestUtils.clickOnElement(driver,By.xpath(preSalePopupClose));
    }

    public void clickOnMensSubMenu(){
        SeleniumTestUtils.waitForElement(driver,By.xpath(shopMenu));
        SeleniumTestUtils.mouseHoverElement(driver,By.xpath(shopMenu));
        SeleniumTestUtils.waitForElement(driver,By.xpath(mensSubMenu));
        SeleniumTestUtils.clickOnElement(driver,By.xpath(mensSubMenu));
    }





}
