package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.subPageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level06_Page_Generator_01 extends BaseTest {
    //Declare variables
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    String firstName, lastName, emailAddress, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        //No duoc sinh ra và lam action cua page do
        homePage = new HomePageObject(driver);
        firstName = "John";
        lastName = "Conor";
        emailAddress = firstName + generateRandomNumb() + "@gmail.com";
        companyName = "Continental";
        password = "12345678";
    }


    //Testcases
    @Test
    public void User_01_Register() {
        //Khong co su ket noi
        homePage.openRegisterPage();
//        Tu homePage qua registerPage
//        Page do duoc sinh ra de lam action cua page do
        registerPage = new RegisterPageObject(driver);
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
        homePage.openLoginPage();
//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isMyaccountLinkDisplayed());

    }

    @Test
    public void User_03_Myaccount() {
        homePage.openCustomerInfoPage();
//        Tu homePage qua customerInfoPage
//        Page do duoc sinh ra de lam action cua page do
        customerInfoPage = new CustomerInfoPageObject(driver);
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
