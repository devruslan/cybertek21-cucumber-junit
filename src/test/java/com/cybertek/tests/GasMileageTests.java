package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.BrowserUtils;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    GasMileageCalculatorPage page = new GasMileageCalculatorPage();

    @Test
    public void gas_mileage_calculation() throws IOException {

        Driver.getDriver().get(ConfigurationReader.getProperty("calUrl"));
        String path = "src/test/resources/testData/GasMileageTestData.xlsx";

        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        System.out.println("getLastRowNum = " + sheet.getLastRowNum());

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            XSSFRow currentRow = sheet.getRow(i);

            //======================================================

            if (!currentRow.getCell(0).toString().equalsIgnoreCase("y")) {
                if (currentRow.getCell(6) == null)
                    currentRow.createCell(6);
                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }

            //======================================================

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

            String actualResult = Double.valueOf(page.resultInGas.getText().split(" ")[0])+"";
            System.out.println("actualResult = " + actualResult);

            //======================================================

            //Write EXPECTED result to excel currentRow cell [4]
            if (currentRow.getCell(4) == null)
                currentRow.createCell(4);

            currentRow.getCell(4).setCellValue(expectedResult);

            //======================================================

            //Write ACTUAL result to excel currentRow cell [5]
            if (currentRow.getCell(5) == null)
                currentRow.createCell(5);

            currentRow.getCell(5).setCellValue(actualResult);

            //======================================================

            //Write TEST RESULT result to excel currentRow cell [6]
            if (currentRow.getCell(6) == null)
                currentRow.createCell(6);

            if (actualResult.equals(String.valueOf(expectedResult))) {
                //System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("PASS!");
            } else {
                //System.out.println("FAIL!!!");
                currentRow.getCell(6).setCellValue("FAIL!");
            }

            //Write TIME result to excel currentRow cell [7]
            if (currentRow.getCell(7) == null)
                currentRow.createCell(7);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalTime.now().format(dtf));

        }

        /** Line35-de
         * workbook = new XSSFWorkbook(fileInputStream);
         * evezine
         * workbook = new XSSFWorkbook(path);
         * yazanda asagidaki erroru verir:
         * java.io.EOFException: Unexpected end of ZLIB input stream using Apache POI
         * Asagidaki 4 setir bu problemi hell edir:
         * (1) Fayli basqa ad ile save edirsen > (2) Orijinal fayli silirsen > (3) Yeni Faylin adini Orijinal faylin adi ile deyisdirirsen
         * */
//        fileOutputStream = new FileOutputStream(path+"_New");
//        workbook.write(fileOutputStream);
//        Files.delete(Paths.get(path));
//        Files.move(Paths.get(path+"_New"), Paths.get(path));

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();

        BrowserUtils.sleep();
        Driver.closeDriver();

    }
}
