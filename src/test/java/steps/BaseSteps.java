package steps;

import cucumber.api.java.en.Then;
import env.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {

    @Then("^user wait for (\\d+) seconds$")
    public void wait_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
