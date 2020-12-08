package TestCases;

import steps.GoogleSearchSteps;
import steps.IMBdPageSteps;
import utils.GetBrowser;
import org.openqa.selenium.*;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class GetCast {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        driver= GetBrowser.getChromeDriver();
    }

    @Test
    public void test() throws Exception {
       // Following lines of code will open the see all cast page from where the cast is to be fetched. :)
        GoogleSearchSteps.searchAfterLife (driver);
        IMBdPageSteps.openSeeAllCast (driver);
        IMBdPageSteps.writeCast (driver);

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
