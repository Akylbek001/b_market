package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.FilterPage.MAP_OBJECT;

@Owner("Алибек Акылбеков")
@Feature("Фильтр")
public class FilterTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Квартиры Отау и Наурыз", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void otauAndNaurizApartments() {
        step("Поиск по умолчанию", () -> {
            filterSteps.otauAndNaurizApartments();
        });
        Assert.assertEquals(envConfig.baseUrl().concat("pool/search"), brManager.getCurrUrl());
    }

    @Test(description="Поиск недвижимости => На карте", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - покупка. Посмотреть на карте")
    @Severity(SeverityLevel.NORMAL)
    public void onMap_mainPageFilter() {
        step("На карте", () -> {
            filterSteps.onMap();
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(MAP_OBJECT));
    }

    @Test(description="Поиск недвижимости => На карте", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - покупка. Посмотреть на карте")
    @Severity(SeverityLevel.NORMAL)
    public void showResultOnMap() {
        step("Поиск по умолчанию", () -> {
            filterSteps.showSearchResultOnMap();
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(MAP_OBJECT));
    }

    @Test(description="Поиск недвижимости", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void search() {
        step("Поиск по умолчанию", () -> {
            filterSteps.selectRegion();
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(MAP_OBJECT));
    }
}
