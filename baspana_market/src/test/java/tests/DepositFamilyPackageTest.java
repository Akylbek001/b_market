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

@Owner("Алибек Акылбеков")
@Feature("Депозиты => Семейный пакет")
public class DepositFamilyPackageTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Создать семейный пакет", groups = {"automated"}, priority = 0)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void createFamilyPackage() {
        step("Авторизация -> Перейти в раздел <Депозиты>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Создать семейный пакет>", () -> {
            depositSteps.selectCreateFamilyPackageOperation_();
        });
        step("Создать семейный пакет", () -> {
            depositFamilyPackageSteps.createFamilyPackage(config.familyDepositName());
        });
        Assert.assertEquals(
                "Семейный пакет успешно создан", elementsAttributes.getValue(FAMILY_PACKAGE_CREATED_TEXT)
        );
        depositFamilyPackageSteps.clickNavigateToCreatedFamilyPackageButton();
        Assert.assertEquals(config.familyDepositName(), elementsAttributes.getValue(CREATED_FAMILY_PACKAGE_NAME));
    }

    @Test(description="Добавить участника семейного пакета => Валидация степени родства", groups = {"automated"}, priority = 1)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация степени родства")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddMember_withoutSelectRelationDegree() {
        step("Авторизация -> <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage_validateRelationDegree(
                    config.clientAlternativeCode(), config.clientInvalidIin()
            );
        });
        Assert.assertEquals(
                "Выберите степень родства", elementsAttributes.getValue(RELATION_DEGREE_NOT_SELECTED)
        );
    }

    @Test(description="Добавить участника семейного пакета => Валидация ИИН", groups = {"automated"}, priority = 2)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_withInvalidIin() {
        step("Авторизация -> <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(
                    config.clientAlternativeCode(), config.clientInvalidIin()
            );
        });
        Assert.assertEquals(elementsAttributes.getValue(INVALID_IIN), CharacterSetConstants.INVALID_INVITED_MEMBER_IIN);
    }

    @Test(description="Добавить участника семейного пакета => Валидация альт.кода", groups = {"automated"}, priority = 3)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация альт.кода")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_withInvalidAltCode() {
        step("Авторизация -> <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage("191014670511", config.clientIin());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(INVALID_ALT_CODE),
                CharacterSetConstants.INVALID_INVITED_MEMBER_ALTERNATIVE_CODE
        );
    }

    @Test(description="Добавить участника семейного пакета", groups = {"automated"}, priority = 4)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить участника")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember() {
        step("Авторизация -> <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(
                    config.clientAlternativeCode(), config.clientIin()
            );
        });
        step("Нажать кнопку <Добавить участника>", () -> {
            depositFamilyPackageSteps.clickAddMemberButton_();
        });
        Assert.assertEquals(
                CharacterSetConstants.REQUEST_SENT_NOTIFICATION, elementsAttributes.getValue(REQUEST_HAS_BEEN_SENT)
        );
        step("Перейти в раздел <Семейный пакет>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        Assert.assertEquals(
                "Ожидание ответа...", elementsAttributes.getValue(INVITED_MEMBER_STATUS)
        );
    }

    @Test(description="Добавить участника семейного пакета => Депозит уже добавлен или приглашен", groups = {"automated"}, priority = 5)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация степени родства")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddMember_requestAlreadySent() {
        step("Авторизация -> <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(
                    config.clientAlternativeCode(), config.clientIin()
            );
        });
        step("Нажать кнопку <Добавить участника>", () -> {
            depositFamilyPackageSteps.clickAddMemberButton_();
        });
        Assert.assertEquals(
                CharacterSetConstants.CLIENT_ALREADY_ADDED_TO_THIS_FAMILY_PACKAGE,
                elementsAttributes.getValue(DEPOSIT_ALREADY_ADDED_OR_REQUEST_SENT)
        );
    }

    @Test(description="Отказ добавления к семейному пакету", groups = {"automated"}, priority = 6)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Согласие на добавление в семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void cancelAddingDepositToFamilyPackage() {
        step("Авторизация -> Перейти в раздел <Депозиты>", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Отказать от добавления в Семейный пакет", () -> {
            depositFamilyPackageSteps.clickRejectInvitationButton();
        });
        Assert.assertTrue(elementsAttributes.getValue(REQUEST_REJECTED_NOTIFICATION).contains("Запрос отклонен"));
    }

    @Test(description="Повторное добавление участника семейного пакета", groups = {"automated"}, priority = 7)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить участника")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember_afterRefusingFromMember() {
        step("Авторизация -> Перейти в раздел <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Добавить учестника", () -> {
            depositFamilyPackageSteps.addMemberToFamilyPackage(
                    config.clientAlternativeCode(), config.clientIin()
            );
        });
        step("Нажать кнопку <Добавить участника>", () -> {
            depositFamilyPackageSteps.clickAddMemberButton_();
        });
        Assert.assertEquals(
                CharacterSetConstants.REQUEST_SENT_NOTIFICATION, elementsAttributes.getValue(REQUEST_HAS_BEEN_SENT)
        );
    }

    @Test(description="Согласие на добавление в семейный пакет", groups = {"automated"}, priority = 8)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Согласие на добавление в семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void confirmAddingDepositToFamilyPackage() {
        step("Авторизация -> Перейти в раздел <Депозиты>", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Согалсие на добавление в Семейный пакет", () -> {
            depositFamilyPackageSteps.clickAcceptInvitationButton(config.smsCode());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(REQUEST_ACCEPTED_NOTIFICATION),
                "Ваш депозит добавлен в семейный пакет");
    }

    @Test(description="Проверить что участник добавился к семейному пакету", groups = {"automated"}, priority = 9)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Проверить что участник добавился к семейному пакету")
    @Severity(SeverityLevel.NORMAL)
    public void checkMemberAddedToFamilyPackage() {
        step("Авторизация -> Перейти в раздел <Семейный пакет>", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        Assert.assertEquals(
                CharacterSetConstants.REQUEST_SENT_NOTIFICATION, elementsAttributes.getValue(REQUEST_HAS_BEEN_SENT)
        );
    }

    @Test(description="Удалить участника семейного пакета", groups = {"automated"}, priority = 10)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Удалить участника")
    @Severity(SeverityLevel.NORMAL)
    public void removeFamilyPackageMember() {
        step("Авторизация -> Перейти в раздел <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Удалить участника", () -> {
            depositFamilyPackageSteps.removeFamilyPackageMember();
        });
        Assert.assertFalse(false, CANCEL_INVITE_ICON.toString());
    }

    @Test(description="Присвоить гос.премию семейному пакету", groups = {"automated"}, priority = 11)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию - Премия пристуствует")
    @Severity(SeverityLevel.CRITICAL)
    public void tryChangeGosPrem() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
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

    @Test(description="Расформировать семейный пакет", groups = {"automated"}, priority = 12)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расформировать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void disbandFamilyPackage() {
        step("Авторизация -> Перейти в раздел <Семейный пакет>", () -> {
            loginSteps.auth("77476230252", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("PackageFamily"));
        });
        step("Удалить семейный пакет", () -> {
            depositFamilyPackageSteps.disbandFamilyPackage();
        });
        Assert.assertEquals(
                "Семейный пакет расформирован", elementsAttributes.getValue(FAMILY_PACKAGE_DISBANDED)
        );
    }
}
