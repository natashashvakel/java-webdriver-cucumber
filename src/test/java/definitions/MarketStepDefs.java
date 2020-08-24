package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import support.TestContext;

import static support.TestContext.getDriver;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws Exception {
        if (page.equalsIgnoreCase("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if (page.equals("google")) {
            getDriver().get("https://www.google.com/");
        } else if (page.equals("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        } else {
            throw new Exception("Unsupported page!" + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();

    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("johndoe.example.com");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("\u0008");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john@doe.example.com");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");

        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("john");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("doe");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        Thread.sleep(3000);
    }

    @And("I submit the form")
    public void iSubmitTheForm() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(3000);
    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields() {
        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();

    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String d) throws InterruptedException {
        Dimension phoneD = new Dimension(400, 768);
        Dimension desktopD = new Dimension(1024, 768);

        if (d.equals("phone")) {
            getDriver().manage().window().setSize(phoneD);
        } else if (d.equals("desktop")) {
            getDriver().manage().window().setSize(desktopD);
        } else System.out.println("Unsupported resolution: " + d);
        Thread.sleep(20000);
    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() throws Exception {
        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        if (username.equals("jdoe")) {
            System.out.println("User name entered correctly ");
        } else throw new Exception("User name is wrong!");

        String name;

        name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();

        if (name.equals("john doe")) {
                System.out.println("Email entered correctly ");
        } else {
                throw new Exception("Name is wrong!");
        }

    }

    @And("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("8001234567");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("04/20/2020");
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//div[5]//label[2]//input[1]")).click();
        Thread.sleep(3000);

    }

    @And("I {string} agreement")
    public void iAgreement(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        Thread.sleep(3000);
        getDriver().switchTo().alert().accept();
        Thread.sleep(3000);
    }


}

