package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.HeaderPage.*;

@Owner("Алибек Акылбеков")
@Feature("Header")
public class HeaderTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Программа банка", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("программа - Свой дом")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToBankProgram() {
        step("Перейти на страницу программы Свой дом", () -> {
            headerSteps.navigateToBankProgram();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.ownHouseProgramPath()));
    }

    @Test(description="Новости", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Новости")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToNews() {
        step("Перейти на страницу Новости", () -> {
            headerSteps.navigateToNews();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.newsPath()));
    }

    //BUG - loading
    @Test(description="Контакты", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Контакты")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToContacts() {
        step("Перейти на страницу Контакты", () -> {
            headerSteps.navigateToContacts();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.contactsPath()));
    }

    @Test(description="FAQ", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("FAQ")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToFAQ() {
        step("Перейти на страницу FAQ", () -> {
            headerSteps.navigateToFAQ();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.faqUrl());
    }

    @Test(description="Изменить локацию", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выбрать город")
    @Severity(SeverityLevel.MINOR)
    public void changeLocation() {
        step("Сменить локацию", () -> {
            headerSteps.changeLocation();
        });
        Assert.assertEquals(CharacterSetConstants.SELECTED_LOCATION, elementsAttributes.getValue(LOCATION_NAME));
    }

    @Test(description="Разместить объявление => Пользователь не авторизован", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Разместить объявление")
    @Severity(SeverityLevel.TRIVIAL)
    public void postAd() {
        step("Проверить редирект на форму авторизации", () -> {
            headerSteps.postAd();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl());
        // добавить более конкретную проверку
    }

    @Test(description="Избранные объявления => Пользователь не авторизован", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Избранное")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToFavorite() {
        step("Перейти на страницу избранных объявлении", () -> {
            headerSteps.navigateToFavorite();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.favoriteForNotAuthorized()));
        //ошибка - ОР - форма авторизации
    }

    @Test(description="Включить режим <Для слабовидящих>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Для слабовидящих")
    @Severity(SeverityLevel.MINOR)
    public void switchSiteForVisuallyImpaired() {
        step("Включить режим Для слабовидящих", () -> {
            headerSteps.switchPage();
        });
        elementsAttributes.isVisible(HEADER_FUNCTIONAL);
    }

    @Test(description="Изменить язык страницы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выбрать язык")
    @Severity(SeverityLevel.MINOR)
    public void changeLanguage() {
        step("Сменить язык на казахский", () -> {
            headerSteps.selectKazakh();
        });
        Assert.assertEquals(CharacterSetConstants.TITLE_TEXT_IN_KAZAKH, elementsAttributes.getValue(TITLE));
        step("Сменить язык руский", () -> {
            headerSteps.selectRussian();
        });
    }
}
