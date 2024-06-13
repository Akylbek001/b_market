package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class MainPage extends BasePage {
    private static final By LOGIN_LOCATOR = By.id("OBLoginButtDiv");
    private static final By READ_BUTTON = By.xpath("//div[@class='news-box']//p[text()='Читать']");
    private static final By CALCULATE_BUTTON = By.xpath("//div[@class='news-box']//p[text()='Рассчитать']");
    private static final By REALITY_TYPE_TAB = By.id("RealtyType");
    private static final By REGION_LIST = By.id("regionSelect");
    private static final By REDEMPTION_TYPE = By.id("RedemptionMethod");
    private static final By DESIRE_AMOUNT_INPUT = By.id("DesiredAmount");
    public static final By SALDO = By.id("Saldo");
    public static final By SPOUSE_TYPE = By.id("SpouseType");
    public static final By NUMBER_OFF_FAMILY = By.id("NumberOfFamily");
    public static final By INCOMES = By.id("ClientIncomes");
    public static final By COSTS = By.id("ClientCosts");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Login button")
    public MainPage clickLoginButton() {
        button.btnClick(LOGIN_LOCATOR);
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
        move.scrollToElement(CALCULATE_BUTTON);

        button.btnClick(CALCULATE_BUTTON);
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
        input.inputWithClear(COSTS, costs);
        return this;
    }
}
