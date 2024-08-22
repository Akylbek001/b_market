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
import static pages.SpecAccountPage.ERROR_TEXT;

@Owner("Алибек Акылбеков")
@Feature("Счета")
public class AccountTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Открыть текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.CRITICAL)
    public void openCurrentAccount() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77078759590", config.clientPassword());
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectAccountsMenu();
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountSteps.openCurrentAccount();
            accountSteps.openCurrentAccountContinue(config.smsCode());
            accountSteps.finishOpenCurrentAccount();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_FINISHED_SUCCESSFULLY_NOTIFICATION,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Открыть текущий счет => Валидация ОТР", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ОТР")
    @Severity(SeverityLevel.CRITICAL)
    public void openCurrentAccount_otpValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(config.client_for_password_recovery_login(), config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть текущий счет", () -> {
            accountSteps.openCurrentAccount();
            accountSteps.openCurrentAccountContinue(config.smsCode().substring(1));
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_OTP_TEXT, elementsAttributes.getValue(INVALID_OTP));
    }

    @Test(description="Открыть текущий счет => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.BLOCKER)
    public void tryOpenCurrentAccount() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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

//add close current account test

    @Test(description="Открыть счет для ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ")
    @Severity(SeverityLevel.CRITICAL)
    public void openAccountForEPV() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.openAccountForEpvAcceptAgreement();
            accountSteps.openAccountForEpvSignAndConfirm(config.smsCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_FINISHED_SUCCESSFULLY_NOTIFICATION,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Открыть счет для ЕПВ => Валидация ОТР", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ОТР")
    @Severity(SeverityLevel.CRITICAL)
    public void openAccountForEPV_otpValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77016677419", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.openAccountForEpvAcceptAgreement();
            accountSteps.openAccountForEpvSignAndConfirm(config.smsCode().substring(1));
        });
        Assert.assertEquals(
                CharacterSetConstants.EPV_INVALID_OTP_TEXT,
                elementsAttributes.getValue(INVALID_OTP_NOTIFICATION)
        );
    }

    //NEED ACCOUNT - в базе бездействующих налогоплательщиков
    @Test(description="Открыть счет для ЕПВ => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.BLOCKER)
    public void openAccountForEPV_clientValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть счет", () -> {
            accountSteps.openAccountButton();
        });
        step("Открыть счет для ЕПВ", () -> {
            accountSteps.openAccountForEpvAcceptAgreement();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPERATION_REFUSED, elementsAttributes.getValue(EPV_ERROR_MESSAGE)
        );
    }

    @Test(description="Перевод между своими счетами", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.CRITICAL)
    public void transferToDebt() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77003896225", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод между своими счетами", () -> {
            accountSteps.transferToDebt();
        });
        step("Выбрать депозит", () -> {
            certificatesSteps.openAccountsList();
            certificatesSteps.selectAllAccounts();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.transfer_insufficientFunds(config.sumToTransfer());
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertEquals("5,0 ₸", elementsAttributes.getValue(TRANSFER_SUM));
    }

    @Test(description="Перевод между своими счетами => Валидация отсутствия депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация отсутствия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void transferToDebt_validateNoDeposit() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77052713077", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод между своими счетами", () -> {
            accountSteps.transferToDebt();
        });
        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description="Перевод клиенту <Отбасы Банк> => По номеру телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtbasyClient_byPhoneNumber() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
        Assert.assertEquals("5,0 ₸", elementsAttributes.getValue(TRANSFER_SUM));
    }

    @Test(description="Перевод клиенту <Отбасы Банк> по номеру телефона => Клиент не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.CRITICAL)
    public void transferToOtbasyClient_clientNotFound() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_validateClient("77768467535");
        });
        Assert.assertEquals(
                CharacterSetConstants.CLIENT_NOT_FOUND_CHECK_NUMBER, elementsAttributes.getValue(NOT_FOUND_BY_NUMBER)
        );
    }

    //Убрали возможность ввода суммы превышающую сумму на счете
    @Test(description="Перевод клиенту <Отбасы Банк> по номеру телефона => недостаточно средств", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("недостаточно средств")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtasyBank_byPhone_insufficientFunds() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_byPhoneNumber(config.clientLogin().substring(1));
            accountSteps.transfer_insufficientFunds("50000000");
        });
        Assert.assertEquals(
                CharacterSetConstants.INSUFFICIENT_FUNDS_FOR_TRANSFER, elementsAttributes.getValue(INSUFFICIENT_FUNDS)
        );
    }

    @Test(description="Перевод клиенту <Отбасы Банк> => По альтернативному коду", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtbasyClient_byAlternativeCode() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
        Assert.assertEquals("5,0 ₸", elementsAttributes.getValue(TRANSFER_SUM));
    }

    @Test(description="Перевод клиенту <Отбасы Банк> по альт.коду => Клиент не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtbasyClient_byAlternativeCode_notFound() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
                CharacterSetConstants.CLIENT_NOT_FOUND_CHECK_CODE, elementsAttributes.getValue(NOT_FOUND_BY_CODE)
        );
    }

    //Убрали возможность ввода суммы превышающую сумму на счете
    @Test(description="Перевод клиенту <Отбасы Банк> по альт.коду => недостаточно средств", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("недостаточно средств")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtasyBank_byAltCode_insufficientFunds() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод клиенту <Отбасы Банк>>", () -> {
            accountSteps.transferToOtbasyBankClient();
        });
        step("Перевод клиенту <Отбасы Банк>", () -> {
            accountSteps.searchOtbasyBankClient_byAltCode(config.clientAlternativeCode());
            accountSteps.transfer_insufficientFunds("5000000");
        });
        Assert.assertEquals(
                CharacterSetConstants.INSUFFICIENT_FUNDS_FOR_TRANSFER, elementsAttributes.getValue(INSUFFICIENT_FUNDS)
        );
    }

    @Test(description="Перевод в другой банк", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtherBank() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
        Assert.assertEquals("5,0 ₸", elementsAttributes.getValue(TRANSFER_SUM));
    }

    @Test(description="Перевод в другой банк => некрректный IBAN счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("некрректный IBAN счет")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtherBank_invalidIban() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77716081952", config.clientPassword() );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод в другой банк>", () -> {
            accountSteps.transferToOtherBank();
        });
        step("Перевод в другой банк", () -> {
            accountSteps.validateInvalidIban("KZ649729722204F0Z3LL".substring(2));
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_IBAN, elementsAttributes.getValue(IBAN_ERROR)
        );
    }

    //Убрали возможность ввода суммы превышающую сумму на счете
    @Test(description="Перевод в другой банк => недостаточно средств", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("недостаточно средств")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtherBank_insufficientFunds() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Выбрать операцию <Перевод в другой банк>", () -> {
            accountSteps.transferToOtherBank();
        });
        step("Перевод в другой банк", () -> {
            accountSteps.searchOtherBankIban(config.clientIban().substring(2));
            accountSteps.transfer_insufficientFunds("5000000");
        });
        Assert.assertEquals(
                CharacterSetConstants.INSUFFICIENT_FUNDS_FOR_TRANSFER, elementsAttributes.getValue(INSUFFICIENT_FUNDS)
        );
    }

    //NEED ACCOUNT
    @Test(description="Перевод между своими счетами => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToDebt_clientValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
    //NEED ACCOUNT
    @Test(description="Перевод клиенту <Отбасы Банк> => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtbasyClient_clientValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
    //NEED ACCOUNT
    @Test(description="Перевод в другой банк => Валидация налогоплательщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - бездействующий налогоплательщик")
    @Severity(SeverityLevel.BLOCKER)
    public void transferToOtherBank_clientValidation() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
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
    @Test(description="Подключить счет из другого банка", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("счет другого банка")
    @Severity(SeverityLevel.TRIVIAL)
    public void addOtherBankAccount() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Подключить счет из другого банка", () -> {
            accountSteps.addOtherBankAccount();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Перевод между своими счетами => Валидация наличия займа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация наличия займа")
    @Severity(SeverityLevel.CRITICAL)
    public void closeCurrentAccount_validateLoan() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth("77052713077", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Открыть список достпупных операции", () -> {
            accountSteps.openAvailableOperationsList();
        });
        step("Перевод между своими счетами", () -> {
            accountSteps.closeCurrentAccount();
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_HAS_LOAN, elementsAttributes.getValue(ERROR_TEXT));
    }
}

//жду исправления проверок при попытке закрыть текущий счет - Раджан
