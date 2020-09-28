package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {


    CareersHome careersHome = new CareersHome();
    CareersLogin careersLogin = new CareersLogin();
    CareerHeader careerHeader = new CareerHeader();
    CareerRecruit careerRecruit = new CareerRecruit();


    @And("I login as {string}")
    public void iLoginAs(String role)  {
        Map<String,String> recruiter = getData(role);
        careersHome.clickLoginButton();
        careersLogin.fillEmail(recruiter.get("email"));
        careersLogin.fillPassword(recruiter.get("password"));
        careersLogin.submit();
        //careersLogin.agreeToWarning();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        careersHome.verifyLogoutButtonIsPresent();
    }


    @When("I remove {string} position")
    public void iRemovePosition(String position) {
        careerHeader.clickRecruitButton();
        careerRecruit.removePosition(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position)  {
        careerHeader.clickCareersButton();
        careersHome.waitUntilPosingAreaContainText();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        if (careersHome.isPositionPresent(position)) {
            System.out.println("Error: deleted position is still displayed");
        }
        else {
            System.out.println("Position was removed successfully");
        }
    }
}
