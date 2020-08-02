package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverManager;
import org.openqa.selenium.By;
import pages.GoogleHomePage;
import pages.GoogleResultPage;
import utilities.State;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Definition of Cucumber test steps.
 */
public class SearchSteps {
    State state;

    public SearchSteps(State state) {
        this.state = state;
    }

    GoogleHomePage googleHomePage = new GoogleHomePage();
    GoogleResultPage googleResultPage = new GoogleResultPage();
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

    @Then("^the search term remained on the search box$")
    public void check_search_box() {
        assertEquals(googleResultPage.getSearchBoxText(), searchTerm);
    }

    @Then("^all of the web results should be contained the search term$")
    public void check_search_web_results() {
        assertTrue(googleResultPage.checkSearchWebResults(searchTerm));
    }

    @Then("^all of the people also ask results should be contained the search term$")
    public void check_search_ask_results() {
        assertTrue(googleResultPage.checkSearchPeopleAskResults(searchTerm));
    }

    @Then("^all of the top story results should be contained the search term$")
    public void check_search_story_results() {
        assertTrue(googleResultPage.checkSearchStoryResults(searchTerm));
    }

    @Then("^all of the video results should be contained the search term$")
    public void check_search_video_results() {
        assertTrue(googleResultPage.checkSearchVideoResults(searchTerm));
    }

    @Then("^user clicks on the first video$")
    public void user_clicks_on_the_first_video() {
        state.videoTitle = googleResultPage.getVideoResults().get(0).findElement(By.cssSelector("div[role=heading]")).getText();
        googleResultPage.clickOnVideo(0);
    }
}