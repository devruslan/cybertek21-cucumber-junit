package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EtsySearchPage extends BasePage {

//    public EtsySearchPage() {
//        PageFactory.initElements(myDriver, this);
//    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;


}
