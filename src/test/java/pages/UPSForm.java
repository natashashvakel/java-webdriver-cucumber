package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class UPSForm extends Page{

    //fields


    @FindBy(id = "ups-menuLinks2")
    private WebElement ShippingMenu;

    @FindBy(xpath = "//*[text()='Create a Shipment:']")
    private WebElement createShipment;

    @FindBy(id = "originname")
    private WebElement name;

    @FindBy(id = "origincontactName")
    private WebElement contactName;

    @FindBy(id = "originaddress1")
    private WebElement address;

    @FindBy(id = "originpostal")
    private WebElement zip;

    @FindBy(id = "originemail")
    private WebElement email;

    @FindBy(id = "originphone")
    private WebElement phone;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement submit;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancel;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement warning;


    //constructor

    public UPSForm() {
        url = "https://www.ups.com/us/en/Home.page";
        title = "Get a Quote";
    }

    //methods

    public void open() {
        getDriver().get(url);
    }

    public void openShippingMenu () {
        ShippingMenu.click();
    }

    public void createShipment () { createShipment.click(); }

    public void fillName(String value) {
        name.sendKeys(value);
    }

    public void fillContactName(String value) {
        contactName.sendKeys(value);
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void fillZip(String value) {
        zip.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void submit() { getExecutor().executeScript("arguments[0].click();", submit); }

    public void cancel() { getExecutor().executeScript("arguments[0].click();", cancel); }

    public void agreeToWarning () { warning.click(); }

    public String getName() { return name.getText(); }


}
