package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {
    private static final By ACCOUNTS = By.xpath(
            "//div[@class='menu-list']//*[contains(text(), 'Счета')]"
    );
    private static final By OPEN_ACCOUNTS_BUTTON = By.xpath(
            "//div[@class='account_title'] //button[@data-target='#myAccModal']"
    );
    private static final By CURRENT_ACCOUNT = By.xpath(
            "//div[@id='myAccModal'] //a[@href='/CurrentAccount']"
    );
    private static final By ACCOUNT_FOR_EPV = By.xpath(
            "//div[@id='myAccModal'] //a[@href='/PensionAccount/Open']"
    );

    private static final By OPEN_CURRENT_ACCOUNT_BUTTON = By.id("btnOpenCurAccount");
    private static final By FURTHER_BUTTON = By.id("btnOnboardingNext");
    public static final By NOTIFICATION_TEXT = By.id("modalNotificationBody");

    private static final By AGREEMENT_CHECKBOX = By.id("formCheckOne");
    private static final By CONFIRM_BUTTON = By.id("formButtonOne");
    private static final By SIGN_BUTTON = By.id("firstSendCode");
    private static final By INPUT_CODE = By.id("smsVerificationCodeInput");
    private static final By SEND_BUTTON = By.id("smsVerificationBtn");


    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select account menu")
    public AccountsPage selectAccountsMenu() {
        button.btnClick(ACCOUNTS);
        return this;
    }

    @Step("Click open account button")
    public AccountsPage clickOpenAccountButton() {
        button.btnClick(OPEN_ACCOUNTS_BUTTON);
        return this;
    }

    @Step("Select current account")
    public AccountsPage selectCurrentAccount() {
        button.btnClick(CURRENT_ACCOUNT);
        return this;
    }

    @Step("Select account for epv")
    public AccountsPage selectAccountForEpv() {
        button.btnClick(ACCOUNT_FOR_EPV);
        return this;
    }

    @Step("Click agreement checkbox")
    public AccountsPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click confirm button")
    public AccountsPage clickConfirmButton() {
        button.btnClick(CONFIRM_BUTTON);
        return this;
    }

    @Step("Click sign button")
    public AccountsPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Input code")
    public AccountsPage inputCode(String smsCode) {
        input.inputWithClear(INPUT_CODE, smsCode);
        return this;
    }

    @Step("Click send button")
    public AccountsPage clickSendButton() {
        button.btnClick(SEND_BUTTON);
        return this;
    }


    @Step("Click open current account button")
    public AccountsPage clickOpenCurrentAccountButton() {
        button.btnClick(OPEN_CURRENT_ACCOUNT_BUTTON);
        return this;
    }

    @Step("Click further button")
    public AccountsPage clickFurtherButton() {
        button.btnClick(FURTHER_BUTTON);
        return this;
    }
}
