package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage extends BasePage {

    private static final By MY_BANK_MENU = By.xpath("//div[@id='menuList'] /a[@id='menu2']");
    private static final By DEPOSITS = By.xpath(
            "//div[@class='menu-list']//*[contains(text(), 'Депозиты')]"
    );
    private static final By MY_DEPOSIT_LABEL = By.xpath("//label[@role='option']");
    private static final By SHOW_DEPOSIT_DETAILS = By.id("text");
    private static final By CALCULATOR_OP_BUTTON = By.id("calculateOPButton");
    private static final By AVAILABLE_OPERATIONS = By.id("checBlock");
    private static final By CHANGE_GOS_PREM_BUTTON = By.id("terminateDeposit");
    private static final By SELECT = By.id("next-step");

    private static final By NEW_DEPOSIT_BUTTON = By.id("OpenButtons");
    private static final By OPEN_BASPANA_DEPOSIT = By.xpath("//div[@id='baspana'] //span[@class='ob-bodyM']");
    private static final By OPEN_DEPOSIT = By.xpath("//div[@class='DepositBlock--background DepositBlock--infos'] //button[@id='FatcasSteps']");
    private static final By AGREEMENT_CHECKBOX = By.xpath("//form[@id='fatca-formm'] //input[@id='StandardConditionsAgreed']");
    private static final By SUBMIT = By.xpath("//button[@type='submit']");
    private static final By CONFIRM = By.xpath("//button[@class='ValSums']");
    public static final By VISIT_BANK_NOTIFICATION = By.xpath("//div[@id='NextSteps'] //p");
    private static final By SMS_CODE = By.id("CodeSmsId");
    private static final By SEND = By.id("EndsSteps");


    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select myBank menu")
    public DepositPage selectMyBankMenu() {
        button.btnClick(MY_BANK_MENU);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select deposits menu")
    public DepositPage selectDepositsMenu() {
        button.btnClick(DEPOSITS);
        return this;
    }

    @Step("Select my opened deposit")
    public DepositPage selectOpenedDeposit() {
        button.btnClick(MY_DEPOSIT_LABEL);
        return this;
    }

    @Step("Show deposit details")
    public DepositPage showDepositDetails() {
        button.btnClick(SHOW_DEPOSIT_DETAILS);
        return this;
    }

    @Step("Open calculator")
    public DepositPage openCalculator() {
        button.btnClick(CALCULATOR_OP_BUTTON);
        return this;
    }

    @Step("Show available operations")
    public DepositPage showAvailableOperations() {
        button.btnClick(AVAILABLE_OPERATIONS);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select change gos prem operation")
    public DepositPage selectChangeGosPremOperation() {
//        drManager.getDriver().switchTo().defaultContent();
        button.btnClick(CHANGE_GOS_PREM_BUTTON);
        WaitUtils.wait(1);

        button.btnClick(CHANGE_GOS_PREM_BUTTON);

        WaitUtils.wait(5);

        return this;
    }

    @Step("Click select button")
    public DepositPage clickSelectButton() {
        button.btnClick(SELECT);
        return this;
    }

    @Step("Click new deposit button")
    public DepositPage clickNewDepositButton() {
        button.btnClick(NEW_DEPOSIT_BUTTON);
        return this;
    }

    @Step("Click open baspana deposit button")
    public DepositPage clickOpenBaspanaDepositButton() {
        button.btnClick(OPEN_BASPANA_DEPOSIT);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click open deposit button")
    public DepositPage clickOpenDepositButton() {
        button.btnClick(OPEN_DEPOSIT);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Agreement")
    public DepositPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click continue")
    public DepositPage clickContinue() {
        button.btnClick(SUBMIT);
        return this;
    }

    @Step("Click confirm")
    public DepositPage clickConfirm() {
        button.btnClick(CONFIRM);
        return this;
    }

    @Step("Input sms code")
    public DepositPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE, smsCode);
        return this;
    }

    @Step("Click send")
    public DepositPage clickSend() {
        button.btnClick(SEND);
        WaitUtils.wait(5);
        return this;
    }
}
