package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class DiplomaToVillagePage extends BasePage {

    private static final By APPLY_REQUEST = By.cssSelector(
            ".btn.btn-light.clicked"
    );
    private static final By SELECT_DISTRICT = By.cssSelector("select[name='oblast']");
    private static final By SELECT_AKIMAT = By.cssSelector("select[name='districtId']");
    private static final By SELECT_REQUEST_TYPE = By.cssSelector("select[name='targetId']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    public static final By NOT_READY_TO_ACCEPT_REQUEST = By.cssSelector(".village--cancelblock p");
    private static final By CONFIRM_BUTTON = By.cssSelector(".confirm");
    public static final By REQUEST_IN_PROGRESS = By.xpath("//div[@class='border_block'] /div[3]");
    public static final By SAME_REQUEST_TYPE = By.cssSelector(".selo--refusalblock p");


    public static final By AGREEMENT_CHECKBOX = By.id("vector2-checkbox");
    public static final By CONTINUE_BUTTON = By.cssSelector(".confirmation [type='button']");
    public static final By GET_PASSPORT_BUTTON = By.cssSelector(".digital-village-id-card-block");
    public static final By GET_DIPLOMA_BUTTON = By.id("submit-digital3");
    public static final By UPLOAD_EMPLOYMENT_CONTRACT = By.id("EMPLOYMENT_CONTRACT");
    public static final By UPLOAD_REQUISITES = By.id("REQUISITES");
    public static final By CREATED_REQUEST = By.cssSelector(".loanCard");
    public static final By CANCEL_REQUEST = By.cssSelector("[data-target='#exampleModal-digital-cansel']");
    public static final By CANCEL_REQUEST_CONFIRM_BUTTON= By.cssSelector(".head_submitting_app .btn.btn-info.cansel-application");




    public DiplomaToVillagePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click apply request")
    public DiplomaToVillagePage clickApplyRequest() {
        button.btnClick(APPLY_REQUEST);
        return this;
    }

    @Step("Select district")
    public DiplomaToVillagePage selectDistrict(Integer index) {
        dropDown.selectByIndex(SELECT_DISTRICT, index);
        return this;
    }

    @Step("Select akimat")
    public DiplomaToVillagePage selectAkimat(Integer index) {
        dropDown.selectByIndex(SELECT_AKIMAT, index);
        return this;
    }

    @Step("Select request type")
    public DiplomaToVillagePage selectRequestType() {
        dropDown.selectByIndex(SELECT_REQUEST_TYPE, 1);
        return this;
    }

    @Step("Click submit button")
    public DiplomaToVillagePage clickSubmitButton() {
        button.btnClick(SUBMIT_BUTTON);
        return this;
    }

    @Step("Click confirm button")
    public DiplomaToVillagePage clickConfirmButton() {
        button.btnClick(CONFIRM_BUTTON);
        return this;
    }

    @Step("Click agreement checkbox")
    public DiplomaToVillagePage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click continue button")
    public DiplomaToVillagePage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Select created request")
    public DiplomaToVillagePage selectCreatedRequest() {
        button.btnClick(CREATED_REQUEST);
        return this;
    }

    @Step("Click cancel request")
    public DiplomaToVillagePage clickCancelRequest() {
        button.btnClick(CANCEL_REQUEST);
        return this;
    }

    @Step("Click confirm cancel request button")
    public DiplomaToVillagePage clickConfirmCancelRequestButton() {
        button.btnClick(CANCEL_REQUEST_CONFIRM_BUTTON);
        return this;
    }

    @Step("Click news link")
    public DiplomaToVillagePage checkElemIsDisappeared() {
        move.moveToElem(CREATED_REQUEST);
        return this;
    }
}
