package com.cybertek.utilities;

/*
We will create utility methods for repeated steps that can be used
in browsers, and store in this class.
 */

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*
    This method accepts List<WebElements> and returns List<String>
     */

    public static List<String> getElementsText(List<WebElement> webElementList) {

        //placeholder
        List<String> webElementsAsString = new ArrayList<>();

        //looping through web elements and storing text into the placeholder
        for (WebElement each : webElementList) {
            webElementsAsString.add(each.getText());
        }

        //returning final List<String>
        return webElementsAsString;
    }


    // method to assert title
    public static void titleVerification(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }


    //create method name: wait
    //converting milliseconds to seconds
    //handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

    public static void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

}
