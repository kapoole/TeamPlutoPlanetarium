package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
public class HomePage {

    private WebDriver driver;



    @FindBy(id = "locationSelect")
    private WebElement locationSelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;


    @FindBy(xpath = "//div[@class='center']/div[@id='inputContainer']/button[@class='submit-button']")
    private WebElement submitButton;
    //
    @FindBy(id = "deleteInput")
    private WebElement deleteInput;
    //
    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLocationSelect(){
        locationSelect.click();
    }
    public void enterPlanetName(String PlanetName) { planetNameInput.sendKeys(PlanetName); }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void clickDeleteButton() { deleteButton.click(); }

    public void selectPlanet() {
        Select select = new Select(locationSelect);
        select.selectByValue("Planet");
    }



}

