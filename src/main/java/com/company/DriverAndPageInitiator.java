package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAndPageInitiator {
    protected WebDriver driver;
    protected String baseUrl;


    public DriverAndPageInitiator(WebDriver driver, String baseUrl) {

        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver,baseUrl);
    }

    public boolean FullyLoaded() {
            try{
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
                return true;
            }catch(RuntimeException exception) {
                return false;
            }
        }

}