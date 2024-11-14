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

    @Then("the User should see an Alert saying {string}")
    public void the_User_should_see_an_Alert_saying(String message) {
        TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();

        System.out.print("[");
        System.out.print(alertMessage);
        System.out.println("]");

        try{
            if(message.equals("Moon Created")){
                Assert.assertEquals("Filler to be deleted, no alert for positive case", alertMessage);
            } else if (message.equals("Moon Not Created")) {
                Assert.assertEquals("Failed to delete moon with name ", alertMessage);
            } else{
                Assert.fail("Incorrect alert message produced: actual message: " + alertMessage );
            }
        } finally{
            alert.accept();
            // here we tell the driver to wait up to 2 seconds for the alert to be gone before continuing
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }


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
        if (deleteMoonResult.equals("Moon Deleted")) {
            Boolean isMoonVisible = TestRunner.homePage.isMoonVisible(expectedMessage);
            Assert.assertEquals(false, isMoonVisible);
        } else if (deleteMoonResult.equals("Alert")) {
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
            Assert.fail("Incorrect add moon result produced: " + deleteMoonResult);
        }
    }
}
