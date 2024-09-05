package steps;

import org.openqa.selenium.WebDriver;
import pages.GeneralPage;

public class GeneralSteps {
    private final GeneralPage generalPage;

    public GeneralSteps(WebDriver driver) {
        generalPage = new GeneralPage(driver);
    }

    public void acceptAgreement_startBiometry() {
        generalPage
                .clickAgreementCheckbox()
                .clickStartBiometryButton();
    }

    public void acceptAgreement() {
        generalPage
                .clickAgreementCheckbox();
    }

    public void startBiometry() {
        generalPage
                .clickStartBiometryButton();
    }

    public void confirmationByOtp(String otp) {
        generalPage
                .inputOtp(otp)
                .clickSendOtpButton();
    }

    public void confirmationByOtp_(String otp) {
        generalPage
                .inputOtp(otp)
                .clickSendOtpButton_();
    }
}
