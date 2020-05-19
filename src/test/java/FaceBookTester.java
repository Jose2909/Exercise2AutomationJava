import com.company.ForgotAccountPage;
import com.company.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceBookTester extends BrowserSelector {

            @Test(alwaysRun = true, priority = 2, description = "Go to US country")
            public void goToFaceBookUS(){
               LandingPage countryLink = new LandingPage(myDriver);
                        countryLink.countryUS();
            }

            @Test(alwaysRun = true, priority = 1, description = "Validate Url and verify the page is fully loaded")
            public void validateUrl () {
                myDriver.get(LandingPage.BASE_URL);
                LandingPage faceLanding = new LandingPage(myDriver);
                Assert.assertEquals(myDriver.getCurrentUrl(), LandingPage.BASE_URL, "Is another URL");
                Assert.assertTrue(faceLanding.FullyLoaded());
            }

            @Test(alwaysRun = true, priority = 3, description = "Validate title in the Home Page of FeceBook")
            public void validateTitle () {
                Assert.assertEquals(myDriver.getTitle(), "Facebook - Log In or Sign Up", "Title doesn´t match");
            }
            @Test(alwaysRun = true, priority = 4, description = "Fill the text box in registration section")
            public void FillAllSignUpSection () {
                LandingPage name = new LandingPage(myDriver);
                name.FillInfo("MyName", "MyLastName", "Myemail@noexist.com", "!MyPassword1");
            }
            @Test(alwaysRun = true, priority = 5, description = "Select different Day of Birth")
            public void NewDOB () {
                LandingPage dob = new LandingPage(myDriver);
                dob.DifferentBirthDay("2", "10", "2003");
            }
            @Test(alwaysRun = true, priority = 6, description = "Choose sex, you can select any options displayed in the page")
            public void SelectSexo () {
                LandingPage sexo = new LandingPage(myDriver);
                sexo.SelectSex("Mujer");
            }
            @Test(alwaysRun = true, priority = 7, description = "Validate Verbiage")
            public void ValidateVerbiage () {
                Assert.assertEquals(myDriver.getPageSource().contains("Connect with friends and the world around you on Facebook."), true);
            }
            @Test(alwaysRun = true, priority = 8, description = "Validate Verbiage in Forgot Acc page")
            public void GoToForgotAcc () {
                LandingPage forgotLink = new LandingPage(myDriver);
                forgotLink.Forgot();
                Assert.assertEquals(myDriver.getPageSource().contains("Find Your Account"), true);
            }
            @Test(alwaysRun = true, priority = 9, description = "Send Valid eamil but with out registration")
            public void SendValidateEmail () {
                ForgotAccountPage fakeemail = new ForgotAccountPage(myDriver);
                fakeemail.email("Myemail@noexist.com");
            }
            @Test(alwaysRun = true, priority = 10, description = "Validate Verbiage form Warning message")
            public void ValidateErrorMessage () throws InterruptedException {
                ForgotAccountPage errorVerbiage = new ForgotAccountPage(myDriver);
                errorVerbiage.ErrorMessage("No Search Results");
            }



}
