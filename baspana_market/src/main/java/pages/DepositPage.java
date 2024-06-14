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
    private static final By NEW_DEPOSIT_BUTTON = By.id("OpenButtons");
    private static final By OPEN_BASPANA_DEPOSIT = By.xpath(
            "//div[@id='baspana'] //span[@class='ob-bodyM']"
    );
    private static final By OPEN_DEPOSIT = By.xpath(
            "//div[@class='DepositBlock--background DepositBlock--infos'] //button[@id='FatcasSteps']"
    );
    private static final By AGREEMENT_CHECKBOX = By.xpath(
            "//form[@id='fatca-formm'] //input[@id='StandardConditionsAgreed']"
    );
    private static final By SUBMIT = By.xpath("//button[@type='submit']");
    private static final By CONFIRM = By.xpath("//button[@class='ValSums']");
    public static final By NOTIFICATION_VISIT_THE_BANK = By.xpath("//div[@id='NextSteps'] //p");
    private static final By SMS_CODE = By.id("CodeSmsId");
    private static final By SEND = By.id("EndsSteps");
    private static final By SHOW_DEPOSIT_DETAILS = By.id("text");
    private static final By CALCULATOR_OP_BUTTON = By.id("calculateOPButton");

    private static final By AVAILABLE_OPERATIONS = By.id("checBlock");
    private static final By CHANGE_GOS_PREM_OPERATION = By.id("changeGosPremButton");
    private static final By SELECT = By.id("next-step");

    private static final By TERMINATE_DEPOSIT_OPERATION = By.id("terminateDeposit");
    private static final By TERMINATE_DEPOSIT_BUTTON = By.xpath(
            "//button[@data-target='#TerminationModal']"
    );
    private static final By CONTINUE_TERMINATE_DEPOSIT_BUTTON = By.xpath(
            "//button[@onclick='BlocksStartsTerminationEnd()']"
    );

    private static final By CHANGE_DEPOSIT_CONDITIONS_OPERATION = By.id("ChangeDeposConditionsButton");

    private static final By CREATE_FAMILY_PACKAGE_OPERATION = By.xpath("//div[@onclick='onGetDeposits()']");
    private static final By SELECT_DEPOSIT = By.xpath("//div[@class='deposit_consolidation_step1_list_item']");
    private static final By CONTINUE_BUTTON = By.id("btnNext");
    private static final By FAMILY_PACKAGE_NAME = By.id("inptFPName");
    private static final By CREATE_FAMILY_PACKAGE_BUTTON = By.id("btnCreate");
    public static final By CREATED_FAMILY_PACKAGE_NAME = By.xpath("//h2");
    private static final By INVITE_FAMILY_PACKAGE_MEMBER_BUTTON = By.xpath("//div[@class='family-members-add'] /span");
    private static final By  RELATION_DEGREE_LIST = By.xpath("//div[@class='col-4']/div[@class='select']");
    private static final By  RELATION_DEGREE_VALUE = By.xpath("//ul[@class='select-options'] /li[@rel='SPOS']");
    private static final By  INVITED_IIN = By.id("inputInviteIIN");
    private static final By  INVITED_ALTERNATIVE_CODE = By.id("inputInviteAlterCode");
    private static final By  ADD_MEMBER_BUTTON = By.id("btnAddMember");
    public static final By ADDED_FAMILY_MEMBER_FIO = By.xpath("//div[@class='family-members'][2] //div[@class='col-sm-4'] /h6");
    private static final By  CANCEL_INVITE_ICON = By.id("cancelInvite");
    private static final By  CONFIRM_CANCEL_INVITE_BUTTON = By.xpath("//button[@id='btnCancelInvite'][2]");

    public static final By DISBAND_FAMILY_PACKAGE_BUTTON = By.xpath("//button[@data-target='#modalDisbandFP']");
    private static final By CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON = By.id("btnCreateFP");




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
        button.btnDoubleClick(AVAILABLE_OPERATIONS);
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

    @Step("Select create family package operation")
    public DepositPage createFamilyPackageOperation() {
        button.hoverAndClick(CREATE_FAMILY_PACKAGE_OPERATION);
        WaitUtils.wait(1);
        button.btnClick(CREATE_FAMILY_PACKAGE_OPERATION);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Select deposit")
    public DepositPage selectDeposit() {
        button.btnClick(SELECT_DEPOSIT);
        return this;
    }

    @Step("Click continue button")
    public DepositPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Input family package name")
    public DepositPage inputFamilyPackageName(String familyPackageName) {
        input.inputWithClear(FAMILY_PACKAGE_NAME, familyPackageName);
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
