package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assert;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.*;

public class UspaStepDefs {

    @Given("I go to my {string} page")
    public void iGoToMyPage(String page) {
        switch (page) {
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "ups":
                getDriver().get("https://www.ups.com/us/en/Home.page");
                break;
            default:
                throw new RuntimeException("Unsupported page! " + page);
        }
    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//*[contains(@href,'ZipLookupAction!')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'Find by Address')]")).click();
        Thread.sleep(2000);
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        String stateXpath = "//select[@id='tState']//option[@value='" + state + "']";
        String myState = "//select[@id='tState']//option[contains(text(),'CA - California')]";
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath(stateXpath)).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id='zip-by-address']")).click();
        Thread.sleep(2000);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String result = getDriver().findElement(By.xpath("//ul[@class='list-group industry-detail']")).getText();
        System.out.println("Hello");
        System.out.println(result);
        assertThat(result).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        //Actions actions = new Actions(getDriver());
        //actions.moveToElement(mailAndShip).perform();
        getActions().moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']//a[contains(@href,'postcalc')]")).click();
    }


    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        countrySelect.selectByVisibleText(country);
        //getDriver().findElement(By.xpath("//input[@id='option_1']")).click();
        getDriver().findElement(By.xpath("//div[@id='options-section']//input[@value='"+shape+"']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String qty) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(qty);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        //String result = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        //System.out.println(result);
        //assertThat(result).contains(cost);
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        //WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search USPS.com')]")));
        getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search USPS.com')]")));
        WebElement parameter = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        //Actions actions = new Actions(getDriver());
        //actions.moveToElement(parameter).perform();
        getActions().moveToElement(parameter).perform();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'"+search.toUpperCase()+"')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //String elementName = "//ul//a[@title='"+filter+"']";
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
        //getDriver().findElement(By.xpath(filterElement)).click();
        // Using Javascript click below instead (my commented code above)!!!
        WebElement filterElement = getDriver().findElement(By.xpath("//ul//a[@title='"+filter+"']"));
        //JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        //executor.executeScript("arguments[0].click();", filterElement);
        getExecutor().executeScript("arguments[0].click();", filterElement);

    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String qty) throws InterruptedException {
        // Note: extract WebDriverWait from here, put it in TestContext as Static method, in order to use it across my app
        //WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated((By.xpath("//ul//a[@title='International']") ))));
        getWait().until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));
        String result2 = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        System.out.println("Hello "+result2);
        assertThat(result2).contains(qty);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String option) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));
        getWait().until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+option+"')]/../..")));

        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//span[contains(text(),'"+option+"')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
  //      WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String elementName = "//a[contains(text(),'"+button+"')]";
