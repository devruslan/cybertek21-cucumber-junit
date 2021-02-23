package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("wikiUrl"));
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiSearchPage.searchBox.sendKeys(string);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_in_the_wiki_title(String string) {
        String expected = string + " - Wikipedia";
        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.equalsIgnoreCase(expected));
    }

    @Then("User sees {string} in the main header")
    public void userSeesInTheMainHeader(String arg0) {
        String expected = arg0;
        String actual = wikiSearchPage.mainHeader.getText();
        Assert.assertTrue(actual.equalsIgnoreCase(expected));
        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
    }
}
