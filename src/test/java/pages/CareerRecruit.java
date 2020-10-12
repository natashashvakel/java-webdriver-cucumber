package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class CareerRecruit extends CareerHeader {

    //fields

    @FindBy(xpath = "//*[text()='Principal Automation Engineer']/../../..//button[@class='style-close']")
    private static WebElement principalAutomationEngineerRemoveButton;

    @FindBy(xpath = "//*[text()='New Position']")
    private static WebElement newPositionButton;

    @FindBy(xpath = "//*[text()='Open new position']/../..")
    private static WebElement recruitControl;



    // dynamic field

    private WebElement removePositionButton(String position) {
        return getDriver().findElement(By.xpath("//*[text()='" + position + "']/../../..//button[@class='style-close']"));
    }

    private WebElement positionElement(String position) {
        return getDriver().findElement(By.xpath("//*[text()='" + position + "']/../../.."));
    }


    //methods

    public void removePosition(String position) {
        mouseOver(positionElement(position));
        removePositionButton(position).click();
    }

    public void openPosition() {
        mouseOver(recruitControl);
        newPositionButton.click();
    }


}
