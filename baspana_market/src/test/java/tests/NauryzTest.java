package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.OtauPage.*;

@Owner("Алибек Акылбеков")
@Feature("Наурыз")
public class NauryzTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Подать заявку => Валидация суммы < 1 000 000", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация суммы")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validateSum () {
        step("Авторизация", () -> {
            loginSteps.auth("77056552753", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("OtauNauriz"));
        });
        step("Подать заявку", () -> {
            otauSteps.clickApplyButton();
        });
        step("Ввод данных по локации", () -> {
            otauSteps.fillFormAndContinue();
        });
        Assert.assertEquals(
                CharacterSetConstants.REFUSED_REASON, elementsAttributes.getValue(REFUSED_REASON_TEXT)
        );
    }

    @Test(description = "Подать заявку => Валидация клиента <не найден в БМГ>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация клиента")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validateClient () {
        step("Авторизация", () -> {
            loginSteps.auth("77752512222", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Ansagan/MyApplications"));
        });
        step("Подать заявку", () -> {
            otauSteps.clickApplyButton();
        });
        step("Ввод данных по локации", () -> {
            otauSteps.fillFormAndContinue();
        });
        Assert.assertEquals(
                "Клиент не найден в БМГ", elementsAttributes.getValue(REFUSED_REASON_TEXT)
        );
    }

    //+7(701) 700-42-02
    @Test(description = "Подать заявку", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Подать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest () {
        step("Авторизация", () -> {
            loginSteps.auth("77477172709", "12345test");
            brManager.navigateTo(envConfig.baseUrl().concat("Ansagan/MyApplications"));
        });
        step("Подать заявку", () -> {
            otauSteps.clickApplyButton();
        });
        step("Ввод данных по локации", () -> {
            otauSteps.fillFormAndContinue();
        });
        step("Выбрать депозит", () -> {
            otauSteps.selectDeposit();
        });
    }

    @Test(description = "Подать заявку => Валидация активной заявки Otau", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация активной заявки Otau")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validateActiveOtauRequest() {
        step("Авторизация", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Nauriz"));
        });
        step("Ввод данных по локации", () -> {
            otauSteps.clickApplyButton();
        });
        Assert.assertTrue(elementsAttributes.getValue(BANNER_TEXT)
                .contains("У вас уже имеется активная заявка по программе Otau с номером ")
        );
    }

    @Test(description = "Аннулировать заявку", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Аннулировать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void cancelRequest() {
        step("Авторизация", () -> {
            loginSteps.auth("77056552753", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("Nauriz"));
        });
        step("Ввод данных по локации", () -> {
            otauSteps.cancelRequest();
        });
        Assert.assertTrue(elementsAttributes.isVisible(APPLY_BUTTON));
    }
}
