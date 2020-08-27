package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CalcStepDefs {

    @Given("I go to new {string} page")
    public void iGoToNewPage(String page) {
        switch (page) {
            case "calculator":
                getDriver().get("https://www.calculator.net/");
                break;
            case "converter":
                getDriver().get("https://www.unitconverters.net/");
                break;

            default:
                    throw new RuntimeException("Unsupported page! " + page);
            }
        }


    @When("I navigate to {string}")
    public void iNavigateTo(String option) {
        option = "//a[contains(text(),'"+ option +"')]";
        getDriver().findElement(By.xpath(option)).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }


    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }


    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        assertThat(getDriver().findElement(By.xpath("//font[contains(text(),'"+error+"')]")).isDisplayed());
    }


    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downPay, String tradeIn, String state, String salesTax, String fees) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downPay);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(salesTax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@name='cstate']")));
        stateSelect.selectByVisibleText(state);
    }


    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String payment) {
        //assertThat(getDriver().findElement(By.xpath("")).isDisplayed());
        String result = getDriver().findElement(By.xpath("//h2[contains(text(),'Monthly Pay')]")).getText();
        System.out.println("--------------------------------");
        System.out.println(result);
        assertThat(result).contains(payment);

    }
}





