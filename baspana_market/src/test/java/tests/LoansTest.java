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
        step("Авторизация -> Запись в отдление", () -> {
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
        step("Авторизация -> Запись в отдление", () -> {
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

    @Test(description="Частичное досрочное погашение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepayment () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation();
            loansSteps.partialEarlyRepayment("124000");
        });
    }

    @Test(description="Частичное досрочное погашение - нет целовое использование займа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepayment_validateIntendedUse () {
        step("Авторизация -> Запись в отдление", () -> {
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
//        step("Авторизация -> Запись в отдление", () -> {
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
        step("Авторизация -> Запись в отдление", () -> {
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
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth("77016677419", "12345test");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectSwitchingToHomeLoanOperation();
        });
        Assert.assertEquals(
                CharacterSetConstants.DENIED_RESTRICTION_ON_ACCOUNTS,
                elementsAttributes.getValue(SWITCHING_TO_HOME_LOAN_ACCOUNT_VALIDATION)
        );
    }

    @Test(description="Переход на жилищный заем => валидация договорной суммы(< 50%)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("< 50%")
    @Severity(SeverityLevel.NORMAL)
    public void selectSwitchingToHomeLoan_validateDepositSum() {
        step("Авторизация -> Запись в отдление", () -> {
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
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth("77016360731", "12345test");
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
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth("77016360731", "12345test");
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
        step("Авторизация -> Запись в отдление", () -> {
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

    @Test(description="Замена залога", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Замена залога")
    @Severity(SeverityLevel.NORMAL)
    public void changeCollateral_validateRegistration () {
        step("Авторизация -> Запись в отдление", () -> {
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
                "Ваш залогодатель не зарегестрирован. Зарегистрируйтесь и попробуйте еще e.",
                elementsAttributes.getValue(NOTIFICATION_OF_REGISTRATION)
        );
    }
}
