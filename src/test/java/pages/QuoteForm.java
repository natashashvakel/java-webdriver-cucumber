package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    //fields


    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(name = "middleName")
    private WebElement middleName;

    @FindBy(id = "lastName")
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

    @FindBy(id = "confirmPassword-error")
    private WebElement confirmPasswordError;

    @FindBy(id = "name-error")
    private WebElement nameError;

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private WebElement agreedToPrivacyPolicy;


    // dynamic field
    private WebElement errorElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName + "-error"));
    }


    //constructor

    public QuoteForm() {
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    //methods

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
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + lastNameValue);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + middleNameValue + " " + lastNameValue);
    }


    public String getFieldValue (String fieldName) {
        if (fieldName.equals("name"))
            return name.getAttribute("value");

        else return "";
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
            case "confirmPassword":
                return confirmPasswordError.getText();
        }
        return "";
    }

    public String getErrorFieldText(String fieldName) {
        waitToBeSelected(errorElement(fieldName));
        return errorElement(fieldName).getText();
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

    public boolean errorDisplayed(String fieldId) {

        switch (fieldId) {
            case "username":
                return usernameError.isDisplayed();
            case "email":
                return emailError.isDisplayed();
            case "password":
                return passwordError.isDisplayed();
            case "name":
                return nameError.isDisplayed();
            case "agreedToPrivacyPolicy":
                return agreedToPrivacyPolicy.isDisplayed();
        }
        return false;
    }


}
