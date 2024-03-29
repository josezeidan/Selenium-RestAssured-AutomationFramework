package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class GoogleHPage {

    WebDriver driver;

    public GoogleHPage() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "APjFqb")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")
    public WebElement searchButton;

    @FindBy(xpath = "//h3[text()='Laptops and Notebooks']")
    public WebElement bestBuy;


}
