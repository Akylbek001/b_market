package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class LoginPage extends BasePage {
    private static final By CLIENT_BUTTON = By.xpath("//div[@class='btn-group'] /button[1]");
    private static final By GUEST_BUTTON = By.xpath("//div[@class='btn-group'] /button[2]");
    private static final By BASPANA_BUSINESS_BUTTON = By.xpath("//div[@class='btn-group'] /a");
    private static final By BIN = By.id("binTextBox");
    private static final By BIN_PASS= By.id("passwordTextBox");
    private static final By USER_PHONE_NUMBER_LOCATOR = By.id("UserNameLogin");
    private static final By USER_PASSWORD_LOCATOR = By.id("PasswordLogin");
    private static final By SUBMIT_BUTTON_LOCATOR = By.cssSelector(".baspanaBusiness.bbreverse");
    public static final By PROFILE_NAME = By.xpath("//div[@class='clientName'] /a");
    public static final By PROFILE_ICON = By.cssSelector("[src='/Images-baspana/cab_icons.svg']");
    private static final By FORGET_PASSWORD_LOCATOR = By.id("forgetPass");
    private static final By DOCUMENT_DATA_LOCATOR = By.id("documentData");
    public static final By USER_NOT_FOUND = By.cssSelector("#resultForgetTxtResult #resultForgetTxt");
    private static final By USER_NAME_LOCATOR = By.id("UserNameName");
    private static final By SMS_CODE_LOCATOR = By.id("smsForget");
    private static final By RE_CAPTURE = By.cssSelector(".recaptcha-checkbox-border");
    private static final By CONTINUE_SMS_FORGET_BUTTON = By.id("checkPassForgetPassword");
    private static final By NEW_PASSWORD_INPUT_LOCATOR = By.id("newPassInpBiometryChange");
    private static final By NEW_PASSWORD_CONFIRM_LOCATOR = By.id("newPassInpConfirmBiometryChange");
    private static final By SAVE_AND_LOGIN_BUTTON = By.id("saveAndLoginIntoBiometry");
    private static final By SEND_SMS_BUTTON_LOCATOR = By.cssSelector("#sendSmsForget #sendSmsBtnForgetPass");
    public static final By WRONG_SMS_CODE_TEXT = By.id("otpResult");
    public static final By WRONG_PASSWORD_CONFIRMATION = By.cssSelector(".content.forgetPassModalContent.biometry__forget__password #newPassInpConfirmErr");
    private static final By CHANGE_PHONE_NUMBER_LOCATOR = By.xpath(
            "//*[contains(text(), 'Изменить номер телефона')]"
    );
    private static final By IIN_LOCATOR = By.id("iin-input");
    private static final By PHONE_LOCATOR = By.id("phone-input");
    private static final By CONTINUE_BUTTON_LOCATOR = By.xpath(
            "//*[contains(text(), 'Продолжить')]"
    );
    public static final By BIOMETRY_ERROR = By.id("errorMessage");
    private static final By BY_ALTERNATIVE_CODE_LOCATOR = By.xpath("//span[.='По альтернативному коду']");
    public static final By WRONG_CREDENTIALS_TEXT = By.id("LoginMSG");
    public static final By USER_NOT_FOUND_TEXT = By.cssSelector("#resultForgetTxtResult #resultForgetTxt");

    private static final By REGISTRATION_LINK_LOCATOR = By.xpath(
            "//div[@class='btn-submit text-center regs'] /button[contains(text(), 'Зарегистрироваться ')]"
    );
    private static final By BECOME_CLIENT_BUTTON = By.xpath(
            "//div[@class='general-info-about-accession'] //button[contains(text(), 'Стать клиентом ')]"
    );

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click guest button")
    public LoginPage clickClientButton() {
        button.btnClick(CLIENT_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click guest button")
    public LoginPage clickGuestButton() {
        WaitUtils.wait(1);
        button.btnClick(GUEST_BUTTON);
        elementsAttributes.waitUntilVisible(USER_PHONE_NUMBER_LOCATOR);
        return this;
    }

    @Step("Input login")
    public LoginPage inputPhoneNumber(String phoneNumber) {
        input.inputWithClear(USER_PHONE_NUMBER_LOCATOR, phoneNumber);
        return this;
    }

    @Step("Input password")
    public LoginPage inputPassword(String digitalDocument) {
        input.inputWithClear(USER_PASSWORD_LOCATOR, digitalDocument);
        return this;
    }

    @Step("Click submit button")
    public LoginPage clickSubmitButton() {
        button.btnClick(SUBMIT_BUTTON_LOCATOR);
//        new WebDriverWait(drManager.getDriver(), 10).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click forgot password link")
    public LoginPage clickForgotPasswordLink() {
        WaitUtils.wait(1);
        button.btnClick(FORGET_PASSWORD_LOCATOR);
        return this;
    }

    @Step("Input document number")
    public LoginPage inputDocumentNumber(String docNumber) {
        input.inputWithClear(DOCUMENT_DATA_LOCATOR, docNumber);
        return this;
    }

    @Step("Input login")
    public LoginPage inputUserName(String phoneNumber) {
        input.inputWithClear(USER_NAME_LOCATOR, phoneNumber);
        return this;
    }

    @Step("Click sendSms button")
    public LoginPage clickSendSmsButton() {
        button.btnClick(SEND_SMS_BUTTON_LOCATOR);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input forget sms")
    public LoginPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE_LOCATOR, smsCode);
        return this;
    }

    @Step("Input forget sms")
    public LoginPage clickReCapture() {
        button.btnClick(RE_CAPTURE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click sendSms button")
    public LoginPage clickContinueButton() {
        button.btnClick(CONTINUE_SMS_FORGET_BUTTON);
        return this;
    }

    @Step("New password value")
    public LoginPage inputNewPassword(String newPassword) {
        input.inputWithClear(NEW_PASSWORD_INPUT_LOCATOR, newPassword);
        return this;
    }

    @Step("Confirm new password")
    public LoginPage confirmNewPassword(String newPassword) {
        input.inputWithClear(NEW_PASSWORD_CONFIRM_LOCATOR, newPassword);
        return this;
    }

    @Step("Save new pass and login")
    public LoginPage saveAndLogin() {
        button.btnClick(SAVE_AND_LOGIN_BUTTON);
        return this;
    }

    @Step("Click recovery pass by alternative code")
    public LoginPage clickAlternativeCodeRadioButton() {
        button.btnClick(BY_ALTERNATIVE_CODE_LOCATOR);
        return this;
    }

    @Step("Click change phone number link")
    public LoginPage clickChangePhoneNumberLink() {
        button.btnClick(CHANGE_PHONE_NUMBER_LOCATOR);
        return this;
    }

    @Step("Input iin")
    public LoginPage inputIin(String iin) {
        input.inputWithClear(IIN_LOCATOR, iin);
        return this;
    }

    @Step("Input phone")
    public LoginPage inputPhone(String phone) {
        input.inputWithClear(PHONE_LOCATOR, phone);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click continue button")
    public LoginPage clickContinue() {
        button.btnClick(CONTINUE_BUTTON_LOCATOR);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click guest button")
    public LoginPage clickBaspanaBusinessButton() {
        button.btnClick(BASPANA_BUSINESS_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input bin")
    public LoginPage inputBin(String bin) {
        input.inputWithClear(BIN, bin);
        WaitUtils.wait(4);
        return this;
    }

    @Step("Input bin pass")
    public LoginPage inputBinPass(String bin) {
        input.inputWithClear(BIN_PASS, bin);
        WaitUtils.wait(4);
        return this;
    }

    @Step("Click resister link")
    public LoginPage clickRegisterLink() {
        WaitUtils.wait(2);
        button.btnClick(REGISTRATION_LINK_LOCATOR);
        return this;
    }

    @Step("Click become client button")
    public LoginPage clickBecomeClientButton() {
        WaitUtils.wait(1);
        button.btnClick(BECOME_CLIENT_BUTTON);
        return this;
    }
}
