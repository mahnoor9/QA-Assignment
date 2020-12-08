package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//this class is an antidote to laziness,it will add wait to the browser
//see some elements are lazy and take time to be available for usage
//so this class serves the purpose
public class WaitBrowser {

    public static WebDriverWait wait (WebDriver driver1) {
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.ofSeconds (6));
        return wait1;
    }
}