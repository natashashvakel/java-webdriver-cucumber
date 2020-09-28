package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getActions;
import static support.TestContext.getDriver;


public class CareersHome extends CareerHeader {

    //constructor

    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    //fields


    @FindBy(xpath = "//*/div[@id='shuffle']")
    private WebElement positionPostings;


    // dynamic field


    private WebElement positionName(String position) {
        try { return getDriver().findElement(By.xpath("//*[(text()='" + position + "')]")); }
        catch (Exception e) { }
        return null;
    }


    //methods


    public boolean isPositionPresent(String position) {
        WebElement element = positionName(position);
        return element != null && element.isDisplayed();
    }


    public void clickPosition(String position) {
        click(positionName(position));
    }

    public void waitUntilPosingAreaContainText() {
        waitUntilContainsText(positionPostings);
    }



}
