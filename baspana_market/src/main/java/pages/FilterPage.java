package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class FilterPage extends BasePage {
    private static final By BUY_TAB = By.id("newObjid");
    private static final By RENT_TAB = By.id("secondObjid");
    private static final By OTAU_AND_NAURIZ_APARTMENTS = By.id("thirdObjid");

    public static final By ON_MAP = By.cssSelector(".menu-labels");
    public static final By RESULT_ON_MAP = By.xpath("//div[@class='SearchTitleBlocks '] //label[2]");
    public static final By MAP_OBJECT = By.id("yandexMapObjects");
    private static final By SEARCH_HOUSE_BUTTON = By.cssSelector("#mainMapButtonHolder #btnSearchHouse");
    //    private static final By REGION = By.xpath("//div[@class='objects_all'] //button[@id='dropdownRegionButton'] //span");
    //    private static final By REGION = By.cssSelector(".objects_all #dropdownRegionButton span.control-label.region-labels.ob__bodyL.ob__dark__black.placehold");
    //    private static final By REGION = By.xpath("//div[@class='objects_all'] //img[@id='select-icon-region']");
    //    private static final By REGION = By.cssSelector(".objects_all #select-icon-region");
    private static final By REGION = By.cssSelector("form#searchFromMain .objects_all #dropdownRegionButton");


    public FilterPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click buy tab")
    public FilterPage clickBuyTab() {
        button.btnClick(BUY_TAB);
        return this;
    }

    @Step("Click rent tab")
    public FilterPage clickRentTab() {
        button.btnClick(RENT_TAB);
        return this;
    }

    @Step("Click rent tab")
    public FilterPage clickOtauAndNaurizApartments() {
        button.btnClick(OTAU_AND_NAURIZ_APARTMENTS);
        return this;
    }

    @Step("Click <on map> button")
    public FilterPage clickOnMapButton() {
        button.btnClick(ON_MAP);
        elementsAttributes.waitUntilVisible(MAP_OBJECT);
        return this;
    }

    @Step("Click show on map")
    public FilterPage clickShowOnMap() {
        button.btnClick(RESULT_ON_MAP);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click search button")
    public FilterPage clickSearchButton() {
        button.btnClick(SEARCH_HOUSE_BUTTON);
        return this;
    }

    @Step("Select region")
    public FilterPage selectRegion() {
        WaitUtils.wait(2);
        button.btnClick(REGION);
        WaitUtils.wait(2);

        return this;
    }
}
