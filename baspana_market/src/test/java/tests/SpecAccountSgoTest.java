package tests;

import base.BaseTest;
import common.utils.DatesUtils;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.MainPage.SALDO;
import static pages.SpecAccountPage.TRANSFER_DETAILS;
import static pages.SpecAccountSgoPage.CURRENT_ACC_BALANCE_VALIDATION;

@Owner("Алибек Акылбеков")
@Feature("Спец.счет c СГО")
public class SpecAccountSgoTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Полный расчет в Otbasy Bank => по номеру телефона с контарактом", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77073650565", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.inputPhone(config.clientLogin().substring(1));
            specAccountSgoSteps.inputTransferData("00-019", DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("50");
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    //BUG - добавить обязательность полей(номер договора)
    @Test(description = "Полный расчет в Otbasy Bank => по номеру телефона без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77073650565", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.inputPhone(config.clientLogin().substring(1));
            specAccountSgoSteps.inputTransferData_withoutContract(DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("77");
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Полный расчет в Otbasy Bank => по альт коду с контарактом", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77073650565", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.inputAltCode(config.clientAlternativeCode());
            specAccountSgoSteps.inputTransferData("00-019", DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("50");
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Полный расчет в Otbasy Bank => по альт коду без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77073650565", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.inputAltCode(config.clientAlternativeCode());
            specAccountSgoSteps.inputTransferData_withoutContract(DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("77");
            specAccountSteps.confirmTransferOnModal();
            generalSteps.confirmationByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ) = валидации суммы текущего счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_validateCurrentAccBalance () {
        step("Авторизация", () -> {
            loginSteps.auth("77073650565", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSteps.acceptAgreementAndTransfer_forValidate();
        });
        Assert.assertEquals("На текущем счете недостаточно средств!",
                elementsAttributes.getValue(CURRENT_ACC_BALANCE_VALIDATION)
        );
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ)", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption () {
        step("Авторизация", () -> {
            loginSteps.auth("77022636672", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSteps.confirmTransferOnModal();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ) =>без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth("77022636672", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(config.clientIin(), config.clientIban().substring(2));
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("77");
            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());

        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }
}
