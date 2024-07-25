package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.AppointmentToDepartmentPage.RESULT;
import static pages.CertificatesPage.CERTIFICATE_GENERATED_NOTIFICATION;

@Owner("Алибек Акылбеков")
@Feature("Запись в отделение")
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
    public void appointmentToDepartment_byCancelModal () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.userLogin(), config.userPass()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Закрыть модальное окно", () -> {
            appointmentToDepartmentSteps.clickCancelButton();
        });
        step("Заполнить форму", () -> {
            appointmentToDepartmentSteps.fillForm(config.clientLogin());
        });
        Assert.assertEquals(
                "Ваш запрос на бронирование очереди подтвержден",
                elementsAttributes.getValue(RESULT)
        );
    }

    @Test(description="Запись в отделение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Запись в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void appointmentToDepartment_byAcceptModal () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Закрыть модальное окно", () -> {
            appointmentToDepartmentSteps.clickReserveButton();
        });
        step("Заполнить форму", () -> {
            appointmentToDepartmentSteps.fillForm(config.clientLogin());
        });
        Assert.assertEquals(
                "Ваш запрос на бронирование очереди подтвержден",
                elementsAttributes.getValue(RESULT)
        );
    }
}
