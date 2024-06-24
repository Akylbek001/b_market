package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.RandomUtils;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.LoginPage.*;

@Owner("Алибек Акылбеков")
@Feature("Авторизация")
public class LoginTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Авторизация клиента {логин & пароль}", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная авторизация")
    @Severity(SeverityLevel.NORMAL)
    public void successfulAuthorizationClient() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.clientLogin(), config.clientPassword());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Авторизация клиента => Не корректный логин {номер телефона}", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного логина")
    @Severity(SeverityLevel.NORMAL)
    public void validateClientLogin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.clientInvalidLogin(), config.clientPassword());
        });
        Assert.assertEquals(
                CharacterSetConstants.UNEXPECTED_ERROR,elementsAttributes.getValue(WRONG_CREDENTIALS_TEXT));
    }

    @Test(description="Авторизация клиента => Не корректный пароль", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateClientPassword() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.clientLogin(), config.clientInvalidPassword());
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_CLIENT_NAME_OR_PASSWORD,
                elementsAttributes.getValue(WRONG_CREDENTIALS_TEXT)
        );
    }

    @Test(description="Авторизация гостя {логин & пароль}", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Гость. Успешная авторизация")
    @Severity(SeverityLevel.NORMAL)
    public void successfulAuthorizationGuest() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Выбрать вкладку Гость", () -> {
            loginSteps.selectGuest();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.guestLogin(), config.guestPassword());
        });
        Assert.assertEquals(CharacterSetConstants.GUEST_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Авторизация гостя => Не корректный логин {номер телефона}", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного логина ")
    @Severity(SeverityLevel.NORMAL)
    public void validateGuestLogin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Выбрать вкладку Гость", () -> {
            loginSteps.selectGuest();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.guestInvalidLogin(), config.guestPassword());
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_GUEST_NAME_OR_PASSWORD,
                elementsAttributes.getValue(WRONG_CREDENTIALS_TEXT)
        );
    }

    @Test(description="Авторизация гостя => Не корректный пароль", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateGuestPassword() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Выбрать вкладку Гость", () -> {
            loginSteps.selectGuest();
        });
        step("Ввести авторизационные данные", () -> {
            loginSteps.login(config.guestLogin(), config.guestInvalidPassword());
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_GUEST_NAME_OR_PASSWORD,
                elementsAttributes.getValue(WRONG_CREDENTIALS_TEXT)
        );
    }

    //ToDo - find out how to get capture
    @Test(description="Восстановление пароля по номеру документа", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное восстановление пароля")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecoveryByDocument() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку Забыли пароль", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_document(),
                    config.client_for_password_recovery_login());
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(
                    config.client_for_password_recovery_newPassword(),
                    config.client_for_password_recovery_newPassword()
            );
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Восстановление пароля пароля по номеру документа => Валидация данных", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Проверка валидации при установке существующего пароля в виде нового пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateUserPasswordRecoveryByDocument() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку Забыли пароль", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_invalidDocument(),
                    config.client_for_password_recovery_invalidLogin());
        });
        Assert.assertEquals(
                CharacterSetConstants.USER_WITH_SUCH_DATA_NOT_FOUND, elementsAttributes.getValue(USER_NOT_FOUND_TEXT)
        );
    }

    //ToDo - find out how to get capture
    @Test(description="Восстановление пароля по номеру документа=> Валидация смс-кода", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация смс-кода")
    @Severity(SeverityLevel.NORMAL)
    public void validateSmsCodePasswordRecoveryByDocument() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку Забыли пароль", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_document(),
                    config.client_for_password_recovery_login());
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(RandomUtils.randomNumeric(6));
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_CODE, elementsAttributes.getValue(WRONG_SMS_CODE_TEXT)
        );
        //rc-anchor-container
    }

    //ToDo - find out how to get capture
    @Test(description="Восстановление пароля по номеру документа => Валидация пароля", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация пароля подтверждения")
    @Severity(SeverityLevel.NORMAL)
    public void validationPasswordConfirmationRecoveryByDocument() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку <Забыли пароль>", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_document(),
                    config.client_for_password_recovery_login());
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(
                    config.client_for_password_recovery_newPassword(),
                    config.client_for_password_recovery_invalidPassword()
            );
        });
        Assert.assertEquals(
                "", elementsAttributes.getValue(WRONG_SMS_CODE_TEXT)
        );
    }

    //ToDo - find out alternative code
    @Test(description="Восстановление пароля по альтернативному коду", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное восстановление пароля")
    @Severity(SeverityLevel.NORMAL)
    public void passRecoveryByCode() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку <Забыли пароль>", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Выбрать опцию по альтернативному коду", () -> {
            loginSteps.selectAlternativeCodeRadioButton();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_alternativeCode(),
                    config.client_for_password_recovery_login());
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(
                    config.client_for_password_recovery_newPassword(),
                    config.client_for_password_recovery_newPassword()
            );
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Восстановление пароля по альтернативному коду => Пользователь не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Пользователь не найден")
    @Severity(SeverityLevel.NORMAL)
    public void tryRecoveryPasswordByInvalidClientData() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку <Забыли пароль>", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Выбрать опцию по альтернативному коду", () -> {
            loginSteps.selectAlternativeCodeRadioButton();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    config.client_for_password_recovery_document(),
                    config.client_for_password_recovery_login());
        });
        Assert.assertEquals(
                CharacterSetConstants.USER_WITH_SUCH_DATA_NOT_FOUND, elementsAttributes.getValue(USER_NOT_FOUND)
        );
    }

    @Test(description="Изменение номера телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное изменение номера телефона")
    @Severity(SeverityLevel.NORMAL)
    public void changePhone() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть <Изменить номер телефона>", () -> {
            loginSteps.clickChangePhoneNumberLink();
        });
        step("Заполненить инн и логин", () -> {
            loginSteps.inputIinAndLogin(
                    config.client_for_password_recovery_iin(), config.client_for_password_recovery_newLogin()
            );
        });
        step("Начать биометрическую проверку", () -> {
            loginSteps.startBiometryChecking();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Изменение номера телефона => Валидация текущего логина", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация текущего логина")
    @Severity(SeverityLevel.NORMAL)
    public void tryUpdateLoginToCurrentLogin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть <Изменить номер телефона>", () -> {
            loginSteps.clickChangePhoneNumberLink();
        });
        step("Заполнить инн и логин", () -> {
            loginSteps.inputIinAndLogin(
                    config.client_for_password_recovery_iin(), config.client_for_password_recovery_login()
            );
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.PHONE_NUMBER_ALREADY_CURRENT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменение номера телефона => Ошибка биометрии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Ошибка биометрии")
    @Severity(SeverityLevel.NORMAL)
    public void identityVerificationFailed() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть <Изменить номер телефона>", () -> {
            loginSteps.clickChangePhoneNumberLink();
        });
        step("Заполнить инн и логин", () -> {
            loginSteps.inputIinAndLogin(
                    config.client_for_password_recovery_iin(), config.client_for_password_recovery_newLogin()
            );
        });
        step("Начать биометрическую проверку", () -> {
            loginSteps.startBiometryChecking();
        });
        Assert.assertEquals(
                CharacterSetConstants.IDENTITY_VERIFICATION_ERROR_TEXT, elementsAttributes.getValue(BIOMETRY_ERROR)
        );
    }

    @Test(description="BaspanaBusiness", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Авторизация")
    @Severity(SeverityLevel.NORMAL)
    public void baspanaBusiness() {
        step("Перейти на страницу авторизации", () -> mainSteps.loginButton());
        step("Ввести данные авторизации", () -> {
            loginSteps.selectBaspanaBusiness();
            brManager.switchToLastTab();
            loginSteps.inputBin("800800800800", "passs");
        });
    }
}
