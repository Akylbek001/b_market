package steps;

import org.openqa.selenium.WebDriver;
import pages.GovServicesPage;

public class GovServicesSteps {
    private final GovServicesPage govServicesPage;
    public GovServicesSteps(WebDriver driver) {
        govServicesPage = new GovServicesPage(driver);
    }

    public void getCertificateOfAbsenceOfRealEstatesButton() {
        govServicesPage
                .clickCertificateOfAbsenceOfRealEstatesButton();
    }

    public void getCertificateOfRegisteredRightsAndEncumbrances() {
        govServicesPage
                .clickCertificateOfRegisteredRightsAndEncumbrances();
    }

    public void complete() {
        govServicesPage
                .clickCompleteButton();
    }

    public void clickConfirmedButton() {
        govServicesPage
                .clickConfirmedButton();
    }
}
