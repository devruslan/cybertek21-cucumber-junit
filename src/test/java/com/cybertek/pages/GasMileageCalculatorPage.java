package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage {

    public GasMileageCalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "uscodreading")
    public WebElement inputCurrentOdometer;
    @FindBy(id = "uspodreading")
    public WebElement inputPreviousOdometer;
    @FindBy(id = "usgasputin")
    public WebElement inputGas;
    @FindBy(xpath = "(//input[@alt='Calculate'])[1]")
    public WebElement calcButton;
    @FindBy(xpath = "//b[contains(text(),'mpg')]") // <font color="green"> <b>10.25 mpg</b> </font>
    public WebElement resultInGas;

}
