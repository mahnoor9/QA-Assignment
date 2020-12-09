package steps;

import components.GetCastIMBdPage;
import constants.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.List;
import java.util.ListIterator;
import static utils.ReadWriteFileData.write;

public class IMBdStepsImproved {

    private WebDriver driver;

    public IMBdStepsImproved(WebDriver driver){
        this.driver = driver;
    }

    public void openSeeAllCast()
    {
        driver.get(Constants.IMBdLink);
        driver.findElement(GetCastIMBdPage.seeFullCastButton).click();
    }

    public ListIterator<WebElement> getListOfCast()
    {
        WebElement table = driver.findElement (GetCastIMBdPage.castTable);
        List<WebElement> rows = table.findElements(GetCastIMBdPage.tableRows);
        ListIterator<WebElement> Iterator = rows.listIterator ();
        return Iterator;
    }

    public void writeCast() throws IOException {
        write(getListOfCast ());
    }

}
