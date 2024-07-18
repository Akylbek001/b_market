package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatesPage extends BasePage {
    private static final By CERTIFICATE_OF_ACCOUNT_AVAILABILITY = By.id("GetForm");
    private static final By CERTIFICATE_OF_LOAN_DEBT = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Справка о ссудной задолженности']");
    private static final By CERTIFICATE_OF_DEPOSIT = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Выписка по депозиту']");
    private static final By CERTIFICATE_OF_ACCOUNT = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Выписка по счету']");
    private static final By CERTIFICATE_OF_LOAN_STATEMENT = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Выписка по займу']");
    private static final By CERTIFICATE_OF_LOAN_REPAYMENT_SCHEDULE = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Выписка по графику погашения займа']");

    private static final By ACCOUNTS_DROPDOWN_LIST = By.cssSelector(".custom-select--for--counts");
    private static final By ALL_ACCOUNTS = By.xpath("//div[@class='select-items'] /div[1]");
    private static final By CURRENT_ACCOUNT = By.xpath("//div[@class='select-items'] /div[2]");
    private static final By EPV_ACCOUNT = By.xpath("//div[@class='select-items'] /div[3]");
    private static final By SPECIAL_ACCOUNT = By.xpath("//div[@class='select-items'] /div[4]");
    private static final By DEPOSIT_ACCOUNT = By.xpath("//div[@class='select-items'] /div[5]");

    private static final By ACCOUNTS_DROPDOWN_VALUE = By.xpath("//div[@class='select-items'] /div");
    private static final By _CURRENT_ACCOUNT = By.xpath("//div[@class='select-items'] /div[1]");
    private static final By _EPV_ACCOUNT = By.xpath("//div[@class='select-items'] /div[2]");
    private static final By _SPECIAL_ACCOUNT = By.xpath("//div[@class='select-items'] /div[3]");

    private static final By LANGUAGE_DROPDOWN_LIST = By.cssSelector(".custom-select");
    private static final By LANGUAGE = By.xpath("//div[@class='select-items'] /div[1]");
    private static final By FOR_ALL_PERIOD = By.cssSelector(".btn-onoff");
    private static final By PERIOD = By.id("calendar-range");
    private static final By START_DATE = By.cssSelector("[aria-label='Июль 1, 2024']");
    private static final By END_DATE = By.cssSelector("[aria-label='Июль 30, 2024']");

    private static final By GET_CERTIFICATE_BUTTON = By.xpath("//button[@class='btn-form_app']");
    public static final By CERTIFICATE_GENERATED_NOTIFICATION = By.xpath("//div[@id='GetToCertificateFinale'] //b");
    public static final By GENERATED_CERTIFICATE = By.cssSelector(".certificate_info--b");


    public CertificatesPage(WebDriver driver) {
        super(driver);
    }


    @Step("Select certificate of account availability")
    public CertificatesPage selectAccountAvailabilityCertificate() {
        button.btnClick(CERTIFICATE_OF_ACCOUNT_AVAILABILITY);
        return this;
    }

    @Step("Select certificate of loan debt")
    public CertificatesPage selectLoanDebtCertificate() {
        button.btnClick(CERTIFICATE_OF_LOAN_DEBT);
        return this;
    }

    @Step("Select certificate of deposit")
    public CertificatesPage selectDepositCertificate() {
        button.btnClick(CERTIFICATE_OF_DEPOSIT);
        return this;
    }

    @Step("Select certificate of account")
    public CertificatesPage selectAccountCertificate() {
        button.btnClick(CERTIFICATE_OF_ACCOUNT);
        return this;
    }

    @Step("Select certificate of loan statement")
    public CertificatesPage selectLoanStatementCertificate() {
        button.btnClick(CERTIFICATE_OF_LOAN_STATEMENT);
        return this;
    }

    @Step("Select certificate of loan repayment schedule")
    public CertificatesPage selectLoanRepaymentScheduleCertificate() {
        button.btnClick(CERTIFICATE_OF_LOAN_REPAYMENT_SCHEDULE);
        return this;
    }

    @Step("Click accounts list dropdown")
    public CertificatesPage clickAccountsListsDropdown() {
        button.btnClick(ACCOUNTS_DROPDOWN_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select all accounts")
    public CertificatesPage selectAllAccounts() {
        button.btnClick(ALL_ACCOUNTS);
        return this;
    }

    @Step("Select current account")
    public CertificatesPage selectCurrentAccount() {
        button.btnClick(CURRENT_ACCOUNT);
        return this;
    }

    @Step("Select EPV account")
    public CertificatesPage selectEPVAccount() {
        button.btnClick(EPV_ACCOUNT);
        return this;
    }

    @Step("Select special account")
    public CertificatesPage selectSpecialAccount() {
        button.btnClick(SPECIAL_ACCOUNT);
        return this;
    }

    @Step("Select deposit account")
    public CertificatesPage selectDepositAccount() {
        button.btnClick(DEPOSIT_ACCOUNT);
        return this;
    }

    @Step("Select value from list value")
    public CertificatesPage selectValueFromList() {
        button.btnClick(ACCOUNTS_DROPDOWN_VALUE);
        return this;
    }

    @Step("Select current account")
    public CertificatesPage _selectCurrentAccount() {
        button.btnClick(_CURRENT_ACCOUNT);
        return this;
    }

    @Step("Select EPV account")
    public CertificatesPage _selectEPVAccount() {
        button.btnClick(_EPV_ACCOUNT);
        return this;
    }

    @Step("Select social account")
    public CertificatesPage _selectSpecialAccount() {
        button.btnClick(_SPECIAL_ACCOUNT);
        return this;
    }

    @Step("Click languages list dropdown")
    public CertificatesPage clickLanguagesListsDropdown() {
        button.btnClick(LANGUAGE_DROPDOWN_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select language")
    public CertificatesPage selectLanguage() {
        button.btnClick(LANGUAGE);
        return this;
    }

    @Step("Click for all period checkbox")
    public CertificatesPage clickForAllPeriodCheckbox() {
        button.btnClick(FOR_ALL_PERIOD);
        return this;
    }

    @Step("Click period to select dates")
    public CertificatesPage clickPeriodToSelectDates() {
        button.btnClick(PERIOD);
        return this;
    }

    @Step("Select start date")
    public CertificatesPage clickStartDate() {
        button.btnClick(START_DATE);
        return this;
    }

    @Step("Select end date")
    public CertificatesPage clickEndDate() {
        button.btnClick(END_DATE);
        return this;
    }

    @Step("Click get certificate button")
    public CertificatesPage clickGetCertificateButton() {
        button.btnClick(GET_CERTIFICATE_BUTTON);
        elementsAttributes.waitUntilVisible(GENERATED_CERTIFICATE);
        return this;
    }

    @Step("Click get certificate button")
    public CertificatesPage clickGetCertificateButton_additionalWaitResult() {
        button.btnClick(GET_CERTIFICATE_BUTTON);
        elementsAttributes.waitUntilVisible(GENERATED_CERTIFICATE);
        return this;
    }
}
