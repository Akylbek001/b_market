package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositPage;

public class DepositSteps {
    private final DepositPage depositPage;
    public DepositSteps(WebDriver driver) { depositPage = new DepositPage(driver); }

    public void selectOpenedDeposit() {
        depositPage.selectOpenedDeposit();
    }

    public void selectCreateFamilyPackageOperation() {
        depositPage
                .createFamilyPackageOperation();
    }

    public void clickNewDepositButton() {
        depositPage.clickNewDepositButton();
    }

    public void clickOpenBaspanaDepositButton() {
        depositPage.clickOpenBaspanaDepositButton();
    }

    public void openBaspanaDeposit() {
        depositPage
                .clickOpenDepositButton()
                .clickAgreementCheckbox()
                .clickSubmit();
    }

    public void openAqyl() {
        depositPage
                .clickOpenAqylButton()
                .clickOpenAqylContinueButton();
    }

    public void cleanField() {
        depositPage
                .cleanField()
                .clickConfirmForValidateSum();
    }

    public void agreedSum(String sum) {
        depositPage
                .inputAgreedSum(sum);
//                .clickConfirmForValidateSum();
    }

    public void confirmBySms(String smsCode) {
        depositPage
                .clickConfirm()
                .inputSmsCode(smsCode)
                .confirmOpeningDeposit();
    }

    public void selectFirstDeposit() {
        depositPage
                .selectFirstDeposit();
    }

    public void selectSecondDeposit() {
        depositPage
                .selectSecondDeposit();
    }

    public void showAvailableOperations() {
        depositPage.showAvailableOperations();
    }

    public void changeGosPrem(String otp) {
        depositPage
                .selectChangeGosPremOperation()
                ._selectSecondDeposit()
                .clickSelectButton()
                .clickGosPremAgreement()
                .clickSelectButton()
                .inputSmsCode(otp)
//                .clickOtpConfirmButton();
                .clickSelectButton();
    }

    public void changeGosPrem_validation() {
        depositPage
                .selectChangeGosPremOperation()
                ._selectFirstDeposit()
                .clickSelectButton();
    }

    public void terminateDeposit() {
        depositPage
                .terminateDepositOperation()
                .clickTerminateButton()
                .clickContinueTerminateButton();
    }

    public void changeDepositConditionsAmount(String amount) {
        depositPage
                .changeDepositConditionsOperation()
                .inputNegotiatedAmount(amount);
    }

    public void confirmDepositConditionsChange(String smsCode) {
        depositPage
                .clickChangeDetailButton()
                .clickSignChangeDetailButton()
                .inputSmsCode(smsCode)
                .confirmChangeDepositTerms();
    }

    public void selectDepositDivisionOperation() {
        depositPage
                .createDepositDivisionOperation()
                .clickDivideButton();
    }

    public void selectUniteDepositOperation() {
        depositPage
                .selectUniteDepositOperation();
    }

    public void uniteDeposits(String otp) {
        depositPage
                .selectFirstDepositToUnite()
                .selectSecondDepositToUnite()
                .clickConfirmSelectedDepositsButton()
                .clickUniteDepositsConfirmButton()
                .inputOtp(otp)
                .clickUniteDepositsContinueButton()
                .selectDepositForGosPrem()
                .clickConfirmSelection();
    }

    public void depositPolling_otpValidation(String otp) {
        depositPage
                .selectFirstDepositToUnite()
                .selectSecondDepositToUnite()
                .clickConfirmSelectedDepositsButton()
                .clickUniteDepositsConfirmButton()
                .inputOtp(otp)
                .clickUniteDepositsContinueButton();
    }

    public void selectAssignmentGratuitousOperation() {
        depositPage
                .selectAssignmentGratuitousOperation();
    }

    public void assignmentGratuitousOperation(String iin, String otp) {
        depositPage
                .selectAssignmentGratuitousOperation()
                .clickAssignmentGratuitousContinueButton()
                .selectRelationDegree()
                .inputIin(iin)
                .clickAssignmentGratuitousContinueButton_();
    }

    public void confirmByOtp(String otp) {
        depositPage
                .clickAssignmentGratuitousContinueButton_()
                .inputSmsCode(otp)
                .clickOtpConfirmButton();
    }

    public void calculator() {
        depositPage
                .showDepositDetails()
                .openCalculator();
    }
}
