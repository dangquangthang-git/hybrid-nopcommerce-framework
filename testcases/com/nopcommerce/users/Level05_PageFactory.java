package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.CustomerInfoPageFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

public class Level05_PageFactory extends BaseTest {
    //Declare variables
    private WebDriver driver;
    private HomePageFactory homePage;
    private RegisterPageFactory registerPage;
    private LoginPageFactory loginPage;
    private CustomerInfoPageFactory customerInfoPage;
    String attribute, firstName, lastName, emailAddress, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        //No duoc sinh ra và lam action cua page do
        homePage = new HomePageFactory(driver);
        firstName = "John";
        lastName = "Conor";
        emailAddress = firstName + generateRandomNumb() + "@gmail.com";
        companyName = "Continental";
        password = "12345678";
    }


    //Testcases
    @Test
    public void User_01_Register() {
//        Action01
        homePage.clickToRegisterLink();
//        Tu homePage qua registerPage
//        Page do duoc sinh ra de lam action cua page do
        registerPage = new RegisterPageFactory(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextBox(firstName);
        registerPage.enterToLastNameTextBox(lastName);
//        registerPage.selectDayDropDown();
//        registerPage.selectMonthDropDown();
//        registerPage.selectYearDropDown();
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToCompanyTextBox(companyName);
        registerPage.enterToPasswordTextBox(password);
        registerPage.enterToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToLogoutButton();
    }

    @Test
    public void User_02_Login() {
        homePage.clickToLoginButton();
//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        loginPage = new LoginPageFactory(driver);
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        homePage = new HomePageFactory(driver);
        Assert.assertTrue(homePage.isMyaccountLinkDisplayed());

    }

    @Test
    public void User_03_Myaccount() {
        homePage.clickToMyaccountLink();
//        Tu homePage qua customerInfoPage
//        Page do duoc sinh ra de lam action cua page do
        customerInfoPage = new CustomerInfoPageFactory(driver);
        Assert.assertTrue(customerInfoPage.isMaleGenderSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
//        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), "");
//        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), "");
//        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), "");
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);

    }

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

}
