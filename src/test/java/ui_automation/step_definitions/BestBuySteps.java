package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.BestBuyPage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.ExcelUtility;

import java.util.*;

import static ui_automation.utilities.WaitHelper.*;

public class BestBuySteps {

    public static final Logger oLog = LogManager.getLogger(BestBuySteps.class);
    WebDriver driver = Driver.getInstance().getDriver();

    BestBuyPage bestBuy = new BestBuyPage();
    WebDriverWait wait;// = new WebDriverWait(driver,10);
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    String path = "/src/test/resources/testData/testData.xlsx";
    Actions act = new Actions(driver);
    String lapName;
    String maxPriceName;
    String minPriceName;
    List<WebElement> listOfPCs;


    @Then("User enters the item want to search for and add filters")
    public void user_enters_the_item_want_to_search_for_and_add_filters() throws Exception {

        String filePath = System.getProperty("user.dir")  + path;
        ExcelUtility.setExcelFile(filePath, "Sheet1");
        String category = ExcelUtility.getCellDataAsString(1, 0);
        bestBuy.searchInput.sendKeys(category);
        bestBuy.searchInput.sendKeys(Keys.ENTER);
        waitForVisibility(bestBuy.pcLaptops, 50);
        bestBuy.pcLaptops.click();

    }

    @Then("User chooses the item and add it to cart")
    public void user_chooses_the_item_and_add_it_to_cart() throws Exception {


        hardWait(6000);
        listOfPCs = bestBuy.laptopListGenerator();
        List<WebElement> rates = bestBuy.ratesListGenerator();
        Map<Integer, Integer> intRates = new TreeMap<>();
        int index = 0;
        int higherRate = 0;
        int pcRate;
        for (WebElement rt : rates) {

            String rateStr = rt.getText().trim();
            if(rateStr.equals("Not Yet Reviewed")) rateStr = "(0)"; //(11,732)
            rateStr = rateStr.substring(1, rateStr.length() - 1); //11,732
            if(rateStr.contains(",")){
                rateStr = rateStr.substring(0, rateStr.indexOf(',')) +
                          rateStr.substring(rateStr.indexOf(',')+1) ;   //11732
            }
                pcRate = Integer.parseInt(rateStr);     // 11732 as integer
            if (pcRate > higherRate) higherRate = pcRate;

            intRates.put(pcRate, index); // key = 11732, value = 0,1,2
            System.out.print(pcRate + "=" + index + " ,");
            System.out.println(listOfPCs.get(index).getText());
            index++;


        }
        System.out.println();
        int maxRateIndex = intRates.get(higherRate);
        System.out.println("Map: " + intRates);
        System.out.println("Max Index Value is: " + maxRateIndex);
        WebElement maxRatePc = listOfPCs.get(maxRateIndex);
        waitForVisibility(maxRatePc, 50);
        //jse.executeScript("arguments[0].scrollIntoView();", maxRatePc);
        act.moveToElement(listOfPCs.get(maxRateIndex)).perform();
        listOfPCs.get(maxRateIndex).click();
       // maxRatePc.click();

        waitForVisibility(bestBuy.laptopName, 50);
        lapName = bestBuy.laptopName.getText().trim();
        waitForVisibility(bestBuy.addToCart, 50);
        act.moveToElement(bestBuy.addToCart).perform();
        bestBuy.addToCart.click();
        waitForVisibility(bestBuy.continueShopping, 50);
        act.moveToElement(bestBuy.continueShopping).perform();
        bestBuy.continueShopping.click();


    }

    @Then("User chooses the item with lowest rate and add it to cart")
    public void userChoosesTheItemWithLowestRateAndAddItToCart() throws InterruptedException {

        hardWait(6000);
        listOfPCs = bestBuy.laptopListGenerator();
        List<WebElement> rates = bestBuy.ratesListGenerator();
        Map<Integer, Integer> intRates = new TreeMap<>();
        int index = 0;
        int lowerRate = 10000;
        int pcRate;
        for (WebElement rt : rates) {

            String rateStr = rt.getText().trim();
            if(rateStr.equals("Not Yet Reviewed")) rateStr = "(0)"; //(11,732)
            rateStr = rateStr.substring(1, rateStr.length() - 1); //11,732
            if(rateStr.contains(",")){
                rateStr = rateStr.substring(0, rateStr.indexOf(',')) +
                        rateStr.substring(rateStr.indexOf(',')+1) ;   //11732
            }
            pcRate = Integer.parseInt(rateStr);     // 11732 as integer
            if (pcRate < lowerRate) lowerRate = pcRate;

            intRates.put(pcRate, index); // key = 11732, value = 0,1,2
            System.out.print(pcRate + "=" + index + " ,");
            System.out.println(listOfPCs.get(index).getText());
            index++;


        }
        System.out.println();
        int lowRateIndex = intRates.get(lowerRate);
        System.out.println("Map: " + intRates);
        System.out.println("Max Index Value is: " + lowRateIndex);

        waitForVisibility(listOfPCs.get(lowRateIndex), 50);
        act.moveToElement(listOfPCs.get(lowRateIndex)).perform();
        listOfPCs.get(lowRateIndex).click();

        waitForVisibility(bestBuy.laptopName, 50);
        lapName = bestBuy.laptopName.getText().trim();
        waitForVisibility(bestBuy.addToCart, 50);
        act.moveToElement(bestBuy.addToCart).perform();
        bestBuy.addToCart.click();
        waitForVisibility(bestBuy.continueShopping, 50);
        act.moveToElement(bestBuy.continueShopping).perform();
        bestBuy.continueShopping.click();


    }

