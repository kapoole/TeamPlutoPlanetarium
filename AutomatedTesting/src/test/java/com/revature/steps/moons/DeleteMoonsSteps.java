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

//    @Given("the User is logged in and on the {string}")
//    public void the_User_is_logged_in_and_on_the(String url) {
//        TestRunner.loginPage.login("Batman", "I am the night");
//        TestRunner.driver.get(url);
//    }

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
//
//    @Then("should <Stay> on the {string}")
//    public void should_Stay_on_the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("should <stay> on the {string}")
//    public void should_stay_on_the(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

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
        try{
            if(deleteMoonResult.equals("Moon Deleted")){
                Boolean isMoonVisible = TestRunner.homePage.isMoonVisible(expectedMessage);
                Assert.assertEquals(false, isMoonVisible);
            } else if (deleteMoonResult.equals("Alert")) {
                Assert.assertEquals("Failed to delete moon with name ", alertMessage);
            } else{
                Assert.fail("Incorrect delete moon result produced: " + alertMessage );
            }
        } finally{
            alert.accept();
            // here we tell the driver to wait up to 2 seconds for the alert to be gone before continuing
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }
    }
}
