package TestCases;

import OpenBrowser.GetBrowser;
import OpenBrowser.WaitBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import static FileReadAndWrite.ReadWriteFileData.ReadFile;
import static org.testng.Assert.fail;



public class PostFlyer {
    public WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        driver= GetBrowser.getChromeDriver();

    }

    @Test

    public void test() throws Exception {
        WaitBrowser addWait= new WaitBrowser ();
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1603,792 | ]]
        driver.get("https://emumba-test.herokuapp.com/");
        addWait.wait (driver);
        //if you want to uncomment the signup method plz go to the sheet and update the email there. :)
        //  signUp (driver);
        signIn (driver);
        AddPostFlyer (driver,addWait);
        Screenshot ();

    }

    public static void AddPostFlyer(WebDriver driver, WaitBrowser addWait) throws IOException {
        addWait.wait(driver).until(ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"root\"]/div/header/div/div/nav/button[2]"))).click();

        addWait.wait(driver);
        String Title= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/h6")).getText ();
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(Title);
        driver.findElement(By.name("details")).click();
        driver.findElement(By.name("details")).clear();
        //following loop will read the text for the details field.
        for(int line=1;line<=5;line++) {
            String detailLine= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li["+line+"]/div/span")).getText();
            driver.findElement (By.name ("details")).sendKeys (detailLine);
            driver.findElement (By.name("details")).sendKeys (Keys.ENTER);
        }
        //following statements will add phone and address to the form.
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(ReadFile(7,1,0));
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(ReadFile(8,1,0));

        //following piece of code will add the tags from the sheet to the form, lets not uncomment it
        // because there is a little error that is being fixed.
        // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/form/div[4]/div/div")).clear();
       /* String xpath_tag="//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/form/div[4]/div";
        for(int tagNumber=9;tagNumber<12;tagNumber++)
        {
            addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_tag))).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/form/div[4]/div/div")).click();
         //  addWait.wait(driver).until(ExpectedConditions.visibilityOfElementLocated (By.xpath()).sendKeys(ReadFile(tagNumber,1,0));
            //driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/form/div[4]/div/div/fieldset")).sendKeys ("aa");

            addWait.wait(driver).until(ExpectedConditions.elementToBeClickable (By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/form/div[4]/div")));
          //  driver.findElement(By.xpath(xpath_tag)).sendKeys(Keys.ENTER);
            System.out.println ("one");
            addWait.wait (driver);
            addWait.wait (driver);
            System.out.println ("one");
        } */

        driver.findElement(By.xpath("//div[@id='root']/div/header/div/div/nav/button[3]/span")).click();
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/header/div/div/nav/button[1]")).click ();
        addWait.wait (driver).until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"root\"]/div/header/div/div/h6")));

    }

    public static void signUp(WebDriver driver) throws IOException {
        driver.findElement(By.xpath("//div[@id='root']/div/header/div/div/nav/button[3]/span")).click();
        driver.findElement(By.linkText("Not a user yet?")).click();
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(ReadFile(4,0,3));
        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(ReadFile(4,1,3));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(ReadFile(5,1,0));
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(ReadFile(6,1,0));
        driver.findElement(By.name("confirm_password")).click();
        driver.findElement(By.name("confirm_password")).clear();
        driver.findElement(By.name("confirm_password")).sendKeys(ReadFile(6,1,0));
        driver.findElement (By.xpath ("//*[@id=\"root\"]/div/div/div/div/div/form/div[5]/button/span[1]")).click();
    }

    public static void signIn(WebDriver driver) throws IOException {
        WaitBrowser addWait= new WaitBrowser ();
        driver.findElement(By.xpath("//div[@id='root']/div/header/div/div/nav/button[3]/span")).click();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(By.name("email"))).click();
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input"))).sendKeys(ReadFile(5,1,0));
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(ReadFile(6,1,0));
        addWait.wait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/button/span[1]"))).click();
        System.out.println ("hey");
    }

    public  void Screenshot()
    {
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File screenshot=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        System.out.println ("Screenshot is saved at this location:" +  screenshot.getAbsolutePath ());
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

