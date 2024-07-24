package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecAccountSgoPage extends BasePage {
    private static final By TRANSFER_TO_FULL_PAYMENT = By.id("TransferToFullPayment");
    private static final By TRANSFER_TO_INITIAL_PAYMENT = By.id("transferToInitialPayment");
    private static final By TRANSFER_TO_PAYMENT_WITH_REDEMPTION= By.id("transferToPaymentWithRedemption");
    private static final By TRANSFER_TO_PURCHASE_HOME = By.id("transferToPurchaseHome");

    private static final By PHONE_NUMBER = By.id("phoneNumber");
    private static final By ALT_CODE_LABEL = By.cssSelector("[for='option2']");
    private static final By ALT_CODE_VALUE = By.cssSelector("input#numberOnly");

    private static final By FOUND_USER_BY_NUMBER = By.id("foundUserNameByNumber");
    private static final By FOUND_USER_BY_CODE = By.id("foundUserNameByCode");

    private static final By WITHOUT_NUMBER_SLIDER = By.cssSelector(".row .slider.round");
    private static final By CONTRACT_NUMBER = By.id("applicationNumber");
    private static final By CONTRACT_DATE = By.id("applicationDate");
    public static final By SUM_TO_TRANSFER = By.id("sumToTransfer");

    private static final By SEND_TRANSFER_BUTTON = By.id("sendTransferButton");
    private static final By CONFIRM_TRANSFER_BUTTON = By.id("confirmTransfer");
    private static final By OTP_CODE_FOR_TRANSFER = By.id("smsVerificationCodeInput");
    private static final By SEND_OTP_BUTTON = By.id("smsVerificationBtn");
    public static final By TRANSFER_DETAILS = By.cssSelector(".checkTransfer");




    public SpecAccountSgoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select transfer to full payment operation")
    public SpecAccountSgoPage selectTransferToFullPaymentOperation() {
        button.btnClick(TRANSFER_TO_FULL_PAYMENT);
        elementsAttributes.waitUntilVisible(PHONE_NUMBER);
        return this;
    }

    @Step("Input phone")
    public SpecAccountSgoPage inputPhone(String number) {
        input.inputWithClear(PHONE_NUMBER, number);
        elementsAttributes.waitUntilVisible(FOUND_USER_BY_NUMBER);
        return this;
    }

    @Step("Click altCode label")
    public SpecAccountSgoPage clickAltCodeLabel() {
        button.btnClick(ALT_CODE_LABEL);
        return this;
    }

    @Step("Input altCode")
    public SpecAccountSgoPage inputAltCode(String code) {
        input.inputWithClear(ALT_CODE_VALUE, code);
        elementsAttributes.waitUntilVisible(FOUND_USER_BY_CODE);
        return this;
    }

    @Step("Input contract number")
    public SpecAccountSgoPage inputContractNumber(String number) {
        input.inputWithClear(CONTRACT_NUMBER, number);
        return this;
    }

    @Step("Input contract date")
    public SpecAccountSgoPage inputContractDate(String date) {
        input.inputWithClear(CONTRACT_DATE, date);
        return this;
    }

    @Step("Input sum to transfer")
    public SpecAccountSgoPage inputSumToTransfer(String sum) {
        input.inputWithClear(SUM_TO_TRANSFER, sum);
        return this;
    }

    @Step("Click send transfer button")
    public SpecAccountSgoPage clickSendTransferButton() {
        button.btnClick(SEND_TRANSFER_BUTTON);
        return this;
    }

    @Step("Confirm transfer button")
    public SpecAccountSgoPage confirmTransferButton() {
        button.btnClick(CONFIRM_TRANSFER_BUTTON);
        elementsAttributes.waitUntilVisible(OTP_CODE_FOR_TRANSFER);
        return this;
    }

    @Step("Input otp")
    public SpecAccountSgoPage inputOtp(String code) {
        input.inputWithClear(OTP_CODE_FOR_TRANSFER, code);
        return this;
    }

    @Step("Click send otp button")
    public SpecAccountSgoPage clickSendOtpButton() {
        button.btnClick(SEND_OTP_BUTTON);
        return this;
    }
}
