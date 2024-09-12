package steps;

import org.openqa.selenium.WebDriver;
import pages.RentSubsidyPage;

public class RentSubsidyStep {

    private final RentSubsidyPage rentSubsidyPage;
    public RentSubsidyStep(WebDriver driver) { rentSubsidyPage = new RentSubsidyPage(driver); }

    public void applyRequest() {
        rentSubsidyPage.clickApplyRequest();
    }

    public void clickModalButton() {
        rentSubsidyPage.clickModalButton();
    }

    public void cancelRequest() {
        rentSubsidyPage
                .clickActiveRequest()
                .clickCancelRequest()
                .clickConfirmCancelRequest()
                .clickCancelRequestAgreement()
                .clickSignAgreementButton();
    }
}
