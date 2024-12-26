package pageObjects.subPageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.SidebarPageObject;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends SidebarPageObject {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isMaleGenderSelected() {
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

//    public String getDayDropdownSelectedValue() {
//        return null;
//    }
//
//    public String getMonthDropdownSelectedValue() {
//        return null;
//    }
//
//    public String getYearDropdownSelectedValue() {
//        return null;
//    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
    }


}


