package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverManager;
import pages.GoogleHomePage;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Definition of Cucumber test steps.
 */
public class SearchSteps {
    GoogleHomePage googleHomePage = new GoogleHomePage();
    private String searchTerm;

    @Given("^user is on google search page$")
    public void user_is_on_google_search_page() {
        DriverManager.getDriver().get("https://www.google.com/");
    }

    @And("^searches for (.+)$")
    public void searches_for_something(String searchTerm) {
        this.searchTerm = searchTerm;
        googleHomePage.searchWith(searchTerm);
    }


    @When("^user clicks on search button$")
    public void user_clicks_on_search_button() {
        googleHomePage.clickOnSearchButton();
    }


    @Then("^all of the results should be contained the search team$")
    public void check_search_result() {
        assertTrue(googleHomePage.checkSearchResult(searchTerm));
    }
}