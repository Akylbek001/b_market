package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentToDepartmentPage extends BasePage {
    public static final By BOOKING_BUTTON = By.cssSelector("a#NotificationBookingBookingBtn");
    private static final By BOOKING_PHONE_INPUT = By.id("bookingPhone");
    private static final By BOOKING_FILIAL = By.id("bookingFilial");
    private static final By ODER_TYPE = By.id("MainOperList");
    private static final By VISIT_PURPOSE = By.cssSelector("select#bookingVisitPurpose");
    private static final By PERIOD = By.id("calendar-range");
    private static final By DATE = By.cssSelector("[aria-label='Октябрь 10, 2024']");
    private static final By TIME = By.id("bookingTime");
    private static final By SUBMIT_BUTTON = By.id("submit_form");
    private static final By CANCEL_BUTTON = By.id("NotificationBookingcancelBookingBtn");
    private static final By RESERVE_BUTTON = By.id("NotificationBookingBookingBtn");
    public static final By RESULT = By.cssSelector(".booking-title.booking-default-text");
    public static final By CANCEL_RESERVATION = By.cssSelector(".booking-div-btn #cancelBookingBtn");
    private static final By REBOOK_BUTTON = By.id("submit_form_repin");

    public AppointmentToDepartmentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click cancel modal button")
    public AppointmentToDepartmentPage clickCancelButton() {
        button.btnClick(CANCEL_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click reserve modal button")
    public AppointmentToDepartmentPage clickReserveButton() {
        WaitUtils.wait(10);
        elementsAttributes.waitUntilVisible(RESERVE_BUTTON);
        button.btnClick(RESERVE_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click rebook button")
    public AppointmentToDepartmentPage clickRebookButton() {
        WaitUtils.wait(1);
        button.btnClick(REBOOK_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click cancel reservation button")
    public AppointmentToDepartmentPage clickCancelReservationButton() {
        WaitUtils.wait(1);
        button.btnClick(CANCEL_RESERVATION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click booking button")
    public AppointmentToDepartmentPage clickBookingButton() {
        elementsAttributes.waitUntilVisible(BOOKING_BUTTON);
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
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select order type")
    public AppointmentToDepartmentPage selectOrderType() {
        dropDown.selectByIndex(ODER_TYPE, 3);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select visit purpose")
    public AppointmentToDepartmentPage selectVisitPurpose() {
        dropDown.selectByIndex(VISIT_PURPOSE, 1);
        WaitUtils.wait(2);
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
        dropDown.selectByIndex(TIME, 0);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click submit button")
    public AppointmentToDepartmentPage clickSubmitButton() {
        button.btnClick(SUBMIT_BUTTON);
        WaitUtils.wait(10);
        elementsAttributes.waitUntilVisible(RESULT);
        return this;
    }
}
