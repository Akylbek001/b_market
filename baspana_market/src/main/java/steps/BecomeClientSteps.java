package steps;

import org.openqa.selenium.WebDriver;
import pages.BecomeClientPage;

public class BecomeClientSteps {
    private final BecomeClientPage becomeClientPage;

    public BecomeClientSteps(WebDriver driver) { becomeClientPage = new BecomeClientPage(driver); }

    public void becomeClientByOpenDeposit(String authPhone, String authIin) {
        becomeClientPage
                .becomeClientButton()
                .clickOpenDepositBlock()
                .clickOpenDepositButton()
                .inputAuthPhone(authPhone)
                .inputAuthIin(authIin)
                .clickVerifyButton();
    }

    public void becomeClientByOpenAccountForNFD(String authPhone, String authIin) {
        becomeClientPage
                .becomeClientButton()
                .clickAccountForNFDBlock()
                .inputAuthPhone(authPhone)
                .inputAuthIin(authIin)
                .clickVerifyButton();
    }

    public void becomeClientByOpenAccountForEPV(String authPhone, String authIin) {
        becomeClientPage
                .becomeClientButton()
                .clickAccountForEPVBlock()
                .inputAuthPhone(authPhone)
                .inputAuthIin(authIin)
                .clickVerifyButton();
    }
}
