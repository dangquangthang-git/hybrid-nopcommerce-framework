package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;
import pageUIs.jquery.HomePageUI;


public class Level11_DataTable extends BaseTest {
    private WebDriver driver;

    //Pre-condition
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePO(driver);

    }

    //Testcases
//    @Test
    public void Table_01_Paging() {
//Navigate to any page (paging) in table
        homePage.scrollToElement(driver, HomePageUI.SCROLL_ITEM);
        homePage.openPageByNumber("15");
        homePage.openPageByNumber("5");
        homePage.openPageByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActived("12"));


    }

    public void Table_02_Search() {
//        Enter value to header textbox
//        Verify data in first row
        homePage.enterToTextboxByHeaderName("Country", "Algeria");
        Assert.assertTrue(homePage.isRowDataDisplayed("283821", "Algeria", "295140", "578961"));
        homePage.refreshCurrentpage(driver);
        homePage.enterToTextboxByHeaderName("Males", "25266");
        Assert.assertTrue(homePage.isRowDataDisplayed("24128", "Albania", "25266", "49397"));
        homePage.refreshCurrentpage(driver);
        homePage.enterToTextboxByHeaderName("Females", "750");
        Assert.assertTrue(homePage.isRowDataDisplayed("750", "Aruba", "756", "1504"));
        homePage.refreshCurrentpage(driver);


    }

    @Test
    public void Table_03_Delete_Edit() {
        homePage.enterToTextboxByHeaderName("Country", "Afghanistan");
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.sleepInSecond(1);
        homePage.clearSearchBox("Country");
        homePage.enterToTextboxByHeaderName("Country", "Albania");
        homePage.editRowByCountryName("Albania");

    }

    public void Table_04_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        //CO the thao tac bat ki cot hay row nao
        homePage.clickToLoadDataButton();
        homePage.enterToTextboxByIndex("4", "Contact Person", "Michael Jackson");
        homePage.enterToTextboxByIndex("2", "Company", "MJ Company");
        homePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
        homePage.selectToDropdownByIndex("8", "Country", "United Kingdom");
        homePage.selectToDropdownByIndex("5", "NPO?", true);
        homePage.clickToIconByIndex("8", "Move Up");
        homePage.clickToIconByIndex("6", "Remove");
        homePage.clickToIconByIndex("4", "Insert");

    }

    //Post-condition
    @AfterClass
    public void afterClass() {

    }

    private HomePO homePage;
}
