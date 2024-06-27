package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Owner("Алибек Акылбеков")
@Feature("Центр обеспечения жильем")
public class HousingCenterTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }
    String filePath = System.getProperty("user.dir") + "/ui_core/src/resources/META-INF/aop-ajc.xml";

    @Test(description = "Подать заявку => Валидация ncaLayer", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Подать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validationNcaLayer () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Cozh"));
        });
        step("Подать заявку", () -> {
            housingCenterSteps.applyRequest_validateNcaLayer();
        });
    }
}
