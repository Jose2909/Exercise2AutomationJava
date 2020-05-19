import configs.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BrowserSelector {
    protected WebDriver myDriver;

    @BeforeClass(alwaysRun = true, description = "Select Browser in which you will be testing")
    public void setUp(){
        String browser = "firefox";
        myDriver = WebDriverConfig.getDriver(browser);
    }
    @AfterClass(alwaysRun = true, description = "Close the window after the tests ran")
    public void close(){
        myDriver.close();
    }


}

