package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class FilterPage extends BasePage {
    private static final By BUY_TAB = By.id("newObjid");
    private static final By RENT_TAB = By.id("secondObjid");

    private static final By HOUSE_TYPE = By.id("dropdownHousingButton");

    private static final By TYPE_OF_PROPERTY = By.id("dropdownRealEstButton");
    private static final By APARTMENT = By.xpath("//*[text()='Квартира']");
    private static final By TYPE_OF_TRANSACTION = By.id("dropdownTransactionButton");
    private static final By TRANSACTION_TYPE_VALUE = By.xpath("//*[text()='Риелтор']");

    private static final By NEW_BUILDING = By.xpath("// div[@class='objects_all'] /div/div[1]//span[2]");
    private static final By REGION_LIST = By.xpath("//form[@id='searchFromMain'] //div[@class='objects_all']//*[@class='d-flex regNameContainer'] /span[text()='Регион']");
    //    private static final By REGION_LIST = By.xpath("//*[@class='objects_all']//*[@id='dropdownRegionButton']");
    private static final By CITY = By.xpath("//*[text()='г. Алматы']");
    private static final By OBJECT_STATUS = By.id("dropdownObjectButton");

    private static final By OBJECT_STATUS_VALUE = By.xpath("//*[text()='Прием заявлений']");
    private static final By CODE = By.id("dropdownPriceButton");
    private static final By CODE_INPUT = By.cssSelector("input[@class='dropdown-item price-d onlyDigits]");

    private static final By ROOMS = By.id("dropdownRoomsButton");
    private static final By ROOM_VALUE = By.cssSelector("//*a[class='dropdown-item listRooms']");
    private static final By IMPLEMENTATION_TYPE = By.id("dropdownRealizeButton");
    private static final By IMPLEMENTATION_TYPE_VAlUE = By.cssSelector("//*a[class='dropdown-item realization-d']");
    private static final By PRICE = By.id("dropdownPriceButton");
    private static final By PRICE_FROM = By.id("priceFrom");
    private static final By PRICE_TO = By.id("priceTo");
    private static final By SEARCH_HOUSE_BUTTON = By.xpath("//div[@id='mainMapButtonHolder']//input[@id='btnSearchHouse']");
    private static final By OBJECT_DETAILS_BUTTON = By.cssSelector("a[href='/novostroyki/detail/3450/20-etazhnyj-zhiloj-dom']");
    private static final By OBJECT_PAGE_TITLE = By.cssSelector("h1");
    public static final By EMPTY_SEARCH_RESULT_TEXT = By.xpath("//div[@class='pool--title'] /h5");
    public static final By RESULT_ON_MAP = By.xpath("//div[@class='SearchTitleBlocks'] //label[@class='btn btn-radio']");
    public static final By MAP_OBJECT = By.id("yandexMapObjects");

    private static final By ADDITIONAL_FILTER_BUTTON = By.xpath("//div[@class='dropdown '] / button");

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click buy tab")
    public FilterPage clickBuyTab() {
        button.btnClick(HOUSE_TYPE);
        return this;
    }

    @Step("Select house type value")
    public FilterPage selectHouseTypeValue() {
        button.btnClick(NEW_BUILDING);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select region")
    public FilterPage selectRegion() {
        button.btnClick(REGION_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select city")
    public FilterPage selectCity() {
        button.btnClick(CITY);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click object status dropDown city")
    public FilterPage clickObjectStatusDropDown() {
        button.btnClick(OBJECT_STATUS);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select object status value")
    public FilterPage selectObjectStatus() {
        button.btnClick(OBJECT_STATUS_VALUE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select code")
    public FilterPage selectCode() {
        button.btnClick(CODE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Type code value")
    public FilterPage typeCodeValue(String code) {
        input.inputWithClear(CODE_INPUT, code);
        return this;
    }

    @Step("Select rooms")
    public FilterPage selectRooms() {
        button.btnClick(ROOMS);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select rooms value")
    public FilterPage selectRoomsValue() {
        button.btnClick(ROOM_VALUE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select implementation type")
    public FilterPage selectImplementationType() {
        button.btnClick(IMPLEMENTATION_TYPE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select implementation type value")
    public FilterPage selectImplementationTypeValue() {
        button.btnClick(IMPLEMENTATION_TYPE_VAlUE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click price dropDown")
    public FilterPage clickPriceDropDown() {
        button.btnClick(PRICE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input price from")
    public FilterPage inputPriceFrom(String price) {
        input.inputWithClear(PRICE_FROM, price);
        return this;
    }

    @Step("Input price to")
    public FilterPage inputPriceTo(String price) {
        input.inputWithClear(PRICE_TO, price);
        return this;
    }

    @Step("Click search button")
    public FilterPage clickSearchButton() {
        button.btnClick(SEARCH_HOUSE_BUTTON);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Wait page loading")
    public FilterPage waitElem() {
        elementsAttributes.waitUntilVisible(EMPTY_SEARCH_RESULT_TEXT);
        return this;
    }

    @Step("Click rent tab")
    public FilterPage clickRentTab() {
        button.btnClick(RENT_TAB);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click property dropDown")
    public FilterPage clickPropertyTypeDropDown() {
        button.btnClick(TYPE_OF_PROPERTY);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select apartment")
    public FilterPage selectApartmentType() {
        button.btnClick(APARTMENT);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select transaction dropDown")
    public FilterPage selectTransactionType() {
        button.btnClick(TYPE_OF_TRANSACTION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select transaction type value")
    public FilterPage selectTransactionTypeValue() {
        button.btnClick(TRANSACTION_TYPE_VALUE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click details button")
    public FilterPage clickDetailsButton() {
        elementsAttributes.waitUntilVisible(OBJECT_DETAILS_BUTTON);
        button.btnClick(OBJECT_DETAILS_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Get object title value")
    public FilterPage getObjectTitleValue() {
        elementsAttributes.getValue(OBJECT_PAGE_TITLE);
        return this;
    }

    @Step("Click house type")
    public FilterPage clickHouseTypeDropDown() {
        button.btnClick(NEW_BUILDING);
//        move.moveToElemAndClick(HOUSE_TYPE, (int) 163.68, 62);
//        move.moveToElemAndClick(HOUSE_TYPE);
//        button.btnClick(HOUSE_TYPE);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click show on map")
    public FilterPage clickShowOnMap() {
        button.btnClick(RESULT_ON_MAP);
        WaitUtils.wait(1);
        return this;
    }
}
