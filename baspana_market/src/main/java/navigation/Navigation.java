package navigation;

import common.config.env.EnvConfigProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Slf4j
public class Navigation extends BasePage {

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public Navigation gotoLoginPage() {
        brManager.getPage(EnvConfigProvider.get().baseUrl());
        log.info("Navigate to login page");
        return this;
    }
}
