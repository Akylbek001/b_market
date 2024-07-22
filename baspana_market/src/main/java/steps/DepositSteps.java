package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositPage;

public class DepositSteps {
    private final DepositPage depositPage;
    public DepositSteps(WebDriver driver) { depositPage = new DepositPage(driver); }

    public void selectOpenedDeposit() {
        depositPage.selectOpenedDeposit();
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

    public void clearField() {
        depositPage
                .clearInputField();
    }

    public void agreedSum(String sum) {
        depositPage
                .inputAgreedSum(sum);
    }

    public void confirmBySms(Integer smsCode) {
        depositPage
//                .selectDepositTerm()
                .clickConfirm()
                .inputSmsCode(smsCode.toString())
                .clickSend();
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
                .selectFirstDeposit()
                .clickSelectButton()
                .clickGosPremAgreement()
                .clickSelectButton()
                .inputSmsCode(otp)
                .clickOtpConfirmButton();
    }

    public void changeGosPrem_validation() {
        depositPage
                .selectChangeGosPremOperation()
                .selectFirstDeposit()
                .clickSelectButton();
    }

    public void terminateDeposit() {
        depositPage
                .terminateDepositOperation()
                .clickTerminateButton()
                .clickContinueTerminateButton();
    }

    public void changeDepositConditions(String amount, String smsCode) {
        depositPage
                .changeDepositConditionsOperation()
                .inputNegotiatedAmount(amount)
                .clickChangeDetailButton()
                .clickSignChangeDetailButton()
                .inputSmsCode(smsCode)
                .clickSend();
    }

    public void selectCreateFamilyPackageOperation() {
        depositPage
                .createFamilyPackageOperation();
    }

    public void createFamilyPackage(String familyPackageName) {
        depositPage
                .selectDepositForPackage()
                .clickContinueButton()
                .inputFamilyPackageName(familyPackageName)
                .clickCreateFamilyPackageButton();
    }

    public void addMemberToFamilyPackage(String invitedIin, String invitedAlternativeCode) {
        depositPage
                .clickInviteFamilyPackageMemberButton()
                .openRelationDegreeList()
                .selectRelationDegreeValue()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void relationDegreeValidation(String invitedIin, String invitedAlternativeCode) {
        depositPage
                .clickInviteFamilyPackageMemberButton()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void removeFamilyPackageMember() {
        depositPage
                .clickCancelInviteIcon()
                .clickConfirmCancelInviteButton();
    }

    public void disbandFamilyPackage() {
        depositPage
                .clickDisbandFamilyPackageButton()
                .clickConfirmDisbandFamilyPackageButton();
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

    public void selectAssignmentGratuitousOperation(String iin, String otp) {
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
