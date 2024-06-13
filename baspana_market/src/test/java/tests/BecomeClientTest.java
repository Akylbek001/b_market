package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.BecomeClientPage.INVALID_IIN_TEXT;
import static pages.BecomeClientPage.REFUSE_TEXT;

@Owner("Алибек Акылбеков")
@Feature("Стать клиентом")
public class BecomeClientTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Стать клиентом.Открыть депозит.Валидация существующего клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByDeposit() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Заполнение данных", () -> {
            becomeClientSteps.becomeClientByOpenDeposit(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом.Счет для НФД.Валидация возраста по ИИН", groups = {"automated"})
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

    @Test(description="Стать клиентом.Счет для НФД.Валидация формата ИИН", groups = {"automated"})
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

    @Test(description="Стать клиентом.Счет для ЕПВ.Валидация существующего клиента", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счет для ЕПВ.Валидация существующего клиента")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPVValidateExistedIin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Заполнение данных", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV(config.clientLogin(), config.clientIin());
        });
        Assert.assertEquals(CharacterSetConstants.CLIENT_ALREADY_EXIST, elementsAttributes.getValue(REFUSE_TEXT));
    }

    @Test(description="Стать клиентом.Счет для ЕПВ.Валидация формата ИИН", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация формата ИИН")
    @Severity(SeverityLevel.NORMAL)
    public void becomeClientByEPVInvalidIin() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Заполнение данных", () -> {
            becomeClientSteps.becomeClientByOpenAccountForEPV(config.clientLogin(), config.clientInvalidIin());
        });
        Assert.assertEquals(CharacterSetConstants.IIN_FILLED_INCORRECTLY, elementsAttributes.getValue(REFUSE_TEXT));
    }
}
