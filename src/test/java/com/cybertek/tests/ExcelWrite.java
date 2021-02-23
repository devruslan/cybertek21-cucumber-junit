package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_write_() throws IOException {
        String path = "SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileInputStream);//returns workbook
        sheet = workbook.getSheet("Employees");//returns sheet
        row = sheet.getRow(1);//returns row
        cell = row.getCell(1);/** returns cell !!!!!!!!!!!!!!!!!!!!!!!!!!!!! */

        XSSFCell adamCell = sheet.getRow(2).getCell(0);

        System.out.println("Before = " + adamCell);

        adamCell.setCellValue("Madam");

        System.out.println("After = " + adamCell);

        //======================================================

        //TODO: CHANGE STEVEN'S NAME TO TOM

        /*
        Static way of the solution
        */

//        XSSFCell stevenCell= sheet.getRow(1).getCell(0);
//        stevenCell.setCellValue("Tom");
//        System.out.println("stevenCell = " + stevenCell);

        /*
        Dynamic way of the solution
        */

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Steven")){
                sheet.getRow(i).getCell(0).setCellValue("Tom");
            }
        }



        //======================================================

        /** --- WRITE --- */
        //load the file to output stream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        //write to the file using workbook object
        workbook.write(fileOutputStream);

        /** --- CLOSE THEM ALL --- */
        //to have more control over when closing the files you can close them
        //before garbage collector closes them after you are DONE with the file
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
