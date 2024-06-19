package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
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
    private static final By SELECT_ACCOUNT_TYPE = By.id("//span[text()='Платежи за аренду жилища']");
    private static final By CURRENT_ACCOUNT_CONTINUE_BUTTON = By.id("btnOpenNewCurAccountNext");
    private static final By CURRENT_ACCOUNT_AGREEMENT_CHECKBOX = By.id("fatca-check");
    private static final By CURRENT_ACCOUNT_CONFIRM = By.id("fatca-button");
    private static final By NOTIFICATION_BUTTON = By.cssSelector(".modal-footer [onclick='modalNotificationCloseClick()']");
    private static final By STATEMENT_OTP = By.id("inputOtpCode");
    private static final By STATEMENT_CONTINUE_BUTTON = By.cssSelector(".deposit_check_submit button");
    private static final By SEND_RATE_BUTTON = By.cssSelector("[onclick='SendRate()']");
    public static final By OPERATION_COMPLETED_SUCCESSFULLY = By.cssSelector(".part-pay_complete_content h2");
    public static final By NOTIFICATION_TEXT = By.cssSelector("label#modalNotificationBody");

    public static final By EXISTED_CURRENT_ACCOUNT = By.cssSelector(".card.account");




    private static final By AGREEMENT_CHECKBOX = By.id("formCheckOne");
    private static final By CONFIRM_BUTTON = By.id("formButtonOne");
    private static final By SIGN_BUTTON = By.id("firstSendCode");
    private static final By INPUT_CODE = By.id("smsVerificationCodeInput");
    private static final By SEND_BUTTON = By.id("smsVerificationBtn");

    private static final By OTHER_BANK_LABEL = By.xpath("//div[@class='others-bank'] /a");
    private static final By OTHER_BANK_CONTINUE_BUTTON = By.xpath("//button[@class='button-mybank green']");
    private static final By OTHER_BANK_NAME = By.xpath("//div[@class='checkBox-Banks'] /div[2]");
    private static final By OTHER_BANK_CONTINUE_BUTTON_ = By.xpath("//div[@class='Button-SMS'] /button");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select account menu")
    public AccountPage selectAccountsMenu() {
        button.btnClick(ACCOUNTS);
        return this;
    }

    @Step("Click open account button")
    public AccountPage clickOpenAccountButton() {
        button.btnClick(OPEN_ACCOUNTS_BUTTON);
        return this;
    }

    @Step("Select current account")
    public AccountPage selectCurrentAccount() {
        button.btnClick(CURRENT_ACCOUNT);
        return this;
    }

    @Step("Select account for epv")
    public AccountPage selectAccountForEpv() {
        button.btnClick(ACCOUNT_FOR_EPV);
        return this;
    }

    @Step("Click agreement checkbox")
    public AccountPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click confirm button")
    public AccountPage clickConfirmButton() {
        button.btnClick(CONFIRM_BUTTON);
        return this;
    }

    @Step("Click sign button")
    public AccountPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Input code")
    public AccountPage inputCode(String smsCode) {
        input.inputWithClear(INPUT_CODE, smsCode);
        return this;
    }

    @Step("Click send button")
    public AccountPage clickSendButton() {
        button.btnClick(SEND_BUTTON);
        return this;
    }

    @Step("Click open current account button")
    public AccountPage clickOpenCurrentAccountButton() {
        button.btnClick(OPEN_CURRENT_ACCOUNT_BUTTON);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Click further button")
    public AccountPage clickFurtherButton() {
        button.btnClick(FURTHER_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select account type")
    public AccountPage selectAccountType() {
        button.btnClick(SELECT_ACCOUNT_TYPE);
        return this;
    }

    @Step("Click continue button")
    public AccountPage clickContinueButton() {
        button.btnClick(CURRENT_ACCOUNT_CONTINUE_BUTTON);
        return this;
    }

    @Step("Click agreement checkbox")
    public AccountPage clickAgreement() {
        button.btnClick(CURRENT_ACCOUNT_AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click confirm")
    public AccountPage clickConfirm() {
        button.btnClick(CURRENT_ACCOUNT_CONFIRM);
        return this;
    }

    @Step("Click close modal notification button")
    public AccountPage clickCloseModalNotificationButton() {
        button.btnClick(NOTIFICATION_BUTTON);
        return this;
    }

    @Step("Input statement otp")
    public AccountPage inputStatementOTP(String otp) {
        input.inputWithClear(STATEMENT_OTP, otp);
        return this;
    }

    @Step("Click statement continue button")
    public AccountPage clickStatementContinueButton() {
        button.btnClick(STATEMENT_CONTINUE_BUTTON);
        return this;
    }

    @Step("Click other bank label")
    public AccountPage clickOtherBank() {
        button.btnClick(OTHER_BANK_LABEL);
        return this;
    }

    @Step("Click continue button")
    public AccountPage clickContinueOtherBank() {
        button.btnClick(OTHER_BANK_CONTINUE_BUTTON);
        return this;
    }

    @Step("Select other bank name")
    public AccountPage clickOtherBankName() {
        button.btnClick(OTHER_BANK_NAME);
        return this;
    }


    @Step("Click continue button")
    public AccountPage clickContinueOtherBank_() {
        button.btnClick(OTHER_BANK_CONTINUE_BUTTON_);
        return this;
    }
}
