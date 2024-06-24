package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.CabinetPage.CHANGE_PASSWORD_RESULT;
import static pages.CabinetPage.PROFILE_EMAIL;

@Owner("Алибек Акылбеков")
@Feature("Кабинет")
public class CabinetTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        loginSteps.auth(
                config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
        );
        brManager.navigateTo(envConfig.baseUrl().concat("cabinet"));
    }

    @Test(description = "Добавить email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить email")
    @Severity(SeverityLevel.NORMAL)
    public void addEmail () {
        step("Добавить email", () -> {
            cabinetSteps.addEditEmail("Rene@bk.ru");
        });
        Assert.assertEquals(elementsAttributes.getValue(PROFILE_EMAIL), "Rene@bk.ru");
    }

    @Test(description = "Изменить email", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить email")
    @Severity(SeverityLevel.NORMAL)
    public void changeEmail () {
        step("Изменить email", () -> {
            cabinetSteps.addEditEmail("nurRene@bk.ru");
        });
        Assert.assertEquals(elementsAttributes.getValue(PROFILE_EMAIL), "nurRene@bk.ru");
    }

    @Test(description = "Изменить пароль", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить пароль")
    @Severity(SeverityLevel.NORMAL)
    public void changePassword () {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword("oldPassword@", "newPassword@");
        });
        Assert.assertEquals(elementsAttributes.getValue(PROFILE_EMAIL), "Rene@bk.ru");
    }

    @Test(description = "Изменить пароль => валидация текущего пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация текущего пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateCurrentPassword () {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.client_for_password_recovery_newPassword(),
                    config.client_for_newPassword()
            );
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                "Старый и новый пароль не должны совпадать"
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => цифра", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля => цифра")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_digit() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.client_for_password_recovery_newPassword(), "oldassword");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                "Пароль должен содержать хотябы одну цифру"
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => заглавная буква", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля => заглавная буква")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_capitalLetter() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.client_for_password_recovery_newPassword(), "oldassword1");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                "Пароль должен содержать хотябы одну заглавную букву"
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => спецсимвол", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_specialCharacter() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.client_for_password_recovery_newPassword(), "Oldassword1");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                "Пароль должен содержать хотябы один символ"
        );
    }
}
