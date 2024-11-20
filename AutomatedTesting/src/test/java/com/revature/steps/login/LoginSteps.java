package com.revature.steps.login;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    @When("The user enters the login username {string}")
    public void the_user_enters_the_login_username(String username) {
        TestRunner.loginPage.enterUsername(username);
    }

    @And("The user enters the login password {string}")
    public void the_user_enters_the_login_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }

    @And("The user clicks the login button")
    public void the_user_clicks_the_login_button() {
        TestRunner.loginPage.clickLoginButton();
    }


    @Then("The user should see Login Result {string} and {string}")
    public void theUserShouldSeeLoginResultAnd(String loginResult, String expectedMessage) {
        try {
            TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            String alertMessage = alert.getText();

            alert.accept();

            if (loginResult.equals("Login Success")) {
                Assert.fail("Alert but no Alert was expected");
            }  else if (loginResult.equals("Login Failed")) {
                Assert.assertEquals(expectedMessage, alertMessage);
            } else {
                Assert.fail("Alert failure");
            }

        } catch (TimeoutException te) {
            if (loginResult.equals("Login Success")) {
                // Nothing should happen here, inconsequential validate
                Assert.assertEquals(expectedMessage, "N/A");
            } else if (loginResult.equals("Login Failed")) {
                Assert.fail("No Alert but Alert was expected");
            } else{
                Assert.fail("No Alert failure");
            }
        }
    }
}
