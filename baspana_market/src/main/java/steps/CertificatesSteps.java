package steps;

import org.openqa.selenium.WebDriver;
import pages.CertificatesPage;

public class CertificatesSteps {
    private final CertificatesPage certificatesPage;
    public CertificatesSteps(WebDriver driver) { certificatesPage = new CertificatesPage(driver); }

    public void selectAccountAvailabilityCertificate() {
        certificatesPage
                .selectAccountAvailabilityCertificate();
    }

    public void selectLoanDebtCertificate() {
        certificatesPage
                .selectLoanDebtCertificate();
    }

    public void selectDepositCertificate() {
        certificatesPage
                .selectDepositCertificate();
    }

    public void selectEPVAccountCertificate() {
        certificatesPage
                .selectEPVAccountCertificate();
    }

    public void selectLoanStatementCertificate() {
        certificatesPage
                .selectLoanStatementCertificate();
    }

    public void selectLoanRepaymentScheduleCertificate() {
        certificatesPage
                .selectLoanRepaymentScheduleCertificate();
    }

    public void getAccountCertificate() {
        certificatesPage
                .clickAccountsListsDropdown()
                .selectAccount()
                .clickLanguagesListsDropdown()
                .selectLanguage();
    }

    public void getLoanDebtCertificate() {
        certificatesPage
                .clickLoanDebtLanguagesListsDropdown()
                .selectLanguage();
    }

    public void getDepositCertificate() {
        certificatesPage
                .clickAccountsListsDropdown()
                .selectDeposit()
                .clickLanguagesListsDropdown()
                .selectLanguage();
    }

    public void selectEntirePeriod() {
        certificatesPage
                .clickForAllPeriodCheckbox();
    }

    public void selectSpecifiedPeriod() {
        certificatesPage
                .clickPeriodToSelectDates()
                .clickStartDate()
                .clickEndDate();
    }

    public void getEPVAccountCertificate() {
        certificatesPage
                .clickAccountsListsDropdown()
                .selectEpvAccount()
                .clickLanguagesListsDropdown()
                .selectLanguage();
    }

    public void getCertificate() {
        certificatesPage
                .clickGetCertificateButton();
    }
}
