package steps;

import utils.ReadWriteFileData;
import components.GetCastIMBdPage;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class IMBdPageSteps {
    public static void openSeeAllCast(WebDriver driver)
    {
        driver.get(Constants.IMBdLink);
        driver.findElement(GetCastIMBdPage.seeFullCastButton).click();
    }
    public static void writeCast(WebDriver driver) throws IOException {
        ReadWriteFileData cell=new ReadWriteFileData ();

        //Following is the for loop over the cast table to print the cast in excel sheet
        WebElement table = driver.findElement (GetCastIMBdPage.castTable);
        List<WebElement> rows = table.findElements(GetCastIMBdPage.tableRows);
        // rowCount is calculated and saved as integer rowCount
        int rowCount = rows.size ();
        //After the row 114 the xpath changes so the condition for if is applied
        //for row 80 and 86 the xpath is different, so that condition is applied as well.
        for (int i = 2, j = 1; i< rowCount && j<rowCount; i=i+2,j++) {
            String castName;
            String screenName;
            String appearance;
            if (i<114 && i != 80 && i != 86) {
                castName = driver.findElement (GetCastIMBdPage.castName (i)).getText ();
                cell.WriteFile (castName, j, 0, 3);
                screenName =driver.findElement(GetCastIMBdPage.screenName (i)).getText ();
                cell.WriteFile (screenName, j, 1, 3);
                appearance =driver.findElement(GetCastIMBdPage.appearance (i)).getText ();
                cell.WriteFile (appearance, j, 2, 3);

            }
            else if(i>114 )
            {
                castName = driver.findElement (GetCastIMBdPage.castNameForLastRows(i)).getText ();
                cell.WriteFile (castName, j, 0, 3);

                //Saving the text in string and spliting it up for screen name and appearence.
                String value= driver.findElement (GetCastIMBdPage.screenNameForLastRows (i)).getText ();
                String[] part= value.split("1",2);
                screenName= part[0];
                appearance= part[1];
                cell.WriteFile (screenName, j, 1, 3);
                cell.WriteFile (appearance, j, 2, 3);
            }

            else if( i==80 || i== 86)
            {
                castName = driver.findElement (GetCastIMBdPage.castName (i)).getText ();
                cell.WriteFile (castName, j, 0, 3);
                //Saving the text in string and spliting it up for screen name and appearence.
                String value= driver.findElement (GetCastIMBdPage.screenNameForRemaining(i)).getText ();
                String[] part= value.split("1",2);
                screenName= part[0];
                appearance= part[1];
                cell.WriteFile (screenName, j, 1, 3);
                cell.WriteFile (appearance, j, 2, 3);

            }
        }
    }
}
