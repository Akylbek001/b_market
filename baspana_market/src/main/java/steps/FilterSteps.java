package steps;

import org.openqa.selenium.WebDriver;
import pages.FilterPage;

public class FilterSteps {
    private final FilterPage filterPage;

    public FilterSteps(WebDriver driver) {
        filterPage = new FilterPage(driver);
    }

    public void otauAndNaurizApartments() {
        filterPage
                .clickOtauAndNaurizApartments();
    }

    public void showSearchResultOnMap() {
        filterPage
                .clickSearchButton()
                .clickShowOnMap();
    }

    public void onMap() {
        filterPage
                .clickOnMapButton();
    }

    public void selectRegion() {
        filterPage
                .selectRegion();
    }
}
