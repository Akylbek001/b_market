package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.BecomeClientPage.REFUSE_TEXT;
import static pages.DepositPage.VISIT_BANK_NOTIFICATION;


@Owner("Алибек Акылбеков")
@Feature("Депозиты")
public class DepositTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Открыть депозит", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит")
    @Severity(SeverityLevel.NORMAL)
    public void openDeposit() {
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Октыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openDeposit();
        });
        step("Перейти в меню Депозиты", () -> {
            depositSteps.confirmBySms(config.smsCode());
        });
    }

    @Test(description="Открыть депозит. Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - Обратитесь в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenDeposit() {
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Октыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openDeposit();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPEN_DEPOSIT_REFUSED, elementsAttributes.getValue(VISIT_BANK_NOTIFICATION)
        );
    }

    @Test(description="Изменить гос.премию текущего депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию")
    @Severity(SeverityLevel.NORMAL)
    public void tryChangeGosPremOperation() {
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Перейти в открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.changeGosPrem();
        });
    }

    @Test(description="Калькулятор депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Калькулятор депозита")
    @Severity(SeverityLevel.NORMAL)
    public void calculatorOP() {
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Перейти в открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.calculator();
        });
    }
}
