package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteForm {

    //fields

    private String url;
    private String title;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(id = "dateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(name = "allowedToContact")
    private WebElement allowedToContact;

    @FindBy(xpath = "//input[@value='male']")
    private WebElement gender;

    @FindBy(id = "username-error")
    private WebElement usernameError;

    @FindBy(id = "email-error")
    private WebElement emailError;

    @FindBy(id = "password-error")
    private WebElement passwordError;

    @FindBy(id = "name-error")
    private WebElement nameError;

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private WebElement agreedToPrivacyPolicy;


    //constructor

    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    //methods

    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void agreeWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillDateOfBirth(String value) {
        dateOfBirth.sendKeys(value);
    }

    public void fillAllowedToContact() {
        allowedToContact.click();
    }

    public void fillGender() {
        gender.click();
    }

    public String getErrorText(String fieldId) {

        switch (fieldId) {
            case "username":
                return usernameError.getText();
            case "email":
                return emailError.getText();
            case "password":
                return passwordError.getText();
            case "name":
                return nameError.getText();
            case "agreedToPrivacyPolicy":
                return agreedToPrivacyPolicy.getText();
        }
        return "";
    }

    public void fillField(String field, String value) {

        switch (field) {
            case "username":
                username.clear();
                username.sendKeys(value);
                break;
            case "email":
                email.clear();
                email.sendKeys(value);
                break;
            case "password":
                password.clear();
                password.sendKeys(value);
                break;
            case "confirmPassword":
                confirmPassword.clear();
                confirmPassword.sendKeys(value);
                break;
        }
    }

}
