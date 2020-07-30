package steps;
import env.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.BrowserHelper;

public class BaseSteps {

    @Before
    public void beforeScenario(String browser) {
        BrowserHelper.setUpBrowser(browser);
    }

    @After
    public void afterScenario() {
        DriverManager.getDriver().quit();
    }
}
