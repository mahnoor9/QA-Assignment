package steps;

import utils.GetBrowser;
import org.openqa.selenium.WebDriver;

public class OpenPostFlyerApp {

    public static void open(WebDriver driver)
    {

        driver.get("https://emumba-test.herokuapp.com/");
    }
}
