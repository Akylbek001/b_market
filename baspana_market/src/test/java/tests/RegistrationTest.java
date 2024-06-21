package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import static pages.RegistrationPage.*;

@Owner("Алибек Акылбеков")
@Feature("Регистрация")
public class RegistrationTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.loginButton();
        registrationSteps.startRegister();
    }

    @Test(description="Регистрация гостья", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация гостья")
    @Severity(SeverityLevel.NORMAL)
    public void registerGuest() {
        step("Заполнить имя гостя", () -> {
            registrationSteps.registrationGuest(config.guestName());
        });
        step("Заполнение регистрацинных данных гостья", () -> {
            registrationSteps.inputRegistrationData(
                    config.guestPhone(), config.guestEmail(), config.guestPass(), config.guestPass()
            );
            registrationSteps.clickRegisterGuestButton();
        });
        step("Подтверждение регистрации по смс коду", () -> {
            registrationSteps.confirmRegistrationBySmsCode(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Регистрация гостья => Валидация существующего логина гостья", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего логина гостья")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedGuestLogin() {
        step("Заполнить имя гостя", () -> {
            registrationSteps.registrationGuest(config.guestName());
        });
        step("Заполнение регистрацинных данных гостья", () -> {
            registrationSteps.inputRegistrationData(
                    config.guestLogin(), config.guestNewEmail(), config.guestPassword(), config.guestPassword()
            );
            registrationSteps.clickRegisterGuestButton();
        });
        Assert.assertEquals(
                CharacterSetConstants.GUEST_LOGIN_ALREADY_EXIST, elementsAttributes.getValue(REGISTRATION_RESULT)
        );
    }

    @Test(description="Регистрация гостья => Валидация существующего email гостья", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего email гостья")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedGuestEmail() {
        step("Заполнить имя гостя", () -> {
            registrationSteps.registrationGuest(config.guestName());
        });
        step("Заполнение регистрацинных данных гостья", () -> {
            registrationSteps.inputRegistrationData(
                    config.guestLogin(), config.guestEmail(), config.guestPassword(), config.guestPassword()
            );
            registrationSteps.clickRegisterGuestButton();
        });
        Assert.assertEquals(
                CharacterSetConstants.GUEST_EMAIL_ALREADY_EXIST, elementsAttributes.getValue(REGISTRATION_RESULT)
        );
    }

    @Test(description="Регистрация гостья => Валидация ФИО ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterGuestWithInvalidName() {
        step("Заполнить имя гостя", () -> {
            registrationSteps.registrationGuest(config.guestFakeName());
        });
        step("Заполнение регистрацинных данных гостья", () -> {
            registrationSteps.inputRegistrationData(
                    config.guestLogin(), config.guestEmail(), config.guestPassword(), config.guestPassword()
            );
            registrationSteps.clickRegisterGuestButton();
        });
        Assert.assertEquals(CharacterSetConstants.INVALID_FIO, elementsAttributes.getValue(REGISTRATION_RESULT));
    }

    @Test(description="Регистрация гостья => Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterGuestWithInvalidPassConfirmation() {
        step("Заполнить имя гостя", () -> {
            registrationSteps.registrationGuest(config.guestName());
        });
        step("Заполнение регистрацинных данных гостья", () -> {
            registrationSteps.inputRegistrationData(
                    config.guestLogin(),
                    config.guestEmail(),
                    config.guestPassword(),
                    config.guestPassword().concat("@")
            );
            registrationSteps.clickRegisterGuestButton();
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_PASS_CONFIRMATION, elementsAttributes.getValue(PASSWORD_CONFIRMATION_ERROR_TEXT)
        );
    }

    //BUG => ФР->Непредвиденная ошибка при вводе OTP
    @Test(description="Регистрация клиента по номеру документа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация клиента")
    @Severity(SeverityLevel.NORMAL)
    public void clientRegistrationByDocument() {
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode("037916624");
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userLogin(), config.userEmail(), config.userPass(), config.userPass()
            );
            registrationSteps.clickRegisterClientButton();
        });
        step("Подтверждение регистрации по смс коду", () -> {
            registrationSteps.confirmRegistrationBySmsCode(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Регистрация клиента по номеру документа => Валидация существующего логина клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего логина клиента")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientLoginByDocumentCode() {
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode(config.clientDocumentNumber());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.clientLogin(),
                    config.clientEmail(),
                    config.clientPassword().concat("A@"),
                    config.clientPassword().concat("A@")
            );
            registrationSteps.clickRegisterClientButton();
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_LOGIN_ALREADY_EXIST, elementsAttributes.getValue(REGISTRATION_RESULT));
    }

    //BUG=> ФР->Пользователь по номеру документа не найден, ОР-> Неверный формат email
    @Test(description="Регистрация клиента по номеру документа => Валидация существующего email клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего email клиента")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientEmailByDocumentCode() {
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode(config.clientDocumentNumber());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.client_for_login(),
                    config.clientEmail(),
                    config.clientPassword().concat("A@"),
                    config.clientPassword().concat("A@")
            );
            registrationSteps.clickRegisterClientButton();
        });
        Assert.assertEquals(elementsAttributes.getValue(REGISTRATION_RESULT), CharacterSetConstants.CLIENT_EMAIL_ALREADY_EXIST);
    }

    @Test(description="Регистрация клиента по номеру документа => Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация подтверждения пароля")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterClientWithInvalidPassConfirmation() {
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode(config.clientDocumentNumber());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userLogin(), config.clientEmail(), config.userPass(), config.clientInvalidPass()
            );
            registrationSteps.clickRegisterClientButton();
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_PASS_CONFIRMATION, elementsAttributes.getValue(PASSWORD_CONFIRMATION_ERROR_TEXT)
        );
    }

    //BUG => ФР->Пользователь по номеру документа не найден, ОР->Неверный формат номера телефона
    @Test(description="Регистрация клиента по номеру документа => Валидация номера телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего телефона")
    @Severity(SeverityLevel.NORMAL)
    public void validateRegistrationByCodePhone(){
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode("037916624");
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userFakeLogin(), config.userEmail(), config.userPass(), config.userPass()
            );
            registrationSteps.clickRegisterClientButton();
        });
        Assert.assertEquals("Пользователь по номеру документа не найден", elementsAttributes.getValue(REGISTRATION_RESULT));
    }

    //Нужен альтернативный код
    @Test(description="Регистрация клиента по альтернативному коду", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация")
    @Severity(SeverityLevel.NORMAL)
    public void clientRegistrationByAlternativeCode() {
        step("Выбор регистрации по альтернативному коду", () -> {
            registrationSteps.registrationByAlternativeCode(config.clientAlternativeCode());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userLogin(), config.userEmail(), config.userPass(), config.userPass()
            );
            registrationSteps.clickRegisterClientButton();
        });
        step("Подтверждение регистрации по смс коду", () -> {
            registrationSteps.confirmRegistrationBySmsCode(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Регистрация клиента по альтернативному коду => Валидация", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientByAlternativeCode() {
        step("Выбор регистрации по альтернативному коду", () -> {
            registrationSteps.registrationByAlternativeCode(config.clientAlternativeCode());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userLogin(), config.userEmail(), config.userPass(), config.userPass()
            );
            registrationSteps.clickRegisterClientButton();
        });
        Assert.assertTrue(true);
    }
}
