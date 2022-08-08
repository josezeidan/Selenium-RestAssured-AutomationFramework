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

    String path =  "src/test/resources/testData/testData.xlsx";


    Actions act = new Actions(driver);
    String lapName;


    @Then("User enters the item want to search for and add filters")
    public void user_enters_the_item_want_to_search_for_and_add_filters() throws Exception {

      String filePath = System.getProperty("user.dir") +"/"+ path;

        ExcelUtility.setExcelFile(filePath, "Sheet1");

       String category = ExcelUtility.getCellDataAsString(1, 0);
       bestBuy.searchInput.sendKeys(category);
       bestBuy.searchInput.sendKeys(Keys.ENTER);

        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable( bestBuy.pcLaptops));
        bestBuy.pcLaptops.click();

//        bestBuy.priceRange.click();
//        Thread.sleep(2000);
//        bestBuy.gigabytes16_0.click();
//        Thread.sleep(2000);
//        bestBuy.core_i7.click();
//        Thread.sleep(2000);



    }

    @Then("User chooses the item and add it to cart")
    public void user_chooses_the_item_and_add_it_to_cart() throws Exception {

        waitForVisibility(driver.findElement(bestBuy.laptopListLocator),20);


        List<WebElement> listOfPCs = bestBuy.laptopListGenerator();
        List<WebElement> rates = bestBuy.ratesListGenerator();
        Map<Integer,Integer> intRates = new TreeMap<>();
        int index = 0 ;
        int higherRate = 0;
        for(WebElement rt:rates){
            String rateStr = rt.getText().trim();
            rateStr = rateStr.substring(1,rateStr.length()-1);
            int pcRate = Integer.parseInt(rateStr);
            if(pcRate > higherRate) higherRate = pcRate;

            intRates.put(pcRate,index);
            System.out.print(pcRate+"="+index+" ,");
            System.out.println(listOfPCs.get(index).getText());
            index++;

        }
        System.out.println();


        int maxRateIndex = intRates.get(higherRate);

        System.out.println("Map: "+intRates);
        System.out.println("Max Index Value is: "+maxRateIndex);

       Thread.sleep(2000);
       // lapName = listOfPCs.get(maxRateIndex).getText();

       wait = new WebDriverWait(driver,30);
      // wait.until(ExpectedConditions.elementToBeClickable(listOfPCs.get(maxRateIndex)));
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfPCs.get(maxRateIndex)));
      //  act.moveToElement(listOfPCs.get(maxRateIndex)).perform();
        lapName = listOfPCs.get(maxRateIndex).getText();
        listOfPCs.get(maxRateIndex).click();

        System.out.println(lapName);
     //   addToCartList.get(maxRateIndex).click();
        Thread.sleep(2000);

//        wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(listOfPCs.get(maxRateIndex)));
//        act.moveToElement(listOfPCs.get(maxRateIndex)).perform();
//        listOfPCs.get(maxRateIndex).click();

      //  waitForClickablility(bestBuy.addToCart,10);

       // Thread.sleep(2000);
     //  wait.until(ExpectedConditions.elementToBeClickable(bestBuy.addToCart));

      //  act.moveToElement(bestBuy.addToCart).perform();
      // Thread.sleep(2000);
        wait = new WebDriverWait(driver,30);
       // wait.until(ExpectedConditions.elementToBeClickable(bestBuy.addToCart));
        wait.until(ExpectedConditions.visibilityOfAllElements(bestBuy.addToCart));
        act.moveToElement( bestBuy.addToCart).perform();
        bestBuy.addToCart.click();


//        wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(bestBuy.addToCart));
//        bestBuy.addToCart.click();

        try {


       Thread.sleep(2000);
        wait = new WebDriverWait(driver,30);
      //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'c-button-link continue-shopping')]")));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//button[contains(@class,'c-button-link continue-shopping')]"))));
      driver.findElement(By.xpath("//button[contains(@class,'c-button-link continue-shopping')]")).click();
    }catch (StaleElementReferenceException E){

        }

    }

    @Then("User navigates to cart and verified item added correctly")
    public void user_navigates_to_cart_and_verified_item_added_correctly() throws InterruptedException {


        Thread.sleep(2000);
        bestBuy.cart.click();
        String nameFromCartPage = driver.findElement(By.xpath("(//ul[@class='item-list']//div//a)[1]")).getText().trim();

        System.out.println(lapName);
        System.out.println(nameFromCartPage);

        Assert.assertEquals("Do nat added",lapName,nameFromCartPage);


    }



}
