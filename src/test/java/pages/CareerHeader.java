package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CareerHeader extends Page {

    //fields

    @FindBy(xpath = "//button[(text()='Login')]")
    private static WebElement loginButton;

    @FindBy(xpath = "//button[(text()='Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[text()='Recruit']")
    private WebElement recruitButton;

    @FindBy(xpath = "//button[text()='Careers']")
    private WebElement careersButton;



    // dynamic field

    private WebElement buttonName(String button) {
        return getDriver().findElement(By.xpath("//button[text()='" + button + "']"));
    }


    //methods

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickCareersButton() {
        click(careersButton);
    }

    public void clickRecruitButton() {
        click(recruitButton);
    }

    public void clickButton(String button) {
        click(buttonName(button));
    }

    public void verifyLogoutButtonIsPresent() {
        assertThat(logoutButton).isNotNull();
    }


}
