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
    }

    @Test(description="Стать клиентом.Открыть депозит", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDeposit() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Открыть депозит", () -> {
            becomeClientSteps.openDeposit();;
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
            becomeClientSteps.confirmByOtp(config.smsCode());
        });
        Assert.assertTrue(true);
    }

    @Test(description="Стать клиентом_Депозит => Валидация существующего клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDepositWithExistedLogin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Открыть депозит", () -> {
            becomeClientSteps.openDeposit();;
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_НФД => Валидация возраста по ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация возраста по ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDFInvalidAge() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Заполнение данных", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNFD(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(
                CharacterSetConstants.CLIENT_AGE_IS_NOT_SUITABLE, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_НФД => Валидация формата ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByNDFInvalidIinFormat() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Заполнение данных", () -> {
            becomeClientSteps.becomeClientByOpenAccountForNFD(config.clientLogin(), config.clientInvalidIin());
        });
        Assert.assertEquals(CharacterSetConstants.INVALID_IIN_FORMAT, elementsAttributes.getValue(INVALID_IIN_TEXT));
    }

    //BUG -> ЕПВ (ОР: График совершения данной операции: до 18-00, ФР: валидация срабатывает раньше: ~17-30)
    @Test(description="Стать клиентом_ЕПВ. Адресс регистрации==Адрес проживания", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPVSameAddress() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Верификация", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
            becomeClientSteps.confirmByOtp(config.smsCode());
            becomeClientSteps.inputPersonalDataFirstPart("O_Bank","QA","epv@bk.ru");
            becomeClientSteps.selectRegAddress("91", "91");
            becomeClientSteps.selectSameAddressCheckbox();
            becomeClientSteps.inputPersonalDataSecondPart("birthSurname", "codeWord");
        });
        Assert.assertTrue(true);
    }

    @Test(description="Стать клиентом_ЕПВ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Открыть счет для ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPV() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Верификация", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
            becomeClientSteps.confirmByOtp(config.smsCode());
            becomeClientSteps.inputPersonalDataFirstPart("O_Bank","QA","epv@bk.ru");
            becomeClientSteps.selectRegAddress("91", "91");
            becomeClientSteps.selectLivingAddress("21", "21");
            becomeClientSteps.inputPersonalDataSecondPart("birthSurname", "codeWord");
        });
        Assert.assertTrue(true);
    }

    @Test(description="Стать клиентом_ЕПВ => Валидация существующего клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ.Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPVValidateExistedIin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом_ЕПВ => Валидация формата ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPVInvalidIin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Стать клиентом", () -> {
            becomeClientSteps.becomeClient();;
        });
        step("Счет для ЕПВ", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV();
        });
        step("Заполнить данные и подтвердить", () -> {
            becomeClientSteps.verifyPhoneNumberAndIin("77759005677", "890604300394");
        });
        Assert.assertEquals(CharacterSetConstants.IIN_FILLED_INCORRECTLY, elementsAttributes.getValue(REFUSE_TEXT));
    }
}
