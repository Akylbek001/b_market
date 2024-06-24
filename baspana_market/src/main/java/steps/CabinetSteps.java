package steps;

import org.openqa.selenium.WebDriver;
import pages.CabinetPage;


public class CabinetSteps {
    private final CabinetPage cabinetPage;

    public CabinetSteps(WebDriver driver) {
        cabinetPage = new CabinetPage(driver);
    }

    public void selectProfileMenu() {
        cabinetPage
                .clickProfileMenu();
    }

    public void selectMyBankMenu() {
        cabinetPage
                .selectMyBankMenu();
    }

    public void selectDepositsMenu() {
        cabinetPage.selectDepositsMenu();
    }

    public void selectAccountsMenu() {
        cabinetPage
                .selectAccountsMenu();
    }

    public void selectCertificatesMenu() {
        cabinetPage
                .selectCertificatesMenu();
    }

    public void addEditEmail(String email) {
        cabinetPage
                .clickAddEditEmailButton()
                .inputEmail(email)
                .clickSaveEmailButton();
    }

    public void changePassword(String oldPassword, String newPassword) {
        cabinetPage
                .clickChangePasswordButton()
                .inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .inputConfirmPassword(newPassword)
                .clickChangePasswordSubmitButton();
    }
}
