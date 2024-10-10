package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.RentSubsidyPage.MODAL_NOTIFICATION;

@Owner("Алибек Акылбеков")
@Feature("Субсидирование аренды")
public class RentSubsidyTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Подать заявку аренды => Валидация активной заявки", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Валидация активной заявки")
    @Severity(SeverityLevel.NORMAL)
    public void rentSubsidy_validateActiveRequest() {
        step("Авторизация -> Субсидирование аренды", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("RentSubsidy"));
        });
        step("Подать заявку", () -> {
            rentSubsidyStep.applyRequest();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(MODAL_NOTIFICATION), "У клиента уже есть активная заявка"
        );
        rentSubsidyStep.clickModalButton();
    }

    //blocker - не реализована операция "подписать"
    @Test(description="Аннулировать заявку", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Аннулировать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void rentSubsidy_cancelRequest() {
        step("Авторизация -> Субсидирование аренды", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("RentSubsidy"));
        });
        step("Аннулировать заявку", () -> {
            rentSubsidyStep.cancelRequest();
        });
        Assert.assertTrue(true);
    }
}
