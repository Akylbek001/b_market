package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
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
    }

    @Test(description = "Получить справку об отсутствии недвижемого имущества=> Сервис не доступен", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfAbsent_serviceNotAvailable () {
        step("Авторизация -> гос.услуги", () -> {
            loginSteps.auth(config.loanClient_login(), config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
        });
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfAbsenceOfRealEstatesButton();
        });
        Assert.assertEquals(CharacterSetConstants.SERVICE_NOT_AVAILABLE,
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }

    @Test(description = "Получить справку о наличии недвижимости и обременении=> Сервис не доступен", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfRegisteredRightsAndEncumbrances_serviceNotAvailable () {
        step("Авторизация -> гос.услуги", () -> {
            loginSteps.auth(config.loanClient_login(), config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
        });
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfRegisteredRightsAndEncumbrances();
        });
        Assert.assertEquals(CharacterSetConstants.SERVICE_NOT_AVAILABLE,
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }

    @Test(description = "Получить справку об отсутствии недвижемого имущества=> Не найден в БМГ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfAbsent_notFoundInBMG () {
        step("Авторизация -> гос.услуги", () -> {
            loginSteps.auth("77011063133", config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
        });
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfAbsenceOfRealEstatesButton();
        });
        Assert.assertEquals(CharacterSetConstants.NOT_FOUND_IN_BMG,
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }

    @Test(description = "Получить справку о наличии недвижимости и обременении=> Не найден в БМГ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("справку об отсутствии недвижемого имущества")
    @Severity(SeverityLevel.NORMAL)
    public void getCertificateOfRegisteredRightsAndEncumbrances_notFoundInBMG () {
        step("Авторизация -> гос.услуги", () -> {
            loginSteps.auth("77011063133", config.client_for_password_recovery_newPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
        });
        step("Получить справку", () -> {
            govServicesSteps.getCertificateOfRegisteredRightsAndEncumbrances();
        });
        Assert.assertEquals(CharacterSetConstants.SERVICE_NOT_AVAILABLE,
                elementsAttributes.getValue(CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE)
        );
        step("Завершить", () -> {
            govServicesSteps.complete();
        });
    }
}
