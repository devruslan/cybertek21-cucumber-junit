package com.cybertek.step_definitions;

import com.cybertek.pages.BasePage;
import org.junit.Test;

public class TestTest extends BasePage {

    @Test
    public void t1(){
        myDriver.get("https://google.com");
    }

}
