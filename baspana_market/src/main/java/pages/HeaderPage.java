package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    private static final By BANK_PROGRAMS = By.id("pbId");
    private static final By MY_HOUSE_PROGRAM = By.xpath("//*[text()='Свой дом']");
    private static final By NEWS = By.xpath("//div[@class='menu-item-list'] //*[@title='Новости']");
    private static final By CONTACTS = By.xpath("//*[text()='Контакты']");
    private static final By FAQ = By.xpath("//*[text()='FAQ']");
    private static final By POST_AN_AD_BUTTON = By.xpath("//span[@class='glow-on-hoverz']");
    public static final By LOCATION_NAME= By.id("locationName");
    private static final By VKO = By.xpath("//*[text()='ВКО']");
    private static final By KAZAKH = By.xpath("//*[text()='Қаз']");
    private static final By RUSSIAN = By.xpath("//*[text()='Рус']");
    private static final By FAVORITE_ = By.xpath("//span[@class='text-light']");
    private static final By FOR_VISUALLY_IMPAIRED = By.xpath("//*[text()='Для слабовидящих']");
    public static final By HEADER_FUNCTIONAL = By.id("letsee-panel");
    public static final By TITLE = By.xpath("//h1");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click bank programs button")
    public HeaderPage clickBankProgramsButton() {
        move.hoverOverElem(BANK_PROGRAMS);
//        button.btnClick(BANK_PROGRAMS);
        return this;
    }

    @Step("Select my house programs")
    public HeaderPage selectMyHouseProgram() {
        button.btnClick(MY_HOUSE_PROGRAM);
        return this;
    }

    @Step("Click news")
    public HeaderPage clickNews() {
        button.btnClick(NEWS);
        return this;
    }

    @Step("Click contacts")
    public HeaderPage clickContacts() {
        button.btnClick(CONTACTS);
        return this;
    }

    @Step("Click FAQ")
    public HeaderPage clickFAQ() {
        button.btnClick(FAQ);
        return this;
    }

    @Step("Click post an ad button")
    public HeaderPage clickPostAdButton() {
        button.btnClick(POST_AN_AD_BUTTON);
        return this;
    }

    @Step("Click location name")
    public HeaderPage clickLocationName() {
        button.btnClick(LOCATION_NAME);
        return this;
    }

    @Step("Select location")
    public HeaderPage selectAnotherLocation() {
        button.btnClick(VKO);
        return this;
    }

    @Step("Select kazakh language")
    public HeaderPage selectKazakhLanguage() {
        button.btnClick(KAZAKH);
        return this;
    }

    @Step("Select russian language")
    public HeaderPage selectRussianLanguage() {
        button.btnClick(RUSSIAN);
        return this;
    }

    @Step("Select kazakh language")
    public HeaderPage navigateToFavorite_() {
        button.btnClick(FAVORITE_);
        return this;
    }

    @Step("switch page for visually impaired")
    public HeaderPage switchPage() {
        button.btnClick(FOR_VISUALLY_IMPAIRED);
        return this;
    }
}
