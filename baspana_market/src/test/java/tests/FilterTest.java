package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.FilterPage.EMPTY_SEARCH_RESULT_TEXT;
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

    @Test(description="Поиск недвижимости => Покупка", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - покупка")
    @Severity(SeverityLevel.NORMAL)
    public void filterForBuy() {
        step("Выбрать параметры поиска", () -> {
            filterSteps.searchObjectForBuyByAllParameters(config.priceFrom(), config.priceTo());
            filterSteps.testt();
        });
    }

    @Test(description="Поиск недвижимости > Покупка => Карта объекта", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Карточка объекта")
    @Severity(SeverityLevel.NORMAL)
    public void navigateToRealEstate() {
        step("Поиск по умолчанию", () -> {
            filterSteps.objectForBuyDefaultSearch();
        });
        step("Проверить страницу объекта", () -> {
            Assert.assertEquals("20 этажный жилой дом", filterPage.getObjectTitleValue().toString());
        });
    }

    @Test(description="Поиск недвижимости > Покупка => На карте", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - покупка. Посмотреть на карте")
    @Severity(SeverityLevel.NORMAL)
    public void showResultOnMap() {
        step("Поиск по умолчанию", () -> {
            filterSteps.objectForBuyDefaultSearch();
        });
        step("На карте", () -> {
            filterSteps.map();
        });
        Assert.assertTrue(elementsAttributes.isDisplayed(MAP_OBJECT));
    }

    @Test(description="Поиск недвижимости => Аренда", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - аренда")
    @Severity(SeverityLevel.NORMAL)
    public void filterForRent() {
        step("Выбрать параметры поиска", () -> {
            filterSteps.searchObjectForRentByAllParameters(config.priceFrom(), config.priceTo());
        });
    }

    @Test(description="Поиск недвижимости > Аренда => Нет результата", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - аренда")
    @Severity(SeverityLevel.NORMAL)
    public void unsuccessfulSearch() {
        step("Поиск по умолчанию", () -> {
            filterSteps.searchObjectForRentByDefaultSearch();
        });
        elementsAttributes.waitUntilVisible(EMPTY_SEARCH_RESULT_TEXT);
        Assert.assertEquals("Предложений: 0", elementsAttributes.getValue(EMPTY_SEARCH_RESULT_TEXT));
    }

    @Test(description="Поиск недвижимости > Аренда => Доп.фильтр", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Фильтр - аренда")
    @Severity(SeverityLevel.NORMAL)
    public void searchByAdditionalParameters() {
        step("Поиск", () -> {
            filterSteps.testAddFilter();
        });
    }
}
