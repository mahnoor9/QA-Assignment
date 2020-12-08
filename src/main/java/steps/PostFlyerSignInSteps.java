package steps;

import components.PostFlyerSignIn;
import utils.WaitBrowser;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static components.PostFlyerSignIn.*;

public class PostFlyerSignInSteps {
    public static void enterCredentials(WebDriver driver) throws IOException {
        WaitBrowser addWait= new WaitBrowser ();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(emailField)).click();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(Constants.email);
        driver.findElement(components.PostFlyerSignIn.passwordField).click();
        driver.findElement(components.PostFlyerSignIn.passwordField).clear();
        driver.findElement(components.PostFlyerSignIn.passwordField).sendKeys(Constants.password);}
        public static void clickLogin(WebDriver driver)
        {
            WaitBrowser addWait= new WaitBrowser ();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public static void openLogin(WebDriver driver)
    {
        driver.findElement(LoginPage).click();
    }
}