    @Then("User navigates to cart and verified item added correctly")
    public void user_navigates_to_cart_and_verified_item_added_correctly() throws InterruptedException {


        waitForVisibility(bestBuy.cart, 50);
        bestBuy.cart.click();
        String nameFromCartPage = bestBuy.nameFromCartPage.getText().trim();

        System.out.println(lapName);
        System.out.println(nameFromCartPage);

        Assert.assertEquals("Laptop didn't added to cart correctly", lapName, nameFromCartPage);


    }

    @Then("User chose the lower and lower and higher laptop price")
    public void user_chose_the_lower_and_lower_and_higher_laptop_price() throws InterruptedException {

        hardWait(6000);
        listOfPCs = bestBuy.laptopListGenerator();
        List<WebElement> prices = bestBuy.pricesListGenerator();
        List<WebElement> addToCart = bestBuy.addToCartListGenerator();
        Map<Double, Integer> intPrices = new TreeMap<>();
        int index = 0;
        double higherPrice = 0;
        double lowerPrice = 0;
        double pcPrice;
        for (WebElement pr : prices) {

            String priceStr = pr.getText().trim();
            priceStr = priceStr.substring(1,priceStr.length()); //$11,732.99
            if(priceStr.contains(",")){
                priceStr = priceStr.substring(0, priceStr.indexOf(',')) +
                        priceStr.substring(priceStr.indexOf(',')+1) ;   //11732.99
            }

            pcPrice = Double.parseDouble(priceStr);     // 11732.99 as integer
            if (pcPrice > higherPrice) higherPrice = pcPrice;
            if (pcPrice < lowerPrice) lowerPrice = pcPrice;

            intPrices.put(pcPrice, index); // key = 11732, value = 0,1,2
            System.out.print(pcPrice + "=" + index + " ,");
            System.out.println(listOfPCs.get(index).getText());
            index++;


        }
        System.out.println();
        int maxPriceIndex = intPrices.get(higherPrice);
        int minPriceIndex = intPrices.get(lowerPrice);
        System.out.println("Map: " + intPrices);
        System.out.println("Max Index Value is: " + maxPriceIndex);
        System.out.println("Min Index Value is: " + minPriceIndex);



        WebElement maxPricePc = listOfPCs.get(maxPriceIndex);
        WebElement minPricePc = listOfPCs.get(minPriceIndex);

        waitForVisibility(maxPricePc, 50);
        maxPriceName = maxPricePc.getText().trim();
        addToCart.get(maxPriceIndex).click();
        waitForVisibility(bestBuy.continueShopping, 50);
        act.moveToElement(bestBuy.continueShopping).perform();
        bestBuy.continueShopping.click();


        waitForVisibility(minPricePc, 50);
        minPriceName = minPricePc.getText().trim();
        addToCart.get(minPriceIndex).click();
        waitForVisibility(bestBuy.continueShopping, 50);
        act.moveToElement(bestBuy.continueShopping).perform();
        bestBuy.continueShopping.click();



//        waitForVisibility(bestBuy.laptopName, 50);
//        lapName = bestBuy.laptopName.getText().trim();
//        waitForVisibility(bestBuy.addToCart, 50);
//        act.moveToElement(bestBuy.addToCart).perform();
//        bestBuy.addToCart.click();
//        waitForVisibility(bestBuy.continueShopping, 50);
//        act.moveToElement(bestBuy.continueShopping).perform();
//        bestBuy.continueShopping.click();


    }

    @Then("User verifies that laptops got added correctly to add to cart")
    public void user_verifies_that_laptops_got_added_correctly_to_add_to_cart() {

    }



}
