package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.LoansPage.*;

@Owner("Алибек Акылбеков")
@Feature("Займы")
public class LoansTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    //bug - после ввода суммы пополнения отсутствуют дальнейшие шаги
    @Test(description="Пополнить текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Пополнить")
    @Severity(SeverityLevel.NORMAL)
    public void topUpAccount () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770174280", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Выбрать операцию <Пополнить>", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.clickTopUpAccountButton();
        });
        step("Пополнить", () -> {
            loansSteps.topUpAccount(config.userEmail(), "1000000");
        });
        Assert.assertTrue(true);
    }

    //need account with enough amount for repayment
    @Test(description="ПДП => С расторжением депозита", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_withTerminateDeposit () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770174280", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
            loansSteps.selectFullRepaymentWithDepositTermination();
            loansSteps.fullEarlyRepayment(config.smsCode());
        });
    }

    @Test(description="ПДП => Без расторжением депозита", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_withoutTerminateDeposit () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770174280", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
            loansSteps.selectFullRepaymentWithoutDepositTermination();
            loansSteps.fullEarlyRepayment(config.smsCode());
        });
    }

    @Test(description="ПДП => Валдация активной заявки", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_validateActiveRequest () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.ACTIVE_LOAN_REQUEST, elementsAttributes.getValue(MODAL_NOTIFICATION_)
        );
    }

    @Test(description="ПДП => Необходимо обновить данные по документу", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_needToUpdateDocument () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77017183533", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
        });
        Assert.assertTrue(
                elementsAttributes.getValue(MODAL_NOTIFICATION_)
                        .contains(CharacterSetConstants.UPDATE_DOCUMENT_NOTIFICATION)
        );
    }

    @Test(description="ПДП => Валдация активной просрочки", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_validateActiveOverdue () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77071530089", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        Assert.assertTrue(elementsAttributes.isVisible(OVERDUE_MODAL_NOTIFICATION));
    }

    @Test(description="ПДП(с расторжением депозита) => Валидация недостаточной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_withTerminateDeposit_validateNotEnoughFund () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", "12345test");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
            loansSteps.selectFullRepaymentWithDepositTermination();
            String s1 = elementsAttributes.getValue(DEPOSIT_TERMINATION_SUM);
            String s2 = elementsAttributes.getValue(CURRENT_ACCOUNT_SUM);
            String s3 = elementsAttributes.getValue(SUM_DIFF);
            double f1 = Double.parseDouble(s1.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            double f2 = Double.parseDouble(s2.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            double f3 = Double.parseDouble(s3.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            if (f1 - f2 > f3) {
                Assert.assertTrue(elementsAttributes.getValue(SUM_DIFF).contains("Средств недостаточно: " + f3));
            }
        });
    }

    @Test(description="ПДП(без расторжением депозита) => Валидация недостаточной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_withoutTerminateDeposit_validateNotEnoughFund () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", "12345test");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.fullEarlyRepaymentOperation();
            loansSteps.selectFullRepaymentWithDepositTermination();
            String s1 = elementsAttributes.getValue(DEPOSIT_TERMINATION_SUM);
            String s2 = elementsAttributes.getValue(CURRENT_ACCOUNT_SUM);
            String s3 = elementsAttributes.getValue(SUM_DIFF);
            double f1 = Double.parseDouble(s1.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            double f2 = Double.parseDouble(s2.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            double f3 = Double.parseDouble(s3.replaceAll(
                    "[^0-9?!\\,]","").replace(",", ".")
            );
            if (f1 - f2 > f3) {
                Assert.assertTrue(elementsAttributes.getValue(SUM_DIFF).contains("Средств недостаточно: " + f3));
            }
        });
    }

    @Test(description="ЧДП через текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByCurrentAccount () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77078766439", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.partialEarlyRepayment("73000");
        });
        step("ОТП", () -> {
            loansSteps.otp(config.smsCode());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SUCCESSFUL_RESULT), CharacterSetConstants.PARTIAL_REPAYMENT_SUCCESS
        );
        WaitUtils.wait(5);
        drManager.getDriver().navigate().refresh();
        elementsAttributes.waitUntilVisible(SUCCESSFUL_RESULT);
        step("Подписать новый график", () -> {
            loansSteps.signTheSchedule(config.smsCode());
        });
        Assert.assertEquals(elementsAttributes.getValue(FINAL_RESULT), CharacterSetConstants.SUCCESSFULLY_COMPLETE);
    }

    @Test(description="ЧДП через ЕПВ счет", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByEPVAccount () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77754207346", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.selectEPVAccount();
            loansSteps.partialEarlyRepayment("124000");
        });
        step("ОТП", () -> {
            loansSteps.otp(config.smsCode());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SUCCESSFUL_RESULT), CharacterSetConstants.PARTIAL_REPAYMENT_SUCCESS
        );
        WaitUtils.wait(5);
        drManager.getDriver().navigate().refresh();
        elementsAttributes.waitUntilVisible(SUCCESSFUL_RESULT);
        step("Подписать новый график", () -> {
            loansSteps.signTheSchedule(config.smsCode());
        });
        Assert.assertEquals(elementsAttributes.getValue(FINAL_RESULT), CharacterSetConstants.SUCCESSFULLY_COMPLETE);
    }

    @Test(description="ЧДП через текущий счет => Валидация недостаточной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация недостаточной суммы")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByCurrentAccount_validateNotEnoughFund () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77078766439", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.partialEarlyRepayment_validateAmount("100000");
        });
        Assert.assertEquals(
                CharacterSetConstants.NOT_ENOUGH_AMOUNT_ON_ACCOUNT, elementsAttributes.getValue(MODAL_NOTIFICATION)
        );
    }

    //need acc
    @Test(description="ЧДП через ЕПВ счет => Валидация недостаточной суммы", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByEPVAccount_validateNotEnoughFund () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.selectEPVAccount();
            loansSteps.partialEarlyRepayment("124000");
        });
    }

    //need acc
    @Test(description="ЧДП => Нет целового использования займа", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация недостаточной суммы")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepayment_validateIntendedUse () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770077702", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
        });
        Assert.assertEquals(CharacterSetConstants.INTENDED_USE_OF_LOAN,
                elementsAttributes.getValue(INTENDED_USE_OF_LOAN_NOTIFICATION)
        );
    }

