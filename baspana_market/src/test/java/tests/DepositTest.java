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
    }

    @Test(description="Открыть депозит", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит")
    @Severity(SeverityLevel.NORMAL)
    public void openDeposit() {
        step("Открыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openDeposit();
        });
        step("Подтвердить открытие депозита", () -> {
            depositSteps.confirmBySms(config.smsCode());
        });
    }

    @Test(description="Открыть депозит. Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - Обратитесь в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenDeposit() {
        step("Открыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openDeposit();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPEN_DEPOSIT_REFUSED, elementsAttributes.getValue(NOTIFICATION_VISIT_THE_BANK)
        );
    }

    @Test(description="Изменить гос.премию текущего депозита. Валидация имеющейся премии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию - Премия пристуствует")
    @Severity(SeverityLevel.NORMAL)
    public void tryChangeGosPrem() {
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.changeGosPrem();
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                "На выбранном депозите уже присутствует государственная премия"
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Расторжение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расторжение депозита")
    @Severity(SeverityLevel.NORMAL)
    public void terminateDeposit() {
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.terminateDeposit();
        });
        Assert.assertTrue(true);
    }


    @Test(description="Создать семейный пакет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void createFamilyPackage() {
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию Создать семейный пакет", () -> {
            depositSteps.selectCreateFamilyPackageOperation();
        });
        step("Создать семейный пакет", () -> {
            depositSteps.createFamilyPackage(config.familyDepositName());
        });
        Assert.assertEquals(config.familyDepositName(), elementsAttributes.getValue(CREATED_FAMILY_PACKAGE_NAME));
    }

    @Test(description="Добавить участника семейного пакета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember() {
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositSteps.addMemberToFamilyPackage(config.clientIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals(config.clientFullName(), elementsAttributes.getValue(ADDED_FAMILY_MEMBER_FIO));
    }

    @Test(description="Калькулятор депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Калькулятор депозита")
    @Severity(SeverityLevel.NORMAL)
    public void calculatorOP() {
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.calculator();
        });
        Assert.assertTrue(true);
    }
}
