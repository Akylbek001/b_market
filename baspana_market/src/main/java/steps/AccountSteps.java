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
                .clickOpenCurrentAccountButton();
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

    public void clickFurtherButton() {
        accountPage
                .clickFurtherButton();
    }
}
