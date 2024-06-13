package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void login(String phoneNumber, String password) {
        loginPage
                .inputPhoneNumber(phoneNumber)
                .inputPassword(password)
                .clickSubmitButton();
    }

    public void selectGuest() {
        loginPage
                .clickGuestButton();
    }

    public void clickForgetPasswordLink() {
        loginPage
                .clickForgotPasswordLink();
    }

    public void passwordRecovery_input_numberCode_login(String documentData, String phoneNumber) {
        loginPage
                .inputDocumentData(documentData)
                .inputUserName(phoneNumber)
                .clickSendSmsButton();
    }

    public void inputSmsCode(String smsCode) {
        loginPage
                .inputSmsCode(smsCode)
                .clickContinueButton();
    }

    public void passwordRecoverySetNewPassword(String newPassword, String confirmNewPassword) {
        loginPage
                .inputNewPassword(newPassword)
                .confirmNewPassword(confirmNewPassword)
                .saveAndLogin();
    }

    public void selectAlternativeCodeRadioButton() {
        loginPage
                .clickAlternativeCodeRadioButton();
    }

    public void clickChangePhoneNumberLink() {
        loginPage
                .clickChangePhoneNumberLink();
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
        loginPage
                .clickBaspanaBusinessButton();
    }

    public void inputBin(String bin, String binPass) {
        loginPage
                .inputBin(bin)
                .inputBinPass(binPass);
//                .clickLoginButton();
    }
}
