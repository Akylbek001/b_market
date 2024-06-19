package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class RegistrationPage extends BasePage {
    private static final By REGISTRATION_LINK_LOCATOR = By.xpath(
            "//div[@class='btn-submit text-center regs'] /button[contains(text(), 'Зарегистрироваться ')]"
    );
//    private static final By REGISTRATION_LINK_LOCATOR = By.xpath(
//            "//div[@class='BecomeClient'] //button[contains(text(), 'Зарегистрироваться ')]"
//    );
    private static final By ACCEPT_CONTINUE_BUTTON = By.id("registerUser");
    private static final By GUEST_NAME_LOCATOR = By.id("UserName");
    private static final By PHONE__INPUT = By.id("UserPhone");
    private static final By EMAIL_LOCATOR = By.id("UserEmail");
    private static final By PASS_LOCATOR = By.id("PasswordUser");
    private static final By GUEST_PASS_CONFIRMATION_LOCATOR = By.id("ConfirmPasswordUser");
    private static final By REGISTER_GUEST_BUTTON = By.xpath("//div[@class='registration'] /div[4] //input[@type='submit']");
    private static final By REGISTER_CLIENT_BUTTON = By.xpath("//div[@class='registration registrationIfClient'] /div[4] //input[@type='submit']");
    private static final By SMS_CODE = By.id("codeSms");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
    public static final By REGISTRATION_RESULT = By.id("registrationResult");
    public static final By PASSWORD_CONFIRMATION_ERROR_TEXT = By.id("ConfirmPasswordUser-error");
    private static final By CLIENT_BUTTON = By.xpath("//*[text()='Клиент']");
    private static final By CLIENT_DOC_NUMBER_LOCATOR = By.id("docInput");
    private static final By BY_ALTERNATIVE_CODE_LOCATOR = By.xpath("//span[.='По альтернативному коду']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click resister link")
    public RegistrationPage clickRegister() {
        WaitUtils.wait(2);

//        elementsAttributes.waitUntilTextPresent(REGISTRATION_LINK_LOCATOR, "Зарегистрироваться");
        button.btnClick(REGISTRATION_LINK_LOCATOR);
        return this;
    }

    @Step("Click accept and continue button")
    public RegistrationPage clickAcceptContinue() {
        button.btnClick(ACCEPT_CONTINUE_BUTTON);
        return this;
    }

    @Step("Input guest name")
    public RegistrationPage inputGuestName(String guestName) {
        input.inputWithClear(GUEST_NAME_LOCATOR, guestName);
        return this;
    }

    @Step("Input guest phone")
    public RegistrationPage inputGuestPhone(String guestPhone) {
        input.inputWithClear(PHONE__INPUT, guestPhone);
        return this;
    }

    @Step("Input guest phone")
    public RegistrationPage inputGuestEmail(String guestEmail) {
        input.inputWithClear(EMAIL_LOCATOR, guestEmail);
        return this;
    }

    @Step("Input guest pass")
    public RegistrationPage inputGuestPass(String guestPass) {
        input.inputWithClear(PASS_LOCATOR, guestPass);
        return this;
    }

    @Step("Confirm guest pass")
    public RegistrationPage confirmGuestPass(String guestPass) {
        input.inputWithClear(GUEST_PASS_CONFIRMATION_LOCATOR, guestPass);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click register guest button")
    public RegistrationPage clickRegisterGuestButton() {
        move.scrollToElement(REGISTER_GUEST_BUTTON);
        button.btnClick(REGISTER_GUEST_BUTTON);
        return this;
    }

    @Step("Click register client button")
    public RegistrationPage clickRegisterClientButton() {
        move.scrollToElement(REGISTER_CLIENT_BUTTON);
        button.btnClick(REGISTER_CLIENT_BUTTON);
        return this;
    }

    @Step("input sms code")
    public RegistrationPage inputSmsCode(String smsCode) {
        input.inputWithClear(SMS_CODE, smsCode);
        return this;
    }

    @Step("Click submit button")
    public RegistrationPage clickSubmit() {
        button.btnClick(SUBMIT_BUTTON);
        return this;
    }

    @Step("Click register client block")
    public RegistrationPage clickClientBlock() {
        button.btnClick(CLIENT_BUTTON);
        return this;
    }

    @Step("Confirm client docOrCode")
    public RegistrationPage inputDocumentCode(String documentCode) {
        input.inputWithClear(CLIENT_DOC_NUMBER_LOCATOR, documentCode);
        return this;
    }

    @Step("Click recovery pass by alternative code")
    public RegistrationPage clickAlternativeRadioButton() {
        button.btnClick(BY_ALTERNATIVE_CODE_LOCATOR);
        return this;
    }
}
