package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesPage extends BasePage {
    private static final By ADD_TO_FAVORITES_ICON = By.xpath(
            "//label[@class='like-label']"
    );
    public static final By FAVORITE_OBJECT = By.cssSelector(".card.mb-3.object--news");

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }


    @Step("Click add to favorites icon")
    public FavoritesPage clickAddToFavoritesIcon() {
        button.btnClick(ADD_TO_FAVORITES_ICON);
        WaitUtils.wait(1);
        return this;
    }
}
