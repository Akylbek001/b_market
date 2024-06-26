package steps;

import org.openqa.selenium.WebDriver;
import pages.DigitalMortgagePage;

public class DigitalMortgageSteps {
    private final DigitalMortgagePage digitalMortgagePage;

    public DigitalMortgageSteps(WebDriver driver) {
        digitalMortgagePage = new DigitalMortgagePage(driver);
    }

    public void applyForDigitalMortgage() {
        digitalMortgagePage
                .clickDigitalMortgageBlock()
                .clickStartButton()
                .clickIConfirmedButton();
    }

    public void clickVideoCallBlock() {
        digitalMortgagePage
                .clickVideoCallBlock();
    }
}
