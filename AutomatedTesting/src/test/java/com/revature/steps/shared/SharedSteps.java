package com.revature.steps.shared;

import com.revature.TestRunner;
import com.revature.utility.Setup;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;

public class SharedSteps {

//    @Before
//    public void resetDatabase() {
//        Setup.main(new String[]{});
//    }


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

    @Given("the User is on the {string}")
    public void the_User_is_on_the(String url) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.login("IamRobin", "Iwillsavetheworld");
        TestRunner.driver.get(url);
    }

    @Then("the User should  {string}")
    public void the_User_should_stay_in_homepage(String url) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get(url);
    }
  
    // Shared step for clicking the logout button (added for logout functionality)
    @When("The user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        TestRunner.homePage.clickLogoutButton(); // Use HomePage to click logout
    }

    @Then("The user should redirect to {string}")
    public void the_user_should_redirect_to(String expectedPageTitle) {
        String actualTitle = TestRunner.driver.getTitle();

        // Validate the page title to confirm redirection
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }
}
