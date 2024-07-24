package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.DatesUtils;
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

    //нужна учетка
    @Test(description="Открыть депозит <Баспана>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит Баспана")
    @Severity(SeverityLevel.CRITICAL)
    public void openBaspanaDeposit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    "77076769290", config.clientPassword()
            );
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectDepositsMenu();
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        step("Подтвердить открытие депозита", () -> {
//            depositSteps.clearField();
//            depositSteps.agreedSum(config.priceFrom());
            depositSteps.confirmBySms(777777);
            Assert.assertEquals("Депозит успешно открыт", elementsAttributes.getValue(SUCCESS));
        });
        step("Посмотреть открытый депозит", () -> {
            depositSteps.selectFirstDeposit();
            Assert.assertEquals(elementsAttributes.getValue(DEPOSIT_CREATED_DATE), DatesUtils.getCurrentDate());
        });
    }

    @Test(description="Открыть депозит <Баспана> => Валидация договорной суммы <", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит Баспана")
    @Severity(SeverityLevel.CRITICAL)
    public void openBaspanaDeposit_validateAgreedLessSum() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    "77003896225", config.client_for_password_recovery_newPassword()
            );
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectDepositsMenu();
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        step("Подтвердить открытие депозита", () -> {
            depositSteps.agreedSum("800000");
//            depositSteps.confirmBySms(config.smsCode());
//            Assert.assertEquals(CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN,
//                    elementsAttributes.getValue(SUCCESS));
        });
//        Assert.assertEquals(
//                drManager.getDriver().switchTo().alert().getText(),
//                CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN
//        );
//        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Открыть депозит <Баспана> => Валидация договорной суммы >", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит Баспана")
    @Severity(SeverityLevel.CRITICAL)
    public void openBaspanaDeposit_validateAgreedMaxSum() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    "77003896225", config.client_for_password_recovery_newPassword()
            );
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectDepositsMenu();
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        step("Подтвердить открытие депозита", () -> {
            depositSteps.agreedSum("198000000");
//            depositSteps.confirmBySms(config.smsCode());
//            Assert.assertEquals(CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN,
//                    elementsAttributes.getValue(SUCCESS));
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.DEPOSIT_AMOUNT_MUST_BE_BETWEEN
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //Нужна соответствующая учетка
    @Test(description="Открыть депозит <Баспана> => Обратитесь в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - Обратитесь в отделение")
    @Severity(SeverityLevel.CRITICAL)
    public void tryOpenBaspanaDeposit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.clickOpenBaspanaDepositButton();
            depositSteps.openBaspanaDeposit();
        });
        Assert.assertEquals(
                CharacterSetConstants.OPEN_DEPOSIT_REFUSED,
                elementsAttributes.getValue(REFUSED_NOTIFICATION)
        );
    }

    @Test(description="Открыть депозит => Валидация ареста", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - Обратитесь в отделение")
    @Severity(SeverityLevel.CRITICAL)
    public void openDeposit_validate() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        String alertText = drManager.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Запрет открытия счетов"));
        drManager.getDriver().switchTo().alert().accept();
    }

    //Нужна соответствующая учетка
    @Test(description="Открыть образовательный вклад <AQYL>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("AQYL")
    @Severity(SeverityLevel.CRITICAL)
    public void openAqyl() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.openAqyl();
        });
        Assert.assertTrue(true);
    }

    @Test(description="Открыть обр.вклад <AQYL> => Валидация счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - отсутствует текущий счет")
    @Severity(SeverityLevel.CRITICAL)
    public void openAqyl_needAccount() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.openAqyl();
        });
        Assert.assertEquals(
                CharacterSetConstants.NEED_TO_OPEN_CURRENT_ACCOUNT_TEXT,
                elementsAttributes.getValue(REFUSED_NOTIFICATION)
        );
    }

    @Test(description="Открыть обр.вклад <AQYL> => не достаточно средств", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - не достаточно средств")
    @Severity(SeverityLevel.CRITICAL)
    public void openAqyl_insufficientFunds() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.openAqyl();
        });
        Assert.assertEquals(
                CharacterSetConstants.INSUFFICIENT_FOUND_TEXT, elementsAttributes.getValue(REFUSED_NOTIFICATION));
    }

    @Test(description="Открыть обр.вклад <AQYL> => отсутсвует в базе налогового органа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отказ - отсутсвует в базе налогового органа")
    @Severity(SeverityLevel.CRITICAL)
    public void openAqyl__NotInTaxAuthorityDatabase() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Открыть депозит", () -> {
            depositSteps.clickNewDepositButton();
            depositSteps.openAqyl();
        });
        Assert.assertEquals(
                CharacterSetConstants.NOT_IN_TAX_AUTHORITY_DATABASE_TEXT.replace(
                        config.clientInvalidIin(), config.client_for_password_recovery_iin()
                ),
                elementsAttributes.getValue(REFUSED_NOTIFICATION)
        );
    }

    @Test(description="Изменить <гос.премию> текущего депозита => Валидация имеющейся премии", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить гос.премию - Премия пристуствует")
    @Severity(SeverityLevel.CRITICAL)
    public void tryChangeGosPrem() {
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
            loginSteps.auth("77003896225", config.userPass());
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
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
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

    //api or заявка на деление
    //добавить кейс - невозможно расторгнуть если > million
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
        step("Присвоить гос.премию", () -> {
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
            depositSteps.changeDepositConditions("3700000", config.smsCode());
        });
        Assert.assertEquals(CharacterSetConstants.DEPOSIT_CONDITIONS_CHANGED_SUCCESSFULLY_TEXT,
                elementsAttributes.getValue(OPERATION_COMPLETED_SUCCESSFULLY)
        );
    }

    @Test(description="Создать семейный пакет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void createFamilyPackage() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
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
            depositSteps.createFamilyPackage(config.familyDepositName());
        });
        Assert.assertEquals(config.familyDepositName(), elementsAttributes.getValue(CREATED_FAMILY_PACKAGE_NAME));
    }

    @Test(description="Добавить участника семейного пакета => Валидация степени родства", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация степени родства")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddMember_WithoutSelectRelationDegree() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
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

    @Test(description="Добавить участника семейного пакета => Валидация ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void tryAddFamilyPackageMember_WithInvalidIin() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
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
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
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

    //добавить кейс проверить связку иин и аль кода добавляемого клиента
    @Test(description="Добавить участника семейного пакета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить участника")
    @Severity(SeverityLevel.NORMAL)
    public void addFamilyPackageMember() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
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
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth("77770366767", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить учестника", () -> {
            depositSteps.removeFamilyPackageMember();
        });
    } //добавить проверку

    @Test(description="Расформировать семейный пакет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расформировать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void disbandFamilyPackage() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Удалить семейный пакет", () -> {
            depositSteps.disbandFamilyPackage();
        });
    } //добавить проверку

    @Test(description="Деление депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Деление депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision() {
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
            loginSteps.auth(config.userLogin(), config.userPass());
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
            loginSteps.auth(config.userLogin(), config.userPass());
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

    @Test(description="Объединение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling() {
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
            depositSteps.selectAssignmentGratuitousOperation(config.clientIin(), config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            depositSteps.confirmByOtp(config.smsCode());
        });
    }
    //implement other side accept

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
