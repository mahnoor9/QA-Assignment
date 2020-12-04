package FileReadAndWrite;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadWriteFileData {
      //following function takes three arguments, rowNumber,cellNumber,SheetNumber and return the data of that entity in the sheet as a String
    public static String ReadFile (int rowNumber, int cellNumber, int sheetNumber) throws IOException {
        String val1=" ";
        File file = new File ("C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\java\\TestData\\qaautomation (1).xlsx");
        FileInputStream fs = new FileInputStream (file);
      //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook (fs);
        //XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
       CellType type = sheet.getRow (rowNumber).getCell (cellNumber).getCellType();
       //i separated the numeric and string cells, but then again returned them as string
        //seems like redundant work BUT WITHOUT IT THE CODE DOESN'T WORK
        // SO DONT YOU DARE TOUCH IT!!!!
       if(type == CellType.STRING) {
           val1 = sheet.getRow (rowNumber).getCell (cellNumber).getStringCellValue ();
           workbook.close();
       }
       else if(type == CellType.NUMERIC)
       {
           int val = (int) sheet.getRow (rowNumber).getCell (cellNumber).getNumericCellValue ();
           workbook.close();
           return String.valueOf (val);

       }
       return val1;
    }


    public static void WriteFile (String value, int rowNumber, int cellNumber, int sheetNumber) throws IOException {
        File file = new File ("C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\java\\TestData\\qaautomation (1).xlsx");
        FileInputStream fs = new FileInputStream (file);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook (fs);
        //following if condition was so necessary that without it the whole thing was falling apart. it checks:
        //if no cell already present for a row, new row will be created, otherwise the previous row iwll be used, in order
        //to not waste the data already present :)
        if(cellNumber==0) {
            XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
            Row newRow = sheet.createRow (rowNumber);
            Cell cell = newRow.createCell (cellNumber);
            cell.setCellValue ((String) value);
            FileOutputStream fo = new FileOutputStream (file);
            workbook.write (fo);
            workbook.close ();
        }
        else
        {
            XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
            Row newRow = sheet.getRow (rowNumber);
            Cell cell = newRow.createCell (cellNumber);
            cell.setCellValue ((String) value);
            FileOutputStream fo = new FileOutputStream (file);
            workbook.write (fo);
            workbook.close ();
        }

        }



    }



