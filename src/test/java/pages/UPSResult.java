package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UPSResult extends Page{


    //fields

    @FindBy(xpath = "//div[@class='ups-group ups-group_condensed']")
    private WebElement shipFrom;

    //methods

    public String getResult() {
        return shipFrom.getText();
    }
}
