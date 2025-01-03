package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSecond(2);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber)
                .endsWith("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendkey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendkey, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
        sleepInSecond(1);
    }

    public boolean isRowDataDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME, countryName);
        sleepInSecond(3);
    }

    public void clearSearchBox(String headerName) {
        clickToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        getElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName).clear();
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT);
        sleepInSecond(1);
        getElement(driver, HomePageUI.DYNAMIC_EDIT).clear();
        sleepInSecond(1);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_EDIT, "abcd");
        sleepInSecond(2);
        clickToElement(driver, HomePageUI.DYNAMIC_SUBMIT);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        //        Tu comlumnName lay ra columnIndex
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        //        Convert qua dang text(String)
        String columnIndex = String.valueOf(columnIndexNumber);
        //        Truyen rowIndex vs columnIndex vào locator de tuong tac và sendkey
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        //        Tu comlumnName lay ra columnIndex
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        //        Convert qua dang text(String)
        String columnIndex = String.valueOf(columnIndexNumber);
        selectItemInDropdownList(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
    }

    public void selectToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        //        Tu comlumnName lay ra columnIndex
        int columnIndexNumber = getListElement(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;
        //        Convert qua dang text(String)
        String columnIndex = String.valueOf(columnIndexNumber);
        if (checkOrUncheck) {
            unCheckToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
            sleepInSecond(2);
        } else {
            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
            sleepInSecond(2);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX,rowIndex, iconName);

    }
}
