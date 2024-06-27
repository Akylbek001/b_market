package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HousingCenterPage extends BasePage {
    private static final By APPLY_REQUEST = By.cssSelector("#cozhnews #applyApplication");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".conditions-container label.agreement");
    private static final By SIGN_BUTTON = By.id("sign-button");
    private static final By FINISH_BUTTON = By.cssSelector(".btn.btn-green.bodyL");


    public HousingCenterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click apply request")
    public HousingCenterPage clickApplyRequest() {
        button.btnClick(APPLY_REQUEST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click agreement checkBox")
    public HousingCenterPage clickAgreementCheckBox() {
        move.scrollToElement(AGREEMENT_CHECKBOX);
        button.btnClick(AGREEMENT_CHECKBOX);
        WaitUtils.wait(1);

        return this;
    }

    @Step("Click sign button")
    public HousingCenterPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

//    @Step("Click sign button")
//    public HousingCenterPage clickSignButton(String path) {
//        button.btnClick(SIGN_BUTTON);
//        input.inputWithClear(SIGN_BUTTON, path);
//        return this;
//    }

    @Step("Click finish button")
    public HousingCenterPage clickFinishButton() {
        button.btnClick(FINISH_BUTTON);
        return this;
    }
}
