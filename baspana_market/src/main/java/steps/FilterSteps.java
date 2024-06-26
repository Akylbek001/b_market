package steps;

import org.openqa.selenium.WebDriver;
import pages.FilterPage;

public class FilterSteps {
    private final FilterPage filterPage;

    public FilterSteps(WebDriver driver) {
        filterPage = new FilterPage(driver);
    }

    public void searchObjectForBuyByAllParameters() {
        filterPage
//                .clickBuyTab()
//                .clickHouseTypeDropDown();
//                .selectHouseTypeValue();
//                .selectRegion()
//                .selectCity()
//                .clickObjectStatusDropDown()
//                .selectObjectStatus()
//                .selectCode()
//                .typeCodeValue(code)
//                .selectRooms()
//                .selectRoomsValue()
//                .selectImplementationType()
//                .selectImplementationTypeValue()
//                .clickPriceDropDown()
//                .inputPriceFrom(price)
//                .inputPriceTo(price)
                .clickSearchButton();
    }

    public void testt() {
        filterPage
                .clickBuyTab();
    }

    public void objectForBuyDefaultSearch() {
        filterPage
                .clickBuyTab()
                .clickSearchButton();
//                .clickDetailsButton();
    }

    public void searchObjectForRentByAllParameters(String code, String price) {
        filterPage
                .clickRentTab()
                .selectRegion();
//                .selectCity()
//                .clickPropertyTypeDropDown()
//                .selectApartmentType()
//                .selectRooms()
//                .selectRoomsValue()
//                .selectTransactionType()
//                .selectTransactionTypeValue()
//                .clickPriceDropDown()
//                .inputPriceFrom(price)
//                .inputPriceTo(price)
//                .clickSearchButton();
    }

    public void searchObjectForRentByDefaultSearch() {
        filterPage
                .clickRentTab()
                .clickSearchButton();
    }

    public void testAddFilter() {
        filterPage
                .clickRentTab()
                .clickHouseTypeDropDown();
//                .clickSearchButton();
    }

    public void map() {
        filterPage
                .clickShowOnMap();
    }
}
