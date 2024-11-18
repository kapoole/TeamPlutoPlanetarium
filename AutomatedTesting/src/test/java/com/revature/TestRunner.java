package com.revature;

import com.revature.poms.HomePage;
import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;
import com.revature.poms.HomePage; // Add HomePage import
import com.revature.utility.Setup;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.revature.steps", // Glue code for step definitions
        features = "classpath:features", // Path to feature files
        plugin = {"pretty", "json:src/test/resources/json-report.json", "html:/src/test/resources/html-report.html"} // Report generation
)
public class TestRunner {

    // Declare WebDriver and WebDriverWait
    public static WebDriver driver;
    public static WebDriverWait alertWait;

    // Declare page objects
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;
    public static HomePage homePage; // Declare HomePage object for logout functionality


    // Setup method to initialize WebDriver and page objects
    @BeforeClass
    public static void setup() {
        // Initialize the WebDriver (ChromeDriver in this case)
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Initialize the WebDriverWait
        alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // Initialize page objects
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver); // Initialize HomePage for logout functionality
    }

    // Tear down method to close the WebDriver after tests
    @AfterClass
    public static void tearDown() {
        System.out.println("TEARING DOWN...");
        if (driver != null) {
            driver.quit(); // Close the browser after tests
            System.out.println("Closed driver!!!!!!!");
        }
        Setup.main(new String[]{}); // Run the Setup utility (if applicable)
    }
}
