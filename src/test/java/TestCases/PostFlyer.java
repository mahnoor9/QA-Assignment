package TestCases;

import components.AddPostFlyer;
import components.PostFlyerSignIn;
import steps.*;
import utils.GetBrowser;
import utils.WaitBrowser;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;



public class PostFlyer {
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        driver= GetBrowser.getChromeDriver();
    }

    @Test

    public void test() throws Exception {
        WaitBrowser addWait= new WaitBrowser ();
        OpenPostFlyerApp.open (driver);
        WaitBrowser.wait (driver);
        //PostFlyerSignUpSteps.FillSignUpForm (driver);
        //WaitBrowser.wait (driver);
        //PostFlyerSignUpSteps.ClickSignUp (driver);
        PostFlyerSignInSteps.openLogin (driver);
        PostFlyerSignInSteps.enterCredentials (driver);
        PostFlyerSignInSteps.clickLogin (driver);
        AddPostFlyerSteps.fillForm (driver,addWait);
        AddPostFlyerSteps.submitForm (driver);
        TakeScreenshot.CaptureAndSave (driver);

    }




    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

