package com.revature.steps.moons;

import com.revature.TestRunner;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewMoonsSteps {


    @Given("the User is logged in and on the {string} as {string} and {string}")
    public void theUserIsLoggedInAndOnTheAsAnd(String url, String username, String password) {
        TestRunner.loginPage.login(username, password);
        TestRunner.driver.navigate().to(url);
    }


    @Then("the User should see {string}")
    public void the_User_should_see(String numberOfMoons) {
        int moonCount = TestRunner.homePage.moonsCount();
        Assert.assertEquals(numberOfMoons, moonCount + " Moons");
    }

}
