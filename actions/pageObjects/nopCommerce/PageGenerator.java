package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserAddressPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserOrderPO;
import pageObjects.nopCommerce.users.UserRewardPointPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserAddressPO getUserAddressPage(WebDriver driver) {
        return new UserAddressPO(driver);
    }

    public static UserOrderPO getUserOrderPage(WebDriver driver) {
        return new UserOrderPO(driver);
    }

    public static UserRewardPointPO getUserRewardPoint(WebDriver driver) {
        return new UserRewardPointPO(driver);
    }

    public static AdminDashboardPO getAdminDashboard(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }


}
