package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Owner("Алибек Акылбеков")
@Feature("Цифровая ипотека")
public class DigitalMortgageTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Цифровая ипотека", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Предварительное одобрение")
    @Severity(SeverityLevel.NORMAL)
    public void digitalMortgage () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("DigitalMortgage"));
        });
        step("Заполнить форму", () -> {
            digitalMortgageSteps.applyForDigitalMortgage();
        });
    }

    //BUG - поля для ввода ФИ не кликабельны(поля не заполнить)
    @Test(description="Цифровая ипотека => Видеозвонок", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Цифровая ипотека => Видеозвонок")
    @Severity(SeverityLevel.NORMAL)
    public void digitalMortgage_videoCall () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("DigitalMortgage"));
        });
        step("Заполнение формы обратной связи", () -> {
            digitalMortgageSteps.clickVideoCallBlock();
            drManager.getDriver().switchTo().frame("myFrame");
            feedbackSteps.videoConsultation(
                    config.guestPhone(), config.guestIin(), config.guestSureName(), config.guestName()
            );
        });
    }
}
