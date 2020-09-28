package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getActions;
import static support.TestContext.getExecutor;

public class UspsHeader extends Page{

    @FindBy(xpath = "//*[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']/a")
    private WebElement lookupByZip;

    @FindBy(xpath = "//li[@class='tool-calc']//a[contains(@href,'post')]")
    private WebElement calculatePrice;

    public void goToLookupByZip() {
        //waitToBeSelected(mailAndShip);
        mouseOver(mailAndShip);
        //getActions().moveToElement(mailAndShip).perform();
        //using enhanced with Java Script "click" method from Page.java object
        click(lookupByZip);
        //clickWithJS(lookupByZip);
        //lookupByZip.click();
    }

    public void goToCalculatePrice() {
        //getActions().moveToElement(mailAndShip).perform();
        mouseOver(mailAndShip);
        calculatePrice.click();
    }


}
