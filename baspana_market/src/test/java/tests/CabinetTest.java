package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
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

        loginSteps.auth(config.userLogin(), config.userPass());
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
            cabinetSteps.addEditEmail("akylbek@bk.ru");
        });
        Assert.assertEquals(elementsAttributes.getValue(PROFILE_EMAIL), "akylbek@bk.ru");
    }

    @Test(description = "Изменить пароль", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить пароль")
    @Severity(SeverityLevel.NORMAL)
    public void changePassword () {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.userPass(), config.userPass());
        });
    }

    @Test(description = "Изменить пароль => валидация текущего пароля", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация текущего пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validateCurrentPassword () {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.userPass(),
                    config.userPass()
            );
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                CharacterSetConstants.PASSWORDS_MUST_NOT_BE_SAME
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => цифра", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля => цифра")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_digit() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.userPass(), "oldassword");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                CharacterSetConstants.PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_NUMBER
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => заглавная буква", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля => заглавная буква")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_capitalLetter() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.userPass(), "oldassword1");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                CharacterSetConstants.PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
        );
    }

    @Test(description = "Изменить пароль -> валидация формата пароля => спецсимвол", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация формата пароля")
    @Severity(SeverityLevel.NORMAL)
    public void validatePassword_specialCharacter() {
        step("Изменить пароль", () -> {
            cabinetSteps.changePassword(config.userPass(), "Oldassword1");
        });
        Assert.assertEquals(elementsAttributes.getValue(CHANGE_PASSWORD_RESULT),
                CharacterSetConstants.PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_CHARACTER
        );
    }
}
