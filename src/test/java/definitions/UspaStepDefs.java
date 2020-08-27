package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspaStepDefs {

    @Given("I go to my {string} page")
    public void iGoToMyPage(String page) {
        switch (page) {
            case "usps":
                getDriver().get("https://www.usps.com/");
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
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mailAndShip).perform();
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
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Search USPS.com')]")));
        WebElement parameter = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(parameter).perform();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(text(),'FREE BOXES')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String elementName = "//ul//a[@title='"+filter+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
        getDriver().findElement(By.xpath(elementName)).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String qty) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated((By.xpath("//ul//a[@title='International']") ))));
        String result2 = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        System.out.println("Hello "+result2);
        assertThat(result2).contains(qty);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String option) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(text(),'Last')]") ))));

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+option+"')]/../..")));

        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//span[contains(text(),'"+option+"')]/../..")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
  //      WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String elementName = "//a[contains(text(),'"+button+"')]";
/*
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
*/
        Thread.sleep(3000);
        getDriver().findElement(By.xpath(elementName)).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {

        //String windowHandle = getDriver().getWindowHandle();

        // getting all browser tabs
        ArrayList tabs = new ArrayList (getDriver().getWindowHandles());

        // switching to last tab
        getDriver().switchTo().window((String) tabs.get(tabs.size()-1));

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.titleContains("Sign In"));

        assertThat(getDriver().findElement(By.xpath("//h1[contains(text(),'Sign In To Your Account')]")).isDisplayed());
    }

    @When("I go to {string} tab")
    public void iGoToTab(String option) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + option + "')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchValue) {
        getDriver().findElement(By.xpath("//input[@id='137:0']")).sendKeys(searchValue);
        getDriver().findElement(By.xpath("//button[@title='Search']")).click();
    }


    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchValue) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand']")));
        String result = getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText();
        System.out.println("_________________________");
        System.out.println(result);
        assertThat(result).doesNotContain(searchValue);
    }
}

