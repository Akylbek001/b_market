package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtauPage extends BasePage {
    public static final By APPLY_BUTTON = By.cssSelector(".ob-btn.ob-btn-tangerine.ob-h-36px.createApplication");
    public static final By REGION_OF_REAL_ESTATE = By.id("regionOfRealEstate");
    private static final By CITY_OF_REAL_ESTATE = By.id("cityOfRealEstate");
    private static final By REGION_OF_RESIDENCE = By.id("regionOfResidence");
    private static final By CITY_OF_RESIDENCE = By.id("cityOfResidence");
    private static final By AGREEMENT = By.cssSelector("[for='checkboxAgree']");
    private static final By CONTINUE_BUTTON = By.id("continueButton");
    public static final By REFUSED_REASON_TEXT = By.cssSelector(".ob-accentXS");
    private static final By SELECT_DEPOSIT_BUTTON = By.cssSelector("#work-window #firstChooseDeposit");
    public static final By DEPOSIT_VALUE = By.cssSelector(".card-item.deposit-item");
    private static final By SELECT_BUTTON = By.id("addDepositButton");
    private static final By AGREEMENT_FOR_PUBLIC = By.cssSelector("[for='checkboxAgree1']");
    private static final By AGREEMENT_FOR_PERSONAL_DATA = By.cssSelector("[for='checkboxAgree2']");
    private static final By CONFIRM_BUTTON = By.id("confirmBMG");
    public static final By BANNER_TEXT = By.cssSelector(".ob-banner-text .ob-bodyM");
    private static final By ACTIVE_REQUEST = By.xpath("//div[@id='deposit'] //a[@class='application'] [1]");
    private static final By CANCEL_BUTTON = By.id("cancelButton");
    private static final By CONFIRM_CANCEL_BUTTON = By.id("application-annulment");


    public OtauPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click apply button")
    public OtauPage clickApplyButton() {
        button.btnClick(APPLY_BUTTON);
        return this;
    }

    @Step("Select real estate region")
    public OtauPage selectRealEstateRegion() {
        dropDown.selectByIndex(REGION_OF_REAL_ESTATE, 6);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select residence region")
    public OtauPage selectResidenceRegion() {
        dropDown.selectByIndex(REGION_OF_RESIDENCE, 5);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click agreement")
    public OtauPage clickAgreement() {
        move.scrollToElement(AGREEMENT);
        button.btnClick(AGREEMENT);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click continue button")
    public OtauPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click select deposit button")
    public OtauPage clickSelectDepositButton() {
        button.btnClick(SELECT_DEPOSIT_BUTTON);
        elementsAttributes.waitUntilVisible(DEPOSIT_VALUE);
        return this;
    }

    @Step("Click deposit value")
    public OtauPage clickDepositValue() {
        button.btnClick(DEPOSIT_VALUE);
        return this;
    }

    @Step("Click select button")
    public OtauPage clickSelectButton() {
        button.btnClick(SELECT_BUTTON);
        elementsAttributes.waitUntilVisible(AGREEMENT_FOR_PUBLIC);
        return this;
    }

    @Step("Click agreement for public")
    public OtauPage clickAgreementForPublic() {
        button.btnClick(AGREEMENT_FOR_PUBLIC);
        return this;
    }

    @Step("Click agreement for share personal data")
    public OtauPage clickAgreementForSharePersonalData() {
        button.btnClick(AGREEMENT_FOR_PERSONAL_DATA);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click confirm button")
    public OtauPage clickConfirmButton() {
        move.scrollToElement(CONFIRM_BUTTON);
        button.btnClick(CONFIRM_BUTTON);
        return this;
    }

    @Step("Select active request")
    public OtauPage selectActiveRequest() {
        button.btnClick(ACTIVE_REQUEST);
        return this;
    }

    @Step("Click cancel button")
    public OtauPage clickCancelButton() {
        button.btnClick(CANCEL_BUTTON);
        return this;
    }

    @Step("Click confirm cancel button")
    public OtauPage clickConfirmCancelButton() {
        button.btnClick(CONFIRM_CANCEL_BUTTON);
        return this;
    }
}
