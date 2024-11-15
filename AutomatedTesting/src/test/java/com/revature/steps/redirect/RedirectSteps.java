package com.revature.steps.redirect;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RedirectSteps {

    // Step to click the Create Account button from the Login Page
    @When("the User click the Create Account button")
    public void the_user_clicks_the_create_account_button() {
        // Click the registration button
        TestRunner.loginPage.clickRegistrationButton();
    }

    // Step to verify the redirection to the registration page
    @Then("the User should redirect to registration page {string}")
    public void the_user_should_redirect_to_registration_page(String createAccountPageUrl) {
        // Validate the current page URL to confirm the redirection
        String currentUrl = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals("User is not redirected to the create account page", createAccountPageUrl, currentUrl);
    }

}
