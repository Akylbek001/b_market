package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.DepositFamilyPackagePage.*;
import static pages.DepositPage.MY_DEPOSIT_LABEL;

@Owner("Алибек Акылбеков")
@Feature("Депозиты => Семейный пакет")
public class DepositFamilyPackageTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        loginSteps.auth("77770366767", config.clientPassword());
        brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
    }

    @Test(description="Создать семейный пакет", groups = {"automated"}, priority = 0)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void createFamilyPackage() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Создать семейный пакет>", () -> {
            depositSteps.selectCreateFamilyPackageOperation();
        });
        step("Создать семейный пакет", () -> {
            depositFamilyPackageSteps.createFamilyPackage(config.familyDepositName());
        });
        Assert.assertEquals(config.familyDepositName(), elementsAttributes.getValue(CREATED_FAMILY_PACKAGE_NAME));
    }

    @Test(description="Добавить участника семейного пакета => Валидация степени родства", groups = {"automated"}, priority = 1)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация степени родства")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddMember_WithoutSelectRelationDegree() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.relationDegreeValidation(config.clientInvalidIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.RELATION_DEGREE_NOT_SELECTED_TEXT,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }

    @Test(description="Добавить участника семейного пакета => Валидация ИИН", groups = {"automated"}, priority = 2)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_WithInvalidIin() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(config.clientInvalidIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals(
                CharacterSetConstants.VALIDATION_OF_REGISTRATION,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }

    @Test(description="Добавить участника семейного пакета => Валидация алтернативного кода", groups = {"automated"}, priority = 3)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация алтернативного кода")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_WithInvalidAltCode() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(config.clientIin(), config.clientIin());
        });
        Assert.assertEquals(
                CharacterSetConstants.INVALID_INVITED_MEMBER_ALTERNATIVE_CODE,
                elementsAttributes.getValue(INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION)
        );
    }

    //добавить кейс проверить связку иин и аль кода добавляемого клиента
    @Test(description="Добавить участника семейного пакета", groups = {"automated"}, priority = 4)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить участника")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(config.clientIin(), config.clientAlternativeCode());
        });
        Assert.assertEquals("Мамиев С. А.", elementsAttributes.getValue(ADDED_FAMILY_MEMBER_FIO));
    }

    @Test(description="Удалить участника семейного пакета", groups = {"automated"}, priority = 5)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Удалить участника")
    @Severity(SeverityLevel.NORMAL)
    public void removeFamilyPackageMember() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить учестника", () -> {
            depositFamilyPackageSteps.removeFamilyPackageMember();
        });
        Assert.assertFalse(false, CANCEL_INVITE_ICON.toString());
    }


    @Test(description="Расформировать семейный пакет", groups = {"automated"}, priority = 6)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расформировать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void disbandFamilyPackage() {
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить семейный пакет", () -> {
            depositFamilyPackageSteps.disbandFamilyPackage();
        });
        Assert.assertTrue(elementsAttributes.isVisible(MAIN_DEPOSIT_AMOUNT));
    }
}
