package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class CareerOpenPosition extends CareerHeader {

    //fields

    @FindBy(xpath = "//*[@placeholder='Enter position Title']")
    private static WebElement positionTitle;

    @FindBy(xpath = "//*[@placeholder='Enter detailed Description']")
    private static WebElement positionDescription;

    @FindBy(xpath = "//*[text()='Address']/..//input")
    private static WebElement positionAddress;

    @FindBy(xpath = "//*[@placeholder='City']")
    private static WebElement positionCity;

    @FindBy(xpath = "//*[@id='root']//select")
    private static WebElement positionState;

    @FindBy(xpath = "//*[@placeholder='Zip code. Zip plus']")
    private static WebElement positionZip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private static WebElement positionDateOpen;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private static WebElement submitButton;


    //methods

    public void fillTitle(String value) { sendKeys(positionTitle,value);}

    public void fillDescription(String value) { sendKeys(positionDescription, value); }

    public void fillAddress(String value) { sendKeys(positionAddress,value);}

    public void fillCity(String value) { sendKeys(positionCity,value);}

    public void fillState(String value) {
    Select stateSelect = new Select(getDriver().findElement(By.xpath("//body/div[@id='root']//select[1]")));
        stateSelect.selectByVisibleText(value);

    }

    public void fillZip(String value) { sendKeys(positionZip,value);}

    public void fillDate(String value) { sendKeys(positionDateOpen,value);}

    public void clickSubmitButton() { click(submitButton); }





}
