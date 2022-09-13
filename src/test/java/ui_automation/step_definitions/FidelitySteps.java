package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ui_automation.pages.FidelityPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.List;

public class FidelitySteps {

    public static final Logger oLog = LogManager.getLogger(FidelitySteps.class);
    WebDriver driver = Driver.getInstance().getDriver();


    FidelityPage fidelity = new FidelityPage();
    Actions act;

    @Given("User navigate to fidelity web page")
    public void user_navigate_to_fidelity_web_page() {

        driver.get(ConfigurationReader.getProperty("ui-config.properties", "fidelity.url"));

        act = new Actions(driver);


    }

    @Given("User hover over the Why Fidelity drop down menu")
    public void user_hover_over_the_Why_Fidelity_drop_down_menu() {

        act.moveToElement(fidelity.whyFidelity).perform();


    }

    @Then("User selects carers from the menu")
    public void user_selects_carers_from_the_menu() {

        List<WebElement> whyFidelityList = fidelity.whyFidelityDD();


        for(WebElement whyF:whyFidelityList){
            if(whyF.getText().equals("Careers")){
                whyF.click();
                break;
            }
        }

    }

    @Then("User verifies landed on the carer page")
    public void user_verifies_landed_on_the_carer_page() {

        String title = driver.getTitle();
        System.out.println("Title is : "+title);

    }



}
