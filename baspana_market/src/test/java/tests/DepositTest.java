package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static common.consts.CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN;
import static io.qameta.allure.Allure.step;
import static pages.DepositPage.*;

@Owner("Алибек Акылбеков")
@Feature("Депозиты")
public class DepositTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Изменить <гос.премию> текущего депозита => Валидация имеющейся премии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию - Премия пристуствует")
    @Severity(SeverityLevel.CRITICAL)
    public void tryChangeGosPrem() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77003896225", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.changeGosPrem_validation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.GOS_PREM_ALREADY_EXIST_TEXT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Присвоить гос.премию", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Присвоить гос.премию")
    @Severity(SeverityLevel.CRITICAL)
    public void changeGosPrem() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77003896225", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectSecondDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.changeGosPrem(config.smsCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.GOS_PREM_SUCCESSFULLY_ADDED, elementsAttributes.getValue(FINAL_TEXT)
        );
    }

    @Test(description="Расторжение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расторжение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77083007217", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectSecondDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Расторгнуть", () -> {
            depositSteps.terminateDeposit();
        });
        Assert.assertEquals(
                CharacterSetConstants.REQUEST_ACCEPTED_TEXT,
                elementsAttributes.getValue(TERMINATE_DEPOSIT_REQUEST_ACCEPTED)
        );
    }

    @Test(description="Расторжение депозита => Валидация суммы депозита > 1000000", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ-Сумма депозита > 1000000")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit_validateExceedsPermissibleLimit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77775657007", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Расторгнуть", () -> {
            depositSteps.terminateDeposit();
        });
        String alertText = drManager.getDriver().switchTo().alert().getText();
        Assert.assertEquals(
                alertText,
                CharacterSetConstants.EXCEEDS_PERMISSIBLE_LIMIT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //api or заявка на деление
    @Test(description="Расторжение депозита => Валидация актуальной заявки на деление", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ-Валидация актуальной заявки на деление")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit_validateActiveOrderForDivision() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Расторгнуть", () -> {
            depositSteps.terminateDeposit();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.ACTIVE_ORDER_FOR_DIVISION_MESSAGE
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    // добавить кейс - изменить срок депозита
    // добавить кейс указав сумму в рамках условии
    @Test(description="Изменить условия депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить условия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsAmount("3700000");
        });
        step("Подтвердить изменение условия депозита", () -> {
            depositSteps.confirmDepositConditionsChange(config.smsCode());
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_CONDITIONS_CHANGED_SUCCESSFULLY_TEXT,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Изменить условия депозита => Проврека изменения суммы ежемесечного взноса", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить условия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateContributionAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77754502772", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsAmount("9000000");
            JavascriptExecutor js = (JavascriptExecutor) drManager.getDriver();
            js.executeScript("setAttribute('style', 'left: 16.6667%;')", HOUSING_LOAN_TERM);
        });
        Assert.assertEquals("18 902 ₸", elementsAttributes.getValue(NEW_DEPOSIT_MONTH_PAY));
    }

    @Test(description="Изменить условия депозита => Валидация договорной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить условия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateNegotiatedAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77754502772", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsAmount("900000");
        });
        Assert.assertEquals(
                CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN,
                elementsAttributes.getValue(NEGOTIATED_AMOUNT_VALIDATION_TEXT)
        );
    }

    @Test(description="Деление депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Деление депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77016677419", config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Деление депозита", () -> {
            depositSteps.selectDepositDivisionOperation();
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_DIVISION_ACCEPTED,
                elementsAttributes.getValue(DIVIDE_DEPOSIT_ACCEPTED)
        );
    }

    @Test(description="Деление депозита => Валидация отсутствия текущего счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация отсутствия текущего счета")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateNoCurrentAccount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77772647557", config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Деление депозита", () -> {
            depositSteps.selectDepositDivisionOperation();
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_DIVISION_NEED_TO_OPEN_ACCOUNT_VALIDATION,
                elementsAttributes.getValue(DIVIDE_NO_ACCOUNT_VALIDATION)
        );
    }

    @Test(description="Деление депозита => Валидация суммы накопления", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы накопления")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateSavingAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77752815134", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Деление депозита", () -> {
            depositSteps.selectDepositDivisionOperation();
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_DIVISION_SAVING_AMOUNT_VALIDATION,
                elementsAttributes.getValue(DIVIDE_SAVING_AMOUNT_VALIDATION)
        );
    }

    @Test(description="Деление депозита => Валидация договорной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы накопления")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateNegotiatedAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Деление депозита", () -> {
            depositSteps.selectDepositDivisionOperation();
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_DIVISION_NEGOTIATION_AMOUNT,
                elementsAttributes.getValue(DIVIDE_SAVING_AMOUNT_VALIDATION)
        );
    }
    //предварительно добавить еще один депозит
    @Test(description="Объединение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77083007217", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Объединение депозита>", () -> {
            depositSteps.selectUniteDepositOperation();
        });
        step("Объединение депозита", () -> {
            depositSteps.uniteDeposits(config.smsCode());
        });
        Assert.assertEquals(CharacterSetConstants.OPERATION_FINISHED_SUCCESSFULLY_NOTIFICATION,
                elementsAttributes.getValue(OPERATION_FINISHED_SUCCESSFULLY)
        );
    }

    //предварительно добавить еще один депозит
    @Test(description="Объединение депозита => Валидация ОТП", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling_otpValidation() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77083007217", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Объединение депозита>", () -> {
            depositSteps.selectUniteDepositOperation();
        });
        step("Объединение депозита", () -> {
            depositSteps.depositPolling_otpValidation(config.smsCode());
        });
        Assert.assertEquals("Введенный вами код из СМС неправильный.", elementsAttributes.getValue(INVALID_OTP));
    }


    @Test(description="Объединение депозита => Валидация наличия всего одного депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита-валидация кол-ва депозитов")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling_validateDepositQuantity() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Объединение депозита", () -> {
            depositSteps.selectUniteDepositOperation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.ONLY_ONE_DEPOSIT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //BUG-implement other side accept
    @Test(description="Уступка безвозмездная", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Уступка безвозмездная")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentGratuitous() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Уступка безвозмездная", () -> {
            depositSteps.assignmentGratuitousOperation(config.clientIin(), config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            depositSteps.confirmByOtp(config.smsCode());
        });
    }

    @Test(description="Уступка безвозмездная => Валидация суммы накопления", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Уступка безвозмездная")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentGratuitous_validateSavingAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77083007217", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Уступка безвозмездная", () -> {
            depositSteps.selectAssignmentGratuitousOperation();
        });
        Assert.assertEquals(CharacterSetConstants.ASSIGNMENT_GRATUITOUS_SAVING_AMOUNT_VALIDATION,
                elementsAttributes.getValue(ASSIGNMENT_GRATUITOUS_AMOUNT_VALIDATION)
        );
    }

    @Test(description="Калькулятор депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Калькулятор депозита")
    @Severity(SeverityLevel.NORMAL)
    public void calculatorOP() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.calculator();
        });
        Assert.assertTrue(true);
    }
}
