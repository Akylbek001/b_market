package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoansPage extends BasePage {
    private static final By EXISTED_LOAN = By.cssSelector(".loanGritCover");
    private static final By AVAILABLE_OPERATIONS = By.cssSelector("[onclick='collapseOper()']");
    private static final By PARTIAL_EARLY_REPAYMENT_OPERATION = By.xpath("//div[@class='allOperWrap'] /div[2]");
    private static final By REPLACEMENT_OF_COLLATERAL_OPERATION = By.xpath("//div[@class='operTxt' and text()='Замена залога']");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".container.firstcheck.checkbox");
    private static final By VALIDATION_BUTTON = By.xpath(".validation");
    private static final By SIGN_BUTTON = By.xpath("[onclick='SendOtp()']");





    private static final By NEXT_BUTTON = By.xpath("//div[@id='StartTheApplicationsId']//div[@class='modal-footer'] /button[2]");
    private static final By COLLATERAL_FOR_CHANGE = By.id("4EDC8A84DE07D1BBCE22A726769D803F");
    private static final By START_BUTTON = By.cssSelector("[onclick='Validations()']");
    public static final By NOTIFICATION_OF_REGISTRATION = By.id("ExchangesModalToAttenttionsBody");





    private static final By PARTIAL_REPAYMENT_SUM = By.cssSelector(".InputBlocks input");
    private static final By CONTINUE_BUTTON = By.cssSelector("button.validate");


    public LoansPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select existed loan")
    public LoansPage selectExistedLoan() {
        button.btnClick(EXISTED_LOAN);
        return this;
    }

    @Step("Open available operation")
    public LoansPage openAvailableOperations() {
        button.btnClick(AVAILABLE_OPERATIONS);
        return this;
    }

    @Step("Select partial early repayment operation")
    public LoansPage selectPartialEarlyRepaymentOperation() {
        button.btnClick(PARTIAL_EARLY_REPAYMENT_OPERATION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select replacement of collateral operation")
    public LoansPage selectReplacementOfCollateralOperation() {

        move.scrollToElement(REPLACEMENT_OF_COLLATERAL_OPERATION);
        button.btnClick(REPLACEMENT_OF_COLLATERAL_OPERATION);
        return this;
    }

    @Step("Click agreement checkbox")
    public LoansPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click validation button")
    public LoansPage clickValidationButton() {
        button.btnClick(VALIDATION_BUTTON);
        return this;
    }

    @Step("Click sign button")
    public LoansPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Click next button")
    public LoansPage clickNextButton() {
        button.btnClick(NEXT_BUTTON);
        WaitUtils.wait(10);

        return this;
    }

    @Step("Select collateral for change")
    public LoansPage selectCollateralForChange() {
        button.btnClick(COLLATERAL_FOR_CHANGE);
        return this;
    }

    @Step("Click start button")
    public LoansPage clickStartButton() {
        button.btnClick(START_BUTTON);
        return this;
    }


    @Step("Input sum")
    public LoansPage inputSum(String sum) {
        input.inputWithClear(PARTIAL_REPAYMENT_SUM, sum);
        return this;
    }

    @Step("Click continue button")
    public LoansPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }
}
