package steps;

import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void navigateToMainBanner() {
        mainPage
                .navigateToMainBanner();
    }

    public void closeBannerIcon() {
        mainPage
                .closeBannerIcon();
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

    public void clickNaurizMortgage() {
        mainPage
                .clickNaurizMortgage();
    }

    public void clickHappyFamilyMortgage() {
        mainPage
                .clickHappyFamilyMortgage();
    }

    public void clickShowAllNewBuildingsButton() {
        mainPage
                .clickShowAllNewBuildingsButton();
    }

    public void clickShowAllSecondaryHousingButton() {
        mainPage
                .clickShowAllSecondaryHousingButton();
    }

    public void clickShowAllStateProgramsButton() {
        mainPage
                .clickShowAllStateProgramsButton();
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
                .inputCosts(costs)
                .clickRealityTabCalculateButton();
    }

    public void postAd(String area, String floor, String street, String house, String description, String price) {
        mainPage
                .selectRoom()
                .inputTotalArea(area)
                .inputFloor(floor)
                .inputFloorInHouse(floor)
                .selectObjectState()
                ._selectRegion()
                .selectCity()
                .inputStreet(street)
                .inputHouse(house)
                .selectHouseType()
                .inputDescription(description)
                .inputPrice(price)
                .clickPublicButton();
    }

    public void removeAd() {
        mainPage
                .clickRemoveButton()
                .clickRemoveConfirmButton();
    }

    public void clickPostAdButton() {
        mainPage
                .clickPostAdButton();
    }

    public void clickPostAdButton_fromMyAdBlock() {
        mainPage
                .clickPostAdButton_fromMyAdBlock();
    }

    public void clickLogOutButton() {
        mainPage
                .clickLogOutButton();
    }
}
