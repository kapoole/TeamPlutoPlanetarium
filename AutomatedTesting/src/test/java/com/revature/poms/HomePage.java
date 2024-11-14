package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    // Locator for Logout Button
    @FindBy(id = "logout-button") // Make sure to use the correct locator here
    private WebElement logoutButton;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click the Logout button
    public void clickLogoutButton() {
        logoutButton.click();
    }
}

