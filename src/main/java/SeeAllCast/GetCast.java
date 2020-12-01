package SeeAllCast;

import FileReadAndWrite.ReadFileData;
import OpenBrowser.GetBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class GetCast {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        //driver = new ChromeDriver();

       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver= GetBrowser.getChromeDriver();
       // baseUrl = "https://www.blazedemo.com/";
    }

    @Test
    public void test() throws Exception {
        // Label: Test
        // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1603,760 | ]]
        ReadFileData cell=new ReadFileData ();
        driver.get(baseUrl + "chrome://newtab/");
        driver.get(cell.ReadFile (1,1,0));
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(cell.ReadFile (2,1,0));
        driver.findElement(By.name("q")).sendKeys (Keys.ENTER);
       // String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        //String s= "//span[text()='"+(cell.ReadFile (3,1,0))+"']";
        //driver.wait();
        //driver.findElement(By.xpath(s)).sendKeys (selectLinkOpeninNewTab);
        driver.get("https://www.imdb.com/title/tt8398600/");
        driver.findElement(By.linkText("See full cast")).click();

        //Following is the for loop over the cast table to print the cast in excel sheet
        WebElement table = driver.findElement (By.xpath ("//table[@class='cast_list']"));
        List<WebElement> rows = table.findElements(By.tagName ("tr"));
       // int rowCount = rows.size();
        int rowCount = 134;

        
        for (int i = 2, j = 1; i< rowCount && j<rowCount; i=i+2,j++) {
            String castName;
            String screenName;
            String appearance;
            if (i<114 && i != 80 && i != 86) {
                castName = driver.findElement (By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr[" + i + "]/td[2]/a")).getText ();
                cell.WriteFile (castName, j, 0, 3);
                screenName =driver.findElement(By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]/a[1]")).getText ();
              cell.WriteFile (screenName, j, 1, 3);
                appearance =driver.findElement(By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]/a[2]")).getText ();
              cell.WriteFile (appearance, j, 2, 3);

            }
            else if(i>114 )
            {
                castName = driver.findElement (By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr[" + (i+1) + "]/td[2]/a")).getText ();
                cell.WriteFile (castName, j, 0, 3);
                String value= driver.findElement (By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+(i+1)+"]/td[4]")).getText ();
                String[] part= value.split("1",2);
                screenName= part[0];
                appearance= part[1];
                cell.WriteFile (screenName, j, 1, 3);
                cell.WriteFile (appearance, j, 2, 3);
            }

            else if( i==80 || i== 86)
            {
                castName = driver.findElement (By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr[" + i + "]/td[2]/a")).getText ();
                cell.WriteFile (castName, j, 0, 3);
                String value= driver.findElement (By.xpath ("//*[@id=\"fullcredits_content\"]/table[3]/tbody/tr["+i+"]/td[4]")).getText ();
                String[] part= value.split("1",2);
                screenName= part[0];
                appearance= part[1];
                cell.WriteFile (screenName, j, 1, 3);
                cell.WriteFile (appearance, j, 2, 3);

            }
        }
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
