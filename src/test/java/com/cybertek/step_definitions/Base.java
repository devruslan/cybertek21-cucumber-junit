package com.cybertek.step_definitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public WebDriver myDriver;

    public Base(){
        System.out.println("-=-=-=-=-=-=-=-=-=-@Before(>)-=-=-=-=-=-=-=-=-=-");
        driverSetup();
        System.out.println("-=-=-=-=-=-=-=-=-=-@Before(<)-=-=-=-=-=-=-=-=-=-");
    }

    public void driverSetup(){
        System.out.println("-=-=-=-=-=-=-=-=-=-driverSetup(>)-=-=-=-=-=-=-=-=-=-");
        WebDriverManager.chromedriver().setup();
        myDriver = new ChromeDriver();
        System.out.println("-=-=-=-=-=-=-=-=-=-driverSetup(<)-=-=-=-=-=-=-=-=-=-");

    }
}
