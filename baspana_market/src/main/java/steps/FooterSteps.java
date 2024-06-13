package steps;

import org.openqa.selenium.WebDriver;
import pages.FooterPage;

public class FooterSteps {
    private final FooterPage footerPage;

    public FooterSteps(WebDriver driver) {
        footerPage = new FooterPage(driver);
    }

    public void navigateToInternetBankingPage() {
        footerPage
                .clickInternetBankingLink();
    }

    public void navigateToMortgagePage() {
        footerPage
                .clickMortgageLink();
    }

    public void navigateToCalcPage() {
        footerPage
                .clickCalcLink();
    }

    public void navigateToNewsPage() {
        footerPage
                .clickNewsLink();
    }

    public void navigateToProgramsPage() {
        footerPage
                .clickProgramsLink();
    }

    public void navigateToSiteMapPage() {
        footerPage
                .clickSiteMapLink();
    }

    public void navigateToNewBuildingsPage() {
        footerPage
                .clickNewBuildingsLink();
    }

    public void navigateToBaspanaInfoPage() {
        footerPage
                .clickBaspanaInfoLink();
    }

    public void navigateToBaiterekPage() {
        footerPage
                .clickBaiterekLink();
    }

    public void navigateToInformationSecurityPage() {
        footerPage
                .clickInformationSecurityLink();
    }

    public void navigateToDepositPortfolioPage() {
        footerPage
                .clickDepositPortfolioLink();
    }

    public void navigateToFacebookPage() {
        footerPage
                .clickFacebookLink();
    }

    public void navigateToVkPage() {
        footerPage
                .clickVkLink();
    }

    public void navigateToInstagramPage() {
        footerPage
                .clickInstagramLink();
    }

    public void navigateToYoutubePage() {
        footerPage
                .clickYoutubeLink();
    }
}
