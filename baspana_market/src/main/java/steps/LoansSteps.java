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

    public void openAvailableOperations() {
        loansPage
                .openAvailableOperations();
    }

    public void partialEarlyRepaymentOperation(String sum) {
        loansPage
                .selectPartialEarlyRepaymentOperation()
                .inputSum(sum)
                .clickContinueButton()
                .clickAgreementCheckbox()
                .clickValidationButton()
                .clickSignButton();
    }

    public void selectReplacementOfCollateralOperation() {
        loansPage
                .selectReplacementOfCollateralOperation()
                .clickNextButton()
                .selectCollateralForChange()
                .clickStartButton();
    }
}
