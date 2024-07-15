package steps;

import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void loginButton() {
        mainPage
                .clickLoginButton();
    }

    public void clickProfileIcon() {
        mainPage
                .clickProfileIcon();
    }

    public void navigateToBaspanaNewsPage() {
        mainPage
                .clickReadBaspanaNewsButton();
    }

    public void clickCalculateButton() {
        mainPage
                .clickCalculateButton();
    }

    public void checkSaldo(String amount) {
        mainPage
                .inputDesireAmount(amount)
                .clickRealityTab();
    }

    public void fillMortgageForm(String amount, String numberOfFamily, String incomes, String costs) {
        mainPage
                .selectRegion()
                .selectRedemptionType()
                .inputDesireAmount(amount)
                .selectSpouseType()
                .inputNumberOfFamily(numberOfFamily)
                .inputIncomes(incomes)
                .inputCosts(costs);
    }

    public void postAd(String area, String floor) {
        mainPage
                .clickPostAdButton()
                .selectRoom()
                .inputTotalArea(area)
                .inputFloor(floor)
                .inputFloorInHouse(floor)
                .selectObjectState();
    }
}
