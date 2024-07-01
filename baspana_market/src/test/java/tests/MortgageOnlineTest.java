package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Owner("Алибек Акылбеков")
@Feature("Ипотека онлайн")
public class MortgageOnlineTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Ипотека онлайн", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Видеозвонок")
    @Severity(SeverityLevel.NORMAL)
    public void mortgageOnline () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("cabinet/MyStatement"));
        });
        step("Видеозвонок", () -> {
            mortgageOnlineSteps.clickVideoCallBlock();
        });
    }
}
