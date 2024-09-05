package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.SpecAccountPage.TRANSFER_DETAILS;

public class GeneralPage extends BasePage {

    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".form-check-label");
    private static final By START_BIOMETRY_BUTTON = By.id("startBiometry");
    public static final By OTP_CODE_FOR_TRANSFER = By.id("smsVerificationCodeInput");
    private static final By SEND_OTP_BUTTON = By.id("smsVerificationBtn");


    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click agreement checkbox")
    public GeneralPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
//        WaitUtils.wait(2);
        return this;
    }

    @Step("Click start biometry button")
    public GeneralPage clickStartBiometryButton() {
        button.btnClick(START_BIOMETRY_BUTTON);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Input otp")
    public GeneralPage inputOtp(String code) {
        input.inputWithClear(OTP_CODE_FOR_TRANSFER, code);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click send otp button")
    public GeneralPage clickSendOtpButton() {
        button.btnClick(SEND_OTP_BUTTON);
        elementsAttributes.waitUntilVisible(TRANSFER_DETAILS);
//        elementsAttributes.waitUntilVisible(OTP_CODE_FOR_TRANSFER);
        return this;
    }

    @Step("Click send otp button")
    public GeneralPage clickSendOtpButton_() {
        button.btnClick(SEND_OTP_BUTTON);
        return this;
    }
}
