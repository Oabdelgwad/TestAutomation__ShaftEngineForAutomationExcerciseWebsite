package SignUp;
import automationExcercise.api.APIS;
import automationExcercise.api.userManagement.DeleteAccountAPI;
import automationExcercise.api.userManagement.LoginAPI;
import automationExcercise.pages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShaftUserManagement {
    SHAFT.TestData.JSON testData;
    SHAFT.GUI.WebDriver driver;
    SHAFT.API api;

    @BeforeMethod
    public void driverSetupAndWebsiteNavigation(){
        testData = new SHAFT.TestData.JSON("src/test/resources/signUpTestData.json");
        driver= new SHAFT.GUI.WebDriver();
        api= new SHAFT.API(APIS.baseUrl);
    }

    @Test
    public void signUpNewUser(){
        new HomePage(driver).navigate();
        new MenuItems(driver).navigateToLoginPage();
        new LoginPage(driver).signUpAsNewUser(testData.getTestData("userName"),testData.getTestData("email"));
        new SignUpPage(driver).navigate()
                .assertYouAreInSignUpPage()
                .enterAccountInformation(SignUpPage.Gender.male,testData.getTestData("password"),testData.getTestData("dayOfBirth"),testData.getTestData("monthOfBirth"),testData.getTestData("yearOfBirth"), SignUpPage.newsAndOffersCheckList.newsAndOffersCheck)
                .fillFirstAndLastName(testData.getTestData("firstName"),testData.getTestData("lastName"))
                .fillCompanyName(testData.getTestData("companyName"))
                .fillAddreses(testData.getTestData("address1"), testData.getTestData("address2"))
                .selectCountry(testData.getTestData("country"))
                .fillStateAndCityAndZipCode(testData.getTestData("state"), testData.getTestData("city"),testData.getTestData("zipCode"))
                .fillMobilePhone(testData.getTestData("mobilePhone"))
                .clickOnCreateAccountButtonAndNavigateCreatedAccountPage();
        new CreatedAccountPage(driver).assertAccountCreated( "ACCOUNT CREATED!")
                .backToHomePage();
        new HomePage(driver).assertYouAreLoggedInHomePage(testData.getTestData("userName"));
        new MenuItems(driver).logout();
        new LoginPage(driver).assertYouAreInLoginPage();
        new LoginAPI(api).loginViaAPI(testData.getTestData("email"),testData.getTestData("password"));
        new DeleteAccountAPI(api).DeleteAccountViaAPI(testData.getTestData("email"),testData.getTestData("password"));
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