/*
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
*/
        //Thread.sleep(3000);
        getDriver().findElement(By.xpath(elementName)).click();
        int numOfWin = getDriver().getWindowHandles().size();
        while (getDriver().getWindowHandles().size() < numOfWin + 1) {
            getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();
            Thread.sleep(100);
        }
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {

        //String windowHandle = getDriver().getWindowHandle();

        // getting all browser tabs
        ArrayList tabs = new ArrayList (getDriver().getWindowHandles());

        // switching to last tab
        getDriver().switchTo().window((String) tabs.get(tabs.size()-1));

        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //wait.until(ExpectedConditions.titleContains("Sign In"));
        getWait().until(ExpectedConditions.titleContains("Sign In"));

        assertThat(getDriver().findElement(By.xpath("//h1[contains(text(),'Sign In To Your Account')]")).isDisplayed());
    }

    @When("I go to {string} tab")
    public void iGoToTab(String option) {
        WebElement menu = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + option + "')]"));
        getActions().moveToElement(menu).perform();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchValue) {
        WebElement menu = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Help')]"));
        menu.click();
        getDriver().findElement(By.xpath("//input[@id='137:0']")).sendKeys(searchValue);
        getDriver().findElement(By.xpath("//button[@title='Search']")).click();
    }


    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchValue) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand']")));
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand']")));
        String result = getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText();
        System.out.println("_________________________");
        System.out.println(result);
        assertThat(result).doesNotContain(searchValue);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenu, String menu) throws InterruptedException {
        WebElement menuElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + menu +"']"));
        getActions().moveToElement(menuElement).perform();
        getDriver().findElement(By.xpath("//li/a[text()='" + subMenu +"']")).click();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[contains(@class,'search-form-field-icon-search')]")).click();
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String text) throws InterruptedException {
        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        getWait().until(visibilityOf(overlay));
        getWait(10).until(invisibilityOf(overlay));
        getDriver().findElement(By.xpath("//a[contains(text(),'" + text + "')]")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String text) {
        getDriver().findElement(By.xpath("//div[@id='route-table']//a[contains(text(),'" + text + "')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class, 'totalsArea')]")).getText();
        int totalCount = Integer.parseInt(totalCountString.replaceAll("\\D*", ""));

        By costListSelector = By.xpath("//td[@idx='7']");
        List<WebElement> costList = getDriver().findElements(costListSelector);
        System.out.println("Expected elements size: " + totalCount);

        // dealing with infinite scroll
        while (costList.size() < totalCount) {
            System.out.println("Actual elements size: " + costList.size());
            int lastIndex = costList.size() - 1;
            getActions().moveToElement(costList.get(lastIndex)).perform();
            costList = getDriver().findElements(costListSelector);
        }
        System.out.println("Actual elements size: " + costList.size());

        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double actualTotal = 0;
        for (WebElement cost : costList) {
            double costTotal = formatter.parse(cost.getText()).doubleValue();
            actualTotal += costTotal;
        }
        System.out.println("Actual total " + actualTotal);

        String expectedTotalString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        double expectedTotal = Double.parseDouble(expectedTotalString);
        System.out.println("Expected total " + expectedTotal);

        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));

    }


    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String searchValue) throws InterruptedException {
        WebElement input = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-store']"));
        getActions().moveToElement(input).click().perform();
        input.sendKeys(searchValue);
        getActions().moveToElement(getDriver().findElement(By.xpath("//input[@id='global-header--search-track-store']/..//input[2]"))).click().perform();
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Postal Store')]")));
        //String result = getDriver().findElement(By.xpath("")).getText();
        WebElement result = getDriver().findElement(By.xpath("//div[@class='no-product']"));
        assertThat(result).isNotNull();
    }

    @And("choose mail service Priority Mail")
    public void chooseMailServicePriorityMail() {
        WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Mail Service')]/..//*[contains(text(),'Priority Mail (')]"));
        getActions().moveToElement(element).perform();
        assertThat(element).isNotNull();
    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int num) {
        WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Mail Service')]/..//*[text()='Priority Mail ("+num+")']"));
        assertThat(element).isNotNull();
    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String zip) {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//a[@class='searchBtn']")).click();
    }


    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String address) throws InterruptedException {
        //see spinner
        String progressElement = "//div[@id='mapProgressModal']";
        WebElement progress = getDriver().findElement(By.xpath(progressElement));
        getWait().until(ExpectedConditions.invisibilityOf(progress));

        String result = getDriver().findElement(By.xpath("//div[@class='col-xs-12 col-sm-8 col-md-6 scrollingResults']")).getText();
        String id = getDriver().findElement(By.xpath("//div[@class='col-xs-12 col-sm-8 col-md-6 scrollingResults']")).getAttribute("id");
        System.out.println("***********"+ result );
        System.out.println("^^^^^^^^^^^^^^^"+ id );
        assertThat(result).contains(address);
    }


    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn(String size, String address) {
        //getDriver().findElement(By.xpath("//div[@id='1370964']//span[contains(@class,'icon-carat_down listArrow')]")).click();
        getDriver().findElement(By.xpath("//span[text()='"+address+"']")).click();
       // getDriver().findElement(By.xpath("//div[@id='1370964']//div[contains(@class,'row')]")).click();
        String result = getDriver().findElement(By.xpath("//div[@id='availableboxes']")).getText();
        assertThat(result).contains(size);
    }

    @When("I unselect {string} checkbox")
    public void iUnselectCheckbox(String option) throws InterruptedException {
        String labelXPath = "//label[contains(text(),'" + option + " (')]";
        getDriver().findElement(By.xpath(labelXPath)).click();
      }


    @And("select {string} stamp Shape")
    public void selectStampShape(String option) throws InterruptedException {
       String elementName = "//label[contains(text(),'" + option + " (')]";
       getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
       WebElement element = getDriver().findElement(By.xpath(elementName));
       getActions().moveToElement(element).click().perform();
       //getExecutor().executeScript("arguments[0].click();", element);
    }


    @And("I click {string} color")
    public void iClickColor(String option) {
        String elementName = "//*[contains(@onclick,'/" + option.toLowerCase() + "/')]";
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
        WebElement element = getDriver().findElement(By.xpath(elementName));
        getActions().moveToElement(element).click().perform();
        //getExecutor().executeScript("arguments[0].click();", element);
    }

    WebElement locateFilter(String option) {
        String elementName = "//*[@class='cartridge-viewport']//*[contains(@onclick,'/" + option.toLowerCase() + "/')]";
        WebElement element = getDriver().findElement(By.xpath(elementName));
        return element;
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String option1, String option2) {
        assertThat(locateFilter(option1)).isNotNull();
        assertThat(locateFilter(option2)).isNotNull();
    }

    @Then("I verify {string} filtered items found")
    public void iVerifyFilteredItemsFound(String qty) {
        String result = getDriver().findElement(By.xpath("//*[@class='col-md-3 application-header align-self-center results-per-page']")).getText();
        assertThat(result).contains(qty);
    }


    @And("I verify that items below {int} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(int price) throws ParseException {
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='results-product-preview-price']"));

        int qty = 0;

        for (int i=0;i<list.size();i++) {
            try {

                WebElement temp = list.get(i);

                String stringPrice = temp.getText();

                Number num = NumberFormat.getCurrencyInstance().parse(stringPrice);

                if ( num.doubleValue() < (double)price ) qty++;

                System.out.println("text "+stringPrice+" parsed:"+num);
            }
            catch (ParseException e)
            {

            }
        }

        System.out.println("Count less than "+price+" is equal="+qty);

        assertThat(qty).isGreaterThan(0);
    }

    @And("I click my {string} button")
    public void iClickMyButton(String button) {
        String elementName = "//a[contains(text(),'"+button+"')]";
        getDriver().findElement(By.xpath(elementName)).click();
        //int numOfWin = getDriver().getWindowHandles().size();
        //while (getDriver().getWindowHandles().size() < numOfWin + 1) {
        //    getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();

    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String service) {
        String progressElement = "//*[@class='white-spinner-container']";
        WebElement progress = getDriver().findElement(By.xpath(progressElement));
        getWait().until(ExpectedConditions.invisibilityOf(progress));
        assertThat(getDriver().findElement(By.xpath("//*[text()='" + service + "']"))).isNotNull();
        //serviceSelect.selectByVisibleText(service);

    }
}

