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
    public void openAvailableOperations_onProd() {
        loansPage
                .openAvailableOperations_onProd();
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

    public void selectReplacementOfCoBorrowerOperation() {
        loansPage
                .selectReplacementOfCoBorrowerOperation();
    }
    public void selectResettingDepositOperation() {
        loansPage
                .selectResettingDepositOperation();
    }

    public void replacementOfCoBorrowerOperation() {
        loansPage
                .replacementOfCoBorrowerOperation();
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

    public void clickTopUpAccountButton() {
        loansPage
                .clickTopUpAccountButton();
    }

    public void topUpAccount(String email, String amount) {
        loansPage
                .inputEmail(email)
                .inputAmount(amount)
                .clickTopUpContinueButton();
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
                .inputSum(sum)
                .clickContinueButton()
                .clickAgreementCheckbox()
                .clickValidationButton()
                .clickSignButton();
    }

    public void otp(String otp) {
        loansPage
                .inputOtp_(otp)
                .clickConfirmOtpButton();
    }

    public void signTheSchedule(String otp) {
        loansPage
                .clickContinueToScheduleButton()
                .clickSignScheduleButton_()
                .inputOtp(otp)
                .clickSendOtpButton();
    }

    public void partialEarlyRepayment_validateAmount(String sum) {
        loansPage
                .inputSum(sum)
                .clickContinueButton_validate();
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
