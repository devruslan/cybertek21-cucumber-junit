package com.cybertek.step_definitions;

import com.cybertek.pages.DropDownPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class DataTable_StepDefinitions {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    DropDownPage dropDownPage = new DropDownPage();


    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> fruitList) {
        System.out.println(fruitList.size());
        System.out.println(fruitList);
    }

//  SmartBear below

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
    }

    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> loginInfo) {
        String username = loginInfo.get("username");
        String password = loginInfo.get("password");

        smartBearLoginPage.loginToSmartBear(username, password);
    }

    @Then("User should see title changed to Web Orders")
    public void user_should_see_title_changed_to_web_orders() {
        BrowserUtils.titleVerification("Web Orders");
    }

    //12 months below

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");

    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {

        Select monthDropdown = new Select(dropDownPage.monthDropdown);
        Assert.assertTrue(expectedList.equals(BrowserUtils.getElementsText(monthDropdown.getOptions())));


//        List<WebElement> monthsAsWebElements = monthDropdown.getOptions();
//        List<String> actualList = new ArrayList<>();
//        for (WebElement each : monthsAsWebElements) {
//            actualList.add(each.getText());
//        }
//        //v1
////        Assert.assertTrue(expectedList.equals(actualList));
//        //v2
//        for (int i = 0; i < actualList.size(); i++) {
//            Assert.assertTrue(actualList.get(i).equals(expectedList.get(i)));
//        }

    }

}

