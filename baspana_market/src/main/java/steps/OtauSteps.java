package steps;

import org.openqa.selenium.WebDriver;
import pages.OtauPage;

public class OtauSteps {

    private final OtauPage otauPage;

    public OtauSteps(WebDriver driver) {
        otauPage = new OtauPage(driver);
    }

    public void apply() {
        otauPage
                .clickApplyButton()
                .selectRealEstateRegion()
                .selectResidenceRegion()
                .clickAgreement()
                .clickContinueButton();
    }

    public void clickApplyButton() {
        otauPage
                .clickApplyButton();
    }

    public void selectDeposit() {
        otauPage
                .clickSelectDepositButton()
                .clickDepositValue()
                .clickSelectButton()
                .clickAgreementForPublic()
                .clickAgreementForSharePersonalData()
                .clickContinueButton()
                .clickConfirmButton();
    }

    public void cancelRequest() {
        otauPage
                .selectActiveRequest()
                .clickCancelButton()
                .clickConfirmCancelButton();
    }
}
