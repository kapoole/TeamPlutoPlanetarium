package com.revature.steps.AddPlanet;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPlanet {
    @When("the User enter  {string}")
    public void the_User_enter(String PlanetName) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(PlanetName);
    }

    @When("clicks on Submit button")
    public void clicks_on_Submit_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.clickSubmitButton();
    }

    @Then("the User should see alert {string}")
    public void the_User_should_see_alert_Planet_added_successfully(String message) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        // if one of these assert statements fails then the methods execution stops, so we need to make sure the alert is closed
        try{
            if(message.equals("Planet added successfully.")){
                Assert.assertEquals("Planet added successfully ", alertMessage);
            }  else{
                Assert.fail("Incorrect alert message produced: actual message: " + alertMessage );
            }
        } finally{
            alert.accept();
            // here we tell the driver to wait up to 2 seconds for the alert to be gone before continuing
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }

    }

//    @Then("the User should  {string}")
//    public void the_User_should_Redirect(String url) {
//        // Write code here that turns the phrase above into concrete actions
//        TestRunner.driver.get(url);
//    }

//    @Then("the User should see alert {string}")
//    public void the_User_should_see_alert_Planet_added_successfully(String string) {
//        // Write code here that turns the phrase above into concrete actions
//
//    }
//
//    @Then("the User should  \"\"be redirected to their updated planet list\"\"")
//    public void the_User_should_be_redirected_to_their_updated_planet_list() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the User should see alert \"\"Error: Planet name cannot exceed characters limit.{string}")
//    public void the_User_should_see_alert_Error_Planet_name_cannot_exceed_characters_limit(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the User should  \"\"remain on the Add Planet page\"\"")
//    public void the_User_should_remain_on_the_Add_Planet_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the User should see alert \"\"Error: Planet name must be unique.{string}")
//    public void the_User_should_see_alert_Error_Planet_name_must_be_unique(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the User should  {string}{string}\"")
//    public void the_User_should(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
