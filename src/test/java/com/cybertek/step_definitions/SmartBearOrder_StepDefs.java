package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.pages.SmartBearOrderPage;
import com.cybertek.pages.SmartBear_ViewAllOrdersPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrder_StepDefs {

    SmartBearLoginPage sb_login = new SmartBearLoginPage();
    SmartBearOrderPage sb_order = new SmartBearOrderPage();
    SmartBear_ViewAllOrdersPage sb_allOrders = new SmartBear_ViewAllOrdersPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
        BrowserUtils.sleep();
        sb_login.loginToSmartBear();
        sb_order.orderLink.click();

    }

    @Then("User fills out the form as followed from the table below:")
    public void user_fills_out_the_form_as_followed_from_the_table_below() {
    }

    @Then("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {
        BrowserUtils.sleep();
        Select dropdown = new Select(sb_order.productDropdown);
        dropdown.selectByVisibleText(string);
    }

    @Then("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {
        BrowserUtils.sleep();
        sb_order.quantity.sendKeys(Keys.BACK_SPACE + string);
    }

    @Then("User enters {string} to expected name")
    public void user_enters_to_expected_name(String string) {
        BrowserUtils.sleep();
        sb_order.customerName.sendKeys(string);
    }

    @Then("User enters {string} to street")
    public void user_enters_to_street(String string) {
        BrowserUtils.sleep();
        sb_order.street.sendKeys(string);
    }

    @Then("User enters {string} to city")
    public void user_enters_to_city(String string) {
        BrowserUtils.sleep();
        sb_order.inputCity.sendKeys(string);
    }

    @Then("User enters {string}  to state")
    public void user_enters_to_state(String string) {
        BrowserUtils.sleep();
        sb_order.inputState.sendKeys(string);
    }

    @Then("User enters {string} to zip")
    public void user_enters_to_zip(String string) {
        BrowserUtils.sleep();
        sb_order.inputZip.sendKeys(string);
    }

    @Then("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {
        BrowserUtils.sleep();
        sb_order.visaCredit.click();
    }

    @Then("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {
        BrowserUtils.sleep();
        sb_order.inputCardNumber.sendKeys(string);
    }

    @Then("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {
        BrowserUtils.sleep();
        sb_order.inputExpireDate.sendKeys(string);
    }

    @Then("User clicks process button")
    public void user_clicks_process_button() {
        BrowserUtils.sleep();
        sb_order.processButton.click();
    }

    @Then("User verifies {string} is in the list of names")
    public void user_verifies_is_in_the_list_of_names(String expectedName) {
        BrowserUtils.sleep();
        sb_order.viewAllOrdersLink.click();
        String actualName = sb_allOrders.newCustomerCell.getText();
        Assert.assertTrue(actualName.equals(expectedName));
    }


}
