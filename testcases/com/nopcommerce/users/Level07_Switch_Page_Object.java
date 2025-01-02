package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level07_Switch_Page_Object extends BaseTest {
    //Declare variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    String firstName, lastName, emailAddress, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        //No duoc sinh ra và lam action cua page do
        homePage = PageGenerator.getUserHomePage(driver);
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
        registerPage = PageGenerator.getUserHomePage(driver).openRegisterPage();
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

//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        loginPage = PageGenerator.getUserHomePage(driver).openLoginPage();
        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        homePage = PageGenerator.getUserLoginPage(driver).clickToLoginButton();
        Assert.assertTrue(homePage.isMyaccountLinkDisplayed());

    }

    @Test
    public void User_03_Myaccount() {
        customerInfoPage = PageGenerator.getUserHomePage(driver).openCustomerInfoPage();
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
        addressPage = customerInfoPage.openAddressPage();
        //Address -> RewardPoint
        rewardPointPage = addressPage.openRewardPointPage();
        //RewardPoint -> Order
        orderPage = rewardPointPage.openOrderPage();
        //Order -> Address
        addressPage = orderPage.openAddressPage();
        //Address -> CustomerInfo
        customerInfoPage = addressPage.openCustomerInfoPage();
        orderPage = customerInfoPage.openOrderPage();
        addressPage = rewardPointPage.openAddressPage();

    }

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

}
