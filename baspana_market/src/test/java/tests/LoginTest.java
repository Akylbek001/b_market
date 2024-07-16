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

    @Test(description="Восстановление пароля по номеру документа", groups = {"automated"})
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
                    "037916624",
                    config.userLogin());
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
            drManager.getDriver().switchTo().frame(0);
            loginSteps.clickReCapture();
            drManager.getDriver().switchTo().defaultContent();
            loginSteps.clickContinueButton();
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(config.userNewPassword(), config.userNewPassword());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Восстановление пароля пароля по номеру документа => Валидация номера документа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация номера документа")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecoveryByDocument_validateDocNumber() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку Забыли пароль", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    "037916623",
                    config.userLogin());
        });
        Assert.assertEquals(
                CharacterSetConstants.USER_WITH_SUCH_DATA_NOT_FOUND, elementsAttributes.getValue(USER_NOT_FOUND_TEXT)
        );
    }

    @Test(description="Восстановление пароля по номеру документа=> Валидация смс-кода", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация смс-кода")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecoveryByDocument_validateOtp() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку Забыли пароль", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    "037916624",
                    config.userLogin());
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(RandomUtils.randomNumeric(6));
            drManager.getDriver().switchTo().frame(0);
            loginSteps.clickReCapture();
            drManager.getDriver().switchTo().defaultContent();
            loginSteps.clickContinueButton();
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_CODE, elementsAttributes.getValue(WRONG_SMS_CODE_TEXT)
        );
    }

    @Test(description="Восстановление пароля по номеру документа => Валидация пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация подтверждения пароля")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecoveryByDocument_validatePasswordConfirmation() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Кликнуть ссылку <Забыли пароль>", () -> {
            loginSteps.clickForgetPasswordLink();
        });
        step("Ввести данные для восстановления", () -> {
            loginSteps.passwordRecovery_inputData(
                    "037916624",
                    config.userLogin());
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
            drManager.getDriver().switchTo().frame(0);
            loginSteps.clickReCapture();
            drManager.getDriver().switchTo().defaultContent();
            loginSteps.clickContinueButton();
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(config.userNewPassword(), config.userFakePass());
        });
        Assert.assertEquals(
                "Пароли не совпадают", elementsAttributes.getValue(WRONG_PASSWORD_CONFIRMATION)
        );
    }

    @Test(description="Восстановление пароля по альтернативному коду", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное восстановление пароля")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecovery_byAltCode() {
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
                    "311052345789",
                    config.userLogin());
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        step("Подтвердить пользователя по смс", () -> {
            loginSteps.inputSmsCode(config.smsCode());
            drManager.getDriver().switchTo().frame(0);
            loginSteps.clickReCapture();
            drManager.getDriver().switchTo().defaultContent();
            loginSteps.clickContinueButton();
        });
        step("Подтвердить и установить новый пароль", () -> {
            loginSteps.passwordRecoverySetNewPassword(config.userNewPassword(), config.userNewPassword());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NAME, elementsAttributes.getValue(PROFILE_NAME));
    }

    @Test(description="Восстановление пароля по альтернативному коду => Пользователь не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Пользователь не найден")
    @Severity(SeverityLevel.NORMAL)
    public void passwordRecoveryByAltCode_validateAltCode() {
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
                    "311052345780",
                    config.userLogin());
        });
        Assert.assertEquals(
                CharacterSetConstants.USER_WITH_SUCH_DATA_NOT_FOUND, elementsAttributes.getValue(USER_NOT_FOUND)
        );
    }

    //нужна учетка
    @Test(description="Изменение номера телефона", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное изменение номера телефона")
    @Severity(SeverityLevel.NORMAL)
    public void updateLogin() {
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
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Изменение номера телефона => Повторное изменение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Ошибка биометрии")
    @Severity(SeverityLevel.NORMAL)
    public void updateLogin_tryUpdateAgain() {
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
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.UPDATE_LOGIN_NOTIFICATION
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменение номера телефона => Валидация текущего логина", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация текущего логина")
    @Severity(SeverityLevel.NORMAL)
    public void updateLogin_validateCurrentLogin() {
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

    @Test(description="Изменение номера телефона => График совершения операции", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Ошибка биометрии")
    @Severity(SeverityLevel.NORMAL)
    public void updateLogin_transactionSchedule() {
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
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.TRANSACTION_SCHEDULE
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменение номера телефона => Ошибка биометрии", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Ошибка биометрии")
    @Severity(SeverityLevel.NORMAL)
    public void updateLogin_biometryError() {
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
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        Assert.assertEquals(
                CharacterSetConstants.IDENTITY_VERIFICATION_ERROR_TEXT, elementsAttributes.getValue(BIOMETRY_ERROR)
        );
    }

    // пока не нужный кейс
    @Test(description="BaspanaBusiness", groups = {"automated"}, enabled = false)
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
