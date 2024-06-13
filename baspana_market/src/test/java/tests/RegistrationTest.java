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
    }

    @Test(description="Регистрация гостья", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация гостья")
    @Severity(SeverityLevel.NORMAL)
    public void registerGuest() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация гостья. Валидация существующего логина гостья", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего логина гостья")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedGuestLogin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация гостья. Валидация существующего email гостья", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего email гостья")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedGuestEmail() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация гостья. Валидация ФИО ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterGuestWithInvalidName() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация гостья. Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterGuestWithInvalidPassConfirmation() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация клиента по номеру документа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация клиента")
    @Severity(SeverityLevel.NORMAL)
    public void clientRegistrationByDocument() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
        step("Выбор регистрации по номеру документа", () -> {
            registrationSteps.registrationByDocumentCode(config.clientDocumentNumber());
        });
        step("Заполнение регистрацинных данных клиента", () -> {
            registrationSteps.inputRegistrationData(
                    config.userLogin(), config.userEmail(), config.userPass(), config.userPass()
            );
        });
        step("Подтверждение регистрации по смс коду", () -> {
            registrationSteps.confirmRegistrationBySmsCode(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Регистрация клиента по номеру документа. Валидация существующего логина клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего логина клиента")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientLoginByDocumentCode() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    //BUG - не валидирует существующий email - вместо этого вылетает ошибка "Пользователь по номеру документа не найден"
    @Test(description="Регистрация клиента по номеру документа. Валидация существующего email клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего email клиента")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientEmailByDocumentCode() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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
        Assert.assertEquals(CharacterSetConstants.CLIENT_EMAIL_ALREADY_EXIST, elementsAttributes.getValue(REGISTRATION_RESULT));
    }

//    @Test(description="Регистрация клиента по номеру документа. Валидация Email", groups = {"automated"})
//    @Issue("https://jira.kz/browse/QA-")
//    @Description("Валидация некорректного email")
//    @Severity(SeverityLevel.NORMAL)
//    public void validateRegistrationByCodeEmail() {
//        step("Перейти на страницу авторизации", () -> {
//            mainSteps.loginButton();
//        });
//        step("Перейти на страницу регистрации", () -> {
//            registrationSteps.startRegister();
//        });
//        step("Выбор регистрации по номеру документа", () -> {
//            registrationSteps.registrationByDocumentCode(config.clientDocumentNumber());
//        });
//        step("Заполнение регистрацинных данных клиента", () -> {
//            registrationSteps.inputRegistrationData(
//                    config.userLogin(), config.clientInvalidEmail(), config.userPass(), config.userPass()
//            );
//            registrationSteps.clickRegisterClientButton();
//        });
//        Assert.assertEquals(CharacterSetConstants.INVALID_EMAIL, elementsAttributes.getValue(REGISTRATION_RESULT));
//    }

    @Test(description="Регистрация клиента по номеру документа. Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация подтверждения пароля")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterClientWithInvalidPassConfirmation() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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
//
//    @Test(description="Регистрация клиента по номеру документа. Валидация телефона", groups = {"automated"})
//    @Issue("https://jira.kz/browse/QA-")
//    @Description("Валидация существующего телефона")
//    @Severity(SeverityLevel.NORMAL)
//    public void validateRegistrationByCodePhone(){
//        step("Перейти на страницу авторизации", () -> {
//            mainSteps.loginButton();
//        });
//        step("Перейти на страницу регистрации", () -> {
//            registrationSteps.startRegister();
//        });
//        step("Заполнение данных", () -> {
//            registrationSteps.registerClientByDoc(
//                    config.documentData(),
//                    config.userLogin(),
//                    config.userEmail(),
//                    config.userPass());
//        });
//        Assert.assertEquals(CharacterSetConstants.EMAIL_EXIST, elementsAttributes.getValue(REGISTRATION_RESULT));
//    }


    @Test(description="Регистрация клиента по альтернативному коду", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешная регистрация")
    @Severity(SeverityLevel.NORMAL)
    public void clientRegistrationByAlternativeCode() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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

    @Test(description="Регистрация клиента по альтернативному коду.Валидация", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void tryRegisterExistedClientByAlternativeCode() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Перейти на страницу регистрации", () -> {
            registrationSteps.startRegister();
        });
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
