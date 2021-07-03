package com.cybertek.step_definitions;

import com.cybertek.pages.BasePage;
import io.cucumber.java.en.Given;

public class Etsy_StepDefinitions extends BasePage {


    //EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-11111111-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        myDriver.get("https://google.com");
        //Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-22222222-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

//    @Then("user should see Etsy title as expected")
//    public void user_should_see_etsy_title_as_expected() {
//        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
//        String actual = Driver.getDriver().getTitle();
//        Assert.assertTrue(actual.equals(expected));
//    }
//
//    @When("user searches for {string}")
//    public void userSearchesFor(String arg0) {
//        etsySearchPage.searchBox.sendKeys(arg0, Keys.ENTER);
//    }
//
//    @Then("user should see {string} in title")
//    public void userShouldSeeInTitle(String arg0) {
//        String expected = arg0 + " | Etsy";
//        String actual = Driver.getDriver().getTitle();
//        Assert.assertTrue(actual.equalsIgnoreCase(expected));
//    }
}
