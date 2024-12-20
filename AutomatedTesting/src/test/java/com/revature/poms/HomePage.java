package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    // Locator for Logout Button
    @FindBy(id = "logoutButton") // Make sure to use the correct locator here
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement locationSelect;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "moonNameInput")
    private WebElement addMoonNameInput;

    @FindBy(className = "submitButton")
    private WebElement addMoonSubmitButton;

    @FindBy(className = "submitButton")
    private WebElement addPlanetSubmitButton;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement addMoonOrbitedPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement addMoonImageInput;


    @FindBy(id = "celestialTable")
    private WebElement celestialTable;

    @FindBy(xpath = "//table[@id='celestialTable']//td[contains(text(), 'moon')]")
    private List<WebElement> moons;

    @FindBy(xpath = "//table[@id='celestialTable']//td[contains(text(), 'planet')]")
    private List<WebElement> planets;
  
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLocationSelect(){
        locationSelect.click();
    }
    public void enterPlanetName(String PlanetName) { planetNameInput.sendKeys(PlanetName); }

    public void clickSubmitButton() {
        addPlanetSubmitButton.click();
    }

    // Method to click the Logout button
    public void clickLogoutButton() {
        logoutButton.click();
    }
  
    public void enterMoonNameToBeDeleted(String moonName) { deleteInput.sendKeys(moonName); }

    public void enterPlanetNameToBeDeleted(String planetName) { deleteInput.sendKeys(planetName); }

    public void enterMoonNameToBeAdded(String moonName ) { addMoonNameInput.sendKeys(moonName); }

    public void enterOrbitedPlanetID(String orbitedPlanetID) { addMoonOrbitedPlanetInput.sendKeys(orbitedPlanetID); }

    public void enterImage(String imageFile) { addMoonImageInput.sendKeys("src/test/resources/Celestial-Images/moon-3.jpg"); }

    public void submitAddMoonForm() { addMoonSubmitButton.click(); }

    public void clickDeleteButton() { deleteButton.click(); }

    public int moonsCount() {
        return moons.size();
    }

    public int visiblePlanetsCount() {
        return planets.size();
    }

    public void selectMoon() {
        Select select = new Select(locationSelect);
        select.selectByValue("moon");
    }

    public void selectPlanet() {
        Select select = new Select(locationSelect);
        select.selectByValue("planet");
    }

    public boolean isMoonVisible(String moonName) {

        boolean isFound = false;

        System.out.println(celestialTable.toString());

        return isFound;

    }

    public boolean isPlanetVisible(String planetName) {
        boolean isFound = false;

        return isFound;
    }


}

