package steps;

import components.PostFlyerSignIn;
import utils.WaitBrowser;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static components.PostFlyerSignIn.*;

public class PostFlyerSignInSteps {
    private WebDriver driver;

    public PostFlyerSignInSteps(WebDriver driver){
        this.driver = driver;
    }

    public void enterCredentials(String email,String password) throws IOException {
        WaitBrowser addWait= new WaitBrowser ();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(emailField)).click();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
        driver.findElement(components.PostFlyerSignIn.passwordField).click();
        driver.findElement(components.PostFlyerSignIn.passwordField).clear();
        driver.findElement(components.PostFlyerSignIn.passwordField).sendKeys(password);}
        public  void clickLogin()
        {
            WaitBrowser addWait= new WaitBrowser ();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public void openLogin()
    {
        driver.findElement(LoginPage).click();
    }
}
