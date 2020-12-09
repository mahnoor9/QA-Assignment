package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelSheettoMap {


    public static List<Map<String, String>> readSheet(String path, String sheetName) throws Exception {
        try {
            FileInputStream File = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(File);
            XSSFSheet sheet = wb.getSheet(sheetName);

            List<Map<String, String>> sheetValues = new ArrayList<Map<String, String>>();

            XSSFRow firstRow = sheet.getRow(0);

            //calculates the row and col count for the loop:
            int rowCount = sheet.getLastRowNum()+1;
            int colCount= firstRow.getLastCellNum();

            // loop to iterate over the sheet to get test data
            for(int row=1; row<rowCount; row++){
                Map<String, String> hashMapForSheet = new HashMap<String, String>();
                for(int col=0; col<colCount; col++){
                    hashMapForSheet.put(firstRow.getCell(col).toString(), sheet.getRow(row).getCell(col).toString());
                }
                sheetValues.add(hashMapForSheet);
            }

            return sheetValues;


        } catch (Exception e) {
            throw (e);
        }
    }

}
