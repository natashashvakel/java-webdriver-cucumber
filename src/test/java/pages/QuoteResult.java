package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult {

    //constructor

    public QuoteResult() {
        PageFactory.initElements(getDriver(),this);

    }

    //fields

    //@FindBy(name = "username")
    //private WebElement username;

    //@FindBy(name = "email")
    //private WebElement email;

    @FindBy(name = "password")
    private WebElement passwordResult;

    //@FindBy(name = "firstName")
    //private WebElement firstName;

    //@FindBy(name = "lastName")
    //private WebElement lastName;

    @FindBy(id = "quotePageResult")
    private WebElement quotePageResult;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(name = "allowedToContact")
    private WebElement contact;

    @FindBy(name = "gender")
    private WebElement gender;


    //methods

    public String getResult() {
        return quotePageResult.getText();
    }

    public String getPasswordResult() {
        return passwordResult.getText();
    }

    public String getPrivacyPolicy() {
        return privacy.getText();
    }

    public String getContact() {
        return contact.getText();
    }

    public String getGender() {
        return gender.getText();
    }



}
