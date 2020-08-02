package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.BrowserHelper;
import env.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseHooks {
    @Before(order = 1)
    public void setUpBrowser() {
        BrowserHelper.setUpBrowser("Chrome");
    }

    @After(order = 0)
    public void quiteBrowser() {
        DriverManager.getDriver().quit();
    }

    @Before(order = 0)
    public void beforeScenarioStart(Scenario scenario) {
        System.out.println("-----------------Start of Scenario " + scenario.getName() + "-----------------");
    }


    @After(order = 1)
    public void afterScenarioFinish(Scenario scenario) {
        System.out.println("-----------------End of Scenario " + scenario.getName() + "-----------------");
    }
}
