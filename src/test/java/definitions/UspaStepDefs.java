package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

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


}

