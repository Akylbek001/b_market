package steps;

import org.openqa.selenium.WebDriver;
import pages.HeaderPage;

public class HeaderSteps {
    private final HeaderPage headerPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
    }

    public void navigateToBankProgram() {
        headerPage
                .clickBankProgramsButton()
                .selectMyHouseProgram();
    }

    public void navigateToNews() {
        headerPage
                .clickNews();
    }

    public void navigateToContacts() {
        headerPage
                .clickContacts();
    }

    public void navigateToFAQ() {
        headerPage
                .clickFAQ();
    }

    public void postAd() {
        headerPage
                .clickPostAdButton();
    }

    public void changeLocation() {
        headerPage
                .clickLocationName()
                .selectAnotherLocation();
    }

    public void selectKazakh() {
        headerPage
                .selectKazakhLanguage();
    }

    public void selectRussian() {
        headerPage
                .selectRussianLanguage();
    }

    public void navigateToFavorite() {
        headerPage
                .navigateToFavorite_();
    }

    public void switchPage() {
        headerPage
                .switchPage();
    }
}
