package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.GovServicesPage.CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE;

@Owner("Алибек Акылбеков")
@Feature("Гос.Услуги")
public class GosServicesTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        loginSteps.auth(
                config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
        );
        brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
    }

    @Test(description = "Получить справку об отсутствии недвижемого имущества", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfAbsent () {
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfAbsenceOfRealEstatesButton();
        });
        Assert.assertEquals("Изивините, сервис временно недоступен! Повторите попытку позже",
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }

    @Test(description = "Получить справку о наличии недвижимости и обременении", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfRegisteredRightsAndEncumbrances () {
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfRegisteredRightsAndEncumbrances();
        });
        Assert.assertEquals("Изивините, сервис временно недоступен! Повторите попытку позже",
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }
}
