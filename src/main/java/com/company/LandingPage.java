package com.company;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class LandingPage extends DriverAndPageInitiator {
    public static final String BASE_URL = "https://www.facebook.com/";

    @FindBy(how = How.XPATH, using = "//div[@id='pageFooter']//li[11]/a[@class]" )
    private WebElement country;
    @FindBy(how = How.XPATH, using = "//div[@id='intl-region-container']//td[@class='_51m- vTop pas'][1]//ul//li[17]" )
    private WebElement countryus;
    @FindBy(how = How.XPATH, using = "//input[@type='submit']" )
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@name=\"firstname\"]" )
    private WebElement typeName;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@name=\"lastname\"]" )
    private WebElement typeLastname;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@name=\"reg_email__\"]" )
    private WebElement typeEmail;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@type=\"password\"]" )
    private WebElement typePass;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::select[1]" )
    private WebElement dropDownDay;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::select[2]" )
    private WebElement dropDownMont;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::select[3]" )
    private WebElement dropDownYear;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@type=\"radio\"] [@value=\"1\"]" )
    private WebElement radial;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@type=\"radio\"] [@value=\"2\"]" )
    private WebElement radial1;
    @FindBy(how = How.XPATH, using = "//form[@name =\"reg\"]//descendant::input[@type=\"radio\"] [@value=\"-1\"]" )
    private WebElement radial2;
    @FindBy(how = How.XPATH, using = "//tbody//descendant::tr[3]//a" )
    private WebElement forgotAccount;

    public  LandingPage(WebDriver driver) {
        super(driver,driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }
    public void countryUS(){
        country.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(countryus));
        countryus.click();

    }
    public void FillInfo(String name, String lastname, String email, String pass) {
        typeName.sendKeys(name);
        typeLastname.sendKeys(lastname);
        typeEmail.sendKeys(email);
        typePass.sendKeys(pass);
    }
    public void DifferentBirthDay(String day, String month, String year) {
        Select dayDropD = new Select(dropDownDay);
        dayDropD.selectByValue(day);

        Select dayDrop2 = new Select(dropDownMont);
        dayDrop2.selectByValue(month);

        Select dayDrop3 = new Select(dropDownYear);
        dayDrop3.selectByValue(year);
    }
    public void SelectSex(String m){
        if(m.equals("Mujer")){
            radial.click();
        } else if(m.equals("Hombre")){
            radial1.click();
        } else {
            radial2.click();
        }
    }
    public ForgotAccountPage Forgot() {
        forgotAccount.click();
        return new ForgotAccountPage(driver);
    }

    @Override
    public boolean FullyLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(country));
            wait.until(ExpectedConditions.visibilityOf(submitButton));
            wait.until(ExpectedConditions.visibilityOf(typeName));
            wait.until(ExpectedConditions.visibilityOf(typeLastname));
            wait.until(ExpectedConditions.visibilityOf(typeEmail));
            wait.until(ExpectedConditions.visibilityOf(typePass));
            wait.until(ExpectedConditions.visibilityOf(dropDownDay));
            wait.until(ExpectedConditions.visibilityOf(dropDownMont));
            wait.until(ExpectedConditions.visibilityOf(dropDownYear));
            wait.until(ExpectedConditions.visibilityOf(radial));
            wait.until(ExpectedConditions.visibilityOf(radial1));
            wait.until(ExpectedConditions.visibilityOf(radial2));
            wait.until(ExpectedConditions.visibilityOf(forgotAccount));

            return true;
        }catch(RuntimeException exception) {
            return false;
        }
    }
}



