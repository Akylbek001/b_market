package steps;

import org.openqa.selenium.WebDriver;
import pages.FavoritesPage;

public class FavoritesSteps {
    private final FavoritesPage favoritesPage;

    public FavoritesSteps(WebDriver driver) {
        favoritesPage = new FavoritesPage(driver);
    }

    public void addToFavorites() {
        favoritesPage
                .clickAddToFavoritesIcon();
    }
}
