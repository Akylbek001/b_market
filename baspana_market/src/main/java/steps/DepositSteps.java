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

    public void selectCreateFamilyPackageOperation_() {
        depositPage
                .createFamilyPackageOperation_();
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

    public void agreedSum(String sum) {
        depositPage
                .inputAgreedSum(sum);
//                .clickConfirmForValidateSum();
    }

    public void clickConfirm() {
        depositPage
                .clickConfirm();
    }

    public void confirmBySms(String smsCode) {
        depositPage
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

    public void selectSecondDeposit_prod() {
        depositPage
                .selectSecondDeposit_prod();
    }

    public void showAvailableOperations() {
        depositPage.showAvailableOperations();
    }

    public void changeGosPrem(String otp) {
        depositPage
                .selectChangeGosPremOperation()
//                ._selectSecondDeposit()
                .clickSelectButton()
                .clickGosPremAgreement()
                .clickSelectButton()
                .inputOtpCode(otp)
//                .clickOtpConfirmButton();
                .clickSelectButton();
    }

    public void changeGosPrem_smoke() {
        depositPage
                .changeGosPremOperation();
    }

    public void terminateDeposit_smoke() {
        depositPage
                .terminateDepositOperation_();
    }

    public void changeDepositConditions_smoke() {
        depositPage
                .changeDepositConditionsOperation_();
    }

    public void depositDivisionOperation() {
        depositPage
                .depositDivisionOperation();
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

    public void changeDepositConditionsOperation() {
        depositPage
                .changeDepositConditionsOperation();
    }

    public void clickAmount() {
        depositPage
                .clickAmount();
    }

    public void confirmDepositConditionsChange() {
        depositPage
                .clickChangeDetailButton();
    }

    public void signByOtp(String smsCode) {
        depositPage
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
    public void uniteDepositOperation() {
        depositPage
                .uniteDepositOperation();
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

//    public void assignmentGratuitousOperation(String iin, String otp) {
//        depositPage
//                .selectAssignmentGratuitousOperation()
//                .clickAssignmentGratuitousContinueButton()
//                .selectRelationDegree()
//                .inputIin(iin)
//                .clickAssignmentGratuitousContinueButton_();
//    }
//
//    public void navigateToRequestForSign() {
//        depositPage
//                .navigateToRequestForSign()
//                .clickRequestBlock();
//    }
//
//    public void rejectRequest() {
//        depositPage
//                .clickRejectRequestButton();
//    }
//
//    public void acceptRequest() {
//        depositPage
//                .clickAcceptRequestButton()
//                .clickAcceptRequestCheckbox()
//                .clickAcceptRequestContinueButton()
//                .clickSignButton()
//                .clickContinueRequestConfirmationButton();
//    }
//
//    public void acceptRequest_otp(String otp) {
//        depositPage
//                .inputAcceptConfirmationOtp(otp)
//                .clickConfirmOtpButton();
//    }
//
//    public void confirmByOtp(String otp) {
//        depositPage
//                .clickAssignmentGratuitousContinueButton_()
//                .inputSmsCode(otp)
//                .clickOtpConfirmButton();
//    }

    public void calculator() {
        depositPage
                .showDepositDetails()
                .openCalculator();
    }
}
