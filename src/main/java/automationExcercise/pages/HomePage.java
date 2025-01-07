package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By loggedInWithYourNAme = By.xpath("//a[b]");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    public void navigate() {
        driver.browser().navigateToURL("https://automationexercise.com/");
    }
    ////////////////Validations\\\\\\\\\\\\\\\\\\\
    public HomePage assertYouAreLoggedInHomePage(String userName)
    {
        driver.assertThat().element(loggedInWithYourNAme).text().isEqualTo("Logged in as " + userName);
        return this;
    }


}
