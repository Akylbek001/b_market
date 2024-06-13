package steps;

import org.openqa.selenium.WebDriver;
import pages.AccountsPage;

public class AccountsSteps {
    private final AccountsPage accountsPage;
    public AccountsSteps(WebDriver driver) { accountsPage = new AccountsPage(driver); }

    public void selectAccountsMenu() {
        accountsPage
                .selectAccountsMenu();
    }

    public void openAccountButton() {
        accountsPage
                .clickOpenAccountButton();
    }

    public void openCurrentAccount() {
        accountsPage
                .selectCurrentAccount()
                .clickOpenCurrentAccountButton();
    }

    public void openAccountForEpvAcceptAgreement() {
        accountsPage
                .selectAccountForEpv()
                .clickAgreementCheckbox()
                .clickConfirmButton();
    }

    public void openAccountForEpvSignAndConfirm(String code) {
        accountsPage
                .clickSignButton()
                .inputCode(code)
                .clickSendButton();
    }

    public void clickFurtherButton() {
        accountsPage
                .clickFurtherButton();
    }
}
