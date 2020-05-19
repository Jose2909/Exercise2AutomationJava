package com.company;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ForgotAccountPage extends DriverAndPageInitiator {
    @FindBy(how = How.XPATH, using = "//form[@id=\"identify_yourself_flow\"]//descendant::input[@id=\"identify_email\"]" )
    private WebElement recuperaAcc;
    @FindBy(how = How.XPATH, using = "//form[@id=\"identify_yourself_flow\" ]//div[@class=\"fsl fwb fcb\"]" )
    private WebElement errorMess;

    public ForgotAccountPage(WebDriver driver) {
        super(driver,driver.getCurrentUrl());
        PageFactory.initElements(driver, this);
    }

    public void email(String emial){
        recuperaAcc.sendKeys(emial, Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(recuperaAcc));
        recuperaAcc.submit();
    }
    public void ErrorMessage(String error) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(errorMess));
        Assert.assertEquals(errorMess.getText(),error,"Somethig Went Wrong");

        Thread.sleep(2000);
    }

    @Override
    public boolean FullyLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(recuperaAcc));
            wait.until(ExpectedConditions.visibilityOf(errorMess));
            return true;
        }catch(RuntimeException exception) {
            return false;
        }

    }
}
