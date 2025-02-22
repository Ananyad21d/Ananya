package cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static ExtentReports extent;
    static ExtentTest test;
    private static ExtentSparkReporter htmlReporter;

    @Before
    public void setup(Scenario scenario) {
        // Initialize WebDriver
        WebDriverSingleton.getDriver();

        // Initialize ExtentReports (only once)
        if (extent == null) {
            htmlReporter = new ExtentSparkReporter("extent-report.html");
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("Extent Report Example");
            htmlReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }

        // Create a new test case for each scenario
        test = extent.createTest(scenario.getName());
        System.out.println("WebDriver initialized and test started: " + scenario.getName());
    }

    @After
    public void teardown(Scenario scenario) {
        // Log the scenario status (Pass/Fail)
        if (scenario.isFailed()) {
            test.fail("Test failed: " + scenario.getName());
        } else {
            test.pass("Test passed: " + scenario.getName());
        }
        
        
        extent.flush();
    }
}
