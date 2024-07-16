package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import static pages.MainPage.*;

@Owner("Алибек Акылбеков")
@Feature("Главная страница")
public class MainTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Разместить объявление", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.MINOR)
    public void postAd() {
        step("Авторизация", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
        });
        step("Разместить объявление", () -> {
            mainSteps.postAd("50", "4", "street", "house", "description", "8000000");
        });
        Assert.assertEquals(elementsAttributes.getValue(STATUS_OF_AD), "На модерации");
    }

    @Test(description="Разместить объявление из раздела <Мои объявления>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.MINOR)
    public void postAd_fromMyAdBlock() {
        step("Авторизация", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
        });
        step("Перейти в раздел <Мои объявления>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("SecondHouse/MySecondHouses"));
        });
        step("Разместить объявление", () -> {
            mainSteps._clickPostAdButton();
            mainSteps.postAd("50", "4", "street", "house", "description", "17000000");
        });
        Assert.assertEquals(elementsAttributes.getValue(STATUS_OF_AD), "На модерации");
    }

    @Test(description="Удалить объявление", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Удалить объявление")
    @Severity(SeverityLevel.MINOR)
    public void removeAd() {
        step("Авторизация", () -> {
            loginSteps.auth(config.clientLogin(), config.clientPassword());
        });
        step("Перейти в раздел <Мои объявления>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("SecondHouse/MySecondHouses"));
        });
        step("Удалить объявление", () -> {
            mainSteps.removeAd();
        });
    }

    @Test(description="Ссылка новости Baspana", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу новости Baspana")
    @Severity(SeverityLevel.MINOR)
    public void navigateToBaspanaNews() {
        step("Навигация на страницу новости Baspana", () -> {
            mainSteps.navigateToBaspanaNewsPage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.baspanaNewsPath()));
    }

    @Test(description="Калькулятор ипотеки. Проверка рассчета первоначального взноса", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Проверка рассчета первоначального взноса")
    @Severity(SeverityLevel.NORMAL)
    public void CheckInitialFee() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.clientLogin(), config.clientPassword());
        });
        step("Редирект в форму заполнения", () -> {
            mainSteps.clickCalculateButton();
        });
        step("Ввести стоимость недвижимости", () -> {
            mainSteps.checkSaldo(config.mortgageAmount());
        });
        Assert.assertEquals(elementsAttributes.getAttrValueElemPresent(SALDO), "25000000");
    }

    @Test(description="Калькулятор ипотеки => Проверить рассчет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void calculateMortgage() {
        step("Перейти на страницу авторизации", () -> {
            mainSteps.loginButton();
        });
        step("Авторизация", () -> {
            loginSteps.login(config.clientLogin(), config.clientPassword());
        });
        step("Редирект в форму заполнения", () -> {
            mainSteps.clickCalculateButton();
        });
        step("Рассчитать", () -> {
            mainSteps.fillMortgageForm(config.mortgageAmount(), "2", config.priceTo(), config.priceFrom());
        });
    }

    @Test(description="Калькулятор ипотеки. Проверить редирект в форму авторизации", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Неавторизованный пользователь")
    @Severity(SeverityLevel.MINOR)
    public void checkRedirectToAuth() {
        step("Проверить редирект в форму авторизации", () -> {
            mainSteps.clickCalculateButton();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.authPath()));
    }
}
