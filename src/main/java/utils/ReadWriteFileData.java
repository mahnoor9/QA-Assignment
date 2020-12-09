package utils;

import java.io.*;
import java.util.ListIterator;
import java.util.regex.Pattern;

import constants.Constants;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


public class ReadWriteFileData {
    public static void main(String[] args) throws IOException {
     System.out.println (ReadFile (4,0,1));
    }
      //following function takes three arguments, rowNumber,cellNumber,SheetNumber and return the data of that entity in the sheet as a String
    public static String ReadFile (int rowNumber, int cellNumber, int sheetNumber) throws IOException {
        String val1=" ";
        File file = new File ("src/test/resources/qaautomation.xlsx");
        FileInputStream fs = new FileInputStream (file);
      //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook (fs);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
       CellType type = sheet.getRow (rowNumber).getCell (cellNumber).getCellType();
       if(type == CellType.STRING)
       {
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


        public static void write(ListIterator<WebElement> Iterator) throws IOException {
            File file = new File ("src/test/resources/qaautomation.xlsx");
            FileInputStream fs = new FileInputStream (file);
            //Creating a workbook
            XSSFWorkbook workbook = new XSSFWorkbook (fs);
            XSSFSheet sheet = workbook.getSheetAt (3);

            int rowIndex= 1;
            while (Iterator.hasNext()) {

                WebElement e = Iterator.next();

                Row row = sheet.createRow(rowIndex++);
                String Total= e.getText ();
                String[] dummy=Total.split ("/n",2);
                String[] name= dummy[0].split (Pattern.quote ("."));
                row.createCell(0).setCellValue(name[0]);
                String remaining= Total.substring (Total.lastIndexOf (".")+1);
                row.createCell (1).setCellValue (remaining);

                FileOutputStream fo = new FileOutputStream (file);
                workbook.write (fo);
            }
            workbook.close ();
        }



    }




