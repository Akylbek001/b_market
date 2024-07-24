package steps;

import org.openqa.selenium.WebDriver;
import pages.SpecAccountSgoPage;

public class SpecAccountSgoSteps {
    private final SpecAccountSgoPage specAccountSgoPage;
    public SpecAccountSgoSteps(WebDriver driver) {
        specAccountSgoPage = new SpecAccountSgoPage(driver);
    }

    public void selectTransferToFullPaymentOperation() {
        specAccountSgoPage
                .selectTransferToFullPaymentOperation();
    }

    public void selectTransferToPaymentWithRedemptionOperation() {
        specAccountSgoPage
                .selectTransferToPaymentWithRedemptionOperation();
    }

    public void inputPhone(String number) {
        specAccountSgoPage
                .inputPhone(number);
    }

    public void inputAltCode(String code) {
        specAccountSgoPage
                .clickAltCodeLabel()
                .inputAltCode(code);
    }

    public void inputTransferData(String contractNumber, String date) {
        specAccountSgoPage
                .inputContractNumber(contractNumber)
                .inputContractDate(date);
    }

    public void inputTransferData_withoutContract(String date) {
        specAccountSgoPage
                .clickWithoutContractSwitch()
                .inputContractDate(date);
    }

    public void inputSumToTransfer(String sum) {
        specAccountSgoPage
                .inputSumToTransfer(sum)
                .clickSendTransferButton();
    }

    public void confirmTransferByOtp(String otp) {
        specAccountSgoPage
                .confirmTransferButton()
                .inputOtp(otp)
                .clickSendOtpButton();
    }



}
