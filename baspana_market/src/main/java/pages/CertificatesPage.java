package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatesPage extends BasePage {
    private static final By CERTIFICATE_OF_ACCOUNT_AVAILABILITY = By.id("GetForm");
    private static final By CERTIFICATE_OF_LOAN_DEBT = By.xpath("//div[@class='cert--blocks--items'] //p[text() = 'Справка о ссудной задолженности']");

    private static final By ACCOUNTS_DROPDOWN_LIST = By.xpath("//div[@class='custom-select--for--counts']");
    private static final By ACCOUNT = By.xpath("//div[@class='select-items'] /div[2]");
    private static final By LANGUAGE_DROPDOWN_LIST = By.xpath("//div[@class='custom-select']");
    private static final By LANGUAGE = By.xpath("//div[@class='select-items'] /div[1]");
    private static final By GET_CERTIFICATE_BUTTON = By.xpath("//button[@class='btn-form_app']");
    public static final By CERTIFICATE_GENERATED_NOTIFICATION = By.xpath("//div[@id='GetToCertificateFinale'] //b");
    private static final By LOAN_DEBT_LANGUAGE_DROPDOWN_LIST = By.xpath("//div[@class='select-selected']");

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

    @Step("Click accounts list dropdown")
    public CertificatesPage clickAccountsListsDropdown() {
        button.btnClick(ACCOUNTS_DROPDOWN_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select account")
    public CertificatesPage selectAccount() {
        button.btnClick(ACCOUNT);
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

    @Step("Click get certificate button")
    public CertificatesPage clickGetCertificateButton() {
        button.btnClick(GET_CERTIFICATE_BUTTON);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click loan debt languages list dropdown")
    public CertificatesPage clickLoanDebtLanguagesListsDropdown() {
        button.btnClick(LOAN_DEBT_LANGUAGE_DROPDOWN_LIST);
        WaitUtils.wait(1);
        return this;
    }
}
