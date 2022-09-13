package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class FidelityPage {


    WebDriver driver;

    public FidelityPage() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> whyFidelityDD() {

        return driver.findElements(By.xpath("//div[@id='pnmm']//a[contains(text(),'Why Fidelity')]/../following-sibling::div//ul//li"));
    }
//    @FindBy(xpath = "//div[@id='pnmm']//a[contains(text(),'Why Fidelity')]/../following-sibling::div//ul//li")
//    public WebElement whyFidelityDD;

    //div[@id='pnmm']//a[contains(text(),'Why Fidelity')]

    @FindBy(xpath = "//div[@id='pnmm']//a[contains(text(),'Why Fidelity')]")
    public WebElement whyFidelity;





}
