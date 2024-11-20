package com.revature.steps.moons;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteMoonsSteps {



    @When("the User selects Moon from the Dropdown")
    public void the_User_selects_from_the_Dropdown() {
        TestRunner.homePage.selectMoon();
    }

    @When("inputs {string}")
    public void inputs(String moonName) {
        TestRunner.homePage.enterMoonNameToBeDeleted(moonName);
    }
//
    @When("clicks Delete Button")
    public void clicks_Delete_Button() {
        TestRunner.homePage.clickDeleteButton();
    }

    @And("should {string}")
    public void should(String redirectionResult) {
        if(redirectionResult.equals("User stays on Home Page")){
            Assert.assertEquals("Home", TestRunner.driver.getTitle());
        } else {
            Assert.assertEquals("Home", TestRunner.driver.getTitle());
        }
    }

    @Then("the User should see {string} and {string}")
    public void theUserShouldSeeAnd(String deleteMoonResult, String expectedMessage) {
        try {
            TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            String alertMessage = alert.getText();

            alert.accept();

            if (deleteMoonResult.equals("Moon Deleted")) {
                Assert.fail("Alert but no Alert was expected");
            }  else if (deleteMoonResult.equals("Alert")) {
                Assert.assertEquals(expectedMessage, alertMessage);
            }

        } catch (TimeoutException te) {
            if (deleteMoonResult.equals("Moon Deleted")) {
                Boolean isMoonVisible = TestRunner.homePage.isMoonVisible(expectedMessage);
                Assert.assertEquals(false, isMoonVisible);
            } else if (deleteMoonResult.equals("Alert")) {
                Assert.fail("No Alert but Alert was expected");
            } else{
                Assert.fail("No Alert failure");
            }
        }
    }
}
