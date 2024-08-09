package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class MainPage extends BasePage {
    private static final By LOGIN_BUTTON = By.id("OBLoginButtDiv");
    private static final By CLIENT_PROFILE_NAME = By.id("ClientName");
    private static final By READ_BUTTON = By.cssSelector("[onclick=\"window.location.href = '/news-ads/ads'\"]");
    private static final By CALCULATE_BUTTON = By.cssSelector("[onclick=\"window.location.href = '/OnlineMortgage/IpotekaCalculate'\"]");
    private static final By NAURIZ_MORTGAGE_MORTGAGE_PROGRAM = By.cssSelector("[href='/Nauriz'] .qamqor_button");
    private static final By HAPPY_FAMILY_MORTGAGE_PROGRAM = By.id("EtspId");
    private static final By ALL_NEW_BUILDINGS_BUTTON = By.cssSelector("#div_DirectSale .slider_box-titles--button");
    private static final By ALL_SECONDARY_HOUSING_BUTTON = By.cssSelector("#div_SecondHouses .slider_box-titles--button");
    private static final By ALL_STATE_PROGRAMS_BUTTON = By.cssSelector("#div_StatePrograms .slider_box-titles--button");
    private static final By REALITY_TYPE_TAB = By.id("RealtyType");
    private static final By REGION_LIST = By.id("regionSelect");
    private static final By REDEMPTION_TYPE = By.id("RedemptionMethod");
    private static final By DESIRE_AMOUNT_INPUT = By.id("DesiredAmountDisplay");
    public static final By SALDO = By.id("Saldo");
    private static final By SPOUSE_TYPE = By.id("SpouseType");
    private static final By NUMBER_OFF_FAMILY = By.id("NumberOfFamily");
    private static final By INCOMES = By.id("ClientIncomesDisplay");
    private static final By COSTS = By.id("ClientCostsDisplay");
    private static final By CALCULATE_BUTTON_ = By.cssSelector("[value='Submit']");
    public static final By NOTIFICATION = By.cssSelector(".scroller h3");



    private static final By POST_AD_BUTTON = By.cssSelector(".glow-on-hoverz");
    private static final By ROOM = By.cssSelector("[for='RoomsCount1']");
    private static final By TOTAL_AREA = By.cssSelector(".square-items.square-items--f.decimal");
    private static final By FLOOR = By.cssSelector(".square-items.items-w.items-w--nc.decimal");
    private static final By FLOOR_IN_HOUSE = By.cssSelector(".square-items.items-w.items-w--c.decimal");
    private static final By OBJECT_STATE = By.xpath("//*[text()='Хорошее']");
    private static final By REGION = By.cssSelector("select.square-items.adress-items--w");
    private static final By CITY_REGION = By.cssSelector("select.square-items.adress-items--w.sub-opt");
    private static final By STREET = By.cssSelector(".adress-items .square-items.adress-items--w");
    private static final By HOUSE = By.xpath("//div[@class='adress-items']// input[@class='square-items']");
    private static final By HOUSE_TYPE = By.cssSelector("select.square-items.btn-wb");
    private static final By DESCRIPTION = By.cssSelector(".item-description");
    private static final By PRICE = By.cssSelector(".square-items.c");
    private static final By PUBLIC_BUTTON = By.cssSelector(".btn-object");
    public static final By STATUS_OF_AD = By.cssSelector(".house-card-footer--t");
    private static final By REMOVE_AD_BUTTON = By.cssSelector(".btn.u");
    private static final By REMOVE_CONFIRM_BUTTON = By.cssSelector("button.button--r");
    private static final By POST_AD_BUTTON_FROM_MY_AD = By.cssSelector(".addstates input");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click login button")
    public MainPage clickLoginButton() {
        button.btnClick(LOGIN_BUTTON);
        return this;
    }

    @Step("Click profile icon")
    public MainPage clickProfileIcon() {
        button.btnClick(CLIENT_PROFILE_NAME);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click post ad button")
    public MainPage clickPostAdButton() {
        button.btnClick(POST_AD_BUTTON);
        elementsAttributes.waitUntilVisible(ROOM);
        return this;
    }

    @Step("Select room")
    public MainPage selectRoom() {
        button.btnClick(ROOM);
        return this;
    }

    @Step("Input total area")
    public MainPage inputTotalArea(String area) {
        input.inputWithClear(TOTAL_AREA, area);
        return this;
    }

    @Step("Input total area")
    public MainPage inputFloor(String floor) {
        input.inputWithClear(FLOOR, floor);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input total area")
    public MainPage inputFloorInHouse(String floor) {
        input.inputWithClear(FLOOR_IN_HOUSE, floor);
        return this;
    }

    @Step("Select object state")
    public MainPage selectObjectState() {
        move.scrollToElement(OBJECT_STATE);
        button.btnClick(OBJECT_STATE);
        return this;
    }

    @Step("Select region")
    public MainPage _selectRegion() {
        dropDown.selectByIndex(REGION, 8);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select city")
    public MainPage selectCity() {
        dropDown.selectByIndex(CITY_REGION, 8);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input street")
    public MainPage inputStreet(String street) {
        move.scrollToElement(STREET);
        input.inputWithClear(STREET, street);
        return this;
    }

    @Step("Input house")
    public MainPage inputHouse(String house) {
        input.inputWithClear(HOUSE, house);
        return this;
    }

    @Step("Select house type")
    public MainPage selectHouseType() {
        dropDown.selectByIndex(HOUSE_TYPE, 5);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input description")
    public MainPage inputDescription(String description) {
        input.inputWithClear(DESCRIPTION, description);
        return this;
    }

    @Step("Input price")
    public MainPage inputPrice(String price) {
        input.inputWithClear(PRICE, price);
        return this;
    }

    @Step("Click public button")
    public MainPage clickPublicButton() {
        button.btnClick(PUBLIC_BUTTON);
        return this;
    }

    @Step("Click remove button")
    public MainPage clickRemoveButton() {
        button.btnClick(REMOVE_AD_BUTTON);
        return this;
    }

    @Step("Click remove confirm button")
    public MainPage clickRemoveConfirmButton() {
        button.btnClick(REMOVE_CONFIRM_BUTTON);
        return this;
    }

    @Step("Click post ad button")
    public MainPage clickPostAdButton_fromMyAdBlock() {
        move.scrollToElement(POST_AD_BUTTON_FROM_MY_AD);
        button.btnClick(POST_AD_BUTTON_FROM_MY_AD);
        return this;
    }

    @Step("Click read baspana news button")
    public MainPage clickReadBaspanaNewsButton() {
        move.scrollToElement(READ_BUTTON);
        button.btnClick(READ_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click calculate button")
    public MainPage clickCalculateButton() {
        move.scrollToElement(CALCULATE_BUTTON);
        button.btnClick(CALCULATE_BUTTON);
        return this;
    }

    @Step("Click nauriz mortgage info button")
    public MainPage clickNaurizMortgage() {
        move.scrollToElement(NAURIZ_MORTGAGE_MORTGAGE_PROGRAM);
        button.btnClick(NAURIZ_MORTGAGE_MORTGAGE_PROGRAM);
        return this;
    }

    @Step("Click happy family mortgage info button")
    public MainPage clickHappyFamilyMortgage() {
        move.scrollToElement(HAPPY_FAMILY_MORTGAGE_PROGRAM);
        button.btnClick(HAPPY_FAMILY_MORTGAGE_PROGRAM);
        return this;
    }

    @Step("Click show all new buildings button")
    public MainPage clickShowAllNewBuildingsButton() {
        move.scrollToElement(ALL_NEW_BUILDINGS_BUTTON);
        button.btnClick(ALL_NEW_BUILDINGS_BUTTON);
        return this;
    }

    @Step("Click show all secondary housing button")
    public MainPage clickShowAllSecondaryHousingButton() {
        move.scrollToElement(ALL_SECONDARY_HOUSING_BUTTON);
        button.btnClick(ALL_SECONDARY_HOUSING_BUTTON);
        return this;
    }

    @Step("Click show all state programs button")
    public MainPage clickShowAllStateProgramsButton() {
        move.scrollToElement(ALL_STATE_PROGRAMS_BUTTON);
        button.btnClick(ALL_STATE_PROGRAMS_BUTTON);
        return this;
    }


    @Step("Click reality tab")
    public MainPage clickRealityTab() {
        button.btnClick(REALITY_TYPE_TAB);
        return this;
    }

    @Step("Select region")
    public MainPage selectRegion() {
        dropDown.selectByIndex(REGION_LIST, 2);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select redemption type")
    public MainPage selectRedemptionType() {
        dropDown.selectByIndex(REDEMPTION_TYPE, 1);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input desire amount")
    public MainPage inputDesireAmount(String desireAmount) {
        input.inputWithClear(DESIRE_AMOUNT_INPUT, desireAmount);
        return this;
    }

    @Step("Select spouse type")
    public MainPage selectSpouseType() {
        dropDown.selectByIndex(SPOUSE_TYPE, 2);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input number of family")
    public MainPage inputNumberOfFamily(String numberOffFamily) {
        input.inputWithClear(NUMBER_OFF_FAMILY, numberOffFamily);
        return this;
    }

    @Step("Input incomes")
    public MainPage inputIncomes(String incomes) {
        input.inputWithClear(INCOMES, incomes);
        return this;
    }

    @Step("Input costs")
    public MainPage inputCosts(String costs) {
        move.scrollToElement(COSTS);
        input.inputWithClear(COSTS, costs);
        return this;
    }

    @Step("Click calculate button ")
    public MainPage clickRealityTabCalculateButton() {
        button.btnClick(CALCULATE_BUTTON_);
        return this;
    }
}
