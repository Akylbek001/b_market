package tests;

import base.BaseTest;
import common.utils.DatesUtils;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.SpecAccountSgoPage.TRANSFER_DETAILS;

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
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
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
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isVisible(TRANSFER_DETAILS));
    }

    @Test(description = "Полный расчет в Otbasy Bank => по номеру телефона без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byPhone_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
            specAccountSgoSteps.inputPhone(config.clientLogin().substring(1));
            specAccountSgoSteps.inputTransferData_withoutContract(DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("50");
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Полный расчет в Otbasy Bank => по альт коду с контарактом", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withContract () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
            specAccountSgoSteps.inputAltCode(config.clientAlternativeCode());
            specAccountSgoSteps.inputTransferData("00-019", DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("50");
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }

    @Test(description = "Полный расчет в Otbasy Bank => по альт коду без контракта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешный перевод")
    @Severity(SeverityLevel.NORMAL)
    public void transferToFullPayment_byAltCode_withoutContract () {
        step("Авторизация", () -> {
            loginSteps.auth(config.specAccount_login(), config.specAccount_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        step("Выбрать операцию <Полный расчет в Otbasy Bank>", () -> {
            specAccountSgoSteps.selectTransferToFullPaymentOperation();
            specAccountSgoSteps.inputAltCode(config.clientAlternativeCode());
            specAccountSgoSteps.inputTransferData_withoutContract(DatesUtils.getCurrentDate());
            specAccountSgoSteps.inputSumToTransfer("50");
            specAccountSgoSteps.confirmTransferByOtp(config.smsCode());
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(TRANSFER_DETAILS));
    }
}
