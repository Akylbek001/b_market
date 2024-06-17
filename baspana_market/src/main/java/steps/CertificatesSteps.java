package steps;

import org.openqa.selenium.WebDriver;
import pages.CertificatesPage;

public class CertificatesSteps {
    private final CertificatesPage certificatesPage;
    public CertificatesSteps(WebDriver driver) { certificatesPage = new CertificatesPage(driver); }

    public void selectCertificatesMenu() {
        certificatesPage
                .selectCertificatesMenu();

    }
    public void getAccountCertificate() {
        certificatesPage
                .selectAccountAvailabilityCertificate()
                .clickAccountsListsDropdown()
                .selectAccount()
                .clickLanguagesListsDropdown()
                .selectLanguage()
                .clickGetCertificateButton();
    }

    public void getLoanDebtCertificate() {
        certificatesPage
                .selectLoanDebtCertificate()
                .clickLoanDebtLanguagesListsDropdown()
                .selectLanguage()
                .clickGetCertificateButton();
    }
}
