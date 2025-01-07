package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItems {
    SHAFT.GUI.WebDriver driver;
    private By deleteAccountChoice = By.className("fa-trash-o");
    private By signupChoiceLocator = By.className("fa-lock");
    private By logoutChoiceLocator = By.className("fa-lock");
    public MenuItems(    SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public MenuItems navigateToLoginPage(){
        driver.element().click(signupChoiceLocator);
        return this;
    }
    public MenuItems logout(){
        driver.element().click(logoutChoiceLocator);
        return this;
    }
    public MenuItems deleteAccount()
    {
        driver.element().click(deleteAccountChoice);
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\


}
