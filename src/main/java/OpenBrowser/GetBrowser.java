package OpenBrowser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;
import static org.apache.commons.lang3.SystemUtils.*;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class GetBrowser {

    /**
     *          detect operating system
     *          if it is not one of the predefined ones, just throw exception
     *          only create a webDriver instance for a known operating system
     */

    public WebDriver getWinChromeDriver() {
        setProperty("webdriver.chrome.driver", "C:\\new folder 1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getChromeDriver() {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
            setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\resources\\chromedriver1.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }



    public WebDriver getChromeDriverCustomSize(int width, int height) {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
            setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\resources\\chromedriver1.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        return driver;
    }

}