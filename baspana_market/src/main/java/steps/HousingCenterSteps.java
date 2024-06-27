package steps;

import org.openqa.selenium.WebDriver;
import pages.HousingCenterPage;

public class HousingCenterSteps {
    private final HousingCenterPage housingCenterPage;
    public HousingCenterSteps(WebDriver driver) { housingCenterPage = new HousingCenterPage(driver); }

    public void applyRequest_validateNcaLayer() {
        housingCenterPage
                .clickApplyRequest()
                .clickAgreementCheckBox()
                .clickSignButton();
//                .clickFinishButton();
    }
}
