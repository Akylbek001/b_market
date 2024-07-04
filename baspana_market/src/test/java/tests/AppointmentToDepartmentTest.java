package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.CertificatesPage.CERTIFICATE_GENERATED_NOTIFICATION;

@Owner("Алибек Акылбеков")
@Feature("Справки")
public class AppointmentToDepartmentTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Запись в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Запись в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void appointmentToDepartment () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
//            mainSteps.clickProfileIcon();
//            cabinetSteps.selectAppointmentToDepartmentMenu();
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Заполнить форму", () -> {
            appointmentToDepartmentSteps.fillForm(config.clientLogin());
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }
}
