package TestCases;

import TestData.DataProviderTestNG;
import steps.GoogleSearchSteps;
import steps.IMBdPageSteps;

import org.testng.annotations.*;

import java.util.Map;

public class GetCast extends BaseClass{



    @Test(dataProvider = "GetSheetData", dataProviderClass = DataProviderTestNG.class)
    public void GetCastTest(Map<String, String> sheet) throws Exception {
       // Following lines of code will open the see all cast page from where the cast is to be fetched. :)
        GoogleSearchSteps googleSearchSteps = new GoogleSearchSteps (driver);
        googleSearchSteps.searchAfterLife (sheet.get("searchString"));
        IMBdPageSteps imBdPageSteps = new IMBdPageSteps (driver);
        imBdPageSteps.openSeeAllCast ();
        imBdPageSteps.writeCast ();

            }

}
