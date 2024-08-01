package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage extends BasePage {

    private static final By MY_DEPOSIT_LABEL = By.cssSelector("[role='option']");
    private static final By NEW_DEPOSIT_BUTTON = By.id("OpenButtons");
    private static final By OPEN_BASPANA_DEPOSIT = By.xpath(
            "//div[@id='baspana'] //span[@class='ob-bodyM']"
    );
    private static final By OPEN_CONTRIBUTION_AQYL = By.id("openAqylDeposit");
    private static final By CONTINUE_OPEN_CONTRIBUTION_AQYL_BUTTON = By.xpath("//div[@class='modal fade show'] //button[@id='continueOpenChildDeposit']");
    public static final By REFUSED_NOTIFICATION = By.id("reasonAqyl");

//    private static final By OPEN_BASPANA_DEPOSIT_CONTINUE_BUTTON = By.xpath(
//            "//div[@class='DepositBlock--background DepositBlock--infos'] //button[@id='FatcasSteps']"
//    );
    private static final By OPEN_BASPANA_DEPOSIT_CONTINUE_BUTTON = By.id("FatcasSteps");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector("#StandardConditionsAgreed");

    private static final By SUBMIT = By.xpath("//button[@type='submit']");
    private static final By AGREED_SUM = By.cssSelector("input#dep_agree_sum.depsums");
    private static final By DEPOSIT_TERM = By.id("calc_l_m_range--g");
    public static final By CONFIRM = By.cssSelector("#NextSteps .ValSums");

    public static final By NOTIFICATION_VISIT_THE_BANK = By.xpath("//div[@id='NextSteps'] //p");
    public static final By SUCCESS = By.cssSelector("#NextSteps p");
    private static final By SMS_CODE = By.id("CodeSmsId");
    private static final By SEND = By.id("EndsSteps");
    private static final By FIRST_DEPOSIT = By.cssSelector(".DepositBlock--background.OpenDepositsStepsEnds button");
    private static final By SECOND_DEPOSIT = By.cssSelector("//div[@class='slick-track']/label[2]");

    public static final By DEPOSIT_CREATED_DATE = By.cssSelector(".titlel");
    private static final By SHOW_DEPOSIT_DETAILS = By.id("text");
    private static final By CALCULATOR_OP_BUTTON = By.id("calculateOPButton");

    private static final By AVAILABLE_OPERATIONS_WITH_DEPOSIT = By.id("checBlock");
    private static final By CHANGE_GOS_PREM_OPERATION = By.id("changeGosPremButton");
    private static final By SELECT_SECOND_DEPOSIT = By.cssSelector(".card-item.deposit-item.active");
    private static final By GOS_PREM_AGREEMENT = By.cssSelector("#modal-body-gos-prem [for='AgreeWithAgreement']");
    public static final By FINAL_TEXT = By.cssSelector(".finalTxt");

    private static final By SELECT = By.id("next-step");
    private static final By TERMINATE_DEPOSIT_OPERATION = By.id("terminateDeposit");
    private static final By TERMINATE_DEPOSIT_BUTTON = By.cssSelector(
            "[data-target='#TerminationModal']"
    );
    private static final By CONTINUE_TERMINATE_DEPOSIT_BUTTON = By.cssSelector(
        "[onclick='BlocksStartsTerminationEnd()']"
    );
    public static final By TERMINATE_DEPOSIT_REQUEST_ACCEPTED = By.cssSelector(".TerminationBlocks--Starts h3");
    private static final By CHANGE_DEPOSIT_CONDITIONS_OPERATION = By.id("ChangeDeposConditionsButton");
    private static final By NEGOTIATED_AMOUNT = By.cssSelector("[name='NewAgreementSumm']");
    private static final By CHANGE_DETAILS_BUTTON = By.id("changeDetailsButton");
    private static final By SIGN_CHANGE_DETAILS_BUTTON = By.id("signChangeDetailsButton");
    public static final By OPERATION_COMPLETED_SUCCESSFULLY = By.cssSelector(".finishHead .title");
    private static final By CREATE_FAMILY_PACKAGE_OPERATION = By.xpath("//div[@onclick='onGetDeposits()']");
    private static final By SELECT_DEPOSIT = By.cssSelector(".deposit_consolidation_step1_list_item");
    private static final By CONTINUE_BUTTON = By.id("btnNext");
    private static final By FAMILY_PACKAGE_NAME = By.id("inptFPName");
    private static final By CREATE_FAMILY_PACKAGE_BUTTON = By.id("btnCreate");
    public static final By CREATED_FAMILY_PACKAGE_NAME = By.xpath("//h2");
    private static final By INVITE_FAMILY_PACKAGE_MEMBER_BUTTON = By.cssSelector("[data-target='#modalInvite']");//?
    private static final By RELATION_DEGREE_LIST = By.cssSelector(".col-4 div.select");
    private static final By RELATION_DEGREE_VALUE = By.cssSelector("ul.select-options li[rel='SPOS']");
    private static final By INVITED_IIN = By.id("inputInviteIIN");
    private static final By INVITED_ALTERNATIVE_CODE = By.id("inputInviteAlterCode");
    public static final By INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION = By.cssSelector("label#modalNotificationBody");
    private static final By ADD_MEMBER_BUTTON = By.id("btnAddMember");
    public static final By ADDED_FAMILY_MEMBER_FIO = By.xpath("//div[@class='family-members'][2] //div[@class='col-sm-4'] /h6");
    private static final By CANCEL_INVITE_ICON = By.id("cancelInvite");//?
    private static final By CONFIRM_CANCEL_INVITE_BUTTON = By.xpath("//button[@id='btnCancelInvite'][2]");
    public static final By DISBAND_FAMILY_PACKAGE_BUTTON = By.cssSelector("[data-target='#modalDisbandFP']");//?
    private static final By CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON = By.id("btnCreateFP");
    private static final By DEPOSIT_DIVISION_OPERATION = By.xpath(" //div[@class='operTxt' and text()='Деление депозита']");
    private static final By DIVIDE_BUTTON = By.cssSelector(".button-sp_div .split.white");
    public static final By DIVIDE_NO_ACCOUNT_VALIDATION = By.cssSelector(".modal-body.body-attention > p");
    public static final By DIVIDE_SAVING_AMOUNT_VALIDATION = By.id("diffinfoHTML");
    public static final By DIVIDE_DEPOSIT_ACCEPTED = By.cssSelector(".h5_22");//?
    private static final By UNITE_DEPOSIT_OPERATION = By.id("UniteDepositsButton");
    public static final By ASSIGNMENT_GRATUITOUS = By.cssSelector(".operBtn.deposit-relatives-cession");
    public static final By ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON = By.cssSelector(".right_button button");
    private static final By ASSIGNMENT_GRATUITOUS_RELATION_DEGREE = By.id("selectKinship");
    private static final By USER_IIN = By.id("iin-input");
    public static final By ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON_ = By.cssSelector(".right_button.ob-mt-20px.web-block button");
    private static final By CONFIRM_SMS_BUTTON = By.id("continue-sms-cession");


    public DepositPage(WebDriver driver) {
        super(driver);
    }


    @Step("Select my opened deposit")
    public DepositPage selectOpenedDeposit() {
        button.btnClick(MY_DEPOSIT_LABEL);
        WaitUtils.wait(1);
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
        button.btnDoubleClick(AVAILABLE_OPERATIONS_WITH_DEPOSIT);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select change gos prem operation")
    public DepositPage selectChangeGosPremOperation() {
        button.hoverAndClick(CHANGE_GOS_PREM_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(CHANGE_GOS_PREM_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click select button")
    public DepositPage clickSelectButton() {
        button.btnClick(SELECT);
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
        button.hoverAndClick(TERMINATE_DEPOSIT_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(TERMINATE_DEPOSIT_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click terminate button")
    public DepositPage clickTerminateButton() {
        button.btnClick(TERMINATE_DEPOSIT_BUTTON);
        return this;
    }

    @Step("Click continue terminate button")
    public DepositPage clickContinueTerminateButton() {
        button.btnClick(CONTINUE_TERMINATE_DEPOSIT_BUTTON);
        return this;
    }

    @Step("Select change deposit conditions operation")
    public DepositPage changeDepositConditionsOperation() {
        button.hoverAndClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(CHANGE_DEPOSIT_CONDITIONS_OPERATION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input negotiated amount")
    public DepositPage inputNegotiatedAmount(String amount) {
        input.inputWithClear(NEGOTIATED_AMOUNT, amount);
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
        button.hoverAndClick(CREATE_FAMILY_PACKAGE_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(CREATE_FAMILY_PACKAGE_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select deposit for package")
    public DepositPage selectDepositForPackage() {
        button.btnClick(SELECT_DEPOSIT);
        return this;
    }

    @Step("Click continue button")
    public DepositPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Input family package name")
    public DepositPage inputFamilyPackageName(String name) {
        input.inputWithClear(FAMILY_PACKAGE_NAME, name);
        return this;
    }

    @Step("Click create family package button")
    public DepositPage clickCreateFamilyPackageButton() {
        button.btnClick(CREATE_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Click invite family package member button")
    public DepositPage clickInviteFamilyPackageMemberButton() {
        button.btnClick(INVITE_FAMILY_PACKAGE_MEMBER_BUTTON);
        return this;
    }

    @Step("Open relation degree list")
    public DepositPage openRelationDegreeList() {
//        dropDown.selectByIndex(RELATION_DEGREE_LIST, 2);  select is not available even by id
        button.btnClick(RELATION_DEGREE_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select relation degree")
    public DepositPage selectRelationDegreeValue() {
        button.btnClick(RELATION_DEGREE_VALUE);
        return this;
    }

    @Step("Input invited iin")
    public DepositPage inputInvitedIin(String invitedIin) {
        input.inputWithClear(INVITED_IIN, invitedIin);
        return this;
    }

    @Step("Input invited alternative code")
    public DepositPage inputInvitedAlternativeCode(String alternativeCode) {
        input.inputWithClear(INVITED_ALTERNATIVE_CODE, alternativeCode);
        return this;
    }

    @Step("Click add member button")
    public DepositPage clickAddMemberButton() {
        button.btnClick(ADD_MEMBER_BUTTON);
        return this;
    }

    @Step("Click cancel invite icon")
    public DepositPage clickCancelInviteIcon() {
        button.btnClick(CANCEL_INVITE_ICON);
        return this;
    }

    @Step("Click confirm cancel invite button")
    public DepositPage clickConfirmCancelInviteButton() {
        button.btnClick(CONFIRM_CANCEL_INVITE_BUTTON);
        return this;
    }

    @Step("Click disband family package button")
    public DepositPage clickDisbandFamilyPackageButton() {
        button.btnClick(DISBAND_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Click confirm disband family package button")
    public DepositPage clickConfirmDisbandFamilyPackageButton() {
        button.btnClick(CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Select deposit division operation")
    public DepositPage createDepositDivisionOperation() {
        button.hoverAndClick(DEPOSIT_DIVISION_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(DEPOSIT_DIVISION_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click divide button")
    public DepositPage clickDivideButton() {
        button.btnClick(DIVIDE_BUTTON);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select unite deposit operation")
    public DepositPage selectUniteDepositOperation() {
        button.hoverAndClick(UNITE_DEPOSIT_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(UNITE_DEPOSIT_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select assignment gratuitous operation")
    public DepositPage selectAssignmentGratuitousOperation() {
        button.hoverAndClick(ASSIGNMENT_GRATUITOUS);
        WaitUtils.wait(1);
        button.btnClick(ASSIGNMENT_GRATUITOUS);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click assignment gratuitous continue button")
    public DepositPage clickAssignmentGratuitousContinueButton() {
        button.btnClick(ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select relation degree")
    public DepositPage selectRelationDegree() {
        dropDown.selectByIndex(ASSIGNMENT_GRATUITOUS_RELATION_DEGREE, 1);
        return this;
    }

    @Step("Input iin")
    public DepositPage inputIin(String iin) {
        input.inputWithClear(USER_IIN, iin);
        return this;
    }

    @Step("Click assignment gratuitous continue button")
    public DepositPage clickAssignmentGratuitousContinueButton_() {
        button.btnClick(ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON_);
        WaitUtils.wait(1);
        return this;
    }


    @Step("Click otp confirm button")
    public DepositPage clickOtpConfirmButton() {
        button.btnClick(CONFIRM_SMS_BUTTON);
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
        elementsAttributes.waitUntilVisible(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Agreement")
    public DepositPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click continue")
    public DepositPage clickSubmit() {
        button.btnClick(SUBMIT);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Clear agreed sum input fields")
    public DepositPage clearInputField() {
        input.cleanField(AGREED_SUM);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Input agreed sum")
    public DepositPage inputAgreedSum(String sum) {
        WaitUtils.wait(3);
        input.inputWithClear(AGREED_SUM, sum);
        return this;
    }

    @Step("Select deposit term")
    public DepositPage selectDepositTerm() {
        button.btnClick(DEPOSIT_TERM);
        return this;
    }

    @Step("Click confirm")
    public DepositPage clickConfirm() {
        button.btnClick(CONFIRM);
        elementsAttributes.waitUntilClickable(SEND);
        return this;
    }

    @Step("Input iin")
    public DepositPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE, smsCode);
        return this;
    }

    @Step("Click send")
    public DepositPage clickSend() {
        button.btnClick(SEND);
        elementsAttributes.waitUntilVisible(DEPOSIT_CREATED_DATE);
        return this;
    }

    @Step("Select first deposit")
    public DepositPage selectFirstDeposit() {
        button.btnClick(FIRST_DEPOSIT);
        return this;
    }

    @Step("Select second deposit")
    public DepositPage selectSecondDeposit() {
        button.btnClick(SECOND_DEPOSIT);
        return this;
    }
}
