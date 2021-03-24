package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoDaddy {

    @Test
    public void godaddy() {
        Actions a = new Actions(Driver.getDriver());
        Driver.getDriver().get("https://godaddy.com");
        WebElement searchMain = Driver.getDriver().findElement(By.xpath("//input[@name='domainToCheck']"));
        searchMain.sendKeys("a" + Keys.RETURN);
        int count = 0;
        int total = 0;

        for (int i5 = 'a'; i5 <= 'z'; i5++) {
            String searchKey = "" + (char) i5;
            WebElement search = Driver.getDriver().findElement(By.id("domain-search-box"));
            a.moveToElement(search).doubleClick().perform();
            search.sendKeys(searchKey + Keys.RETURN);
            WebElement result = Driver.getDriver().findElement
                    (By.xpath("//div[@id='exact-match']//*[contains(text(), '" + searchKey + ".com')]"));
            if (!result.getText().contains("taken")) {
                WebElement priceInfo = Driver.getDriver().findElement(By.xpath("//span[@class='ms7 text-primary-o']"));
                System.out.println(searchKey + " = " + result.getText() + " | " + priceInfo.getText());
                count++;
                total++;
            }
        }

        System.out.println("--- 1 Char - COMPLETED [Total: " +  count + " | Grand Total: " + total + "] ---");

        count = 0;
        for (int i4 = 'a'; i4 <= 'z'; i4++)
            for (int i5 = 'a'; i5 <= 'z'; i5++) {
                String searchKey = "" + (char) i4 + (char) i5;
                WebElement search = Driver.getDriver().findElement(By.id("domain-search-box"));
                a.moveToElement(search).doubleClick().perform();
                search.sendKeys(searchKey + Keys.RETURN);
                WebElement result = Driver.getDriver().findElement
                        (By.xpath("//div[@id='exact-match']//*[contains(text(), '" + searchKey + ".com')]"));
                if (!result.getText().contains("taken")) {
                    WebElement priceInfo = Driver.getDriver().findElement(By.xpath("//span[@class='ms7 text-primary-o']"));
                    System.out.println(searchKey + " = " + result.getText() + " | " + priceInfo.getText());
                    count++;
                    total++;
                }
            }

        System.out.println("--- 2 Char - COMPLETED [Total: " +  count + " | Grand Total: " + total + "] ---");

        count = 0;
        for (int i3 = 'a'; i3 <= 'z'; i3++)
            for (int i4 = 'a'; i4 <= 'z'; i4++)
                for (int i5 = 'a'; i5 <= 'z'; i5++) {
                    String searchKey = "" + (char) i3 + (char) i4 + (char) i5;
                    WebElement search = Driver.getDriver().findElement(By.id("domain-search-box"));
                    a.moveToElement(search).doubleClick().perform();
                    search.sendKeys(searchKey + Keys.RETURN);
                    WebElement result = Driver.getDriver().findElement
                            (By.xpath("//div[@id='exact-match']//*[contains(text(), '" + searchKey + ".com')]"));
                    if (!result.getText().contains("taken")) {
                        WebElement priceInfo = Driver.getDriver().findElement(By.xpath("//span[@class='ms7 text-primary-o']"));
                        System.out.println(searchKey + " = " + result.getText() + " | " + priceInfo.getText());
                        count++;
                        total++;
                    }
                }

        System.out.println("--- 3 Char - COMPLETED [Total: " +  count + " | Grand Total: " + total + "] ---");

        count = 0;
        for (int i2 = 'a'; i2 <= 'z'; i2++)
            for (int i3 = 'a'; i3 <= 'z'; i3++)
                for (int i4 = 'a'; i4 <= 'z'; i4++)
                    for (int i5 = 'a'; i5 <= 'z'; i5++) {
                        String searchKey = "" + (char) i2 + (char) i3 + (char) i4 + (char) i5;
                        WebElement search = Driver.getDriver().findElement(By.id("domain-search-box"));
                        a.moveToElement(search).doubleClick().perform();
                        search.sendKeys(searchKey + Keys.RETURN);
                        WebElement result = Driver.getDriver().findElement
                                (By.xpath("//div[@id='exact-match']//*[contains(text(), '" + searchKey + ".com')]"));
                        if (!result.getText().contains("taken")) {
                            WebElement priceInfo = Driver.getDriver().findElement(By.xpath("//span[@class='ms7 text-primary-o']"));
                            System.out.println(searchKey + " = " + result.getText() + " | " + priceInfo.getText());
                            count++;
                            total++;
                        }
                    }

        System.out.println("--- 4 Char - COMPLETED [Total: " +  count + " | Grand Total: " + total + "] ---");

        count = 0;
        for (int i1 = 'a'; i1 <= 'z'; i1++)
            for (int i2 = 'a'; i2 <= 'z'; i2++)
                for (int i3 = 'a'; i3 <= 'z'; i3++)
                    for (int i4 = 'a'; i4 <= 'z'; i4++)
                        for (int i5 = 'a'; i5 <= 'z'; i5++) {
                            String searchKey = "" + (char) i1 + (char) i2 + (char) i3 + (char) i4 + (char) i5;
                            WebElement search = Driver.getDriver().findElement(By.id("domain-search-box"));
                            a.moveToElement(search).doubleClick().perform();
                            search.sendKeys(searchKey + Keys.RETURN);
                            WebElement result = Driver.getDriver().findElement
                                    (By.xpath("//div[@id='exact-match']//*[contains(text(), '" + searchKey + ".com')]"));
                            if (!result.getText().contains("taken")) {
                                WebElement priceInfo = Driver.getDriver().findElement(By.xpath("//span[@class='ms7 text-primary-o']"));
                                System.out.println(searchKey + " = " + result.getText() + " | " + priceInfo.getText());
                                count++;
                                total++;
                            }
                        }

        System.out.println("--- 5 Char - COMPLETED [Total: " +  count + " | Grand Total: " + total + "] ---");

    }

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}


/*

<span data-cy="exact-match-price-main" class="ms7 text-primary-o">$1.00/mo</span>

<span data-cy="exact-match-price-main" class="ms7 text-primary-o">$6,000,000.00</span>

//span

 */