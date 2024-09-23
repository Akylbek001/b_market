package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test(description="Расторжение депозита", groups = {"automated"}, priority = 0)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расторжение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77077204839", config.clientPassword());
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
                CharacterSetConstants.REQUEST_ACCEPTED_TEXT,
                elementsAttributes.getValue(TERMINATE_DEPOSIT_REQUEST_ACCEPTED)
        );
    }

    @Test(description="Расторжение депозита => Валидация актуальной заявки на расторжение", groups = {"automated"}, priority = 1)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ-Валидация актуальной заявки на расторжение")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit_validateActiveOrderForTerminate() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77077204839", config.clientPassword());
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
                CharacterSetConstants.ACTIVE_ORDER_FOR_TERMINATE_MESSAGE
        );
        drManager.getDriver().switchTo().alert().accept();
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

    @Test(description="Изменить условия депозита", groups = {"automated"}, priority = 4)
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
            depositSteps.changeDepositConditionsAmount("55000000");
        });
        step("Подтвердить изменение условия депозита", () -> {
            depositSteps.confirmDepositConditionsChange();
            depositSteps.signByOtp(config.smsCode());
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_CONDITIONS_CHANGED_SUCCESSFULLY_TEXT,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Изменить условия депозита=> Измените дог.сумму или дату заверешения депозита ",
                    groups = {"automated"}, priority = 5)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить условия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateSumOrEndDateOfDeposit() {
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
            depositSteps.changeDepositConditionsAmount("55000000");
        });
        step("Подтвердить изменение условия депозита", () -> {
            depositSteps.confirmDepositConditionsChange();
        });
        WaitUtils.wait(4);
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.CHANGE_END_DATE_OR_SUM
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменить условия депозита => Валидация существующей заявки на изменение", groups = {"automated"}, priority = 6)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующей заявки на изменение")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateActiveOrderForChange() {
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
        step("Выбрать операцию изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsOperation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.ACTIVE_ORDER_FOR_CHANGE_CONDITION
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //добавить формулу рассчета рекомендуемого ежемесячного платежа
    @Test(description="Изменить условия депозита => Проврека изменения суммы ежемесечного взноса", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Проврека изменения суммы ежемесечного взноса")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateContributionAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77016108074", config.clientPassword());
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
            depositSteps.clickAmount();
        });
        Assert.assertEquals("24 554 ₸", elementsAttributes.getValue(NEW_DEPOSIT_MONTH_PAY));
    }

    @Test(description="Изменить условия депозита => Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Обратитесь в отделение")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_visitBank() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77777520071", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsOperation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.VISIT_BANK_BRANCH
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Изменить условия депозита => Валидация договорной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация договорной суммы")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateNegotiatedAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77763032332", config.clientPassword());
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
                elementsAttributes.getValue(NEGOTIATED_AMOUNT_VALIDATION_TEXT),
                CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN
        );
    }

    @Test(description="Изменить условия депозита => Валидация привязки к займу", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация привязки к займу")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions_validateDepositTiedToLoan() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77785543870", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditionsOperation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                "Депозит привязан к действующему займу!"
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //need account
    @Test(description="Деление депозита", groups = {"automated"}, priority = 2, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Деление депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77752512222", config.client_for_password_recovery_newPassword());
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

    //need account
    @Test(description="Деление депозита => Валидация актуальной заявки на деление", groups = {"automated"}, priority = 3, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ-Валидация актуальной заявки на деление")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateActiveOrderForDivision() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77074497367", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Расторгнуть", () -> {
            depositSteps.selectDepositDivisionOperation();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.ACTIVE_ORDER_FOR_DIVISION_MESSAGE
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Деление депозита => Валидация депозита Kemel", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация отсутствия текущего счета")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateNoBaspanaDeposit() {
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
        Assert.assertEquals(CharacterSetConstants.ONLY_BASPANA_COULD_BE_DIVIDED,
                elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    @Test(description="Деление депозита => Валидация отсутствия текущего счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация отсутствия текущего счета")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateNoCurrentAccount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.client_for_password_recovery_login(), config.clientPassword());
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

    @Test(description="Деление депозита => Валидация суммы накопления", groups = {"automated"}, enabled = false)
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
                elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    //need special account
    @Test(description="Деление депозита => Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация отсутствия текущего счета")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_visitDepartment() {
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
        Assert.assertEquals(CharacterSetConstants.VISIT_BANK_BRANCH,
                elementsAttributes.getValue(VISIT_BANK_BRANCH_NOTIFICATION)
        );
    }

    //need special account
    @Test(description="Деление депозита => Валидация договорной суммы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы накопления")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision_validateNegotiatedAmount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.client_for_password_recovery_login(), config.clientPassword());
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
                elementsAttributes.getValue(OPERATION_NOT_AVAILABLE)
        );
    }

    //need special account
    //предварительно добавить еще один депозит
    @Test(description="Объединение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77001867334", config.clientPassword());
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

    //need special account
    //предварительно добавить еще один депозит
    @Test(description="Объединение депозита => Валидация ОТП", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling_otpValidation() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77001867334", config.clientPassword());
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
            depositSteps.depositPolling_otpValidation("444444");
        });
        Assert.assertEquals("Введенный вами код из СМС неправильный.", elementsAttributes.getValue(INVALID_OTP));
    }

    @Test(description="Объединение депозита => Валидация наличия всего одного депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита-валидация кол-ва депозитов")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling_validateDepositQuantity() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77777520071", config.clientPassword());
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
            loginSteps.auth("77777520071", config.clientPassword());
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
