package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import static pages.DepositAssignmentGratuitousPage.*;

@Owner("Алибек Акылбеков")
@Feature("Уступка безвозмездная")
public class DepositAssignmentGratuitousTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Заявка на уступку прав и обязательств", groups = {"automated"}, priority = 0)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Уступка безвозмездная")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentGratuitous() {
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
        step("Выбрать операцию <Уступка безвозмездная>", () -> {
            depositSteps.selectAssignmentGratuitousOperation();
        });
        step("Уступка безвозмездная", () -> {
            depositAssignmentGratuitousStep.assignmentGratuitousOperation("890602300680");
            generalSteps.acceptAgreement_startBiometry();
            depositAssignmentGratuitousStep.confirmByOtp(config.smsCode());
        });
        elementsAttributes.waitUntilVisible(WAITING_FOR_SINGING_STATUS);
        Assert.assertEquals(elementsAttributes.getValue(WAITING_FOR_SINGING_STATUS), "Ожидание подписания");
    }

    @Test(description="Уступка безвозмездная => Отклонить запрос на подписание", groups = {"automated"}, priority = 1)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отклонить запрос на подписание")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentFromInvitedMEmber_reject() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77026091989", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Перейти к запросу", () -> {
            depositAssignmentGratuitousStep.navigateToRequestForSign();
        });
        step("Отклонить запрос", () -> {
            depositAssignmentGratuitousStep.rejectRequest();
        });
        Assert.assertEquals(elementsAttributes.getValue(REJECTED_NOTIFICATION), "Операция отменена");
    }

    @Test(description="Уступка безвозмездная => Подача заявки на присоединения(повторная заявка)", groups = {"automated"}, priority = 2)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Уступка безвозмездная(повторная заявка)")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentGratuitous_afterReject() {
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
        step("Выбрать операцию <Уступка безвозмездная>", () -> {
            depositSteps.selectAssignmentGratuitousOperation();
        });
        step("Уступка безвозмездная", () -> {
            depositAssignmentGratuitousStep.assignmentGratuitousOperation("890602300680");
            generalSteps.acceptAgreement_startBiometry();
            depositAssignmentGratuitousStep.confirmByOtp(config.smsCode());
        });
        elementsAttributes.waitUntilVisible(WAITING_FOR_SINGING_STATUS);
        Assert.assertEquals(elementsAttributes.getValue(WAITING_FOR_SINGING_STATUS), "Ожидание подписания");
    }

    @Test(description="Уступка безвозмездная => Принять запрос на подписание", groups = {"automated"}, priority = 3)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Принять запрос на подписание")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentFromInvitedMEmber_accept() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77026091989", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Перейти к запросу", () -> {
            depositAssignmentGratuitousStep.navigateToRequestForSign();
        });
        step("Принять запрос", () -> {
            depositAssignmentGratuitousStep.acceptRequest();
        });
        step("ОТП", () -> {
            depositAssignmentGratuitousStep.confirmByOTP(config.smsCode());
        });
        elementsAttributes.waitUntilVisible(ACCEPTED_NOTIFICATION);
        Assert.assertEquals(
                elementsAttributes.getValue(ACCEPTED_NOTIFICATION), "Родственная связь подтверждена"
        );
    }

    @Test(description="Уступка безвозмездная => Подача заявки - продолжение после подписания второй стороной", groups = {"automated"}, priority = 4)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Принять запрос на подписание")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentGratuitous_continue() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77763032332", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Перейти к запросу", () -> {
            depositAssignmentGratuitousStep.navigateToRequestForSign();
        });
        step("Обработка запроса", () -> {
            depositAssignmentGratuitousStep.assignmentGratuitous_continue();
        });
        step("ОТП", () -> {
            depositAssignmentGratuitousStep.confirmByOTP(config.smsCode());
        });
        elementsAttributes.waitUntilVisible(WAITING_FOR_SINGING_STATUS);
        Assert.assertEquals(elementsAttributes.getValue(WAITING_FOR_SINGING_STATUS), "Ожидание подписания");
    }

    @Test(description="Уступка безвозмездная => Принять запрос на подписание - финальный этап", groups = {"automated"}, priority = 5)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Принять запрос на подписание")
    @Severity(SeverityLevel.CRITICAL)
    public void assignmentFromInvitedMEmber_finalAcceptStep() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77026091989", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Перейти к запросу", () -> {
            depositAssignmentGratuitousStep.navigateToRequestForSign();
        });
        step("Принять запрос", () -> {
            depositAssignmentGratuitousStep.fifthSignStep();
        });
        step("ОТП", () -> {
            depositAssignmentGratuitousStep.confirmByOTP(config.smsCode());
        });
        elementsAttributes.waitUntilVisible(FINAL_STATUS);
        Assert.assertEquals(
                elementsAttributes.getValue(FINAL_STATUS),
                CharacterSetConstants.OPERATION_FINISHED_SUCCESSFULLY_NOTIFICATION
        );
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
}
