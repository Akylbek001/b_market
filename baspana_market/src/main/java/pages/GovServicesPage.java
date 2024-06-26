package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GovServicesPage extends BasePage {
    private static final By CERTIFICATE_OF_ABSENCE_OF_REAL_ESTATES = By.id("AvailabilityRealEstate");
    private static final By CERTIFICATE_OF_REGISTERED_RIGHTS_AND_ENCUMBRANCES = By.id("RegisteredRightsAndEncumbrances");


    public static final By CERTIFICATE_OF_ABSENCE_FAILED_MESSAGE = By.id("failed-error-custom-message");
    private static final By COMPLETE_BUTTON = By.cssSelector(".btn.btn-green.bodyL");

    public GovServicesPage (WebDriver driver) {super(driver);}

    @Step("Click certificate of absence of real estates button")
    public GovServicesPage clickCertificateOfAbsenceOfRealEstatesButton() {
        button.btnClick(CERTIFICATE_OF_ABSENCE_OF_REAL_ESTATES);
        WaitUtils.wait(10);
        return this;
    }

    @Step("Click certificate of absence of real estates button")
    public GovServicesPage clickCertificateOfRegisteredRightsAndEncumbrances() {
        button.btnClick(CERTIFICATE_OF_REGISTERED_RIGHTS_AND_ENCUMBRANCES);
        WaitUtils.wait(10);
        return this;
    }

    @Step("Click complete button")
    public GovServicesPage clickCompleteButton() {
        button.btnClick(COMPLETE_BUTTON);
        return this;
    }
}
