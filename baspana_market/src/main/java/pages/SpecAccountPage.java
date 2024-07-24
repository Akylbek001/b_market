package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.SpecAccountSgoPage.OTP_CODE_FOR_TRANSFER;

public class SpecAccountPage extends BasePage {
    private static final By SPEC_ACCOUNT = By.cssSelector("a.card.specialAccount");
    private static final By SPEC_ACCOUNT_OPERATIONS = By.cssSelector(".allOperBtn.cursor_pointer");
    private static final By TRANSFER_TO_DEPOSIT = By.id("transferToDep");
    private static final By TRANSFER_TO_RENT = By.id("transferToRent");
    private static final By TRANSFER_TO_MORTGAGE = By.id("transferToMortgage");
    public static final By ERROR_TEXT = By.cssSelector("#operationErrorModal #errorText");

    public static final By RECIPIENT_TYPE = By.cssSelector(".select-selected");
    public static final By INDIVIDUAL = By.xpath("//div[@class='select-items'] /div[1]");
    public static final By LEGAL_ENTITY = By.xpath("//div[@class='select-items'] /div[2]");
    private static final By IIN = By.id("inputNormalIin");
    private static final By BIN = By.id("inputLegalIin");
    private static final By BIN_OF_LOAN_REPAYMENT = By.id("inputLegalBin");

    private static final By IBAN = By.id("inputNormalIban");
    private static final By IBAN_RE = By.id("inputLegalIban");
    private static final By BANK_NAME = By.id("ibanBankNaturalPerson");
    private static final By BANK_NAME_RE = By.id("ibanBank");

    public static final By WITH_NUMBER_SWITCH = By.cssSelector("#naturalPersonDiv .slider.round");
    public static final By WITH_NUMBER_SWITCH_RE = By.cssSelector("#legalEntityDiv .slider.round");

    public static final By CONTRACT_NUMBER = By.id("inputNormalApplicationNumber");
    public static final By CONTRACT_NUMBER_RE = By.id("inputLegalApplicationNumber");

    public static final By CONTRACT_DATE = By.id("inputNormalApplicationDate");
    public static final By CONTRACT_DATE_RE = By.id("inputLegalApplicationDate");

    public static final By SUM_TO_TRANSFER_FOR_INDIVIDUAL = By.id("sumToTransferNormal");
    public static final By SUM_TO_TRANSFER_RE = By.id("sumToTransferLegal");
    public static final By AGREEMENT = By.cssSelector("[for='NaturalCheckbox']");
    public static final By AGREEMENT_RE = By.cssSelector("[for='legalConfirmCheckbox']");

    public static final By SEND_TRANSFER_BUTTON = By.id("sendTransferNaturalPerson");
    public static final By SEND_TRANSFER_BUTTON_RE = By.id("sendTransferLegalEntity");


    public SpecAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select spec account")
    public SpecAccountPage selectSpecAccount() {
        button.btnClick(SPEC_ACCOUNT);
        return this;
    }

    @Step("Open spec account operations")
    public SpecAccountPage openSpecAccountOperations() {
        button.btnClick(SPEC_ACCOUNT_OPERATIONS);
        return this;
    }

    @Step("Select transfer to deposit operation")
    public SpecAccountPage selectTransferToDepositOperation() {
        button.btnClick(TRANSFER_TO_DEPOSIT);
        return this;
    }
    @Step("Select transfer to deposit rent")
    public SpecAccountPage selectTransferToRentOperation() {
        button.btnClick(TRANSFER_TO_RENT);
        elementsAttributes.waitUntilVisible(RECIPIENT_TYPE);
        return this;
    }
    @Step("Select transfer to mortgage operation")
    public SpecAccountPage selectTransferToMortgageOperation() {
        button.btnClick(TRANSFER_TO_MORTGAGE);
        return this;
    }

    @Step("Open recipient type list")
    public SpecAccountPage openRecipientTypeList() {
        button.btnClick(RECIPIENT_TYPE);
        elementsAttributes.waitUntilVisible(INDIVIDUAL);
        return this;
    }

    @Step("Select individual")
    public SpecAccountPage selectIndividual() {
        button.btnClick(INDIVIDUAL);
        return this;
    }

    @Step("Select legal entity")
    public SpecAccountPage selectLegalEntity() {
        button.btnClick(LEGAL_ENTITY);
        return this;
    }

    @Step("Input iin")
    public SpecAccountPage inputIin(String iin) {
        input.inputWithClear(IIN, iin);
        return this;
    }

    @Step("Input bin")
    public SpecAccountPage inputBin(String bin) {
        input.inputWithClear(BIN, bin);
        return this;
    }

    @Step("Input bin for loan repayment")
    public SpecAccountPage inputBin_loanRepayment(String bin) {
        input.inputWithClear(BIN_OF_LOAN_REPAYMENT, bin);
        return this;
    }

    @Step("Input iban")
    public SpecAccountPage inputIban(String iban) {
        input.inputWithClear(IBAN, iban);
        elementsAttributes.waitUntilVisible(BANK_NAME);
        return this;
    }

    @Step("Input iban of RE")
    public SpecAccountPage inputIban_RE(String iban) {
        input.inputWithClear(IBAN_RE, iban);
        elementsAttributes.waitUntilVisible(BANK_NAME_RE);
        return this;
    }

    @Step("Click <with number> switch")
    public SpecAccountPage clickWithNumberSwitch() {
        button.btnClick(WITH_NUMBER_SWITCH);
        return this;
    }

    @Step("Click <with number> switch of RE")
    public SpecAccountPage clickWithNumberSwitch_re() {
        button.btnClick(WITH_NUMBER_SWITCH_RE);
        return this;
    }

    @Step("Input contract number")
    public SpecAccountPage inputContractNumber(String number) {
        input.inputWithClear(CONTRACT_NUMBER, number);
        return this;
    }

    @Step("Input contract number of RE")
    public SpecAccountPage inputContractNumber_re(String number) {
        input.inputWithClear(CONTRACT_NUMBER_RE, number);
        return this;
    }

    @Step("Input contract date")
    public SpecAccountPage inputContractDate(String date) {
        input.inputWithClear(CONTRACT_DATE, date);
        return this;
    }

    @Step("Input contract date")
    public SpecAccountPage inputContractDate_re(String date) {
        input.inputWithClear(CONTRACT_DATE_RE, date);
        return this;
    }

    @Step("Input sum to transfer for individual")
    public SpecAccountPage inputSumToTransfer_forIndividual(String sum) {
        input.inputWithClear(SUM_TO_TRANSFER_FOR_INDIVIDUAL, sum);
        return this;
    }

    @Step("Input sum to transfer for RE")
    public SpecAccountPage inputSumToTransfer_re(String sum) {
        input.inputWithClear(SUM_TO_TRANSFER_RE, sum);
        return this;
    }

    @Step("Click agreement")
    public SpecAccountPage clickAgreement() {
        button.btnClick(AGREEMENT);
        return this;
    }

    @Step("Click agreement of RE")
    public SpecAccountPage clickAgreement_re() {
        move.scrollToElement(AGREEMENT_RE);
        button.btnClick(AGREEMENT_RE);
        return this;
    }

    @Step("Click send transfer button")
    public SpecAccountPage clickSendTransferButton() {
        button.btnClick(SEND_TRANSFER_BUTTON);
        elementsAttributes.waitUntilVisible(OTP_CODE_FOR_TRANSFER);
        return this;
    }

    @Step("Click send transfer button for RE")
    public SpecAccountPage clickSendTransferButton_re() {
        button.btnClick(SEND_TRANSFER_BUTTON_RE);
        return this;
    }


}
