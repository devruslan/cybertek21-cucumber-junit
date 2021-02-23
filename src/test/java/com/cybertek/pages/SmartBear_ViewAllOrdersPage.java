package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBear_ViewAllOrdersPage extends SmartBearBasePage{

    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement newCustomerCell;

}
