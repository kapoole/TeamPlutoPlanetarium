package com.revature.steps.DeletePlanet;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeletePlanet {
    @When("the User enter {string}")
    public void the_User_enter(String PlanetName) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(PlanetName);
    }

    @Then("the User should see delete planet alert  {string}")
    public void the_User_should_see__delete_planet_alert (String message) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();

        System.out.print("[");
        System.out.print(alertMessage);
        System.out.println("]");

        try{
            if(message.equals("Planet deleted successfully.")){
                Assert.assertEquals("Filler to be deleted, no alert for positive case", alertMessage);
            } else if (message.equals("Error: You do not have permission to delete this planet.")) {
                Assert.assertEquals("Failed to delete planet with name ", alertMessage);
            } else{
                Assert.fail("Incorrect alert message produced: actual message: " + alertMessage );
            }
        } finally{
            alert.accept();
            // here we tell the driver to wait up to 2 seconds for the alert to be gone before continuing
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }

    }

    @When("the User selects Planet from the Dropdown")
    public void theUserSelectsPlanetFromTheDropdown() {
        TestRunner.homePage.selectPlanet();
    }

    @And("inputs Planet Name {string}")
    public void inputsPlanetNamePlanetName(String planetName) {
        TestRunner.homePage.enterPlanetNameToBeDeleted(planetName);
    }

    @Then("the User should see Delete Planet Result of {string} and {string}")
    public void theUserShouldSeeDeletePlanetResultAndExpectedMessage(String deletePlanetResult, String expectedMessage) {
        try {
            TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            String alertMessage = alert.getText();

            alert.accept();

            if (deletePlanetResult.equals("Planet Deleted")) {
                Assert.fail("Alert but no Alert was expected");
            }  else if (deletePlanetResult.equals("Alert")) {
                Assert.assertEquals(expectedMessage, alertMessage);
            } else {
                Assert.fail("Alert failure");
            }

        } catch (TimeoutException te) {
            if (deletePlanetResult.equals("Planet Deleted")) {
                Boolean isPlanetVisible = TestRunner.homePage.isPlanetVisible(expectedMessage);
                Assert.assertEquals(false, isPlanetVisible);
            } else if (deletePlanetResult.equals("Alert")) {
                Assert.fail("No Alert but Alert was expected");
            } else{
                Assert.fail("No Alert failure");
            }
        }
    }

    @And("should Delete Planet Redirect of {string}")
    public void shouldDeletePlanetRedirectOfDeletePlanetRedirect(String deletePlanetRedirect) {
        if(deletePlanetRedirect.equals("User stays on Home Page")){
            Assert.assertEquals("Home", TestRunner.driver.getTitle());
        } else {
            Assert.assertEquals("Home", TestRunner.driver.getTitle());
        }
    }


//    @Then("the User should  {string}")
//    public void the_User_should_stay_in_homepage(String url) {
//        // Write code here that turns the phrase above into concrete actions
//        TestRunner.driver.get(url);
//    }

//    @Then("the User should {string}")
//    public void the_User_should_be_redirected_to_their_updated_planet_list(String redirectionResult) {
//        // Write code here that turns the phrase above into concrete actions
//        if(redirectionResult.equals("User stays on Home Page")){
//            Assert.assertEquals("Home", TestRunner.driver.getTitle());
//        } else {
//            Assert.assertEquals("Home", TestRunner.driver.getTitle());
//        }
//    }

//    @Then("the User should see alert \"\"Error: You do not have permission to delete this planet.{string}")
//    public void the_User_should_see_alert_Error_You_do_not_have_permission_to_delete_this_planet(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @Then("the User should \"\"remain on the current page\"\"")
//    public void the_User_should_remain_on_the_current_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @Then("the User should see alert \"\"Planet and its orbiting moon deleted successfully.{string}")
//    public void the_User_should_see_alert_Planet_and_its_orbiting_moon_deleted_successfully(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
