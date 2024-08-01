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
import static pages.SpecAccountPage.TRANSFER_DETAILS;
import static pages.SpecAccountSgoPage.*;

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

    @Test(description = "Перевод на аренду(ФЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forIndividual_withoutContractNumber () {
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
            specAccountSteps.inputSumToTransfer_forIndividual("77");
            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на аренду(ФЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forIndividual_withContractNumber () {
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
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    //BUG - нет проверки на валидность ИИН
    @Test(description = "Перевод на аренду(ФЛ) => валидация ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forIndividual_validateIin () {
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
            specAccountSteps.inputIin_validation("960327300188");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IIN_ERROR),
                "Проверьте корректность ИИН"
        );
    }

    @Test(description = "Перевод на аренду(ФЛ) => валидация IBAN отбасы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forIndividual_validateIbanOtbasy () {
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
            specAccountSteps.inputIban_validation("KZ649729722204F0Z3LP");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IBAN_ERROR),
                "Вы ввели некорректный IBAN счет!"
        );
    }

    @Test(description = "Перевод на аренду(ЮЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forRE_withoutContractNumber () {
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
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forRE_withContractNumber () {
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
            specAccountSteps.indicateSign_withContractNumber_re(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("77");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на аренду(ЮЛ) => валидация БИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация БИН")
    @Severity(SeverityLevel.NORMAL)
    public void transferToRent_forRE_validateBin () {
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
            specAccountSteps.inputBin_validation(config.clientIin());

        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(BIN_ERROR),
                "Ошибка при получении информации об организации по БИН"
        );
    }

    @Test(description = "Погашение займа в другом банке(ФЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_forIndividual_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToMortgageOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientIban(config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Погашение займа в другом банке(ФЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_forIndividual_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToMortgageOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientIban(config.clientIban().substring(2));
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("77");
            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Погашение займа в другом банке(ЮЛ) => без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_forRE_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToMortgageOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Погашение займа в другом банке(ЮЛ) => с номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToOtherBank_forRE_withContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSteps.transferToMortgageOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber_re(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("77");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }
}
