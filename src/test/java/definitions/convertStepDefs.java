package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class convertStepDefs {
    @When("I click on {string}")
    public void iClickOn(String option) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'" + option + "')]")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String from, String to) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'" + from + "')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'" + to + "')]")).click();
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String input, String output) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(input);
        String result = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        System.out.println("--------------------------------");
        System.out.println(result);
        assertThat(result).contains(output);
    }
}
