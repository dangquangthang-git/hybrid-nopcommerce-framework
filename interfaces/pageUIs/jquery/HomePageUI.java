package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String SCROLL_ITEM = "xpath=//td[contains(.,'750')]";
    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::"
            + "td[@data-key='country' and text()='%s']/following-sibling::"
            + "td[@data-key='males' and text()='%s']/following-sibling::"
            + "td[@data-key='total' and text()='%s']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,'remove')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,'edit')]";
    public static final String DYNAMIC_EDIT = "xpath=//input[@name='country']";
    public static final String DYNAMIC_SUBMIT = "xpath=//input[@type='submit']";
    public static final String LOAD_DATA_BUTTON = "xpath=//button[@id='load']";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";
    public static final String DYNAMIC_ICON_BY_ROW_INDEX = "xpath=//tr[%s]/td//button[starts-with(@title='Insert')]";
}
