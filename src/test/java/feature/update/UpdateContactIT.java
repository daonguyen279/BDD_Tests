package feature.update;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

With(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/results/update" }
        , glue = { "steps" }
)
public class UpdateContactIT {
}