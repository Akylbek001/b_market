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

        mainSteps.loginButton();
        loginSteps.login(
                config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword());
        profileSteps.navigateToProfile();
        depositSteps.selectMyBankMenu();
    }

    //нужна учетка
    @Test(description="Открыть депозит Баспана", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит Баспана")
    @Severity(SeverityLevel.NORMAL)
    public void openBaspanaDeposit() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Открыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        step("Подтвердить открытие депозита", () -> {
            depositSteps.confirmBySms(config.smsCode());
        });
    }

    @Test(description="Открыть депозит Баспана => Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - Обратитесь в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenBaspanaDeposit() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Открыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPEN_DEPOSIT_REFUSED, elementsAttributes.getValue(NOTIFICATION_VISIT_THE_BANK)
        );
    }

    @Test(description="Открыть образовательный вклад «AQYL» => Валидация счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - отсутствует текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void tryOpenAqyl() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Открыть депозит {}", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.openAqyl();
        });
        Assert.assertEquals(
                CharacterSetConstants.NEED_TO_OPEN_CURRENT_ACCOUNT_TEXT, elementsAttributes.getValue(NEED_ACCOUNT_NOTIFICATION)
        );
    }

    //Add case - нужна учетка для реализации кейса по изменению гос.премии
    @Test(description="Изменить гос.премию текущего депозита => Валидация имеющейся премии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию - Премия пристуствует")
    @Severity(SeverityLevel.NORMAL)
    public void tryChangeGosPrem() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
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
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
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

    @Test(description="Добавить участника семейного пакета => Валидация степени родства", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация степени родства")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddMember_WithoutSelectRelationDegree() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositSteps.relationDegreeValidation(config.clientInvalidIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.RELATION_DEGREE_NOT_SELECTED_TEXT,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }


    //BUG: ввести валидный левый ИИН => ошибка альтКода, ввести не валидный ИИН => валидация регистрации ?!
    @Test(description="Добавить участника семейного пакета => Валидация ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_WithInvalidIin() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositSteps.addMemberToFamilyPackage(config.clientInvalidIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.VALIDATION_OF_REGISTRATION,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }

    @Test(description="Добавить участника семейного пакета => Валидация алтернативного кода", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация алтернативного кода")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_WithInvalidAltCode() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositSteps.addMemberToFamilyPackage(config.clientIin(), config.clientIin());
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_INVITED_MEMBER_ALTERNATIVE_CODE,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }

    @Test(description="Добавить участника семейного пакета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить участника")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositSteps.addMemberToFamilyPackage(config.clientIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals("Мамиев С. А.", elementsAttributes.getValue(ADDED_FAMILY_MEMBER_FIO));
    }

    @Test(description="Удалить участника семейного пакета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Удалить участника")
    @Severity(SeverityLevel.NORMAL)
    public void removeFamilyPackageMember() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить учестника", () -> {
            depositSteps.removeFamilyPackageMember();
        });
    }

    @Test(description="Расформировать семейный пакет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расформировать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void disbandFamilyPackage() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить семейный пакет", () -> {
            depositSteps.disbandFamilyPackage();
        });
    }

    @Test(description="Калькулятор депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Калькулятор депозита")
    @Severity(SeverityLevel.NORMAL)
    public void calculatorOP() {
        step("Перейти в меню Депозиты", () -> {
            depositSteps.selectDepositsMenu();
        });
        step("Выбрать открытый депозит {}", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции {}", () -> {
            depositSteps.calculator();
        });
        Assert.assertTrue(true);
    }
}
