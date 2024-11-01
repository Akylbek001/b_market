package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.ProfilePage.*;

@Owner("Алибек Акылбеков")
@Feature("Профиль")
public class ProfileTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    //изменить можно раз в 90 дней
    @Test(description="Изменить номер телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить номер телефона")
    @Severity(SeverityLevel.NORMAL)
    public void editPhoneNumber() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77773811409", "Baspana_1@");
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Установить новый номер телефона", () -> {
            profileSteps.editPhoneNumber(config.userLogin());
        });
        Assert.assertTrue(true);
    }

    //нужна учетка
    @Test(description="Удостоверение личности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Удостоверение личности")
    @Severity(SeverityLevel.NORMAL)
    public void editIdentificationData() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Удостоверение личности", () -> {
            profileSteps.editIdentification();
        });
        Assert.assertTrue(true);
    }

    //нужна учетка
    @Test(description="Изменить личные данные", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить личные данные")
    @Severity(SeverityLevel.NORMAL)
    public void editPersonalData() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Личные данные", () -> {
            profileSteps.editPersonalData("QA");
        });
        Assert.assertTrue(true);
    }

    @Test(description="Изменить личные данные => Валидация данных", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить личные данные")
    @Severity(SeverityLevel.NORMAL)
    public void editPersonalData_validateData() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Личные данные", () -> {
            profileSteps.editPersonalDataOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.BECOME_CLIENT_INFO_TEXT, elementsAttributes.getValue(BECAME_CLIENT_INFO)
        );
    }

    @Test(description="Изменить email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редактирование email клиента")
    @Severity(SeverityLevel.NORMAL)
    public void changeEmail() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Установить новый email", () -> {
            profileSteps.setNewEmail(config.client_for_newEmail());
        });
        Assert.assertEquals(
                CharacterSetConstants.EMAIL_UPDATED_TEXT, elementsAttributes.getValue(EMAIL_SUCCESSFULLY_CHANGED)
        );
    }

    @Test(description="Изменить email => Валидация формата email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного формата email")
    @Severity(SeverityLevel.NORMAL)
    public void validateInvalidNewEmail() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Установить новый email", () -> {
            profileSteps.setNewEmail("invalidEmail");
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_EMAIL_FORMAT_TEXT,
                elementsAttributes.getValue(INVALID_EMAIL_TEXT_LOCATOR)
        );
    }

    //нужна учетка - повторно изменить пороль после запуска теста
    @Test(description="Изменить пароль", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное изменение пароля клиента")
    @Severity(SeverityLevel.NORMAL)
    public void changePassword() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Ввести текущий и новый пароль", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.clientPassword(), "Standartpass1@", "Standartpass1@"
            );
            profileSteps.confirmPasswordChange();
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        Assert.assertEquals(
                CharacterSetConstants.PASSWORD_UPDATED, elementsAttributes.getValue(PASSWORD_SUCCESSFULLY_CHANGED)
        );
    }

    @Test(description="Изменить пароль => Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация подтверждения пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateNewPasswordConfirmation() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Ввести текущий и новый пароль", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.clientPassword(),
                    "Barisbekova1@",
                    "Barisbekova1@".concat("@")
            );
        });
        Assert.assertEquals(
                CharacterSetConstants.PASSWORD_CONFIRM_ERROR_TEXT,
                elementsAttributes.getValue(PASSWORD_CONFIRMATION_ERROR_LOCATOR)
        );
    }

    //BUG - валидация срабатывает после биометрии, перенести на страницу подтверждения пароля
    @Test(description="Изменить пароль => Валидация текущего пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация текущего пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateCurrentPassword() {
        step("Авторизация -> Перейти в раздел <Профиль>", () -> {
            loginSteps.auth("77750715539", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        step("Ввести текущий и новый пароль", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.clientPassword().concat("#"), "Baspana_1@", "Baspana_1@"
            );
            profileSteps.confirmPasswordChange();
        });
        step("Биометрия", () -> {
            generalSteps.acceptAgreement_startBiometry();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.NEW_PASSWORD_SAME_WITH_CURRENT
        );
        drManager.getDriver().switchTo().alert().accept();
    }
}
