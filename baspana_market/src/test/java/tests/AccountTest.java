package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.AccountPage.CURRENT_ACCOUNT_SUCCESS;
import static pages.AccountPage.NOTIFICATION_TEXT;

@Owner("Алибек Акылбеков")
@Feature("Счета")
public class AccountTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.loginButton();
        loginSteps.login(
                config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
        profileSteps.navigateToProfile();
        depositSteps.selectMyBankMenu();
    }

    @Test(description="Открыть текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void openCurrentAccount() {
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountSteps.openCurrentAccount();
            accountSteps.openCurrentAccountContinue(config.smsCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_REFUSED, elementsAttributes.getValue(CURRENT_ACCOUNT_SUCCESS)
        );
    }

    @Test(description="Открыть текущий счет - Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenCurrentAccount() {
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountSteps.openCurrentAccount();
        });
        System.out.println(elementsAttributes.getValue(NOTIFICATION_TEXT));
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }

    @Test(description="Открыть счет для ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void openAccountForEPV() {
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.openAccountForEpvAcceptAgreement();
            accountSteps.openAccountForEpvSignAndConfirm(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Открыть счет для ЕПВ - Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenAccountForEPV() {
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.openAccountForEpvAcceptAgreement();
        });
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }
    // Add two validation sms_code test cases

    @Test(description="Подключить счет из другого банка", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("счет другого банка")
    @Severity(SeverityLevel.NORMAL)
    public void addOtherBankAccount() {
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.addOtherBankAccount();
        });
        Assert.assertTrue(true);
    }
}
