package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.QuoteForm;
import pages.QuoteResult;
import pages.UPSForm;
import pages.UPSResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UPSOOPStepDefs {
    UPSForm form = new UPSForm();
    UPSResult result = new UPSResult();

    @Given("I open {string} page oop")
    public void iOpenPage(String page) {
        switch (page) {
            case "ups":
                UPSForm form = new UPSForm();
                form.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }


    @And("I open Shipping menu oop")
    public void iOpenShippingMenuOop() {
        form.openShippingMenu();

    }

    @And("I go to Create a Shipment oop")
    public void iGoToCreateAShipmentOop() {
        form.createShipment();
    }


    @When("I fill out origin shipment fields for {string} oop")
    public void iFillOutOriginShipmentFieldsForOop(String location) throws InterruptedException {
        Map<String, String> destination = getData(location);

        form.fillName(destination.get("name"));
        form.fillContactName(destination.get("name"));
        form.fillAddress(destination.get("address"));
        form.fillZip(destination.get("zip"));
        form.fillEmail(destination.get("email"));
        form.fillPhone(destination.get("phone"));
        Thread.sleep(5000);
    }


    @And("I submit the shipment form oop")
    public void iSubmitTheShipmentFormOop() {
        form.submit();
    }


    @Then("I verify origin shipment fields submitted for {string} oop")
    public void iVerifyOriginShipmentFieldsSubmittedForOop(String location) {
        Map<String, String> origin = getData(location);

        String outcome = result.getResult();
        assertThat(outcome).containsIgnoringCase(origin.get("countryAbbrevation"));
        assertThat(outcome).containsIgnoringCase(origin.get("name"));
        assertThat(outcome).containsIgnoringCase(origin.get("address"));
        assertThat(outcome).containsIgnoringCase(origin.get("stateAbbrevation"));
        assertThat(outcome).containsIgnoringCase(origin.get("email"));
        assertThat(outcome).containsIgnoringCase(origin.get("phone"));
        assertThat(outcome).containsIgnoringCase(origin.get("zip"));
    }


    @And("I cancel the shipment form oop")
    public void iCancelTheShipmentFormOop() {
        form.cancel();
        form.agreeToWarning();
    }


    @Then("I verify shipment form is reset oop")
    public void iVerifyShipmentFormIsResetOop() {
        String name = form.getName();
        assertThat(name).isEmpty();
    }
}

