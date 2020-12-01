package FileReadAndWrite;

import java.io.*;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFileData {
    //following function takes three arguments, rowNumber,cellNumber,SheetNumber and return the that entity in the sheet
    public static String ReadFile (int rowNumber, int cellNumber, int sheetNumber) throws IOException {

        File file = new File ("C:\\Users\\dell\\IdeaProjects\\QAAssignment\\src\\main\\java\\TestData\\qaautomation (1).xlsx");
        FileInputStream fs = new FileInputStream (file);
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook (fs);
        //XSSFSheet sheet = workbook.getSheetAt (sheetNumber);
        XSSFSheet sheet = workbook.getSheetAt(0);
       System.out.println (sheet.getRow (rowNumber).getCell (cellNumber));
        String val = sheet.getRow (rowNumber).getCell (cellNumber).getStringCellValue ();
        workbook.close();
        return val;


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

        public static void main(String[] args)
        {
            String a = "tony 1 episode,season 1,2";
            String[] v= a.split ("1",2);
            System.out.println (v[0]);
            System.out.println ("break");
            System.out.println (v[1]);
        }

    }




