package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/cucumber.feature",
    glue = {"cucumber"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunnerClass extends AbstractTestNGCucumberTests {
   
}
