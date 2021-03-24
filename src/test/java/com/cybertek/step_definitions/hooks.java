package com.cybertek.step_definitions;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    @Before
    public void beforeScenario(){
        System.out.println("--- myBefore each scenario ---");
    }


    @After
    public void tearDownScenario(){
        BrowserUtils.sleep(1);
        Driver.closeDriver();
        System.out.println("--- myAfter each scenario ---");
    }

}
