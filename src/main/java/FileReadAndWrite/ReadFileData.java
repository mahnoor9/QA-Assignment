package FileReadAndWrite;

import java.io.*;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFileData {
    //following function takes three arguments, rowNumber,cellNumber,SheetNumber and return the that entity in the sheet
    public static String ReadFile (int rowNumber, int cellNumber, int sheetNumber) throws IOException {
        String val1=" ";
        int i= 12345678;
        System.out.println (String.valueOf (i));
        File file = new File ("C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\java\\TestData\\qaautomation (1).xlsx");
        FileInputStream fs = new FileInputStream (file);
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook (fs);
        //XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
       System.out.println (sheet.getRow (rowNumber).getCell (cellNumber));
       CellType type = sheet.getRow (rowNumber).getCell (cellNumber).getCellType();
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
        if(cellNumber==0) {
            XSSFSheet sheet = workbook.getSheet ("Series Cast");
            Row newRow = sheet.createRow (rowNumber);
            Cell cell = newRow.createCell (cellNumber);
            cell.setCellValue ((String) value);
            FileOutputStream fo = new FileOutputStream (file);
            workbook.write (fo);
            workbook.close ();
        }
        else
        {
            XSSFSheet sheet = workbook.getSheet ("Series Cast");
            Row newRow = sheet.getRow (rowNumber);
            Cell cell = newRow.createCell (cellNumber);
            cell.setCellValue ((String) value);
            FileOutputStream fo = new FileOutputStream (file);
            workbook.write (fo);
            workbook.close ();
        }

        }



    }




