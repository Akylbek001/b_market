package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentToDepartmentPage extends BasePage {
    public static final By BOOKING_BUTTON = By.cssSelector("a#NotificationBookingBookingBtn");
    private static final By BOOKING_PHONE_INPUT = By.id("bookingPhone");
    private static final By BOOKING_FILIAL = By.id("bookingFilial");
    private static final By ODER_TYPE = By.id("MainOperList");
    private static final By VISIT_PURPOSE = By.id("bookingVisitPurpose");
    private static final By PERIOD = By.id("calendar-range");
    private static final By DATE = By.cssSelector("[aria-label='Июнь 5, 2024']");
    private static final By TIME = By.id("bookingTime");
    private static final By SUBMIT_BUTTON = By.id("submit_form");


    public AppointmentToDepartmentPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click booking button")
    public AppointmentToDepartmentPage clickBookingButton() {
        button.btnClick(BOOKING_BUTTON);
        return this;
    }

    @Step("Input phone number")
    public AppointmentToDepartmentPage inputPhone(String phone) {
        input.inputWithClear(BOOKING_PHONE_INPUT, phone);
        return this;
    }

    @Step("Select filial")
    public AppointmentToDepartmentPage selectFilial() {
        dropDown.selectByIndex(BOOKING_FILIAL, 1);
        return this;
    }

    @Step("Select order type")
    public AppointmentToDepartmentPage selectOrderType() {
        dropDown.selectByIndex(ODER_TYPE, 1);
        return this;
    }

    @Step("Select visit purpose")
    public AppointmentToDepartmentPage selectVisitPurpose() {
        dropDown.selectByIndex(VISIT_PURPOSE, 1);
        return this;
    }

    @Step("Click period area")
    public AppointmentToDepartmentPage clickPeriodArea() {
        button.btnClick(PERIOD);
        return this;
    }

    @Step("Select visit date in calendar")
    public AppointmentToDepartmentPage selectVisitDate() {
        button.btnClick(DATE);
        return this;
    }

    @Step("Select visit time")
    public AppointmentToDepartmentPage selectVisitTime() {
        dropDown.selectByIndex(TIME, 1);
        return this;
    }

    @Step("Click submit button")
    public AppointmentToDepartmentPage clickSubmitButton() {
        button.btnClick(SUBMIT_BUTTON);
        return this;
    }
}
