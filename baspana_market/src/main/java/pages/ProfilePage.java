package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class ProfilePage extends BasePage {
    private static final By PROFILE_MENU = By.xpath("//img[@src='/Images-baspana/profile.svg']");
    private static final By PHONE_NUMBER = By.xpath(
            "//img[@src='/Images-baspana/phone-call-3.svg']"
    );
    private static final By INPUT_NEW_PHONE_NUMBER = By.id("phone-input");
    private static final By PERSONAL_DATA = By.xpath(
            "//*[contains(text(), 'Личные данные')]"
    );
    private static final By IDENTIFICATION = By.xpath(
            "//*[contains(text(), 'Удостоверение личности')]"
    );
    private static final By EDIT_DATA_BUTTON = By.xpath(
            "//*[contains(text(), 'Редактировать данные')]"
    );
    private static final By WORK_POSITION = By.id("personalInfoWorkPosition");
    private static final By CHANGE_EMAIL_LOCATOR = By.xpath(
        "//*[contains(text(), 'Изменить e-mail')]"
    );
    public static final By INVALID_EMAIL_TEXT_LOCATOR = By.id("emailError");
    private static final By NEW_EMAIL_INPUT = By.id("inputEmail");
    private static final By CHANGE_EMAIL_BUTTON = By.id("changeEmailButton");
    public static final By EMAIL_SUCCESSFULLY_CHANGED = By.cssSelector(".ob__bodyL");
    private static final By CHANGE_PASSWORD_LOCATOR = By.xpath(
            "//*[contains(text(), 'Изменить пароль')]"
    );
    private static final By OLD_PASSWORD = By.id("passwordOld");
    private static final By NEW_PASSWORD = By.id("passwordNew");
    private static final By REPEAT_NEW_PASSWORD_ = By.id("passwordRepeat");
    public static final By CHANGE_PASSWORD_BUTTON = By.id("changePasswordButton");
    public static final By PASSWORD_CONFIRMATION_ERROR_LOCATOR = By.cssSelector(
            ".ob__bodyM.ob__error.hidden.passwordError"
    );
    private static final By MY_BANK_MENU = By.id("menu2");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click profile menu")
    public ProfilePage clickProfileMenu() {
        button.btnClick(PROFILE_MENU);
        return this;
    }

    @Step("Click phone number")
    public ProfilePage clickPhoneNumber() {
        button.btnClick(PHONE_NUMBER);
        return this;
    }

    @Step("Input new phone number")
    public ProfilePage inputPhoneNumber(String phoneNumber) {
        input.inputWithClear(INPUT_NEW_PHONE_NUMBER, phoneNumber);
        return this;
    }

    @Step("Click identification")
    public ProfilePage clickIdentification() {
        button.btnClick(IDENTIFICATION);
        return this;
    }

    @Step("Click personal data locator")
    public ProfilePage clickPersonalData() {
        button.btnClick(PERSONAL_DATA);
        return this;
    }

    @Step("Click edit data button")
    public ProfilePage clickEditDataButton() {
        button.btnClick(EDIT_DATA_BUTTON);
        return this;
    }

    @Step("Input new work position")
    public ProfilePage inputNewWorkPosition(String newPosition) {
        input.inputWithClear(WORK_POSITION, newPosition);
        return this;
    }

    @Step("Click change email locator")
    public ProfilePage clickChangeEmail() {
        button.btnClick(CHANGE_EMAIL_LOCATOR);
        return this;
    }

    @Step("Input new email")
    public ProfilePage inputNewEmail(String newEmail) {
        input.inputWithClear(NEW_EMAIL_INPUT, newEmail);
        return this;
    }

    @Step("Click change email button")
    public ProfilePage clickChangeEmailButton() {
        button.btnClick(CHANGE_EMAIL_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click change password locator")
    public ProfilePage clickChangePassword() {
        button.btnClick(CHANGE_PASSWORD_LOCATOR);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input old password")
    public ProfilePage inputOldPassword(String oldPassword) {
        input.inputWithClear(OLD_PASSWORD, oldPassword);
        return this;
    }

    @Step("Input new password")
    public ProfilePage inputNewPassword(String newPassword) {
        input.inputWithClear(NEW_PASSWORD, newPassword);
        return this;
    }

    @Step("Repeat new password")
    public ProfilePage repeatNewPassword(String newPassword) {
        input.inputWithClear(REPEAT_NEW_PASSWORD_, newPassword);
        return this;
    }

    @Step("Click change password button")
    public ProfilePage clickChangePasswordButton() {
        button.btnClick(CHANGE_PASSWORD_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click my bank menu")
    public ProfilePage clickMyBankMenu() {
        button.btnClick(MY_BANK_MENU);
        return this;
    }
}
