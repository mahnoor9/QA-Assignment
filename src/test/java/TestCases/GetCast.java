package TestCases;

import TestData.DataProviderTestNG;

import org.testng.annotations.*;
import steps.IMBdStepsImproved;

import java.util.Map;

public class GetCast extends BaseClass{



    @Test(dataProvider = "GetSheetData", dataProviderClass = DataProviderTestNG.class)
    public void GetCastTest(Map<String, String> sheet) throws Exception {
       // Following lines of code will open the see all cast page from where the cast is to be fetched. :)
        //oogleSearchSteps googleSearchSteps = new GoogleSearchSteps (driver);
        //googleSearchSteps.searchAfterLife (sheet.get("searchString"));
        IMBdStepsImproved imBdPageSteps = new IMBdStepsImproved (driver);
        imBdPageSteps.openSeeAllCast ();
        imBdPageSteps.writeCast ();

            }

}
