package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class BestBuyPage {

    WebDriver driver;
    public BestBuyPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public By laptopListLocator = By.xpath("//div[@id='main-results']/ol/li//div[@class='information']/h4/a");

    @FindBy(id= "gh-search-input")
    public WebElement searchInput;

    @FindBy(xpath = "//a[contains(text(),'PC Laptops')]")
    public WebElement pcLaptops;

    @FindBy(id = "currentprice_facet-$750-$999.99-8")
    public WebElement priceRange;

    @FindBy(id = "systemmemoryram_facet-16.0-gigabytes-2")
    public WebElement gigabytes16_0;

    @FindBy(id = "parent_processormodelsv_facet-Intel-Core-i7-2")
    public WebElement core_i7;

    @FindBy(xpath = "//span[contains(text(),'Lenovo - Yoga 7i 2-in-1 15.6')]/..")
    public WebElement lenovoPC;

    @FindBy(xpath = "//button[contains(@class,'c-button-primary')]")
    public WebElement addToCart;

    @FindBy(xpath = "//a[contains(@data-lid,'hdr_carticon')]")
    public WebElement cart;

    @FindBy(xpath = "//div[@class='sku-title']/h1")
    public WebElement laptopName;

    @FindBy(xpath = "//button[contains(@class,'c-button-link continue-shopping')]")
    public WebElement continueShopping;

    @FindBy(xpath = "(//ul[@class='item-list']//div//a)[1]")
    public WebElement nameFromCartPage;

    /**
     * method return a list of WebElements (laptops)
     * @return List<WebElement>
     * */
    public List<WebElement> laptopListGenerator(){

       return driver.findElements(By.xpath("//div[@id='main-results']/ol/li//div[@class='information']/h4/a"));
    }
    /**
     * method return a list of WebElements (rates)
     * @return List<WebElement>
     * */
    public List<WebElement> ratesListGenerator(){

        return driver.findElements(By.xpath("//div[@id='main-results']/ol/li//div[@class='ratings-reviews']//i/following-sibling::span"));
    }

}
