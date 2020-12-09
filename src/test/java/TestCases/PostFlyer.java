package TestCases;

import TestData.DataProviderTestNG;
import steps.*;
import utils.WaitBrowser;
import org.testng.annotations.Test;

import java.util.Map;
import static org.testng.Assert.fail;



public class PostFlyer extends BaseClass{




    @Test(dataProvider = "GetSheetData", dataProviderClass = DataProviderTestNG.class)

    public void PostFlyerTest(Map<String, String> sheet) throws Exception {
        WaitBrowser addWait= new WaitBrowser ();
        OpenPostFlyerApp openPostFlyerApp = new OpenPostFlyerApp (driver);
        openPostFlyerApp.open ();
        WaitBrowser.wait (driver);
       // PostFlyerSignUpSteps postFlyerSignUpSteps = new PostFlyerSignUpSteps (driver);
       // postFlyerSignUpSteps.FillSignUpForm (sheet.get("firstName"),sheet.get("lastName"),sheet.get("email"),sheet.get("password"));
        WaitBrowser.wait (driver);
        PostFlyerSignInSteps postFlyerSignInSteps = new PostFlyerSignInSteps (driver);
       postFlyerSignInSteps.openLogin ();
       postFlyerSignInSteps.enterCredentials (sheet.get("email"),sheet.get("password"));
        postFlyerSignInSteps.clickLogin ();
        AddPostFlyerSteps addPostFlyerSteps = new AddPostFlyerSteps (driver);
        addPostFlyerSteps.fillForm (sheet.get("phone"),sheet.get("address"),addWait);
        addPostFlyerSteps.submitForm ();
       // TakeScreenshot takeScreenshot = new TakeScreenshot (driver);
       // takeScreenshot.CaptureAndSave ();

    }


}

