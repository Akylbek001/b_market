package steps;

import org.openqa.selenium.WebDriver;
import pages.LoansPage;

public class LoansSteps {

    private final LoansPage loansPage;

    public LoansSteps(WebDriver driver) {
        loansPage = new LoansPage(driver);
    }


    public void selectExistedLoan() {
        loansPage
                .selectExistedLoan();
    }
    public void selectThirdLoan() {
        loansPage
                .selectThirdLoan();
    }

    public void openAvailableOperations() {
        loansPage
                .openAvailableOperations();
    }

    public void fullEarlyRepaymentOperation() {
        loansPage
                .selectFullEarlyRepaymentOperation();
    }

    public void fullEarlyRepaymentOperation_smoke() {
        loansPage
                .selectFullEarlyRepaymentOperation_smoke();
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

    public void selectEPVAccount() {
        loansPage
                .selectAccount();
    }

    public void clickContinueButtonOnModal() {
        loansPage
                .clickContinueButtonOnModal();
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

    public void partialEarlyRepayment_validateAmount(String sum) {
        loansPage
                .inputSum(sum)
                .clickContinueButton();
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
//                .clickExtensionInsuranceContractContinueButton()
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
