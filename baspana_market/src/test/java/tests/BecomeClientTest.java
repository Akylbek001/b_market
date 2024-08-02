package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.BecomeClientPage.*;

@Owner("Алибек Акылбеков")
@Feature("Стать клиентом")
public class BecomeClientTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.loginButton();
        loginSteps.becomeClient();
    }

    //проверка подлинности
    @Test(description="Стать клиентом => Открыть депозит", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть депозит")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDeposit() {
        step("Открыть депозит", () -> {
            becomeClientSteps.openDeposit();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77007777777", "860709300429");
            becomeClientSteps.confirmByOtp(config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            becomeClientSteps.inputEmail("bin@bk.ru");

        });
        Assert.assertTrue(true);
    }

    @Test(description="Стать клиентом_Депозит => Валидация существующего клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDeposit_WithExistedLogin() {
        step("Открыть депозит", () -> {
            becomeClientSteps.openDeposit();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_Депозит => < 18", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Вам нет 18 лет")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDeposit_under18YearsOld() {
        step("Открыть депозит", () -> {
            becomeClientSteps.openDeposit();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), "201212551391");
        });
        Assert.assertEquals(elementsAttributes.getValue(REFUSE_TEXT), CharacterSetConstants.UNDER_18_YEARS_OLD_TEXT);
    }

    @Test(description="Стать клиентом НФД", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Стать клиентом НФД")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDF() {
        step("Счет для НДФ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNDF();
        });
        step("Заполнить данные", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77001117070", "060328600678");
            becomeClientSteps.confirmByOtp(config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            becomeClientSteps.inputPersonalDataFirstPart("O_Bank","QA","epv@bk.ru");
            becomeClientSteps.selectRegAddress("91", "91");
            becomeClientSteps.selectLivingAddress("21", "21");
            becomeClientSteps.inputPersonalDataSecondPart("birthSurname", "codeWord");
        });
        Assert.assertEquals("Вы не прошли проверку подлинности личности",
                elementsAttributes.getValue(BIOMETRY_CHECK_FAILED)
        );
    }

    @Test(description="Стать клиентом_НФД => Валидация существующего номера телефона", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего номера телефона")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDF_existedNumber() {
        step("Счет для НДФ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNDF();
        });
        step("Заполнить данные", () -> {
                    becomeClientSteps.verifyPhoneNumberAndIin("77770770707", "060328600678");
        });
        Assert.assertEquals(
                CharacterSetConstants.CLIENT_NUMBER_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_НФД => Валидация возраста", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация возраста по ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDF_InvalidAge() {
        step("Счет для НДФ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNDF();
        });
        step("Заполнить данные", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(
                CharacterSetConstants.CLIENT_AGE_IS_NOT_SUITABLE, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_НФД => Валидация формата ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDF_InvalidIinFormat() {
        step("Счет для НДФ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNDF();
        });
        step("Заполнить данные", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.userInvalidIin());
        });
        Assert.assertEquals(CharacterSetConstants.INVALID_IIN_FORMAT, elementsAttributes.getValue(INVALID_IIN_TEXT));
    }

    @Test(description="Стать клиентом_ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV() {
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Верификация", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
            becomeClientSteps.confirmByOtp(config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            becomeClientSteps.inputPersonalDataFirstPart("O_Bank","QA","epv@bk.ru");
            becomeClientSteps.selectRegAddress("91", "91");
            becomeClientSteps.selectLivingAddress("21", "21");
            becomeClientSteps.inputPersonalDataSecondPart("birthSurname", "codeWord");
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.IDENTITY_VERIFICATION_ERROR_TEXT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    //BUG -> ЕПВ (ОР: График совершения данной операции: до UG -> ЕПВ (ОР: График совершения данной операции: до 18-00,18-00, ФР: валидация срабатывает раньше: ~17-30)
    @Test(description="Стать клиентом_ЕПВ => Адресс регистрации==Адрес проживания", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV_SameAddress() {
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Верификация", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
            becomeClientSteps.confirmByOtp(config.smsCode());
            generalSteps.acceptAgreement_startBiometry();
            becomeClientSteps.inputPersonalDataFirstPart("O_Bank","QA","epv@bk.ru");
            becomeClientSteps.selectRegAddress("91", "91");
            becomeClientSteps.selectSameAddressCheckbox();
            becomeClientSteps.inputPersonalDataSecondPart("birthSurname", "codeWord");
        });
        Assert.assertEquals(
                drManager.getDriver().switchTo().alert().getText(),
                CharacterSetConstants.IDENTITY_VERIFICATION_ERROR_TEXT
        );
        drManager.getDriver().switchTo().alert().accept();
    }

    @Test(description="Стать клиентом_ЕПВ => Валидация существующего клиента о ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ.Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV_ValidateExistedIin() {
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_ЕПВ => Валидация формата ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV_InvalidIin() {
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.userInvalidIin());
        });
        Assert.assertEquals(CharacterSetConstants.IIN_FILLED_INCORRECTLY, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_ЕПВ => ИИН отсутствует в базе налогового органа", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV_NotInTaxAuthorityDatabase() {
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.clientInvalidIin());
        });
        Assert.assertEquals(
                CharacterSetConstants.NOT_IN_TAX_AUTHORITY_DATABASE_TEXT, elementsAttributes.getValue(REFUSE_TEXT)
        );
    }
}
