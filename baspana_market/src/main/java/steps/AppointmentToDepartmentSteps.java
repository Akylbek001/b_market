package steps;

import org.openqa.selenium.WebDriver;
import pages.AppointmentToDepartmentPage;

public class AppointmentToDepartmentSteps {
    private final AppointmentToDepartmentPage appointmentToDepartmentPage;

    public AppointmentToDepartmentSteps(WebDriver driver) {
        appointmentToDepartmentPage = new AppointmentToDepartmentPage(driver);
    }

    public void clickCancelButton() {
        appointmentToDepartmentPage
                .clickCancelButton();
    }

    public void clickReserveButton() {
        appointmentToDepartmentPage
                .clickReserveButton();
    }

    public void clickRebookButton() {
        appointmentToDepartmentPage
                .clickRebookButton();
    }

    public void fillForm(String phone) {
        appointmentToDepartmentPage
//                .clickBookingButton()
                .inputPhone(phone)
                .selectFilial()
                .selectOrderType()
                .selectVisitPurpose()
                .clickPeriodArea()
                .selectVisitDate()
                .selectVisitTime()
                .clickSubmitButton();
    }
}
