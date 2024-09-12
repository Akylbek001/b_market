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
import static pages.AccountPage.*;

import static pages.SpecAccountPage.TRANSFER_DETAILS;
import static pages.SpecAccountSgoPage.*;

@Owner("Алибек Акылбеков")
@Feature("Спец.счет c СГО")
public class SpecAccountSgoTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Полный расчет в Otbasy Bank => По номеру телефона с контарактом", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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
    @Test(description = "Полный расчет в Otbasy Bank => По номеру телефона без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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

    @Test(description = "Полный расчет в Otbasy Bank => По номеру телефона => Клиент не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_validateClient () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.validateClientByPhone("77007010999");
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NOT_FOUND_CHECK_NUMBER,
                elementsAttributes.getValue(NOT_FOUND_BY_NUMBER)
        );
    }

    @Test(description = "Полный расчет в Otbasy Bank => По альт коду с контарактом", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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

    @Test(description = "Полный расчет в Otbasy Bank => По альт коду без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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

    @Test(description = "Полный расчет в Otbasy Bank => По альт коду => Клиент не найден", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Клиент не найден")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_validateClient () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.validateClientByAlt("191014670500");
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_NOT_FOUND_CHECK_CODE,
                elementsAttributes.getValue(NOT_FOUND_BY_CODE)
        );
    }

    @Test(description = "Первоначальный взнос по ипотеке без контракта => Без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToInitialPayment_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать первоначальный взнос по ипотеке", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToInitialPaymentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Первоначальный взнос по ипотеке без контракта => С номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToInitialPayment_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать первоначальный взнос по ипотеке", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToInitialPaymentOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSgoSteps.inputTransferData_withContract(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Первоначальный взнос по ипотеке без контракта => Валидация IBAN", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация IBAN")
    @Severity(SeverityLevel.NORMAL)
    public void transferToInitialPayment_validateIBAN () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать первоначальный взнос по ипотеке", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToInitialPaymentOperation();
        });
        step("Ввести IBAN", () -> {
            specAccountSteps.validateIBAN("KZ649729722204F0Z3LP");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IBAN_ERROR_),
                "Вы ввели некорректный IBAN счет!"
        );
    }

    @Test(description = "Первоначальный взнос по ипотеке без контракта => Валидация BIN", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация BIN")
    @Severity(SeverityLevel.NORMAL)
    public void transferToInitialPayment_validateBIN () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать первоначальный взнос по ипотеке", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToInitialPaymentOperation();
        });
        step("Ввести BIN", () -> {
            specAccountSteps.inputBin_validation("971240001314");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(BIN_ERROR),
                "Ошибка при получении информации об организации по БИН"
        );
    }

    @Test(description="Оплата аренды с последующим выкупом(ФЛ)=Валидации суммы текущего счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидации суммы текущего счета")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_validateCurrentAccBalance () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("600000");
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
    public void transferToPaymentWithRedemption_fl_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSgoSteps.transfer();
//            specAccountSteps.acceptAgreementAndTransfer();
//            specAccountSteps.confirmTransferOnModal();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ) => Без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_withoutContractNumber () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
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
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("77");
            specAccountSgoSteps.transfer();
//            specAccountSteps.acceptAgreementAndTransfer();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ) => валидация ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_validateIin () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
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
            specAccountSteps.inputIin_validation("960327300188");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IIN_ERROR),
                "Проверьте корректность ИИН"
        );
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ) => валидация IBAN отбасы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_validationOtbasyIban () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
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
            specAccountSteps.inputIban_validation("KZ649729722204F0Z3LP");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IBAN_ERROR),
                "Вы ввели некорректный IBAN счет!"
        );
    }

    @Test(description = "Оплата аренды с последующим выкупом(ЮЛ)=> С номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_ul_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
//            specAccountSteps.confirmTransferOnModal();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ЮЛ)=> Недостаточно средств", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы перевода")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_ul_validateSum () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("500500");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
////            specAccountSteps.confirmTransferOnModal();
//            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SUM_TO_TRANSFER_VALIDATE), "Недостаточно средств для перевода"
        );
    }

    @Test(description = "Оплата аренды с последующим выкупом(ФЛ)=> Без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_ul_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber_sgo(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("77");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Оплата аренды с последующим выкупом(ЮЛ) => валидация БИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPaymentWithRedemption_validateBin () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPaymentWithRedemptionOperation();
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

    @Test(description = "Перевод на покупку жилья(ФЛ) => С номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_fl_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSgoSteps.transfer();
//            specAccountSteps.confirmTransferOnModal();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на покупку жилья(ФЛ) => Без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_fl_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("55");
            specAccountSgoSteps.transfer();
//            specAccountSteps.confirmTransferOnModal();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на покупку жилья(ФЛ) => валидация ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_validateIin () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
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

    @Test(description = "Перевод на покупку жилья(ФЛ) => валидация IBAN отбасы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_validationOtbasyIban () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
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

    @Test(description = "Перевод на покупку жилья(ФЛ)=> Недостаточно средств", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы перевода")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_fl_validateSum () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectIndividualRecipientType();
            specAccountSteps.inputRecipientInfo_individual(
                    config.clientIin(), config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forIndividual("500500");
            specAccountSgoSteps.transfer();
//            specAccountSteps.confirmTransferOnModal();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SUM_TO_TRANSFER_VALIDATE_FL), "Недостаточно средств для перевода"
        );
    }

    @Test(description = "Перевод на покупку жилья(ЮЛ) => С номером договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_ul_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withoutContractNumber_RE("00-019", DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на покупку жилья(ЮЛ) => Без номера договора", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_ul_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth("77713695396", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber_sgo(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("55");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Перевод на покупку жилья(ЮЛ) => валидация IBAN отбасы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_ul_validateOtbasyIBAN () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.validateIBAN("KZ649729722204F0Z3LP".substring(1));
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IBAN_ERROR_),
                CharacterSetConstants.IBAN_OTBASY_ERROR_TEXT
        );
    }

    @Test(description = "Перевод на покупку жилья(ЮЛ) => валидация IBAN", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация IBAN отбасы")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_ul_validateIBAN () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на покупку жилья", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.validateIBAN("KZ649729722204F0Z3LU");
        });
        Assert.assertEquals(elementsAttributes.getAttrInnerText(IBAN_ERROR_),
                "Вы ввели некорректный IBAN счет!"
        );
    }

    @Test(description = "Перевод на покупку жилья(ЮЛ)=> Недостаточно средств", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы перевода")
    @Severity(SeverityLevel.NORMAL)
    public void transferToPurchaseHome_ul_validateSum () {
        step("Авторизация", () -> {
            loginSteps.auth("77013404785", config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать перевод на аренду", () -> {
            specAccountSteps.selectSpecAccount();
            specAccountSteps.openSpecAccountOperations();
            specAccountSgoSteps.selectTransferToPurchaseHomeOperation();
        });
        step("Указать получателя и выполнить перевод", () -> {
            specAccountSteps.openRecipientTypeList();
            specAccountSteps.selectRERecipientType();
            specAccountSteps.inputRecipientInfo_RE_loanRepayment(
                    "971240001315", config.clientIban().substring(2)
            );
            specAccountSteps.indicateSign_withContractNumber_sgo(DatesUtils.getCurrentDate());
            specAccountSteps.inputSumToTransfer_forRE("500500");
            specAccountSteps.acceptAgreementAndTransfer_forRE();
////            specAccountSteps.confirmTransferOnModal();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(SUM_TO_TRANSFER_VALIDATE), "Недостаточно средств для перевода"
        );
    }
}
