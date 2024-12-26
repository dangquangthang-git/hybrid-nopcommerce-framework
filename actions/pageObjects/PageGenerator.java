package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.subPageObjects.AddressPageObject;
import pageObjects.subPageObjects.CustomerInfoPageObject;
import pageObjects.subPageObjects.OrderPageObject;
import pageObjects.subPageObjects.RewardPointPageObject;

public class PageGenerator {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static OrderPageObject getOrderPage(WebDriver driver) {
        return new OrderPageObject(driver);
    }

    public static RewardPointPageObject getRewardPoint(WebDriver driver) {
        return new RewardPointPageObject(driver);
    }
}
