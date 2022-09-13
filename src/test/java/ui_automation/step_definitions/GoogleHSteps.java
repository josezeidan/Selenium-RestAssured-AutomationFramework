package ui_automation.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.GoogleHPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.List;

public class GoogleHSteps {

    public static final Logger oLog = LogManager.getLogger(GoogleHSteps.class);
    WebDriver driver = Driver.getInstance().getDriver();

    GoogleHPage googleObj = new GoogleHPage();
    Actions act = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);


    @Given("User navigate to google home page")
    public void user_navigate_to_google_home_page() {
        driver.get(ConfigurationReader.getProperty("ui-config.properties", "google.url"));

    }

    @When("User enters the required search into the search field and clicks the search button")
    public void user_enters_the_required_search_into_the_search_field_and_clicks_the_search_button(DataTable dataTable) throws InterruptedException {

        List<String> searchWords = dataTable.asList(String.class);
        googleObj.searchInput.sendKeys(searchWords.get(0));
        googleObj.searchInput.sendKeys(Keys.ENTER);

    }

    @Then("User chooses the specific link we want to navigate to")
    public void user_chooses_the_specific_link_we_want_to_navigate_to() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(googleObj.bestBuy));
        googleObj.bestBuy.click();
    }

    @Then("User verifies that landed into the specific page")
    public void user_verifies_that_landed_into_the_specific_page() {

        String title = driver.getTitle().trim();
        Assert.assertEquals("User didn't land successfully",
                "Laptops and Notebooks: PC Laptop, Notebook - Best Buy", title);
        System.out.println("Title is : " + title);

    }

}
