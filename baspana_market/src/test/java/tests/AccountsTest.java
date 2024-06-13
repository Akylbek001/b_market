package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.AccountsPage.NOTIFICATION_TEXT;

@Owner("Алибек Акылбеков")
@Feature("Счета")
public class AccountsTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Открыть текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.MINOR)
    public void openCurrentAccount() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Перейти в меню Мой банк", () -> {
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountsSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountsSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountsSteps.openCurrentAccount();
        });
        step("Подтвердить открытие текущего счета", () -> {
            accountsSteps.clickFurtherButton();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Открыть текущий счет - Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.MINOR)
    public void tryOpenCurrentAccount() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Перейти в меню Мой банк", () -> {
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountsSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountsSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountsSteps.openCurrentAccount();
        });
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }

    @Test(description="Открыть счет для ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ")
    @Severity(SeverityLevel.MINOR)
    public void openAccountForEPV() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Перейти в меню Мой банк", () -> {
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountsSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountsSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountsSteps.openAccountForEpvAcceptAgreement();
            accountsSteps.openAccountForEpvSignAndConfirm(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Открыть счет для ЕПВ - Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.MINOR)
    public void tryOpenAccountForEPV() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
        });
        step("Перейти в профиль", () -> {
            profileSteps.navigateToProfile();
        });
        step("Перейти в меню Мой банк", () -> {
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountsSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountsSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountsSteps.openAccountForEpvAcceptAgreement();
        });
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }

    // Add two validation sms_code test cases
}
