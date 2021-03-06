package steps;

import utils.WaitBrowser;
import components.AddPostFlyer;
import components.PostFlyerNavBar;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPostFlyerSteps {

    private WebDriver driver;

    public AddPostFlyerSteps(WebDriver driver){
        this.driver = driver;
    }

    public void fillForm(String phone,String address, WaitBrowser addWait) {
        addWait.wait (driver).until (ExpectedConditions.visibilityOfElementLocated (PostFlyerNavBar.addPostFlyerButton)).click ();
        String Title = driver.findElement (AddPostFlyer.titleText).getText ();
        driver.findElement (AddPostFlyer.titleField).sendKeys (Title);
        //following loop will read the text for the details field.
        for (int line = 1; line <= 5; line++) {
            String detailLine = driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[" + line + "]/div/span")).getText ();
            driver.findElement ((AddPostFlyer.detailsField)).sendKeys (detailLine);
            driver.findElement ((AddPostFlyer.detailsField)).sendKeys (Keys.ENTER);
        }
        //following statements will add phone and address to the form.
        driver.findElement (AddPostFlyer.phoneField).sendKeys (phone);
        driver.findElement (AddPostFlyer.addressField).sendKeys (address);

    }
    public void submitForm()
    {
        driver.findElement(AddPostFlyer.submitButton).click();
        driver.findElement (PostFlyerNavBar.homeButton).click ();
    }

}
