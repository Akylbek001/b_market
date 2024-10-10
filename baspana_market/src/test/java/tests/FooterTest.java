package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Owner("Алибек Акылбеков")
@Feature("Footer")
public class FooterTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);

        mainSteps.closeBannerIcon();
    }

    @Test(description="Ссылка <Интернет-Банкинг>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Интернет-Банкинга")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToInternetBanking() {
        step("Навигация на страницу интернет банкинга", () -> {
            footerSteps.navigateToInternetBankingPage();
        });
        brManager.switchToLastTab();
        Assert.assertTrue(brManager.getCurrUrl().contains(envConfig.internetBankingUrl()));
    }

    @Test(description="Ссылка <Ипотека>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Ипотека")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToMortgage() {
        step("Навигация на страницу ипотеки", () -> {
            footerSteps.navigateToMortgagePage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.mortgagePath()));
    }

    @Test(description="Ссылка <Калькулятор>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Калькулятор")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToCalc() {
        step("Навигация на страницу калькулятора", () -> {
            footerSteps.navigateToCalcPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.calcUrl());
    }

    @Test(description="Ссылка <Новости>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Новости")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToNews() {
        step("Навигация на страницу новостей", () -> {
            footerSteps.navigateToNewsPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.newsPath()));
    }

    @Test(description="Ссылка <Программы>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Программы")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToPrograms() {
        step("Навигация на страницу Программы", () -> {
            footerSteps.navigateToProgramsPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.programsPath()));
    }

    @Test(description="Ссылка <Карта сайта>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Карта сайта")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToSiteMap() {
        step("Навигация на страницу карта сайта", () -> {
            footerSteps.navigateToSiteMapPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.siteMapPath()));
    }

    @Test(description="Ссылка <Новостройки>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Новостройки")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToNewBuildings() {
        step("Навигация на страницу новостройки", () -> {
            footerSteps.navigateToNewBuildingsPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.newBuildingsPath()));
    }

    @Test(description="Ссылка <о Baspana.kz>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу о Baspana.kz")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToAboutBaspanaKz() {
        step("Навигация на страницу о Baspana.kz", () -> {
            footerSteps.navigateToBaspanaInfoPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.baspanaInfoPath()));
    }

    @Test(description="Ссылка <Baiterek>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу <Baiterek>")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToBaiterek() {
        step("Навигация на страницу Baiterek", () -> {
            footerSteps.navigateToBaiterekPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baiterekUrl());
    }

    @Test(description="Ссылка <Памятка по информационной безопасности>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Памятка по информационной безопасности")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToInformationSecurity() {
        step("Навигация на страницу Памятка по информационной безопасности", () -> {
            footerSteps.navigateToInformationSecurityPage();
        });
    }

    @Test(description="Ссылка <Депозитный портфель>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Депозитный портфель")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToDepositPortfolio() {
        step("Навигация на страницу Депозитный портфель", () -> {
            footerSteps.navigateToDepositPortfolioPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.depositPortfolioPath()));
    }

    @Test(description="Ссылка <Facebook>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Facebook")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToFacebook() {
        step("Навигация на страницу Facebook", () -> {
            footerSteps.navigateToFacebookPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.facebookUrl());
    }

    @Test(description="Ссылка <VK>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу vk")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToVk() {
        step("Навигация на страницу vk", () -> {
            footerSteps.navigateToVkPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.vkUrl());
    }

    @Test(description="Ссылка <Instagram>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Instagram")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToInstagram() {
        step("Навигация на страницу Instagram", () -> {
            footerSteps.navigateToInstagramPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.instagramUrl());
    }

    @Test(description="Ссылка <Youtube>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Youtube")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToYoutube() {
        step("Навигация на страницу Youtube", () -> {
            footerSteps.navigateToYoutubePage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.youtubeUrl());
    }

    @Test(description="Ссылка <AppStore>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу AppStore")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToAppStore() {
        step("Навигация на страницу AppStore", () -> {
            footerSteps.navigateToAppStorePage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.appStoreUrl());
    }

    @Test(description="Ссылка <GooglePlay>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу GooglePlay")
    @Severity(SeverityLevel.TRIVIAL)
    public void navigateToGooglePlay() {
        step("Навигация на страницу GooglePlay", () -> {
            footerSteps.navigateToGooglePlayPage();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.googlePlayUrl());
    }
}
