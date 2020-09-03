package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UPSStepDefs {

    public String total;

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment:')]")).click();
    }

    @When("I fill out origin shipment fields for {string}")
    public void iFillOutOriginShipmentFields(String location) {
        Map<String, String> destination = getData(location);
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='origincountry']")));
        countrySelect.selectByVisibleText(destination.get("country"));
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(destination.get("name"));
        getDriver().findElement(By.xpath("//input[@id='origincontactName']")).sendKeys(destination.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(destination.get("address"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(destination.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(destination.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(destination.get("phone"));
        WebElement originCity = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        getWait(10).until(ExpectedConditions.attributeToBeNotEmpty(originCity,"value"));
        String result = originCity.getAttribute("value");
        System.out.println("--------------------------------");
        System.out.println(result);
        assertThat(result).containsIgnoringCase(destination.get("city"));
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='originstate']")));
        String result1 = stateSelect.getFirstSelectedOption().getText();
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println(result1);
        assertThat(result1).containsIgnoringCase(destination.get("state"));
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        WebElement submit = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        getExecutor().executeScript("arguments[0].click();", submit);
    }

    @Then("I verify origin shipment fields submitted for {string}")
    public void iVerifyOriginShipmentFieldsSubmitted(String location) {
        Map<String, String> origin = getData(location);
        String result = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText();
        System.out.println(result);
        assertThat(result).containsIgnoringCase(origin.get("countryAbbrevation"));
        assertThat(result).contains(origin.get("name"));
        assertThat(result).contains(origin.get("address"));
        assertThat(result).contains(origin.get("stateAbbrevation"));
        assertThat(result).containsIgnoringCase(origin.get("email"));
        assertThat(result).contains(origin.get("phone"));
        assertThat(result).contains(origin.get("zip"));
        assertThat(result).contains(origin.get("phone"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement cancel = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        getExecutor().executeScript("arguments[0].click();", cancel);
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        String name = getDriver().findElement(By.xpath("//input[@id='originname']")).getText();
        assertThat(name).isEmpty();
        //assertThat(name).isBlank();
    }

    @When("I fill out destination shipment fields for {string}")
    public void iFillOutDestinationShipmentFields(String location) {
        Map<String, String> destination = getData(location);
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='destinationcountry']")));
        countrySelect.selectByVisibleText(destination.get("country"));
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(destination.get("name"));
        getDriver().findElement(By.xpath("//input[@id='destinationcontactName']")).sendKeys(destination.get("name"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(destination.get("address"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(destination.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='destinationemail']")).sendKeys(destination.get("email"));
        getDriver().findElement(By.xpath("//input[@id='destinationphone']")).sendKeys(destination.get("phone"));
        WebElement destinationCity = getDriver().findElement(By.xpath("//input[@id='destinationcity']"));
        getWait(10).until(ExpectedConditions.attributeToBeNotEmpty(destinationCity,"value"));
        String result = destinationCity.getAttribute("value");
        System.out.println("Destination city: " + result);
        assertThat(result).containsIgnoringCase(destination.get("city"));
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='destinationstate']")));
        String result1 = stateSelect.getFirstSelectedOption().getText();
        System.out.println("Destination state: " + result1);
        assertThat(result1).containsIgnoringCase(destination.get("state"));
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        Select packagingType = new Select(getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")));
        packagingType.selectByVisibleText("UPS Express Box - Small");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1");
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() throws InterruptedException {
        WebElement totalCharges = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
        WebElement balanceBar = getDriver().findElement(By.xpath("//div[@id='nbsBalanceBarHeader']"));
        getWait(10).until(ExpectedConditions.visibilityOf(balanceBar));
        total = totalCharges.getText();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Lowest Cost')]/..")).click();
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("Small gift: lego set, 1 pound");
        getDriver().findElement(By.xpath("//saturday-delivery-option[@class='ng-star-inserted']//label")).click();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        WebElement totalCharges = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));

        System.out.println("Old Total: " + total);

        System.out.println("New Total: " + totalCharges.getText());

        assertThat(totalCharges.getText() != total);
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        getDriver().findElement(By.xpath("//div[@id='tile-4']//label[@class='test-experiment-custom-label']")).click();
    }

    @And("I submit the shipment form review")
    public void iSubmitTheShipmentFormReview() {
        WebElement submit = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
        getExecutor().executeScript("arguments[0].click();", submit);
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        Map<String, String> origin = getData("ups");
        String review1 = getDriver().findElement(By.xpath("//origin[@id='nbsSpaOrigin']//div[@class='ups-group ups-group_condensed']")).getText();
        System.out.println(origin);
        assertThat(review1).contains(origin.get("name"));
        assertThat(review1).contains(origin.get("address"));
        assertThat(review1).contains(origin.get("stateAbbrevation"));
        assertThat(review1).containsIgnoringCase(origin.get("email"));
        assertThat(review1).contains(origin.get("phone"));
        assertThat(review1).contains(origin.get("zip"));
        assertThat(review1).contains(origin.get("phone"));
        Map<String, String> destination = getData("ups2");
        String review2 = getDriver().findElement(By.xpath("//destination[@id='nbsSpaDestination']//div[@class='ups-group ups-group_condensed']")).getText();
        System.out.println(destination);
        assertThat(review2).contains(destination.get("name"));
        assertThat(review2).contains(destination.get("address"));
        assertThat(review2).contains(destination.get("stateAbbrevation"));
        assertThat(review2).containsIgnoringCase(destination.get("email"));
        assertThat(review2).contains(destination.get("phone"));
        assertThat(review2).contains(destination.get("zip"));
        assertThat(review2).contains(destination.get("phone"));
    }
}
