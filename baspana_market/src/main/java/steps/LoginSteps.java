package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginSteps {

    private final LoginPage loginPage;
    private final MainPage mainPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public void auth(String phoneNumber, String password) {
        mainPage.clickLoginButton();
        loginPage
                .inputPhoneNumber(phoneNumber)
                .inputPassword(password)
                .clickSubmitButton();
    }

    public void login(String phoneNumber, String password) {
        loginPage
                .inputPhoneNumber(phoneNumber)
                .inputPassword(password)
                .clickSubmitButton();
    }

    public void selectGuest() {
        loginPage.clickGuestButton();
    }

    public void clickForgetPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    public void passwordRecovery_inputData(String number, String phone) {
        loginPage
                .inputDocumentNumber(number)
                .inputUserName(phone)
                .clickSendSmsButton();
    }

    public void inputSmsCode(String smsCode) {
        loginPage
                .inputSmsCode(smsCode)
                .clickReCapture()
                .clickContinueButton();
    }

    public void passwordRecoverySetNewPassword(String newPassword, String confirmNewPassword) {
        loginPage
                .inputNewPassword(newPassword)
                .confirmNewPassword(confirmNewPassword)
                .saveAndLogin();
    }

    public void selectAlternativeCodeRadioButton() {
        loginPage.clickAlternativeCodeRadioButton();
    }

    public void clickChangePhoneNumberLink() {
        loginPage.clickChangePhoneNumberLink();
    }

    public void inputIinAndLogin(String iin, String phone) {
        loginPage
                .inputIin(iin)
                .inputPhone(phone)
                .clickContinue();
    }

    public void startBiometryChecking() {
        loginPage
                .clickAgreementCheckBox()
                .clickStartBiometry();
    }

    public void selectBaspanaBusiness() {
        loginPage.clickBaspanaBusinessButton();
    }

    public void inputBin(String bin, String password) {
        loginPage
                .inputBin(bin)
                .inputBinPass(password);
//                .clickLoginButton();
    }

    public void registration() {
        loginPage.clickRegisterLink();
    }

    public void becomeClient() {
        loginPage.clickBecomeClientButton();
    }
}
