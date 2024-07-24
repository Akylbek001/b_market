package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralPage extends BasePage {

    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".form-check-label");
    private static final By START_BIOMETRY_BUTTON = By.id("startBiometry");

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click agreement checkbox")
    public GeneralPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
//        WaitUtils.wait(2);
        return this;
    }

    @Step("Click start biometry button")
    public GeneralPage clickStartBiometryButton() {
        button.btnClick(START_BIOMETRY_BUTTON);
//        WaitUtils.wait(2);
        return this;
    }
}
