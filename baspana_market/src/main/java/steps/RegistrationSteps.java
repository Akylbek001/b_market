package steps;

import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        registrationPage = new RegistrationPage(driver);
    }

    public void acceptAgreement() {
        registrationPage
                .clickAcceptAndContinueButton();
    }

    public void clickRegisterGuestButton() {
        registrationPage
                .clickRegisterGuestButton();
    }

    public void clickRegisterClientButton() {
        registrationPage
                .clickRegisterClientButton();
    }

    public void registrationGuest(String guestName) {
        registrationPage
                .inputGuestName(guestName);
    }

    public void registrationByDocumentCode(String documentNumber) {
        registrationPage
                .clickClientBlock()
                .inputDocumentCode(documentNumber);
    }

    public void registrationByAlternativeCode(String alternativeCode) {
        registrationPage
                .clickClientBlock()
                .clickAlternativeRadioButton()
                .inputDocumentCode(alternativeCode);
    }

    public void inputRegistrationData(
            String phone, String email, String password, String confirmPassword
    ) {
        registrationPage
                .inputGuestPhone(phone)
                .inputGuestEmail(email)
                .inputGuestPass(password)
                .confirmGuestPass(confirmPassword);
    }

    public void confirmRegistrationBySmsCode(String smsCode) {
        registrationPage
                .inputSmsCode(smsCode)
                .clickSubmit();
    }
}
