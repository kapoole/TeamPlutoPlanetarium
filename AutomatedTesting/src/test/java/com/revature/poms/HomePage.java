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
    private WebElement locationaSelect;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "celestialTable")
    private WebElement celestialTable;

    @FindBy(xpath = "//table[@id='celestialTable']//td[contains(text(), 'moon')]")
    private List<WebElement> moons;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterMoonNameToBeDeleted(String moonName) { deleteInput.sendKeys(moonName); }

    public void clickDeleteButton() { deleteButton.click(); }

    public int moonsCount() {
        System.out.println(moons.toString());
        return moons.size();
    }

    public void selectMoon() {
        Select select = new Select(locationaSelect);
        select.selectByValue("moon");
    }


}
