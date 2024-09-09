package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HousingCenterPage extends BasePage {
    private static final By APPLY_REQUEST = By.cssSelector("#cozhnews #applyApplication");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".conditions-container label.agreement");
    public static final By SIGN_BUTTON = By.id("sign-button");
    private static final By UPLOAD_DOCUMENTS = By.cssSelector("input_file-button-text nemob");
    private static final By CONTINUE_BUTTON = By.id("stage0continueButton");
    private static final By AGREEMENT = By.cssSelector("[for='AgreeWithAgreement']");
    public static final By FILE_TO_SIGN = By.cssSelector(".cozh_news--clients--doc--i_s");

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
//        input.inputWithClear(SIGN_BUTTON, path);
        return this;
    }

    @Step("Click continue button")
    public HousingCenterPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Click upload documents")
    public HousingCenterPage clickUploadDocuments(String path) {
        input.inputWithClear(UPLOAD_DOCUMENTS, path);
        return this;
    }

    @Step("Click agreement checkbox")
    public HousingCenterPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT);
        return this;
    }
}
