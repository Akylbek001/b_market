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

    public void selectAccountCertificate() {
        certificatesPage
                .selectAccountCertificate();
    }

    public void selectLoanStatementCertificate() {
        certificatesPage
                .selectLoanStatementCertificate();
    }

    public void selectLoanRepaymentScheduleCertificate() {
        certificatesPage
                .selectLoanRepaymentScheduleCertificate();
    }

    public void openAccountsList() {
        certificatesPage
                .clickAccountsListsDropdown();
    }

    public void selectAllAccounts() {
        certificatesPage
                .selectAllAccounts();
    }

    public void selectCurrentAccount() {
        certificatesPage
                .selectCurrentAccount();
    }

    public void selectEPVAccount() {
        certificatesPage
                .selectEPVAccount();
    }

    public void selectSpecialAccount() {
        certificatesPage
                .selectSpecialAccount();
    }

    public void selectDepositAccount() {
        certificatesPage
                .selectDepositAccount();
    }

    public void selectCertificateLanguage() {
        certificatesPage
                .clickLanguagesListsDropdown()
                .selectLanguage();
    }

    public void _selectCurrentAccount() {
        certificatesPage
                ._selectCurrentAccount();
    }

    public void _selectEPVAccount() {
        certificatesPage
                ._selectEPVAccount();
    }

    public void _selectSpecialAccount() {
        certificatesPage
                ._selectSpecialAccount();
    }

    public void fillRequiresData() {
        certificatesPage
                .clickAccountsListsDropdown()
                .selectValueFromList()
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

    public void getLoanCertificate() {
        certificatesPage
                .clickAccountsListsDropdown();
    }

    public void getCertificate() {
        certificatesPage
                .clickGetCertificateButton();
    }

    public void getCertificateForWhile() {
        certificatesPage
                .clickGetCertificateButton_additionalWaitResult();
    }
}
