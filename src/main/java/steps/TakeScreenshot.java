package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenshot {

    private WebDriver driver;

    public TakeScreenshot(WebDriver driver){
        this.driver = driver;
    }

    public void CaptureAndSave()
    {
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File screenshot=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        System.out.println ("Screenshot is saved at this location:" +  screenshot.getAbsolutePath ());
    }
}
