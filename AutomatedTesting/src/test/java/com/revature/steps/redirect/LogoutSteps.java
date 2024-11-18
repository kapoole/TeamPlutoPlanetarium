package com.revature.steps.redirect;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogoutSteps {

    // Step to click the Logout Button
    @When("the User clicks the Logout Button")
    public void the_User_clicks_the_Logout_Button() {
        // Click the logout button
        TestRunner.driver.findElement(By.id("logout-button")).click();
    }

    @Then("the User should redirect to http:\\/\\/localhost:{int}\\/")
    public void the_User_should_redirect(String url) {
        TestRunner.driver.get(url);
    }

}
