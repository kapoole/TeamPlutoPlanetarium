package com.revature.steps.ViewPlanets;
import com.revature.TestRunner;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewPlanetsSteps {
    @Then("the User should see {string} Planets")
    public void theUserShouldSeePlanets(String numberOfPlanets) {
        int planetCount = TestRunner.homePage.visiblePlanetsCount();
        Assert.assertEquals(numberOfPlanets, Integer.toString(planetCount));
    }
}
