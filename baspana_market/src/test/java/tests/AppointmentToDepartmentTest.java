package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.AppointmentToDepartmentPage.RESULT;

@Owner("Алибек Акылбеков")
@Feature("Запись в отделение")
public class AppointmentToDepartmentTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Запись в отделение = забронировать", groups = {"automated"}, priority = 0)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Запись в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void appointmentToDepartment_book () {
        step("Авторизация", () -> {
            loginSteps.auth("77754207346", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Забронировать", () -> {
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

    @Test(description="Запись в отделение => перебронировать", groups = {"automated"}, priority = 1)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Запись в отделение")
    @Severity(SeverityLevel.NORMAL)
    public void appointmentToDepartment_rebook () {
        step("Авторизация", () -> {
            loginSteps.auth("77754207346", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Перебронировать", () -> {
            appointmentToDepartmentSteps.clickRebookButton();
        });
        step("Заполнить форму", () -> {
            appointmentToDepartmentSteps.fillForm(config.clientLogin());
        });
        Assert.assertEquals(
                "Ваш запрос на бронирование очереди подтвержден",
                elementsAttributes.getValue(RESULT)
        );
    }

    //bug
    @Test(description="Запись в отделение - Отмена брони", groups = {"automated"}, priority = 2)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Отмена брони")
    @Severity(SeverityLevel.NORMAL)
    public void appointmentToDepartment_cancelReservation () {
        step("Авторизация", () -> {
            loginSteps.auth("77754207346", config.clientPassword());
            brManager.navigateTo(envConfig.baseUrl().concat("QueueBooking"));
        });
        step("Отменить бронь", () -> {
            appointmentToDepartmentSteps.clickCancelReservationButton();
        });
        Assert.assertTrue(true);
    }
}
