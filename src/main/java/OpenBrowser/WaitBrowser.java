package OpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitBrowser {
    public static WebDriverWait wait (WebDriver driver1) {
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.ofSeconds (6));
        return wait1;
    }
}