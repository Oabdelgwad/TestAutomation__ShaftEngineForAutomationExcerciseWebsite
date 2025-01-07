package automationExcercise.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPage {
    SHAFT.GUI.WebDriver driver;

    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public enum Gender{
        male,female;
    }
    public enum newsAndOffersCheckList{
        noCheck,newsCheck,offersCheck,newsAndOffersCheck;
    }
    ////////////////Locators\\\\\\\\\\\\\\\\\\\
    private By maleGenderChoiceRadioButton = By.id("id_gender1");
    private By femaleGenderChoiceRadioButton = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By birthDayChoice = By.id("days");
    private By birthMonthChoice = By.id("months");
    private By birthYearIDChoice = By.id("years");
    private By newsLetterCheckBox = By.id("newsletter");
    private By offersCheckBox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyNameField = By.id("company");
    private By addressOneField = By.id("address1");
    private By addressTwoField = By.id("address2");
    private By countryChoice = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode") ;
    private By phoneField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("[data-qa='create-account']");
    private By signUpButton = By.cssSelector("[data-qa='signup-button']");
    ////////////////Actions\\\\\\\\\\\\\\\\\\\
    @Step("Enter Account Information")
    public SignUpPage enterAccountInformation(Gender myGender, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, newsAndOffersCheckList targetCheckBoxes) {
        chooseGender(myGender);
        fillPassword(password);
        selectDayOfBirth(dayOfBirth);
        selectMonthOfBirth(monthOfBirth);
        selectYearOfBirth(yearOfBirth);
        checkNewsLettersAndOffers(targetCheckBoxes);
        return this;
    }
    private SignUpPage chooseGender(Gender yourGender)
    {
        if(yourGender==Gender.male)
        {
            driver.element().click(maleGenderChoiceRadioButton);
        }
        else if (yourGender==Gender.female)
        {
            driver.element().click(femaleGenderChoiceRadioButton);
        }
        return this;
    }
    private SignUpPage fillPassword(String password)
    {
        driver.element().type(passwordField, password);
        return this;
    }
    private SignUpPage selectDayOfBirth(String dayOfBirth)
    {
        driver.element().select(birthDayChoice, dayOfBirth);
        return this;
    }
    private SignUpPage selectMonthOfBirth(String monthOfBirth)
    {
        driver.element().select(birthMonthChoice, monthOfBirth);
        return this;
    }
    private SignUpPage selectYearOfBirth(String yearOfBirth)
    {
        driver.element().select(birthYearIDChoice, yearOfBirth);
        return this;
    }
    private void checkNewsLettersAndOffers(newsAndOffersCheckList checks)
    {
        if(checks==newsAndOffersCheckList.noCheck)
        {}
        else if (checks==newsAndOffersCheckList.newsCheck)
        {
            driver.element().click(newsLetterCheckBox);
        }
        else if(checks==newsAndOffersCheckList.offersCheck)
        {
            driver.element().click(offersCheckBox);
        }
        else if(checks==newsAndOffersCheckList.newsAndOffersCheck)
        {
            driver.element().click(newsLetterCheckBox);
            driver.element().click(offersCheckBox);
        }
    }
    @Step("Enter Address Information")
    public SignUpPage fillFirstAndLastName(String firstName,String lastName)
    {
        driver.element().type(firstNameField, firstName);
        driver.element().type(lastNameField, lastName);
        return this;
    }

    public SignUpPage fillCompanyName(String companyName)
    {
        driver.element().type(companyNameField, companyName);
        return this;
    }
    public SignUpPage fillAddreses(String addressOne,String addressTwo)
    {
        driver.element().type(addressOneField, addressOne);
        driver.element().type(addressTwoField, addressTwo);
        return this;
    }
    public SignUpPage selectCountry(String country)
    {
        driver.element().select(countryChoice, country);
        return this;
    }
    public SignUpPage fillStateAndCityAndZipCode(String state,String city ,String zipCode)
    {
        driver.element().type(stateField, state);
        driver.element().type(cityField, city);
        driver.element().type(zipCodeField, zipCode);
        return this;
    }
    public SignUpPage fillMobilePhone(String mobilePhone)
    {
        driver.element().type(phoneField, mobilePhone);
        return this;
    }
    public SignUpPage clickOnCreateAccountButtonAndNavigateCreatedAccountPage()
    {
        driver.element().click(createAccountButton);
        return this;
    }
    public SignUpPage navigate()
    {
        driver.element().click(signUpButton);
        return this;
    }
    ////////////////Validations\\\\\\\\\\\\\\\
    public SignUpPage assertYouAreInSignUpPage(){
        driver.assertThat().browser().title().isEqualTo("Automation Exercise - Signup");
        driver.assertThat().browser().url().isEqualTo("https://automationexercise.com/signup");
        return this;
    }
}
