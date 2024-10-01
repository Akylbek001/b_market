package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage extends BasePage {

    public static final By MY_DEPOSIT_LABEL = By.cssSelector("[role='option']");
    private static final By NEW_DEPOSIT_BUTTON = By.id("OpenButtons");
    private static final By OPEN_BASPANA_DEPOSIT = By.xpath(
            "//div[@id='baspana'] //span[@class='ob-bodyM']"
    );
    private static final By OPEN_CONTRIBUTION_AQYL = By.id("openAqylDeposit");
    private static final By CONTINUE_OPEN_CONTRIBUTION_AQYL_BUTTON = By.xpath("//div[@class='modal fade show'] //button[@id='continueOpenChildDeposit']");
    public static final By REFUSED_NOTIFICATION = By.id("reasonAqyl");
    private static final By OPEN_BASPANA_DEPOSIT_CONTINUE_BUTTON = By.id("FatcasSteps");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector("#StandardConditionsAgreed");

    private static final By SUBMIT = By.xpath("//button[@type='submit']");
    private static final By AGREED_SUM = By.cssSelector("input#dep_agree_sum.depsums");
    private static final By DEPOSIT_TERM = By.id("calc_l_m_range--g");
    public static final By CONFIRM = By.cssSelector("#NextSteps .ValSums");

    public static final By NOTIFICATION_VISIT_THE_BANK = By.xpath("//div[@id='NextSteps'] //p");
    public static final By SUCCESS = By.cssSelector(".DepositBlock--background.OpenDepositsStepsEnds>p");
    private static final By SMS_CODE = By.id("CodeSmsId");
    private static final By OTP = By.id("codeSms");

    private static final By SEND = By.id("EndsSteps");
    private static final By FIRST_DEPOSIT = By.cssSelector(".ob-deposit.depositCover.backgroundCover2.slick-slide.slick-current.slick-active");
    private static final By SECOND_DEPOSIT = By.cssSelector("label[aria-describedby='slick-slide01']");

    public static final By DEPOSIT_CREATED_DATE = By.cssSelector(".titlel");
    private static final By SHOW_DEPOSIT_DETAILS = By.id("text");
    private static final By CALCULATOR_OP_BUTTON = By.id("calculateOPButton");

    private static final By AVAILABLE_OPERATIONS_WITH_DEPOSIT = By.id("checBlock");
//    private static final By AVAILABLE_OPERATIONS_WITH_DEPOSIT = By.cssSelector("#allOperWrap #checBlock");

    private static final By CHANGE_GOS_PREM_OPERATION = By.id("changeGosPremButton");
    private static final By SELECT_SECOND_DEPOSIT = By.cssSelector("[gos-prem-flag='False']");
    private static final By SELECT_FIRST_DEPOSIT = By.cssSelector("[gos-prem-flag='True']");

    private static final By GOS_PREM_AGREEMENT = By.cssSelector("#modal-body-gos-prem [for='AgreeWithAgreement']");
    public static final By FINAL_TEXT = By.cssSelector(".finalTxt");

    private static final By SELECT = By.id("next-step");
    private static final By TERMINATE_DEPOSIT_OPERATION = By.id("terminateDeposit");
    public static final By TERMINATE_DEPOSIT_BUTTON = By.cssSelector(
            "[data-target='#TerminationModal']"
    );
    private static final By CONTINUE_TERMINATE_DEPOSIT_BUTTON = By.cssSelector(
        "[onclick='BlocksStartsTerminationEnd()']"
    );
    public static final By TERMINATE_DEPOSIT_REQUEST_ACCEPTED = By.cssSelector(".TerminationBlocks--Starts h3");
    private static final By CHANGE_DEPOSIT_CONDITIONS_OPERATION = By.id("ChangeDeposConditionsButton");
    private static final By NEGOTIATED_AMOUNT = By.cssSelector("[name='NewAgreementSumm']");
    public static final By HOUSING_LOAN_TERM = By.id("LoanTerm_Slider");
    public static final By NEGOTIATED_AMOUNT_VALIDATION_TEXT = By.id("agreement-sum-valid-txt");
    public static final By NEW_DEPOSIT_MONTH_PAY = By.id("NewDpsMonthPay");
    public static final By CHANGE_DETAILS_BUTTON = By.id("changeDetailsButton");
    private static final By SIGN_CHANGE_DETAILS_BUTTON = By.id("signChangeDetailsButton");
    public static final By OPERATION_COMPLETED_SUCCESSFULLY = By.cssSelector(".finishHead .title");
    private static final By CREATE_FAMILY_PACKAGE_OPERATION = By.xpath("//div[@onclick='onGetDeposits()']");
    private static final By CREATE_FAMILY_PACKAGE_OPERATION_ = By.xpath("//div[@class='operTxt' and text()='Создать семейный пакет']");
    private static final By DEPOSIT_DIVISION_OPERATION = By.xpath("//div[@class='operTxt' and text()='Деление депозита']");
    public static final By DIVIDE_BUTTON = By.cssSelector(".button-sp_div .split.white");
    public static final By DIVIDE_NO_ACCOUNT_VALIDATION = By.cssSelector(".modal-body.body-attention > p");
    public static final By OPERATION_NOT_AVAILABLE = By.id("diffinfoHTML");
    public static final By VISIT_BANK_BRANCH_NOTIFICATION = By.id("showMessageHTML");

    public static final By DIVIDE_DEPOSIT_ACCEPTED = By.cssSelector(".h5_22");//?
    private static final By UNITE_DEPOSIT_OPERATION = By.id("UniteDepositsButton");
    private static final By FIRST_DEPOSIT_TO_UNITE = By.xpath("//div[@class='DepositsChangeBlocks--items'] /div[1]");
    private static final By SECOND_DEPOSIT_TO_UNITE = By.xpath("//div[@class='DepositsChangeBlocks--items'] /div[2]");
    private static final By CONFIRM_SELECTED_DEPOSITS_BUTTON = By.cssSelector(".ChangeDepositsValidations");
    public static final By SELECT_DEPOSITS_BUTTON = By.cssSelector(".ChangeDepositsValidations");
    private static final By UNITE_DEPOSIT_CONFIRM_BUTTON = By.cssSelector(".ConfirmationSteps");
    private static final By OPT_INPUT = By.cssSelector(".input_code input.code");
    private static final By UNITE_DEPOSIT_CONTINUE_BUTTON = By.cssSelector(".continue-button button");
    private static final By DEPOSIT_FOR_GOS_PREM = By.cssSelector("div.RadioBackgroundBlocks");
    private static final By DEPOSIT_FOR_GOS_PREM_CONFIRM_BUTTON = By.cssSelector(".Confirm-My-Bank.BackgroundBlock button");
    public static final By OPERATION_FINISHED_SUCCESSFULLY = By.cssSelector(".UnionDepositsBody h3");
    public static final By INVALID_OTP = By.cssSelector(".AttentionToBlockOfErrors > p");
    public static final By ASSIGNMENT_GRATUITOUS = By.cssSelector(".operBtn.deposit-relatives-cession");
    public static final By PROHIBITION_OF_OPEN_ACCOUNT = By.xpath("//div[@id='arrestsDiv'] /div[@class='arrestDiv'][2] //span[@class='accentXS']");


    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select my opened deposit")
    public DepositPage selectOpenedDeposit() {
        button.btnClick(MY_DEPOSIT_LABEL);
        WaitUtils.wait(3);
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
        button.btnClick(AVAILABLE_OPERATIONS_WITH_DEPOSIT);
//        button.btnDoubleClick(AVAILABLE_OPERATIONS_WITH_DEPOSIT);
//        WaitUtils.wait(10);
        WaitUtils.wait(10);
//        elementsAttributes.waitUntilVisible(DEPOSIT_DIVISION_OPERATION);
        return this;
    }

    @Step("Select change gos prem operation")
    public DepositPage selectChangeGosPremOperation() {
//        button.hoverAndClick(CHANGE_GOS_PREM_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(CHANGE_GOS_PREM_OPERATION);
//        WaitUtils.wait(5);
        button.btnDoubleClick(CHANGE_GOS_PREM_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select change gos prem operation on prod")
    public DepositPage changeGosPremOperation() {
        button.hoverAndClick(CHANGE_GOS_PREM_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(CHANGE_GOS_PREM_OPERATION);
        WaitUtils.wait(5);
//        button.btnDoubleClick(CHANGE_GOS_PREM_OPERATION);
//        WaitUtils.wait(4);
        return this;
    }

    @Step("Click select button")
    public DepositPage clickSelectButton() {
        button.btnClick(SELECT);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select first deposit")
    public DepositPage _selectFirstDeposit() {
        button.btnClick(SELECT_FIRST_DEPOSIT);
        return this;
    }

    @Step("Select second deposit")
    public DepositPage _selectSecondDeposit() {
        button.btnClick(SELECT_SECOND_DEPOSIT);
        return this;
    }

    @Step("Click gos prem agreement")
    public DepositPage clickGosPremAgreement() {
        button.btnClick(GOS_PREM_AGREEMENT);
        return this;
    }

    @Step("Select terminate deposit operation")
    public DepositPage terminateDepositOperation() {
//        button.hoverAndClick(TERMINATE_DEPOSIT_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(TERMINATE_DEPOSIT_OPERATION);
//        WaitUtils.wait(5);
        button.btnDoubleClick(TERMINATE_DEPOSIT_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select terminate deposit operation on prod")
    public DepositPage terminateDepositOperation_() {
        button.btnDoubleClick(TERMINATE_DEPOSIT_OPERATION);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click terminate button")
    public DepositPage clickTerminateButton() {
        button.btnClick(TERMINATE_DEPOSIT_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click continue terminate button")
    public DepositPage clickContinueTerminateButton() {
        button.btnClick(CONTINUE_TERMINATE_DEPOSIT_BUTTON);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select change deposit conditions operation")
    public DepositPage changeDepositConditionsOperation() {
//        button.hoverAndClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
//        WaitUtils.wait(4);
        button.btnDoubleClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select change deposit conditions operation on prod")
    public DepositPage changeDepositConditionsOperation_() {
        button.btnDoubleClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Input negotiated amount")
    public DepositPage inputNegotiatedAmount(String amount) {
        input.inputWithClear(NEGOTIATED_AMOUNT, amount);
        return this;
    }

    @Step("Just click to update page data")
    public DepositPage clickAmount() {
        move.scrollToElement(NEW_DEPOSIT_MONTH_PAY);
        button.btnClick(NEW_DEPOSIT_MONTH_PAY);
        return this;
    }

    //BUG - кнопка изменить не срабатывает с первого раза
    @Step("Click change detail button")
    public DepositPage clickChangeDetailButton() {
        move.scrollToElement(CHANGE_DETAILS_BUTTON);
        button.btnClick(CHANGE_DETAILS_BUTTON);
        button.btnClick(CHANGE_DETAILS_BUTTON);
        return this;
    }

    @Step("Click sign change detail button")
    public DepositPage clickSignChangeDetailButton() {
        button.btnClick(SIGN_CHANGE_DETAILS_BUTTON);
        return this;
    }

    @Step("Select create family package operation")
    public DepositPage createFamilyPackageOperation() {
//        button.hoverAndClick(CREATE_FAMILY_PACKAGE_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(CREATE_FAMILY_PACKAGE_OPERATION);
//        WaitUtils.wait(5);
        button.btnDoubleClick(CREATE_FAMILY_PACKAGE_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Create family package operation")
    public DepositPage createFamilyPackageOperation_() {
//        button.hoverAndClick(CREATE_FAMILY_PACKAGE_OPERATION_);
//        WaitUtils.wait(1);
//        button.btnClick(CREATE_FAMILY_PACKAGE_OPERATION_);
//        WaitUtils.wait(5);
        button.btnDoubleClick(CREATE_FAMILY_PACKAGE_OPERATION_);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select deposit division operation")
    public DepositPage createDepositDivisionOperation() {
//        button.hoverAndClick(DEPOSIT_DIVISION_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(DEPOSIT_DIVISION_OPERATION);
//        WaitUtils.wait(5);

        button.btnDoubleClick(DEPOSIT_DIVISION_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select deposit division operation on prod")
    public DepositPage depositDivisionOperation() {
        button.btnDoubleClick(DEPOSIT_DIVISION_OPERATION);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click divide button")
    public DepositPage clickDivideButton() {
        button.btnClick(DIVIDE_BUTTON);
        WaitUtils.wait(10);
        return this;
    }

    @Step("Select unite deposit operation")
    public DepositPage selectUniteDepositOperation() {
//        button.hoverAndClick(UNITE_DEPOSIT_OPERATION);
//        WaitUtils.wait(1);
//        button.btnClick(UNITE_DEPOSIT_OPERATION);
//        WaitUtils.wait(5);
        button.btnDoubleClick(UNITE_DEPOSIT_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select deposit division operation on prod")
    public DepositPage uniteDepositOperation() {
//        button.btnDoubleClick(UNITE_DEPOSIT_OPERATION);
//        WaitUtils.wait(3);
        button.hoverAndClick(UNITE_DEPOSIT_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(UNITE_DEPOSIT_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select first deposit to unite")
    public DepositPage selectFirstDepositToUnite() {
        button.btnClick(FIRST_DEPOSIT_TO_UNITE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select second deposit to unite")
    public DepositPage selectSecondDepositToUnite() {
        button.btnClick(SECOND_DEPOSIT_TO_UNITE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click confirm selected deposits button")
    public DepositPage clickConfirmSelectedDepositsButton() {
        move.scrollToElement(CONFIRM_SELECTED_DEPOSITS_BUTTON);
        button.btnClick(CONFIRM_SELECTED_DEPOSITS_BUTTON);
        elementsAttributes.waitUntilVisible(UNITE_DEPOSIT_CONFIRM_BUTTON);
        return this;
    }

    @Step("Click unite deposit confirm button")
    public DepositPage clickUniteDepositsConfirmButton() {
        move.scrollToElement(UNITE_DEPOSIT_CONFIRM_BUTTON);
        button.btnClick(UNITE_DEPOSIT_CONFIRM_BUTTON);
        elementsAttributes.waitUntilVisible(OPT_INPUT);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input otp")
    public DepositPage inputOtp(String otp) {
        move.scrollToElement(OPT_INPUT);
        input.inputWithClear(OPT_INPUT, otp);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click unite deposit continue button")
    public DepositPage clickUniteDepositsContinueButton() {
        button.btnClick(UNITE_DEPOSIT_CONTINUE_BUTTON);
        WaitUtils.wait(10);
        return this;
    }

    @Step("Select deposit for gosPrem")
    public DepositPage selectDepositForGosPrem() {
        button.btnClick(DEPOSIT_FOR_GOS_PREM);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click confirm selection deposit for gosPrem ")
    public DepositPage clickConfirmSelection() {
        move.scrollToElement(DEPOSIT_FOR_GOS_PREM_CONFIRM_BUTTON);
        button.btnClick(DEPOSIT_FOR_GOS_PREM_CONFIRM_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select assignment gratuitous operation")
    public DepositPage selectAssignmentGratuitousOperation() {
//        button.hoverAndClick(ASSIGNMENT_GRATUITOUS);
//        WaitUtils.wait(1);
//        button.btnClick(ASSIGNMENT_GRATUITOUS);
//        WaitUtils.wait(3);
        button.btnDoubleClick(ASSIGNMENT_GRATUITOUS);
        WaitUtils.wait(3);
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
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click open educational contribution Aqyl button")
    public DepositPage clickOpenAqylButton() {
        move.scrollToElement(OPEN_CONTRIBUTION_AQYL);
        button.btnClick(OPEN_CONTRIBUTION_AQYL);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click continue open educational contribution Aqyl button")
    public DepositPage clickOpenAqylContinueButton() {
        button.btnClick(CONTINUE_OPEN_CONTRIBUTION_AQYL_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click open deposit button")
    public DepositPage clickOpenDepositButton() {
        button.btnClick(OPEN_BASPANA_DEPOSIT_CONTINUE_BUTTON);
        WaitUtils.wait(5);
        elementsAttributes.waitUntilVisible(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Agreement")
    public DepositPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click continue")
    public DepositPage clickSubmit() {
        button.btnClick(SUBMIT);
        WaitUtils.wait(10);
        elementsAttributes.waitUntilVisible(CONFIRM);
        return this;
    }

    @Step("Input agreed sum")
    public DepositPage inputAgreedSum(String sum) {
        input.input(AGREED_SUM, sum);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select deposit term")
    public DepositPage selectDepositTerm() {
        button.btnClick(DEPOSIT_TERM);
        return this;
    }

    @Step("Click confirm for validate sum")
    public DepositPage clickConfirmForValidateSum() {
        WaitUtils.wait(10);

        button.btnClick(CONFIRM);
        return this;
    }

    @Step("Click confirm")
    public DepositPage clickConfirm() {
        button.btnClick(CONFIRM);
        WaitUtils.wait(10);
//        elementsAttributes.waitUntilVisible(SMS_CODE);
        return this;
    }

    @Step("Input sms")
    public DepositPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE, smsCode);
        return this;
    }

    @Step("Input otp")
    public DepositPage inputOtpCode(String smsCode) {
        input.inputWithClear(OTP, smsCode);
        return this;
    }

    @Step("Confirm open deposit operation")
    public DepositPage confirmOpeningDeposit() {
        button.btnClick(SEND);
        WaitUtils.wait(5);
        elementsAttributes.waitUntilVisible(SUCCESS);
        return this;
    }

    @Step("Confirm change of deposit terms")
    public DepositPage confirmChangeDepositTerms() {
        button.btnClick(SEND);
        WaitUtils.wait(5);
        elementsAttributes.waitUntilVisible(OPERATION_COMPLETED_SUCCESSFULLY);
        return this;
    }

    @Step("Select first deposit")
    public DepositPage selectFirstDeposit() {
        button.btnClick(FIRST_DEPOSIT);
        return this;
    }

    @Step("Select second deposit")
    public DepositPage selectSecondDeposit() {
        WaitUtils.wait(8);
        button.btnClick(SECOND_DEPOSIT);
        return this;
    }

    @Step("Select second deposit")
    public DepositPage selectSecondDeposit_prod() {
        WaitUtils.wait(3);
        button.btnClick(SECOND_DEPOSIT);
        return this;
    }
}
