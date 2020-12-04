package TestCases;

import FileReadAndWrite.ReadWriteFileData;
import OpenBrowser.GetBrowser;
import org.openqa.selenium.*;
import java.util.List;
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

        ReadWriteFileData cell=new ReadWriteFileData ();
        driver.get("chrome://newtab/");
        driver.get(cell.ReadFile (1,1,0));
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(cell.ReadFile (2,1,0));
        driver.findElement(By.name("q")).sendKeys (Keys.ENTER);
        driver.get("https://www.imdb.com/title/tt8398600/");
        driver.findElement(By.linkText("See full cast")).click();

        //Following is the for loop over the cast table to print the cast in excel sheet
        WebElement table = driver.findElement (By.xpath ("//table[@class='cast_list']"));
        List<WebElement> rows = table.findElements(By.tagName ("tr"));
       // rowCount is calculated and saved as integer rowCount
        int rowCount = 134;

        //After the row 114 the xpath changes so the condition for if is applied
        //for row 80 and 86 the xpath is different, so that condition is applied as well.
        // tried to generalized it but it CANNOT BE GENERALIZED :/
        
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

                //Saving the text in string and spliting it up for screen name and appearence.
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
                //Saving the text in string and spliting it up for screen name and appearence.
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


}
