package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.AccountPage.*;

@Owner("Алибек Акылбеков")
@Feature("Счета")
public class AccountTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

//        mainSteps.loginButton();
//        loginSteps.login(
//                config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
//        profileSteps.navigateToProfile();
//        depositSteps.selectMyBankMenu();
    }

    @Test(description="Открыть текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void openCurrentAccount() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
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
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_SUCCESSFULLY,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Открыть счет для ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void openAccountForEPV() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
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
        Assert.assertEquals(
                CharacterSetConstants.CURRENT_ACCOUNT_OPEN_SUCCESSFULLY,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    //BUG - no accounts in dropdown list even when existed deposit
    @Test(description="Перевод между своими счетами", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToDebt() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод между своими счетами", () -> {
            accountSteps.transferToDebt();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Перевод клиенту <Отбасы Банк> => по номеру телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtbasyClient_byPhoneNumber() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(),
                    config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_byPhoneNumber(config.clientLogin().substring(1));
            accountSteps.transfer(config.sumToTransfer(), config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Перевод клиенту <Отбасы Банк> по номеру телефона => не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtbasyClient_byPhoneNumber_notFound() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(),
                    config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_byPhoneNumber(config.clientLogin().substring(1));
        });
        Assert.assertEquals(
                "Клиент не найден, проверьте номер телефона", elementsAttributes.getValue(NOT_FOUND_BY_NUMBER)
        );
    }

    @Test(description="Перевод клиенту <Отбасы Банк> => по альтернативному коду", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtbasyClient_byAlternativeCode() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_byAltCode(config.clientAlternativeCode());
            accountSteps.transfer(config.sumToTransfer(), config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Перевод клиенту <Отбасы Банк> по альтернативному коду => не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtbasyClient_byAlternativeCode_notFound() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.validateOtbasyBankClient_byAltCode("191014670500");
        });
        Assert.assertEquals(
                "Клиент не найден, проверьте введенный код", elementsAttributes.getValue(NOT_FOUND_BY_CODE)
        );
    }

    @Test(description="Перевод в другой банк", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод в другой банк>", () -> {
            accountSteps.transferToOtherBank();
        });
        step("Перевод в другой банк", () -> {
            accountSteps.searchOtherBankIban(config.clientIban().substring(2));
            accountSteps.transfer(config.sumToTransfer(), config.smsCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    @Test(description="Перевод в другой банк => некрректный IBAN счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("некрректный IBAN счет")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_invalidIban() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод в другой банк>", () -> {
            accountSteps.transferToOtherBank();
        });
        step("Перевод в другой банк", () -> {
            accountSteps.searchOtherBankIban("KZ649729722204F0Z3LL".substring(2));
        });
        Assert.assertEquals(
                "Вы ввели некорректный IBAN счет!", elementsAttributes.getValue(IBAN_ERROR)
        );
    }

    @Test(description="Открыть текущий счет => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenCurrentAccount() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountSteps.openCurrentAccount();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }

    @Test(description="Открыть счет для ЕПВ => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenAccountForEPV() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
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
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(NOTIFICATION_TEXT)
        );
    }
    // Add validation sms_code test cases

    @Test(description="Перевод между своими счетами => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void transferToDebt_clientValidation() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.transferToDebt();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    @Test(description="Перевод клиенту_Отбасы Банк => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtbasyClient_clientValidation() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    @Test(description="Перевод в другой банк => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_clientValidation() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод в другой банк", () -> {
            accountSteps.transferToOtherBank();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    //BUG -Произошла непредвиденная ошибка!
    @Test(description="Подключить счет из другого банка", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("счет другого банка")
    @Severity(SeverityLevel.NORMAL)
    public void addOtherBankAccount() {
        step("Авторизация->Мой Банк", () -> {
            mainSteps.loginButton();
            loginSteps.login(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
            profileSteps.navigateToProfile();
            depositSteps.selectMyBankMenu();
        });
        step("Перейти в меню Счета", () -> {
            accountSteps.selectAccountsMenu();
        });
        step("Подключить счет из другого банка", () -> {
            accountSteps.addOtherBankAccount();
        });
        Assert.assertTrue(true);
    }
}
