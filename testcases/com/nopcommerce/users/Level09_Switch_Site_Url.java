package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserRegisterPO;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;

public class Level09_Switch_Site_Url extends BaseTest {


    //Pre-condition
    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        driver = getBrowserDriver(browserName, userUrlValue);
        //No duoc sinh ra và lam action cua page do
        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "John";
        lastName = "Conor";
        emailAddress = firstName + generateRandomNumb() + "@gmail.com";
        adminEmailAddress = "admin2@gmail.com";
        adminPassword = "12345678";
        companyName = "Continental";
        password = "12345678";
//        Pre-Condition
        userRegisterPage = PageGenerator.getUserHomePage(driver).openRegisterPage();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextBox(firstName);
        userRegisterPage.enterToLastNameTextBox(lastName);
//        registerPage.selectDayDropDown();
//        registerPage.selectMonthDropDown();
//        registerPage.selectYearDropDown();
        userRegisterPage.enterToEmailTextBox(emailAddress);
        userRegisterPage.enterToCompanyTextBox(companyName);
        userRegisterPage.enterToPasswordTextBox(password);
        userRegisterPage.enterToConfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
        userHomePage = userRegisterPage.clickToLogoutLink();
    }


    //Testcases
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
//        Tu registerPage qua loginPage
//        Page do duoc sinh ra de lam action cua page do
        userLoginPage = userHomePage.openLoginPage();
//        Tu loginPage qua homePage
//        Page do duoc sinh ra de lam action cua page do
        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyaccountLinkDisplayed());

//        Qua trang Admin de verify/approve
        userHomePage.openPageUrl(driver, adminUrlValue);
//        Chua login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
//        Login vao trang Admin
        adminLoginPage.enterToEmailText(adminEmailAddress);
        adminLoginPage.enterToPasswordText(adminPassword);
        adminDashboardPO = adminLoginPage.clickToLoginButton();


    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        adminDashboardPO.openPageUrl(driver, userUrlValue);
        userHomePage = PageGenerator.getUserHomePage(driver);
//        Action tiếp theo
        userCustomerInfoPage = userHomePage.openCustomerInfoPage();
        Assert.assertTrue(userCustomerInfoPage.isMaleGenderSelected());
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);
    }

    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private UserAddressPO userAddressPage;
    private UserOrderPO userOrderPage;
    private UserRewardPointPO userRewardPointPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPO;
    private String firstName, lastName, emailAddress, companyName, password, userUrlValue, adminUrlValue;
    private String adminEmailAddress, adminPassword;

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

}
