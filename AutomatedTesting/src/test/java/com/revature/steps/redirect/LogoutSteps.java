package com.revature.steps.redirect;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogoutSteps {

    // Step to click the Logout Button
    @When("The user clicks the Logout Button")
    public void the_user_clicks_the_logout_button() {
        // Click the logout button, assuming the button has a specific id (you might need to adjust this locator)
        TestRunner.homePage.clickLogoutButton();
    }

}
