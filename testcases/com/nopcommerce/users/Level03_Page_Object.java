package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.users.UserRegisterPO;

import java.time.Duration;

public class Level03_Page_Object extends BaseTest {
    //Declare variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPO customerInfoPage;
    String firstName, lastName, emailAddress, companyName, password;

    //Pre-condition
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //No duoc sinh ra và lam action cua page do
        homePage = new UserHomePO(driver);
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
        homePage.openRegisterPage();
//        Tu homePage qua registerPage
//        Page do duoc sinh ra de lam action cua page do
        registerPage = new UserRegisterPO(driver);
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
        registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        homePage.openLoginPage();
//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        loginPage = new UserLoginPageObject(driver);
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        homePage = new UserHomePO(driver);
        Assert.assertTrue(homePage.isMyaccountLinkDisplayed());

    }

    @Test
    public void User_03_Myaccount() {
        homePage.openCustomerInfoPage();
//        Tu homePage qua customerInfoPage
//        Page do duoc sinh ra de lam action cua page do
        customerInfoPage = new UserCustomerInfoPO(driver);
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
