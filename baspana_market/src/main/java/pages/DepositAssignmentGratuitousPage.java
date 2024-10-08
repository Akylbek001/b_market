package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositAssignmentGratuitousPage extends BasePage {

    public static final By ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON = By.cssSelector(".right_button button");
    private static final By ASSIGNMENT_GRATUITOUS_RELATION_DEGREE = By.id("selectKinship");
    private static final By USER_IIN = By.id("iin-input");
    public static final By ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON_ = By.cssSelector(".right_button.ob-mt-20px.web-block button");
    private static final By CONFIRM_SMS_BUTTON = By.id("continue-sms-cession");
    public static final By ASSIGNMENT_GRATUITOUS_AMOUNT_VALIDATION = By.cssSelector("span#errorCheckCessioner");
    private static final By SMS_CODE = By.id("CodeSmsId");

    public static final By PROHIBITION_OF_OPEN_ACCOUNT = By.xpath("//div[@id='arrestsDiv'] /div[@class='arrestDiv'][2] //span[@class='accentXS']");
    public static final By GOS_PREM_MODAL_TITLE = By.cssSelector(".changeTitle");
    public static final By WAITING_FOR_SINGING_STATUS = By.cssSelector(".ob-caption");
    private static final By NAVIGATE_TO_REQUEST_FOR_SIGN = By.cssSelector(".ob-btn.ob-btn-teal");
    private static final By REQUEST_BLOCK = By.cssSelector(".tab-pane.active.count-tab-pane-active .StatesToMy");
    private static final By REJECT_REQUEST_BUTTON = By.cssSelector(".main-block.d-flex.flex-column.ob-gap-20px .ob-btn.ob-btn-white.ob-h-48px.reject-first-step");
    private static final By ACCEPT_REQUEST_BUTTON= By.cssSelector(".main-block.d-flex.flex-column.ob-gap-20px .ob-btn.ob-btn-tangerine.ob-h-48px.continue-first-step");
    public static final By REJECTED_NOTIFICATION = By.cssSelector(".ob-accentS.ob-error");

    private static final By CONTINUE_REQUEST_CONFIRMATION_BUTTON = By.cssSelector(".right_button.web-block button");
//    private static final By INPUT_ACCEPT_CONFIRMATION_OTP = By.id("CodeSmsId");
//    private static final By CONFIRM_OTP_BUTTON = By.id("continue-sms-cession");
    public static final By ACCEPTED_NOTIFICATION = By.cssSelector(".ob-banner-text .ob-accentS");
    public static final By ACCEPT_REQUEST_CONFIRM_CHECKBOX = By.cssSelector(".form-check-input");
    private static final By CONTINUE_CONFIRMATION_BUTTON = By.cssSelector(".right_button.web-block button");
    private static final By SIGN_BUTTON = By.cssSelector(".confirmation_div .ob-btn.ob-btn-teal.ob-h-48px.sign-third-step");
    private static final By FINAL_SIGN_BUTTON = By.cssSelector("#documentPDF .ob-btn.ob-btn-teal.sign-fifth-step.ob-h-48px");
    private static final By FIFTH_SIGN_STEP_BUTTON = By.cssSelector(".confirmation_div .ob-btn.ob-btn-teal.ob-h-48px.sign-fifth-step");
    public static final By FINAL_STATUS = By.cssSelector(".div_application .title");


    public DepositAssignmentGratuitousPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click assignment gratuitous continue button")
    public DepositAssignmentGratuitousPage clickAssignmentGratuitousContinueButton() {
        button.btnClick(ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select relation degree")
    public DepositAssignmentGratuitousPage selectRelationDegree() {
        dropDown.selectByIndex(ASSIGNMENT_GRATUITOUS_RELATION_DEGREE, 1);
        return this;
    }

    @Step("Input iin")
    public DepositAssignmentGratuitousPage inputIin(String iin) {
        input.inputWithClear(USER_IIN, iin);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click assignment gratuitous continue button")
    public DepositAssignmentGratuitousPage clickAssignmentGratuitousContinueButton_() {
        button.btnClick(ASSIGNMENT_GRATUITOUS_CONTINUE_BUTTON_);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click otp confirm button")
    public DepositAssignmentGratuitousPage clickOtpConfirmButton() {
        button.btnClick(CONFIRM_SMS_BUTTON);
        return this;
    }

    @Step("Input sms")
    public DepositAssignmentGratuitousPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE, smsCode);
        return this;
    }

    @Step("Navigate to request for sign")
    public DepositAssignmentGratuitousPage navigateToRequestForSign() {
        button.btnClick(NAVIGATE_TO_REQUEST_FOR_SIGN);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click request block")
    public DepositAssignmentGratuitousPage clickRequestBlock() {
        button.btnClick(REQUEST_BLOCK);
        return this;
    }

    @Step("Click reject request button")
    public DepositAssignmentGratuitousPage clickRejectRequestButton() {
        button.btnClick(REJECT_REQUEST_BUTTON);
        return this;
    }

    @Step("Click accept request button")
    public DepositAssignmentGratuitousPage clickAcceptRequestButton() {
        button.btnClick(ACCEPT_REQUEST_BUTTON);
        return this;
    }

    @Step("Click accept request checkbox")
    public DepositAssignmentGratuitousPage clickAcceptRequestCheckbox() {
        button.btnClick(ACCEPT_REQUEST_CONFIRM_CHECKBOX);
        return this;
    }

    @Step("Click accept request continue button")
    public DepositAssignmentGratuitousPage clickAcceptRequestContinueButton() {
        button.btnClick(CONTINUE_CONFIRMATION_BUTTON);
        elementsAttributes.waitUntilVisible(SIGN_BUTTON);
        return this;
    }

    @Step("Click sign button")
    public DepositAssignmentGratuitousPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Click final sign button")
    public DepositAssignmentGratuitousPage clickFinalSignButton() {
        button.btnClick(FINAL_SIGN_BUTTON);
        return this;
    }

    @Step("Click fifth sign step button")
    public DepositAssignmentGratuitousPage clickFifthSignStepButton() {
        button.btnClick(FIFTH_SIGN_STEP_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click continue request confirmation button")
    public DepositAssignmentGratuitousPage clickContinueRequestConfirmationButton() {
        button.btnClick(CONTINUE_REQUEST_CONFIRMATION_BUTTON);
        return this;
    }

//    @Step("Input otp")
//    public DepositAssignmentGratuitousPage inputAcceptConfirmationOtp(String otp) {
//        input.inputWithClear(INPUT_ACCEPT_CONFIRMATION_OTP, otp);
//        return this;
//    }
//
//    @Step("Click confirm otp button")
//    public DepositAssignmentGratuitousPage clickConfirmOtpButton() {
//        button.btnClick(CONFIRM_OTP_BUTTON);
//        return this;
//    }
}
