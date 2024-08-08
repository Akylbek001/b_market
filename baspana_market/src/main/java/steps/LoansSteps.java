package steps;

import org.openqa.selenium.WebDriver;
import pages.LoansPage;

import static pages.LoansPage.DEPOSIT_TERMINATION_SUM;

public class LoansSteps {

    private final LoansPage loansPage;

    public LoansSteps(WebDriver driver) {
        loansPage = new LoansPage(driver);
    }


    public void selectExistedLoan() {
        loansPage
                .selectExistedLoan();
    }

    public void openAvailableOperations() {
        loansPage
                .openAvailableOperations();
    }

    public void fullEarlyRepaymentOperation() {
        loansPage
                .selectFullEarlyRepaymentOperation();
    }

    public void partialEarlyRepaymentOperation() {
        loansPage
                .selectPartialEarlyRepaymentOperation();
    }

    public void replacementOfCollateralOperation() {
        loansPage
                .selectReplacementOfCollateralOperation();
    }

    public void extensionInsuranceContractOperation() {
        loansPage
                .selectExtensionInsuranceContractOperation();
    }

    public void changingPaymentDateOperation() {
        loansPage
                .selectChangingPaymentDateOperation();
    }

    public void selectSwitchingToHomeLoanOperation() {
        loansPage
                .selectSwitchingToHomeLoanOperation();
    }

    public void replacementOfCoBorrowerOperation() {
        loansPage
                .selectReplacementOfCoBorrowerOperation();
    }

    public void exclusionOfCoBorrowerOperation() {
        loansPage
                .selectExclusionOfCoBorrowerOperation();
    }

    public void selectFullRepaymentWithDepositTermination() {
        loansPage
                .selectFullRepaymentWithDepositTermination();
    }

    public void selectFullRepaymentWithoutDepositTermination() {
        loansPage
                .selectFullRepaymentWithoutDepositTermination();
    }

    public void fullEarlyRepayment(String otp) {
        loansPage
                .clickContinueFullRepaymentButton()
                .clickAgreementCheckbox()
                .clickSecondAgreementCheckbox()
                .clickValidationButton()
                .clickSignFullRepaymentButton()
                .inputOtp(otp)
                .clickSendOtpButton();
    }

    public void partialEarlyRepayment(String sum) {
        loansPage
//                .clickContinueButton()
//                .clickAgreementCheckbox()
//                .clickValidationButton()
                .inputSum(sum)
                .clickContinueButton()
                .clickSendButton()
                .clickSignButton()
                .inputSum(sum)
                .clickSendButton();
    }

    public void replacementOfCoBorrower(String iin) {
        loansPage
                .inputSearchIin(iin)
                .clickReplaceContinueButton()
                .selectExceptionType()
                .selectExceptionPerson()
                .selectRegion()
                .clickStartExceptionButton()
                .clickRequestFamilyInfoButton();
    }

    public void extensionInsuranceContract(String otp) {
        loansPage
                .clickExtensionInsuranceContractContinueButton()
                .clickEstateInsuranceCheckbox()
                .clickTitleInsuranceCheckbox()
                .clickAgreementToTransferCheckbox()
                .clickConfirmAgreementButton()
                .clickUploadDocumentButton()
                .inputInsuranceOtp(otp)
                .clickOtpVerificationButton()
                .clickNextToApplicationButton();

    }

    public void replacementOfCollateral() {
        loansPage
                .clickNextButton()
                .selectCollateralForChange()
                .clickStartButton();
    }
}
