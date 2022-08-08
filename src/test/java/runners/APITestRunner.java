package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @smoke - smoke suite
 * @token - token scenarios
 * @getAllExpenses - get all expenses scenario
 * @dashboard - dashboard API scenario
 * @dashboard2 - dashboard API with scenario outline
 * @getMonthlyExpenses - get monthly expenses API
 * @personalInfo - personal Info API
 * @flag - scenarios with flags
 * @createExpense - create expense scenario
 * @endToEnd - creates retrieves and deletes expense
 * @cleanUp - deletes data that was created during test run after scenario passed
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/apiFeatures",
        glue = {"api_automation.stepDefinition"},
        dryRun = false,
        monochrome = true,
        tags = {"@smoke or @ApiRegression"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
)
public class APITestRunner {

}