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

    @Test(description="Полное досрочное погашение => с расторжением депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_terminateDeposit () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", "12345test");
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

    @Test(description="Полное досрочное погашение => без расторжением депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment_withoutTerminateDeposit () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", "12345test");
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

    @Test(description="Полное досрочное погашение(с расторжением депозита) => Валидация недостаточной суммы", groups = {"automated"})
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

    @Test(description="Полное досрочное погашение(без расторжением депозита) => Валидация недостаточной суммы", groups = {"automated"})
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

    @Test(description="Частичное досрочное погашение через текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByCurrentAccount () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77773192656", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.partialEarlyRepayment("124000");
        });
    }

    @Test(description="Частичное досрочное погашение через ЕПВ счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByEPVAccount () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77773192656", config.loanClient_password());
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

    @Test(description="Частичное досрочное погашение через текущий счет=> Валидация недостаточной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация недостаточной суммы")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepaymentByCurrentAccount_validateNotEnoughFund () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77076769290", config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.partialEarlyRepayment_validateAmount("100000");
        });
        Assert.assertEquals("Не хватает средств на счете.", elementsAttributes.getValue(MODAL_NOTIFICATION));
    }

    @Test(description="Частичное досрочное погашение через ЕПВ счет=> Валидация недостаточной суммы", groups = {"automated"})
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

    @Test(description="Частичное досрочное погашение - нет целовое использование займа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация недостаточной суммы")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepayment_validateIntendedUse () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770077702", "12345test");
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

//    @Test(description="Частичное досрочное погашение => аннулировать заявку", groups = {"automated"})
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

    @Test(description="Изменение даты платежа => валидация счетов(ограничения)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация счетов(ограничения)")
    @Severity(SeverityLevel.NORMAL)
    public void changePaymentDate_validateAccounts () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
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

    @Test(description="Переход на жилищный заем => валидация счетов(ограничения)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация счетов(ограничения)")
    @Severity(SeverityLevel.NORMAL)
    public void selectSwitchingToHomeLoan_validateAccount() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77772911272 ", "12345test");
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

    @Test(description="Переход на жилищный заем => валидация договорной суммы(< 50%)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("< 50%")
    @Severity(SeverityLevel.NORMAL)
    public void selectSwitchingToHomeLoan_validateDepositSum() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77770366767", "12345test");
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

    //stop step - request family info
    @Test(description="Замена созаемщика", groups = {"automated"})
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
            loansSteps.replacementOfCoBorrowerOperation();
            loansSteps.replacementOfCoBorrower(config.userIin());
        });
        Assert.assertTrue(false);
    }

    //stop step - request family info
    @Test(description="Исключение созаемщика", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Исключение созаемщика)")
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
        Assert.assertTrue(false);
    }

    //stop step - input document digital code
    @Test(description="Продление договора страхования", groups = {"automated"})
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
                "Ваш залогодатель не зарегестрирован. Зарегистрируйтесь и попробуйте еще раз.",
                elementsAttributes.getValue(MODAL_NOTIFICATION)
        );
    }
}
