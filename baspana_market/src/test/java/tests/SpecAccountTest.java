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
import static pages.SpecAccountPage.ERROR_TEXT;

@Owner("Алибек Акылбеков")
@Feature("Спец.счет")
public class SpecAccountTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Перевод на депозит", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToDeposit () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToDepositOperation();
        });
        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Валидация отсутствия депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отсутствует депозит для перевода")
    @Severity(SeverityLevel.NORMAL)
    public void transferToDeposit_validateDeposit () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Добавить email", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToDepositOperation();
        });
        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

//Перевод на аренду
    @Test(description = "Перевод на аренду(ФЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_ForIndividual_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("777");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ФЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_ForIndividual_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("555");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_ForRE_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("777");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_ForRE_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("555");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }


//Погашение займа в другом банке
    @Test(description = "Перевод на аренду(ФЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_ForIndividual_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientIban(config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("777");
            specAccountSteps.acceptAgreementAndTransfer();
        });
    //        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ФЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_ForIndividual_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientIban(config.clientIban().substring(2));
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("555");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_ForRE_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE(config.clientIin(), config.clientIban());
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("777");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_ForRE_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.selectTransferToRentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE(config.clientIin(), config.clientIban());
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("555");
            specAccountSteps.acceptAgreementAndTransfer();
        });
//        Assert.assertEquals(CharacterSetConstants.NO_DEPOSIT, elementsAttributes.getValue(ERROR_TEXT));
    }
}
