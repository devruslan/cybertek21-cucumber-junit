package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestions {

    @Test
    public void findQuestions() {
        Driver.getDriver().get("https://learn.cybertekschool.com/courses/566/discussion_topics");
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        WebElement button = Driver.getDriver().findElement(By.id("okta-signin-submit"));
        BrowserUtils.sleep(1);
        username.sendKeys("");
        password.sendKeys("");
        button.click();
        BrowserUtils.sleep(1);
        WebElement pushButton = Driver.getDriver().findElement(By.xpath("//input[@value='Send Push']"));
        pushButton.click();
        BrowserUtils.sleep(2);
        List<WebElement> listMain = Driver.getDriver().findElements(By.xpath("//div[@class='ic-item-row__content-col']"));
        List<String> listAll = new ArrayList<>();
        List<WebElement> listQsNumeric;
        List<WebElement> listQsBullets;
        List<WebElement> listQsNone;
        int c = 3150; // total
        int c2 = 148;// company
        for (int i = 147; i < listMain.size(); i++) {
            BrowserUtils.sleep(2);
            listMain = Driver.getDriver().findElements(By.xpath("//div[@class='ic-item-row__content-col']"));
            BrowserUtils.sleep();
            listMain.get(i).click();
            BrowserUtils.sleep(1);
            WebElement h1 = Driver.getDriver().findElement(By.xpath("//h1[@class='discussion-title']"));
            listAll.clear();
            listAll.add((h1.getText().toUpperCase()));
            BrowserUtils.sleep(1);
            listQsNumeric = Driver.getDriver().findElements(By.xpath("//div[@class='message user_content enhanced']/ol/li"));
            BrowserUtils.sleep(1);
            listQsBullets = Driver.getDriver().findElements(By.xpath("//div[@class='message user_content enhanced']/ul/li"));
            BrowserUtils.sleep(1);
            listQsNone = Driver.getDriver().findElements(By.xpath("//div[@class='message user_content enhanced']/p"));
            BrowserUtils.sleep(1);
            if (listQsNumeric.size() != 0) {
                for (WebElement each : listQsNumeric)
                    if (!listAll.contains(each.getText())) {
                        String question = each.getText();
                        if (question.length() > 0)
                            for (int j = 0; j < question.length(); j++) {
                                if (Character.isLetter(question.charAt(j))) break;
                                if (question.length() > 1)
                                    question = question.substring(j + 1);
                            }
                        question = question.trim();
                        if (question.length() > 0) listAll.add(question);
                    }
            }
            if (listQsBullets.size() != 0) {
                for (WebElement each : listQsBullets)
                    if (!listAll.contains(each.getText())) {
                        String question = each.getText();
                        if (question.length() > 0)
                            for (int j = 0; j < question.length(); j++) {
                                if (Character.isLetter(question.charAt(j))) break;
                                if (question.length() > 1)
                                    question = question.substring(j + 1);
                            }
                        question = question.trim();
                        if (question.length() > 0) listAll.add(question);
                    }
            }
            if (listQsNone.size() != 0) {
                for (WebElement each : listQsNone)
                    if (!listAll.contains(each.getText())) {
                        String question = each.getText();
                        if (question.length() > 0)
                            for (int j = 0; j < question.length(); j++) {
                                if (Character.isLetter(question.charAt(j))) break;
                                if (question.length() > 1)
                                    question = question.substring(j + 1);
                            }
                        question = question.trim();
                        if (question.length() > 0) listAll.add(question);
                    }
            }
            for (int j = 0; j < listAll.size(); j++) {
                if (j != 0)
                    if (c <= 9) {
                        if (j <= 9) System.out.print("   " + c++ + ".  " + j + ". ");
                        else System.out.print("   " + c++ + ". " + j + ". ");
                    } else if (c <= 99) {
                        if (j <= 9) System.out.print("  " + c++ + ".  " + j + ". ");
                        else System.out.print("  " + c++ + ". " + j + ". ");
                    } else if (c <= 999) {
                        if (j <= 9) System.out.print(" " + c++ + ".  " + j + ". ");
                        else System.out.print(" " + c++ + ". " + j + ". ");
                    } else {
                        if (j <= 9) System.out.print(c++ + ".  " + j + ". ");
                        else System.out.print(c++ + ". " + j + ". ");
                    }
                else {
                    if (c2 <= 9) System.out.print("#  " + c2++ + ".  ");
                    else System.out.print("# " + c2++ + ".  ");
                }
                System.out.println(listAll.get(j));
            }
            System.out.println("---");
            BrowserUtils.sleep();
            Driver.getDriver().navigate().back();
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("--- harvesting completed ---");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//
//        List<String> nonDuplicates = new ArrayList<>();
//
//        for (int i = 0; i < listAll.size(); i++)
//            if (!nonDuplicates.contains(listAll.get(i))) nonDuplicates.add(listAll.get(i));
//
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//        System.out.println("--- duplicate removal completed ---");
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//
//        for (int i = 0; i < nonDuplicates.size(); i++)
//            System.out.println((i + 1) + " : " + nonDuplicates.get(i));
//
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//        System.out.println("--- non-duplicates print out completed ---");
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}


