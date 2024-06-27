package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.FavoritesPage.FAVORITE_OBJECT;

@Owner("Алибек Акылбеков")
@Feature("Избранные")
public class FavoritesTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Добавить объявление в избранное", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Добавить в избранное")
    @Severity(SeverityLevel.NORMAL)
    public void addToFavorites () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
        });
        step("Добавить в избранное", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("pool/search"));
            favoritesSteps.addToFavorites();
        });
        brManager.navigateTo(envConfig.baseUrl().concat("Favorit"));
        elementsAttributes.isVisible(FAVORITE_OBJECT);
    }
}
