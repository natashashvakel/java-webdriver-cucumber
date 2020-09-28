package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CareersLogin extends Page{

    //fields

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement email;

    @FindBy(id ="loginButton")
    private WebElement SubmitButton;



    //methods

    public void fillPassword(String value) { sendKeys(password,value);}

    public void fillEmail(String value) { sendKeys(email, value); }

    public void submit() { click(SubmitButton); }

    public void agreeToWarning() { getDriver().switchTo().alert().accept(); }


}
