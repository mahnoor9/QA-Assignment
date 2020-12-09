package TestData;

import org.testng.annotations.DataProvider;
import utils.ExcelSheettoMap;

import java.lang.reflect.Method;
import java.util.*;

public class DataProviderTestNG {

    @DataProvider(name = "GetSheetData")
    public static Iterator<Object[]> createDataMap(Method method) throws Exception {
        String sheetName = method.getName();

        //call the read excel file sheet to get a map of key,value pair for test data

        List<Map<String, String>> sheetValues =  ExcelSheettoMap.readSheet("src/test/resources/qaautomationdata.xlsx", sheetName);
        Collection<Object[]> data = new ArrayList<Object[]>();
        sheetValues.forEach(item -> data.add(new Object[]{item}));
        System.out.println (data.iterator ());
        return data.iterator();
    }


}

