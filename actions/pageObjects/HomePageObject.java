package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.subPageObjects.CustomerInfoPageObject;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public boolean isMyaccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }

    public LoginPageObject openLoginPage() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

}
