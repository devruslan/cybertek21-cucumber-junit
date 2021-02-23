package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.commons.math3.util.Precision;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    GasMileageCalculatorPage page = new GasMileageCalculatorPage();

    @Test
    public void gas_mileage_calculation() throws IOException {

        Driver.getDriver().get(ConfigurationReader.getProperty("calUrl"));
        String path = "src/test/resources/TestData/GasMileageTestData.xlsx";
        //load the file into inputStream object
        fileInputStream = new FileInputStream(path);
        //load the workbook to the class
        workbook = new XSSFWorkbook(path);
        //open sheet
        sheet = workbook.getSheet("Sheet1");

//        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            XSSFRow currentRow = sheet.getRow(1);

            double current = currentRow.getCell(1).getNumericCellValue();
            page.inputCurrentOdometer.clear();
            page.inputCurrentOdometer.sendKeys(String.valueOf(current));

            double previous = currentRow.getCell(2).getNumericCellValue();
            page.inputPreviousOdometer.clear();
            page.inputPreviousOdometer.sendKeys(String.valueOf(previous));

            double gas = currentRow.getCell(3).getNumericCellValue();
            page.inputGas.clear();
            page.inputGas.sendKeys(String.valueOf(gas));

            page.calcButton.click();

            double expectedResult = Precision.round((current - previous) / gas, 2);
            System.out.println("expectedResult = " + expectedResult);

            String actualResult = page.resultInGas.getText().split(" ")[0];
            System.out.println("actualResult = " + actualResult);

            //===========================

            //Write EXPECTED result to excel currentRow cell [4]
            if (currentRow.getCell(4) == null) currentRow.createCell(4);
            currentRow.getCell(4).setCellValue(expectedResult);

            //===========================

            //Write ACTUAL result to excel currentRow cell [5]
            if (currentRow.getCell(5) == null) currentRow.createCell(5);
            currentRow.getCell(5).setCellValue(actualResult);

            //===========================

            //Write TEST RESULT result to excel currentRow cell [6]

            if (currentRow.getCell(6) == null) currentRow.createCell(6);

            if (actualResult.equals(String.valueOf(expectedResult))) {
//            System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("PASS!");
            } else {
                //System.out.println("FAIL!!!");
                currentRow.getCell(6).setCellValue("PASS!");
            }

            //Write TIME result to excel currentRow cell [7]
            if (currentRow.getCell(7) == null) currentRow.createCell(7);
            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());

//        }

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
