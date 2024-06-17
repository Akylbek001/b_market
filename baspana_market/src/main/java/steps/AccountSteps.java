package steps;

import org.openqa.selenium.WebDriver;
import pages.AccountPage;

public class AccountSteps {
    private final AccountPage accountPage;
    public AccountSteps(WebDriver driver) { accountPage = new AccountPage(driver); }

    public void selectAccountsMenu() {
        accountPage
                .selectAccountsMenu();
    }

    public void openAccountButton() {
        accountPage
                .clickOpenAccountButton();
    }

    public void openCurrentAccount() {
        accountPage
                .selectCurrentAccount()
                .clickOpenCurrentAccountButton()
                .clickFurtherButton();
    }

    public void openCurrentAccountContinue(String otp) {
        accountPage
                .selectAccountType()
                .clickContinueButton()
                .clickAgreement()
                .clickConfirm()
                .inputOTP(otp)
                .clickContinue()
                .clickSend();
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
