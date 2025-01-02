package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level10_Dynamic_Locator extends BaseTest {
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
        homePage = registerPage.clickToLogoutLink();
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
    public void User_04_Dynamic_Page() {
        //CustomerInfo -> Address
        addressPage = (UserAddressPO) customerInfoPage.openSideBarLinkByPageName("Addresses");
        //Address -> RewardPoint
        rewardPointPage = (UserRewardPointPO) addressPage.openSideBarLinkByPageName("Reward points");
        //RewardPoint -> Order
        orderPage = (UserOrderPO) rewardPointPage.openSideBarLinkByPageName("Orders");
        //Order -> Address
        addressPage = (UserAddressPO) orderPage.openSideBarLinkByPageName("Addresses");
        //Address -> CustomerInfo
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSideBarLinkByPageName("Customer info");
        orderPage = (UserOrderPO) customerInfoPage.openSideBarLinkByPageName("Orders");
        addressPage = (UserAddressPO) rewardPointPage.openSideBarLinkByPageName("Addresses");

    }

    @Test
    public void User_05_Dynamic_Page() {
        //Address -> RewardPoint
        addressPage.openSideBarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPoint(driver);
        //RewardPoint -> Order
        orderPage = PageGenerator.getUserOrderPage(driver);
        //Order -> Address
        orderPage.openSideBarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);
        //Address -> CustomerInfo
        addressPage.openSideBarLinkByPageName("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerInfoPage(driver);
        customerInfoPage.openSideBarLinkByPageName("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);
        addressPage = (UserAddressPO) rewardPointPage.openSideBarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

    }

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

}
