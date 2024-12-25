package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level07_Switch_Page_Object extends BaseTest {
    //Declare variables
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    String firstName, lastName, emailAddress, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        //No duoc sinh ra và lam action cua page do
        homePage = PageGenerator.getHomePage(driver);
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
        registerPage = PageGenerator.getHomePage(driver).openRegisterPage();
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

//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        loginPage = PageGenerator.getHomePage(driver).openLoginPage();
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        homePage = PageGenerator.getLoginPage(driver).clickToLoginButton();
        Assert.assertTrue(homePage.isMyaccountLinkDisplayed());

    }

    @Test
    public void User_03_Myaccount() {
        customerInfoPage = PageGenerator.getHomePage(driver).openCustomerInfoPage();
//        Tu homePage qua customerInfoPage
//        Page do duoc sinh ra de lam action cua page do
        Assert.assertTrue(customerInfoPage.isMaleGenderSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
//        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), "");
//        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), "");
//        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(), "");
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);

    }

    @Test
    public void User_04_Switch_Page() {
        //CustomerInfo -> Address
        addressPage = customerInfoPage.openAddressPage(driver);
        //Address -> RewardPoint
        rewardPointPage = addressPage.openRewardPointPage(driver);
        //RewardPoint -> Order
        orderPage = rewardPointPage.openOrderPage(driver);
        //Order -> Address
        addressPage = orderPage.openAddressPage(driver);
        //Address -> CustomerInfo
        customerInfoPage = addressPage.openCustomerInfoPage(driver);
        orderPage = customerInfoPage.openOrderPage(driver);
        addressPage = rewardPointPage.openAddressPage(driver);

    }

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

}
