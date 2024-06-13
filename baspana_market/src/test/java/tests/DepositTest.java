package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;


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
    @Severity(SeverityLevel.MINOR)
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
            depositSteps.openDeposit(config.smsCode());
        });
    }

    @Test(description="Изменить гос.премию текущего депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию")
    @Severity(SeverityLevel.MINOR)
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
    @Severity(SeverityLevel.MINOR)
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
