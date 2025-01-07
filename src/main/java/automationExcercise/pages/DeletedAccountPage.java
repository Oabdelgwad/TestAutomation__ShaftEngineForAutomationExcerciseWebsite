package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeletedAccountPage {
    SHAFT.GUI.WebDriver driver;
     public DeletedAccountPage(    SHAFT.GUI.WebDriver driver) {
         this.driver = driver;
     }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By continueButton = By.className("btn-primary");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public DeletedAccountPage backToHomePage()
    {
        driver.element().click(continueButton);
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\
    public DeletedAccountPage assertAccountDeleted (String accountDeletedMessage){
        driver.assertThat().element(By.className("text-center")).text().isEqualTo(accountDeletedMessage);
        return this;
    }

}
