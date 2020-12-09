package steps;

import utils.GetBrowser;
import org.openqa.selenium.WebDriver;

public class OpenPostFlyerApp {

    private WebDriver driver;

    public OpenPostFlyerApp(WebDriver driver){
        this.driver = driver;
    }

    public void open()
    {

        driver.get("https://emumba-test.herokuapp.com/");
    }
}
