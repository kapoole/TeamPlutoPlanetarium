package com.revature.steps.moons;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewMoonsSteps {

//    @Given("the User is on the {string}")
//    public void the_User_is_on_the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//
//    }

    @Given("the User is logged in and on the {string}")
    public void the_User_is_logged_in_and_on_the(String url) {
        TestRunner.loginPage.login("Batman", "I am the night");
        TestRunner.driver.get(url);
    }

    @Then("the User should see {string}")
    public void the_User_should_see(String string) {
        int moonCount = TestRunner.homePage.moonsCount();
        Assert.assertEquals(2, moonCount);
    }

}
