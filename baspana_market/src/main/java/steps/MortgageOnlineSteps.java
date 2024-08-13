package steps;

import org.openqa.selenium.WebDriver;
import pages.MortgageOnlinePage;

public class MortgageOnlineSteps {
    private final MortgageOnlinePage mortgageOnlinePage;

    public MortgageOnlineSteps(WebDriver driver) {
        mortgageOnlinePage = new MortgageOnlinePage(driver);
    }

    public void clickStartVideoCallButton() {
        mortgageOnlinePage
                .clickStartVideoCallButton();
    }

    public void clickAgreementCheckbox() {
        mortgageOnlinePage
                .clickAgreementCheckbox();
    }

    public void confirm() {
        mortgageOnlinePage
//                .clickConfirmButton()
                .clickConfirmButton();
    }
}
