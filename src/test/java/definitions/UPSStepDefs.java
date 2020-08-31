package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UPSStepDefs {
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
        Map<String, String> destination = getData(location);
        String result = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText();
        System.out.println(result);
        assertThat(result).containsIgnoringCase(destination.get("countryAbbrevation"));
        assertThat(result).contains(destination.get("name"));
        assertThat(result).contains(destination.get("address"));
        assertThat(result).contains(destination.get("stateAbbrevation"));
        assertThat(result).containsIgnoringCase(destination.get("email"));
        assertThat(result).contains(destination.get("phone"));
        assertThat(result).contains(destination.get("zip"));
        assertThat(result).contains(destination.get("phone"));
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
}
