package com.revature.steps.moons;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddMoonsSteps {

    @And("inputs Moon Name {string}")
    public void inputsMoonName(String moonName) {
        TestRunner.homePage.enterMoonNameToBeAdded(moonName);
    }

    @And("inputs Orbited Planet ID of {string}")
    public void inputsOrbitedPlanetIDOf(String orbitedPlanetID) {
        TestRunner.homePage.enterOrbitedPlanetID(orbitedPlanetID);
    }

    @And("inputs Image of {string}")
    public void inputsImageOf(String imageFile) {
        TestRunner.homePage.enterImage(imageFile);
    }

    @And("clicks the Submit Moon Button")
    public void clicksTheSubmitMoonButton() {
        TestRunner.homePage.submitAddMoonForm();
    }

    @Then("the User should see {string} and {string}>")
    public void theUserShouldSeeAnd(String addMoonResult, String expectedMessage) {
        if (addMoonResult.equals("Moon Created")) {
            Boolean isMoonVisible = TestRunner.homePage.isMoonVisible(expectedMessage);
            Assert.assertEquals(false, isMoonVisible);
        } else if (addMoonResult.equals("Alert")) {
            TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            String alertMessage = alert.getText();

            try {
                Assert.assertEquals(expectedMessage, alertMessage);
            } finally {
                alert.accept();
                TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
            }
        } else {
            Assert.fail("Incorrect delete moon result produced: " + addMoonResult);
        }
    }
}
