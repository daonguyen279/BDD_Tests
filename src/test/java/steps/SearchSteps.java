package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import env.DriverManager;
import org.junit.Assert;
import pages.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Definition of Cucumber test steps.
 */
public class SearchSteps extends BaseSteps{
    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Given("^user is on google search page $")
    public void user_is_on_google_search_page() {
        DriverManager.getDriver().get("https://www.google.com/");
    }


    @And("^searches for $")
    public void searches_for_something(String searchTerm){
        googleHomePage.searchWith(searchTerm);
    }


    @When("^user clicks on search button$")
    public void user_clicks_on_search_button()  {
        googleHomePage.clickOnSearchButton();
    }


    @Then("All of the results should be contained the search team $")
    public void check_search_result()  {

    }
}