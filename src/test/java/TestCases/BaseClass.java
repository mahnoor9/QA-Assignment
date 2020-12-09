package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.GetBrowser;

import static org.testng.Assert.fail;

public class BaseClass {
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        driver= GetBrowser.getChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
