package com.revature.steps.login;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    @When("The user enters the username {string}")
    public void the_user_enters_the_username(String username) {
        TestRunner.loginPage.enterUsername(username);
    }

    @When("The user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }

    @When("The user clicks the login button")
    public void the_user_clicks_the_login_button() {
        TestRunner.loginPage.clickLoginButton();
    }

    @Then("An alert should appear saying {string}")
    public void an_alert_should_appear_saying(String message) {
        // Wait for alert and switch to it
        TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();

        // Validate the alert message
        try {
            if (message.equals("Login successful")) {
                Assert.assertEquals("Login successful", alertMessage);
            } else if (message.equals("Invalid username or password")) {
                Assert.assertEquals("Invalid username or password", alertMessage);
            } else {
                Assert.fail("Unexpected alert message: " + alertMessage);
            }
        } finally {
            alert.accept();
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }
    }

    @Then("The user should redirect to {string}")
    public void the_user_should_redirect_to(String expectedPageTitle) {
        String actualTitle = TestRunner.driver.getTitle();

        // Validate the page title to confirm redirection
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }
}
