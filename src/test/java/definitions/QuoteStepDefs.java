package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();


    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                QuoteForm form = new QuoteForm();
                form.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }

    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String,String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"),user.get("lastName") );
        form.agreeWithPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String,String> user = getData(role);

        String outcome = result.getResult();
        String actualPassword = result.getPasswordResult();
        String actualPrivacyPolicy = result.getPrivacyPolicy();

        assertThat(actualPassword).doesNotContain(user.get("password"));
        assertThat(outcome).containsIgnoringCase(user.get("username"));
        assertThat(outcome).containsIgnoringCase(user.get("email"));
        assertThat(outcome).contains(user.get("firstName") + " " + user.get("lastName"));
        assertThat(actualPrivacyPolicy).isEqualTo("true");

        //assertThat("actualValue").isEqualTo("expectedValue");
        //assertThat(true).isEqualTo(true);
        //assertThat(true).isTrue();
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String,String> user = getData(role);
        form.fillPhone(user.get("phone"));
        form.fillDateOfBirth(user.get("dateOfBirth"));
        form.fillGender();
    }


    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String,String> user = getData(role);

        String outcome = result.getResult();
        String gender = result.getGender();

        assertThat(outcome).contains(user.get("phone"));
        assertThat(outcome).contains(user.get("dateOfBirth"));
        assertThat(gender).isEqualTo(user.get("gender"));
    }


    @Then("I see {string} error message {string} oop")
    public void iSeeErrorMessageOop(String field, String error) {
        String actualError = form.getErrorText(field);
        assertThat(actualError).isEqualTo(error);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {
        form.fillField(field,value);
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        Boolean result = form.errorDisplayed(field);
        assertThat(result).isFalse();

    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstNameValue, String lastNameValue) throws InterruptedException {
        form.fillName(firstNameValue,lastNameValue);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String fieldName, String fieldValue) {
        String result = form.getFieldValue(fieldName);
        assertThat(result).isEqualTo(fieldValue);

    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstNameValue, String middleNameValue, String lastNameValue) {
        form.fillName(firstNameValue,middleNameValue,lastNameValue);

    }
}
