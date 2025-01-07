package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By signupChoiceLocator = By.className("fa-lock");
    private By signUpNameField= By.cssSelector("[data-qa='signup-name']");
    private By signUpEmailField = By.cssSelector("[data-qa='signup-email']");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\

    public LoginPage signUpAsNewUser(String name , String mail) {
        driver.element().type(signUpNameField, name);
        driver.element().type(signUpEmailField, mail);
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\
    public LoginPage assertYouAreInLoginPage()
    {
        driver.assertThat().browser().title().isEqualTo("Automation Exercise - Signup / Login");
        driver.assertThat().browser().url().isEqualTo("https://automationexercise.com/login");
        return this;
    }


}
