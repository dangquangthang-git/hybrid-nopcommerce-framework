package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPoint(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }


    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserOrderPO openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserSidebarPO openSideBarLinkByPageName(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPoint(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInfoPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("pageName is not valid ");
        }

    }

    public void openSideBarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_PAGE_LINK_BY_NAME, pageName);


    }


}
