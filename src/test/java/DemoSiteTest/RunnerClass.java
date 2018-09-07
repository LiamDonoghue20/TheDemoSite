package DemoSiteTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty","json:target/cucumberreports.json" },
                glue = "stepDefinition",
                features = "src/test/resources/TestCases/"
)

public class RunnerClass {
}
