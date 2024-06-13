package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositPage;

public class DepositSteps {
    private final DepositPage depositPage;
    public DepositSteps(WebDriver driver) { depositPage = new DepositPage(driver); }

    public void selectMyBankMenu() {
        depositPage
                .selectMyBankMenu();
    }

    public void selectDepositsMenu() {
        depositPage.selectDepositsMenu();
    }

    public void selectOpenedDeposit() {
        depositPage.selectOpenedDeposit();
    }

    public void showAvailableOperations() {
        depositPage.showAvailableOperations();
    }

    public void changeGosPrem() {
        depositPage
                .selectChangeGosPremOperation()
                .clickSelectButton();
    }

    public void calculator() {
        depositPage
                .showDepositDetails()
                .openCalculator();
    }


    public void clickNewDepositButton() {
        depositPage.clickNewDepositButton();
    }

    public void clickOpenBaspanaDepositButton() {
        depositPage.clickOpenBaspanaDepositButton();
    }

    public void openDeposit(String smsCode) {
        depositPage
                .clickOpenDepositButton()
                .clickAgreementCheckbox()
                .clickContinue()
                .clickConfirm()
                .inputSmsCode(smsCode)
                .clickSend();
    }
}
