package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class CareerRecruit extends CareerHeader {

    //fields

    @FindBy(xpath = "//*[text()='Principal Automation Engineer']/../../..//button[@class='style-close']")
    private static WebElement principalAutomationEngineerRemoveButton;



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
}
