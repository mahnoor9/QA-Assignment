package steps;

import components.PostFlyerSignUp;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import utils.WaitBrowser;

import static components.PostFlyerSignIn.LoginPage;
import static components.PostFlyerSignUp.signUpButton;

public class PostFlyerSignUpSteps {
    private WebDriver driver;

    public PostFlyerSignUpSteps(WebDriver driver){
        this.driver = driver;
    }
    public void FillSignUpForm(String firstName,String lastName, String emailField, String password)
    {
        driver.findElement(LoginPage).click();
        driver.findElement(PostFlyerSignUp.notAUserYetButton).click();
        driver.findElement(PostFlyerSignUp.firstNameField).click();
        driver.findElement(PostFlyerSignUp.firstNameField).clear();
        driver.findElement(PostFlyerSignUp.firstNameField).sendKeys(firstName);
        driver.findElement(PostFlyerSignUp.lastNameField).click();
        driver.findElement(PostFlyerSignUp.lastNameField).clear();
        driver.findElement(PostFlyerSignUp.lastNameField).sendKeys(lastName);
        driver.findElement(PostFlyerSignUp.emailField).click();
        driver.findElement(PostFlyerSignUp.emailField).clear();
        driver.findElement(PostFlyerSignUp.emailField).sendKeys(emailField);
        driver.findElement(PostFlyerSignUp.passwordField).click();
        driver.findElement(PostFlyerSignUp.passwordField).clear();
        driver.findElement(PostFlyerSignUp.passwordField).sendKeys(password);
        driver.findElement(PostFlyerSignUp.confirmPasswordField).click();
        driver.findElement(PostFlyerSignUp.confirmPasswordField).clear();
        driver.findElement(PostFlyerSignUp.confirmPasswordField).sendKeys(password);
    }

    public void ClickSignUp()
    {
        WaitBrowser.wait (driver);
        driver.findElement (signUpButton).click();
    }

}
