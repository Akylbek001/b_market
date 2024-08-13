package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MortgageOnlinePage extends BasePage {
    private static final By START_VIDEO_CALL_BUTTON = By.id("callId");
    private static final By AGREEMENT = By.cssSelector(".form-check-label");
    private static final By CONFIRM_BUTTON = By.cssSelector("#root button");

    public MortgageOnlinePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click start videoCall button")
    public MortgageOnlinePage clickStartVideoCallButton() {
        button.btnClick(START_VIDEO_CALL_BUTTON);
        WaitUtils.wait(4);
        return this;
    }

    @Step("Click agreement checkBox")
    public MortgageOnlinePage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT);
        return this;
    }

    @Step("Click confirm button")
    public MortgageOnlinePage clickConfirmButton() {
        button.btnClick(CONFIRM_BUTTON);
        WaitUtils.wait(1);

        return this;
    }
}
