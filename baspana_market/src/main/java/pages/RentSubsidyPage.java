package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentSubsidyPage extends BasePage {

    private static final By APPLY_REQUEST = By.xpath("//a[@id='subapps'] /div");
    private static final By ACTIVE_REQUEST = By.xpath("//div[@id='statesactive'] /a[1]");
    private static final By CANCEL_REQUEST = By.cssSelector("[data-target='#cancelApplication']");
    private static final By CONFIRM_CANCEL_REQUEST = By.cssSelector("[onclick='SignCancelApplicationDoc(119)']");
    private static final By CANCEL_REQUEST_AGREEMENT = By.cssSelector("#hasToBeSignedCancel label.agreement");
    private static final By SIGN_AGREEMENT_BUTTON = By.id("signAggree");
    public static final By MODAL_NOTIFICATION = By.id("errMsg");
    private static final By MODAL_NOTIFICATION_BUTTON = By.cssSelector("[onclick='unblockScreen()']");


    public RentSubsidyPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click apply request button")
    public RentSubsidyPage clickApplyRequest() {
        button.btnClick(APPLY_REQUEST);
        return this;
    }

    @Step("Click accept and continue button")
    public RentSubsidyPage clickActiveRequest() {
        button.btnClick(ACTIVE_REQUEST);
        elementsAttributes.waitUntilVisible(CANCEL_REQUEST);
        return this;
    }

    @Step("Click cancel request")
    public RentSubsidyPage clickCancelRequest() {
        button.btnClick(CANCEL_REQUEST);
        return this;
    }

    @Step("Click confirm cancel request")
    public RentSubsidyPage clickConfirmCancelRequest() {
        button.btnClick(CONFIRM_CANCEL_REQUEST);
        return this;
    }

    @Step("Click cancel request agreement")
    public RentSubsidyPage clickCancelRequestAgreement() {
        button.btnClick(CANCEL_REQUEST_AGREEMENT);
        return this;
    }

    @Step("Click sign agreement button request")
    public RentSubsidyPage clickSignAgreementButton() {
        button.btnClick(SIGN_AGREEMENT_BUTTON);
        return this;
    }

    @Step("Click modal button")
    public RentSubsidyPage clickModalButton() {
        button.btnClick(MODAL_NOTIFICATION_BUTTON);
        return this;
    }
}
