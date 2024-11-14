package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Instance of WebDriver
    private WebDriver driver;

    // Web element locators for login functionality
    @FindBy(id = "username") // Replace 'id' with the actual attribute in your HTML
    private WebElement usernameInput;

    @FindBy(id = "password") // Replace 'id' with the actual attribute in your HTML
    private WebElement passwordInput;

    @FindBy(id = "login-button") // Replace 'id' with the actual attribute in your HTML
    private WebElement loginButton;

    // Existing registration button locator
    @FindBy(tagName = "a")
    private WebElement registrationButton;

    
    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@id='loginForm']/input[@type='submit']")
    private WebElement loginButton;


    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with login functionality
    public void enterUsername(String username) {
        usernameInput.clear(); // Clear the input field before typing
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear(); // Clear the input field before typing
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    // Existing method for registration button interaction
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    // Optional method to retrieve alert text
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
  
    public void login(String username, String password){
        driver.get("http://localhost:8080/");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
