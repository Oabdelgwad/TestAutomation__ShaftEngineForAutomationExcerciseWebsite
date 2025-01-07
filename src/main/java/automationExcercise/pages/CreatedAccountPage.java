package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreatedAccountPage {
    SHAFT.GUI.WebDriver driver;

    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By continueButton = By.className("btn-primary");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public CreatedAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public CreatedAccountPage backToHomePage()
    {
        driver.element().click(continueButton);
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\
    public CreatedAccountPage assertAccountCreated (String accountCreatedMessage){
        driver.assertThat().element(By.className("text-center")).text().isEqualTo(accountCreatedMessage);
        return this;
    }

}
