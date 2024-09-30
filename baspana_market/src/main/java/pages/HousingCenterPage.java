package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HousingCenterPage extends BasePage {
    private static final By APPLY_REQUEST = By.cssSelector("#cozhnews #applyApplication");
    private static final By SEND_BUTTON = By.id("sendApplicationSenderButton");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".conditions-container .agreement");
    private static final By SIGN_BUTTON = By.id("sign-button");
    public static final By NCA_LAYER_NOT_AVAILABLE = By.id("failed-error-custom-message");
    private static final By WARD_OPTION = By.id("ward");
    private static final By FIO = By.id("fioInput");
    private static final By IIN = By.id("iinInput");
    private static final By DOCUMENT_NUMBER = By.id("documentNumberInput");
    private static final By DOCUMENT_ISSUED_BY = By.id("issuedByInput");
    private static final By DOCUMENT_CREATED_DATE = By.id("documentCreateDateInput");
    private static final By ADDRESS = By.id("residentialAddressInput");
    private static final By CONTINUE_BUTTON = By.id("continueFirstButton");
    private static final By WARD_AGREEMENT_CHECKBOX = By.cssSelector("[for='checkboxAgree2']");
    private static final By WARD_SIGN_BUTTON = By.id("continueSecondButton");
    private static final By OK_MODAL_BUTTON = By.cssSelector(".btn.btn-green.bodyL");

    public static final By REQUESTS_GRAPH = By.id("bar-category");
    private static final By WAITING_LIST_TAB = By.id("waitingListTab");
    public static final By WAITING_LIST_CATEGORY_GRAPH = By.id("bar-hr-category");


    private static final By UPLOAD_DOCUMENTS = By.cssSelector("input_file-button-text nemob");
    private static final By CONTINUE_BUTTON_ = By.id("stage0continueButton");
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

    @Step("Click agreement checkbox")
    public HousingCenterPage clickAgreementCheckbox() {
        move.scrollToElement(AGREEMENT_CHECKBOX);
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click sign button")
    public HousingCenterPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Select ward option")
    public HousingCenterPage selectWardOption() {
        button.btnClick(WARD_OPTION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input fio")
    public HousingCenterPage inputFio(String fio) {
        input.inputWithClear(FIO, fio);
        return this;
    }

    @Step("Input iin")
    public HousingCenterPage inputIin(String iin) {
        input.inputWithClear(IIN, iin);
        return this;
    }

    @Step("Input document number")
    public HousingCenterPage inputDocumentNumber(String number) {
        input.inputWithClear(DOCUMENT_NUMBER, number);
        return this;
    }

    @Step("Input document issued by")
    public HousingCenterPage inputDocumentIssuedBy(String issuedBy) {
        input.inputWithClear(DOCUMENT_ISSUED_BY, issuedBy);
        return this;
    }

    @Step("Input date")
    public HousingCenterPage inputDocumentCreatedDate(String date) {
        input.inputWithClear(DOCUMENT_CREATED_DATE, date);
        return this;
    }

    @Step("Input address")
    public HousingCenterPage inputAddress(String address) {
        input.inputWithClear(ADDRESS, address);
        return this;
    }

    @Step("Click continue button")
    public HousingCenterPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Click send button")
    public HousingCenterPage clickSendButton() {
        button.btnClick(SEND_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click ward agreement checkbox")
    public HousingCenterPage clickWardAgreementCheckbox() {
        move.scrollToElement(WARD_AGREEMENT_CHECKBOX);
        button.btnClick(WARD_AGREEMENT_CHECKBOX);
        return this;
    }

    @Step("Click ward sign button")
    public HousingCenterPage clickWardSignButton() {
        button.btnClick(WARD_SIGN_BUTTON);
        return this;
    }

    @Step("Click ok button on modal window")
    public HousingCenterPage clickOkModalButton() {
        button.btnClick(OK_MODAL_BUTTON);
        return this;
    }

    @Step("Click upload documents")
    public HousingCenterPage clickUploadDocuments(String path) {
        input.inputWithClear(UPLOAD_DOCUMENTS, path);
        return this;
    }

    @Step("Click waiting list tab")
    public HousingCenterPage clickWaitingListTab() {
        button.btnClick(WAITING_LIST_TAB);
        return this;
    }
}
