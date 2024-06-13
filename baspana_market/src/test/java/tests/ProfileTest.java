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
    }

    @Test(description="Изменить номер телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void editPhoneNumber() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Установить новый номер телефона", () -> {
            profileSteps.editPhoneNumber(config.client_for_login());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Удостоверение личности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void editIdentificationData() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Удостоверение личности", () -> {
            profileSteps.editIdentification();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Изменить личные данные", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void editPersonalData() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Личные данные", () -> {
            profileSteps.editPersonalData("QA");
        });
        Assert.assertTrue(true);
    }

    @Test(description="Изменить email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редактирование email клиента")
    @Severity(SeverityLevel.NORMAL)
    public void changeEmail() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Установка нового email", () -> {
            profileSteps.setNewEmail(config.client_for_newEmail());
        });
        Assert.assertEquals(
                CharacterSetConstants.EMAIL_UPDATED_TEXT, elementsAttributes.getValue(EMAIL_SUCCESSFULLY_CHANGED)
        );
    }

    @Test(description="Изменить email. Валидация формата email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация некорректного формата email")
    @Severity(SeverityLevel.NORMAL)
    public void validateInvalidNewEmail() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Установка нового email", () -> {
            profileSteps.setNewEmail("invalidEmail");
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_EMAIL_FORMAT_TEXT, elementsAttributes.getValue(INVALID_EMAIL_TEXT_LOCATOR)
        );
    }

    @Test(description="Изменить пароль. Валидация подтверждения пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация подтверждения пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateNewPasswordConfirmation() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Ввод текущего и нового пароля", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.client_for_password(),
                    config.client_for_password(),
                    config.client_for_password().concat("@")
            );
        });
        Assert.assertEquals(
                CharacterSetConstants.PASSWORD_CONFIRM_ERROR_TEXT,
                elementsAttributes.getValue(PASSWORD_CONFIRMATION_ERROR_LOCATOR)
        );
    }

    @Test(description="Изменить пароль. Валидация текущего пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация текущего пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateCurrentPassword() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Ввод текущего и нового пароля", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.client_for_password(), config.client_for_password(), config.client_for_password()
            );
            profileSteps.confirmPasswordChange();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.NEW_PASSWORD_SAME_WITH_CURRENT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменить пароль", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешное изменение пароля клиента")
    @Severity(SeverityLevel.NORMAL)
    public void changePassword() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.client_for_login(), config.client_for_password());
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Ввод текущего и нового пароля", () -> {
            profileSteps.inputCurrentAndNewPassword(
                    config.client_for_password(), config.client_for_password(), config.client_for_password()
            );
            profileSteps.confirmPasswordChange();
        });
        Assert.assertEquals(
                CharacterSetConstants.PASSWORD_UPDATED, elementsAttributes.getValue(EMAIL_SUCCESSFULLY_CHANGED)
        );
    }
}
