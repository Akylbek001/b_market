package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositAssignmentGratuitousPage;

public class DepositAssignmentGratuitousStep {
    private final DepositAssignmentGratuitousPage depositAssignmentGratuitousPage;
    public DepositAssignmentGratuitousStep(WebDriver driver) {
        depositAssignmentGratuitousPage = new DepositAssignmentGratuitousPage(driver);
    }

    public void assignmentGratuitousOperation(String iin) {
        depositAssignmentGratuitousPage
                .clickAssignmentGratuitousContinueButton()
                .selectRelationDegree()
                .inputIin(iin)
                .clickAssignmentGratuitousContinueButton_();
    }

    public void navigateToRequestForSign() {
        depositAssignmentGratuitousPage
                .navigateToRequestForSign()
                .clickRequestBlock();
    }

    public void assignmentGratuitous_continue() {
        depositAssignmentGratuitousPage
                .clickContinueRequestConfirmationButton()
                .clickFinalSignButton();
    }

    public void rejectRequest() {
        depositAssignmentGratuitousPage
                .clickRejectRequestButton();
    }

    public void acceptRequest() {
        depositAssignmentGratuitousPage
                .clickAcceptRequestButton()
                .clickAcceptRequestCheckbox()
                .clickAcceptRequestContinueButton()
                .clickSignButton();
//                .clickContinueRequestConfirmationButton();
    }

    public void fifthSignStep() {
        depositAssignmentGratuitousPage
                .clickFifthSignStepButton();
    }

    public void confirmByOTP(String otp) {
        depositAssignmentGratuitousPage
                .inputSmsCode(otp)
                .clickOtpConfirmButton();
    }

    public void confirmByOtp(String otp) {
        depositAssignmentGratuitousPage
                .clickAssignmentGratuitousContinueButton_()
                .inputSmsCode(otp)
                .clickOtpConfirmButton();
    }
}
