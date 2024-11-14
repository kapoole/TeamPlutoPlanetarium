package com.revature.steps.shared;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SharedSteps {

    // Starting step for login page (unchanged)
    @Given("The user is on the login page at url {string}")
    public void the_user_is_on_the_login_page_at_url(String url) {
        TestRunner.driver.get(url);
    }

    // Shared step for clicking the registration button (unchanged)
    @When("The user clicks the registration button")
    public void the_user_clicks_the_registration_button() {
        TestRunner.loginPage.clickRegistrationButton();
    }

    // Shared step for clicking the logout button (added for logout functionality)
    @When("The user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        TestRunner.homePage.clickLogoutButton(); // Use HomePage to click logout
    }
}
