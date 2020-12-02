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
import static FileReadAndWrite.ReadFileData.ReadFile;
import static org.testng.Assert.fail;



public class PostFlyer {
    public WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver= GetBrowser.getChromeDriver();

    }

    @Test

    public void test() throws Exception {
        WaitBrowser addWait= new WaitBrowser ();
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1603,792 | ]]
        driver.get("https://emumba-test.herokuapp.com/");
        addWait.wait (driver);
        //  signUp (driver);
        signIn (driver);

        addWait.wait(driver).until(ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"root\"]/div/header/div/div/nav/button[2]"))).click();

        addWait.wait(driver);
        String Title= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/h6")).getText ();
        String detailLine1= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[1]/div/span")).getText ();
        String detailLine2= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[2]/div/span")).getText ();
        String detailLine3= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[3]/div/span")).getText ();
        String detailLine4= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[4]/div/span")).getText ();
        String detailLine5= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li[5]/div/span")).getText ();

        System.out.println (Title + detailLine1 +detailLine2);
       // driver.findElement(By.cssSelector("h6.MuiTypography-root.jss832.MuiTypography-h6")).click();
      //  driver.findElement(By.cssSelector("div.MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-fullWidth.MuiInputBase-formControl.MuiInputBase-multiline.MuiOutlinedInput-multiline.MuiInputBase-adornedEnd.MuiOutlinedInput-adornedEnd")).click();
      //  driver.findElement(By.cssSelector("h6.MuiTypography-root.jss832.MuiTypography-h6")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [contextMenuAt | css=h6.MuiTypography-root.jss832.MuiTypography-h6 | 29,21]]
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(Title);
      //  driver.findElement(By.cssSelector("ul.MuiList-root.MuiList-dense.MuiList-padding")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [contextMenuAt | css=span.MuiTypography-root.MuiListItemText-primary.MuiTypography-body2.MuiTypography-displayBlock | 16,7]]
        // ERROR: Caught exception [ERROR: Unsupported command [contextMenuAt | name=details | 220,42]]
        driver.findElement(By.name("details")).click();
        driver.findElement(By.name("details")).clear();
        for(int line=1;line<=5;line++) {
            String detailLine= driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/ul/li["+line+"]/div/span")).getText();
            driver.findElement (By.name ("details")).sendKeys (detailLine);
            driver.findElement (By.name("details")).sendKeys (Keys.ENTER);
        }
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(ReadFile(7,1,0));
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(ReadFile(8,1,0));

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

    public  void Screenshot(String name)
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

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

