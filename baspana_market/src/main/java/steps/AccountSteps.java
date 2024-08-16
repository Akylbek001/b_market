package steps;

import org.openqa.selenium.WebDriver;
import pages.AccountPage;

public class AccountSteps {
    private final AccountPage accountPage;
    public AccountSteps(WebDriver driver) { accountPage = new AccountPage(driver); }

    public void openAccountButton() {
        accountPage
                .clickOpenAccountButton();
    }

    public void openCurrentAccount() {
        accountPage
                .selectCurrentAccount()
                .clickOpenCurrentAccountButton();
    }

    public void openCurrentAccountContinue(String otp) {
        accountPage
                .clickFurtherButton()
                .selectAccountType()
                .clickContinueButton()
                .clickAgreement()
                .clickConfirm()
                .clickCloseModalNotificationButton()
                .inputStatementOTP(otp)
                .clickStatementContinueButton();
    }

    public void finishOpenCurrentAccount() {
        accountPage
                .clickSendRateButton();
    }

    public void openAvailableOperationsList() {
        accountPage
                .selectExistedCurrentAccount()
                .openAvailableOperations();
    }

    public void transferToDebt() {
        accountPage
                .transferToDebt();
    }

    public void transferToOtbasyBankClient() {
        accountPage
                .transferToOtbasyBankClient();
    }

    public void searchOtbasyBankClient_byPhoneNumber(String number) {
        accountPage
                .inputPhoneNumber(number);
    }

    public void searchOtbasyBankClient_validateClient(String number) {
        accountPage
                .inputPhoneNumber_clientNotFound(number);
    }

    public void searchOtbasyBankClient_byAltCode(String code) {
        accountPage
                .selectAltCodeTab()
                .inputAltCode(code);
    }

    public void validateOtbasyBankClient_byAltCode(String code) {
        accountPage
                .selectAltCodeTab()
                .inputAltCodeForValidation(code);
    }

    public void transferToOtherBank() {
        accountPage
                .transferToOtherBank();
    }

    public void searchOtherBankIban(String iban) {
        accountPage
                .inputIban(iban);
    }

    public void validateInvalidIban(String iban) {
        accountPage
                .inputIban_validation(iban);
    }

    public void transfer(String sum, String otp) {
        accountPage
                .inputSumToTransfer(sum)
                .clickSendTransferButton()
                .clickConfirmTransferButton()
                .inputTransferOtp(otp)
                .clickSendOtpButton();
    }

    public void transfer_insufficientFunds(String sum) {
        accountPage
                .inputSumToTransfer(sum)
                .clickSendTransferButton();
    }

    public void openAccountForEpvAcceptAgreement() {
        accountPage
                .selectAccountForEpv()
                .clickAgreementCheckbox()
                .clickConfirmButton();
    }

    public void openAccountForEpvSignAndConfirm(String code) {
        accountPage
                .clickSignButton()
                .inputCode(code)
                .clickSendButton();
    }

    public void addOtherBankAccount() {
        accountPage
                .clickOtherBank()
                .clickContinueOtherBank()
                .clickOtherBankName()
                .clickContinueOtherBank_();
    }
}