//    @Test(description="ЧДП => аннулировать заявку", groups = {"automated"})
//    @Issue("https://jira.kz/browse/QA-")
//    @Description("аннулировать заявку")
//    @Severity(SeverityLevel.NORMAL)
//    public void partialEarlyRepayment_ () {
//        step("Авторизация -> Займы", () -> {
//            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
//            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
//        });
//        step("Заполнить форму", () -> {
//            loansSteps.selectExistedLoan();
//            loansSteps.openAvailableOperations();
//            loansSteps.partialEarlyRepaymentOperation();
//            loansSteps.partialEarlyRepayment("124000");
//        });
//    }

    @Test(description="Изменение даты платежа => Валидация счетов(ограничения)", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация счетов(ограничения)")
    @Severity(SeverityLevel.NORMAL)
    public void changePaymentDate_validateAccounts () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770077702", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.changingPaymentDateOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.DENIED_RESTRICTION_ON_ACCOUNTS,
                elementsAttributes.getValue(CHANGING_PAYMENT_DATE_NOTIFICATION)
        );
    }

    @Test(description="Изменение даты платежа => Валидация недостаточной суммы для оплаты комиссии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация недостаточной суммы для оплаты комиссии")
    @Severity(SeverityLevel.NORMAL)
    public void changePaymentDate_validateSumForPayCommission () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770077702", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Выбрать операцию <Изменение даты платежа>", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.changingPaymentDateOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.NOT_ENOUGH_SUM_TO_PAY_COMMISSION,
                elementsAttributes.getValue(CHANGING_PAYMENT_DATE_NOTIFICATION)
        );
    }

    @Test(description="Переход на жилищный заем => Валидация счетов(ограничения)", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация счетов(ограничения)")
    @Severity(SeverityLevel.NORMAL)
    public void selectSwitchingToHomeLoan_validateAccount() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77772911272 ", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectSwitchingToHomeLoanOperation();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SWITCHING_TO_HOME_LOAN_ACCOUNT_VALIDATION),
                CharacterSetConstants.DENIED_RESTRICTION_ON_ACCOUNTS
        );
    }

    @Test(description="Переход на жилищный заем => Валидация договорной суммы(< 50%)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("< 50%")
    @Severity(SeverityLevel.NORMAL)
    public void selectSwitchingToHomeLoan_validateDepositSum() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectSwitchingToHomeLoanOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.DENIED_DEPOSIT_SUM,
                elementsAttributes.getValue(SWITCHING_TO_HOME_LOAN_DEPOSIT_VALIDATION)
        );
    }

    @Test(description="Замена созаемщика", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Замена созаемщика)")
    @Severity(SeverityLevel.NORMAL)
    public void changeCoBorrower() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectReplacementOfCoBorrowerOperation();
            loansSteps.replacementOfCoBorrower(config.userIin());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Замена созаемщика => Созаемщик не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Созаемщик не найден)")
    @Severity(SeverityLevel.NORMAL)
    public void changeCoBorrower_validateCoBorrower() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.replacementOfCoBorrowerOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.CO_BORROWER_NOT_FOUNT, elementsAttributes.getValue(NO_CO_BORROWER_NOTIFICATION)
        );
    }

    @Test(description="Исключение созаемщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Исключение созаемщика")
    @Severity(SeverityLevel.NORMAL)
    public void exclusionOfCoBorrower() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.exclusionOfCoBorrowerOperation();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Исключение созаемщика => Созаемщик не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Созаемщик не найден)")
    @Severity(SeverityLevel.NORMAL)
    public void exclusionOfCoBorrower_validateCoBorrower() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.exclusionOfCoBorrowerOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.CO_BORROWER_NOT_FOUNT, elementsAttributes.getValue(NO_CO_BORROWER_NOTIFICATION)
        );
    }

    @Test(description="Обнуление вклада ЖСС => Сумма депозита < 50%", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Депозит < 50%)")
    @Severity(SeverityLevel.NORMAL)
    public void resettingTheDeposit_validateDepositSum() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77023803175", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Выбрать операцию <Обнуление вклада ЖСС>", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectResettingDepositOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.DEPOSIT_SUM_LESS_THAN_50,
                elementsAttributes.getValue(INTENDED_USE_OF_LOAN_NOTIFICATION)
        );
    }

    //stop step - input document digital code
    //bug - непредвиденная ошибка
    @Test(description="Продление договора страхования", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void extensionInsuranceContract () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.extensionInsuranceContractOperation();
            loansSteps.clickContinueButtonOnModal();
            loansSteps.extensionInsuranceContract(config.smsCode());
        });
        Assert.assertTrue(false);
    }

    @Test(description="Замена залога => Валидация регистрации", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Замена залога")
    @Severity(SeverityLevel.NORMAL)
    public void changeCollateral_validateRegistration () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.replacementOfCollateralOperation();
            loansSteps.replacementOfCollateral();
        });
        Assert.assertEquals(
                CharacterSetConstants.PLEDGOR_NOT_REGISTERED, elementsAttributes.getValue(MODAL_NOTIFICATION)
        );
    }
}
