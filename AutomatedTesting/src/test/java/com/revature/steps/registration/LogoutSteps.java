package com.revature.steps.logout;

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
        TestRunner.driver.findElement(By.id("logout-button")).click();
    }

    // Step to verify redirection to the login page
    @Then("The user should redirect to {string}")
    public void the_user_should_redirect_to(String loginPageUrl) {
        // Validate the URL or title of the page to confirm redirection
        String currentUrl = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals("User is not redirected to the login page", loginPageUrl, currentUrl);
    }
}
