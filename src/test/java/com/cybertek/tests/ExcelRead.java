package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void excel_read_test() throws IOException {

        String path = "src/test/resources/testData/SampleData.xlsx";
        //Load the file in order to be able to read from it
        FileInputStream fileInputStream = new FileInputStream(path);

        //Remember excel hierarchy: workbook > sheet > row > cell

        //Create wordbook instance and load with "SampleData" file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //Create the sheet and pass the name of the sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        //                  sheet       row             cell
        System.out.println(sheet.getRow(1).getCell(0));// returns a cell not a String. use .toString or concat to ""

        // Print out singer
        System.out.println(sheet.getRow(3).getCell(2));// returns a cell not a String. use .toString or concat to ""

        //return the count of used cells
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        //TODO: 1- CREATE A LOGIC TO PRINT OUT NEENA FIRSTNAME DYNAMICALLY

        for (int i = 0; i < usedRows; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Neena"))
                System.out.println("Result is: " + sheet.getRow(i).getCell(0));
        }

        //TODO: 2- CREATE A LOGIC TO PRINT OUT SANDLER LASTNAME DYNAMICALLY

        for (int i = 0; i < usedRows; i++) {
            if ((sheet.getRow(i).getCell(1) + "").equals("Sandler"))
                System.out.println("Result is: " + sheet.getRow(i).getCell(1));
        }
        //TODO: 3- CREATE A LOGIC TO PRINT OUT KING's JOB_ID DYNAMICALLY

        for (int i = 0; i < usedRows; i++) {
            if ((sheet.getRow(i).getCell(1) + "").equals("King"))
                System.out.println("Result is: " + sheet.getRow(i).getCell(2));
        }



    }
}
