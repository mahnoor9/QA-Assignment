package steps;

import utils.WaitBrowser;
import components.GetCastGooglePage;
import constants.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {

    public static void searchAfterLife(WebDriver driver)
    {
        WaitBrowser wait1= new WaitBrowser();

        driver.get(Constants.googleLink);
        driver.findElement(GetCastGooglePage.searchBar).clear();
        driver.findElement(GetCastGooglePage.searchBar).sendKeys(Constants.searchString);
        driver.findElement(GetCastGooglePage.searchBar).sendKeys (Keys.ENTER);
    }
}
