package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiplomaToVillagePage extends BasePage {

    private static final By APPLY_REQUEST = By.cssSelector(".btn.btn-light.clicked");
    private static final By SELECT_DISTRICT = By.cssSelector("select[name='oblast']");
    private static final By SELECT_AKIMAT = By.cssSelector("select[name='districtId']");
    private static final By SELECT_REQUEST_TYPE = By.cssSelector("select[name='targetId']");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");

    public static final By NOT_READY_TO_ACCEPT_REQUEST = By.cssSelector(".village--cancelblock p");
    private static final By CONFIRM_BUTTON = By.cssSelector(".confirm");
    public static final By REQUEST_IN_PROGRESS = By.xpath("//div[@class='border_block'] /div[3]");
    public static final By SAME_REQUEST_TYPE = By.cssSelector(".selo--refusalblock p");

    private static final By CONFIRM_PERSONAL_DATA_CHECKBOX = By.cssSelector(".custom_checkbox");
    private static final By CONFIRM_PERSONAL_DATA_BUTTON = By.cssSelector(".confirmation button");

    public static final By GET_PASSPORT_BUTTON = By.cssSelector(".digital-village-id-card-block");
    public static final By PASSPORT_DIGITAL_CODE = By.id("village--id--card");
    public static final By GET_PASSPORT_DIGITAL_CODE_BUTTON = By.cssSelector("#exampleModal-digital .btn.btn-primary.valid");

    public static final By GET_DIPLOMA_BUTTON = By.id("submit-digital3");
    public static final By DIPLOMA_DIGITAL_CODE = By.id("village--id--card");
    public static final By GET_DIPLOMA_DIGITAL_CODE_BUTTON = By.cssSelector("#exampleModal-digital3 .btn.btn-primary.valid");

    public static final By UPLOAD_DIPLOMA_IF_NO_IN_EGOV = By.id("FileName");
    public static final By UPLOAD_CERTIFICATE_OF_ABSENCE_OF_REAL_ESTATE = By.id("CERTIFICATE_OF_ABSENCE_OF_REAL_ESTATE");
    public static final By UPLOAD_EMPLOYMENT_CONTRACT = By.id("EMPLOYMENT_CONTRACT");

    public static final By CREATED_REQUEST = By.cssSelector(".card-body");
    public static final By CANCEL_REQUEST = By.cssSelector("[data-target='#exampleModal-digital-cansel']");
    public static final By CANCEL_REQUEST_CONFIRM_BUTTON= By.cssSelector(".head_submitting_app .btn.btn-info.cansel-application");

    public static final By WORK_LOCATION= By.cssSelector("#wrapper > #workLocation");
    public static final By WORK_PLACE = By.cssSelector("#wrapper > #placeOfWork");
    public static final By POSITION = By.cssSelector("#wrapper > #position");
    public static final By SPHERE_ACTIVITY = By.cssSelector(".select_region--block--items #spheraActivity");
    public static final By SIGN_BUTTON = By.cssSelector(".apply-choose-mio--pkb-report");
    private static final By TRANSFER_OTP = By.id("smsVerificationCodeInput");
    private static final By SEND_OTP_BUTTON = By.cssSelector("#exampleModalSMSVillage .btn.btn-primary");
    private static final By GENERATE_REQUEST_BUTTON = By.cssSelector(".btn.btn-primary.celo-ipoteka.btn-form_app.sign_and_send");

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

    @Step("Click confirm personal data checkbox")
    public DiplomaToVillagePage clickConfirmPersonalDataCheckbox() {
        button.btnClick(CONFIRM_PERSONAL_DATA_CHECKBOX);
        return this;
    }

    @Step("Click continue button")
    public DiplomaToVillagePage clickContinueButton() {
        button.btnClick(CONFIRM_PERSONAL_DATA_BUTTON);
        return this;
    }

    @Step("Click get passport button")
    public DiplomaToVillagePage clickGetPassportButton() {
        button.btnClick(GET_PASSPORT_BUTTON);
        return this;
    }

    @Step("Input passport digital code")
    public DiplomaToVillagePage inputPassportDigitalCode(String code) {
        input.inputWithClear(PASSPORT_DIGITAL_CODE, code);
        return this;
    }

    @Step("Click get passport digital code button")
    public DiplomaToVillagePage clickGetPassportDigitalCodeButton() {
        button.btnClick(GET_PASSPORT_DIGITAL_CODE_BUTTON);
        return this;
    }

    @Step("Click get diploma button")
    public DiplomaToVillagePage clickGetDiplomaButton() {
        button.btnClick(GET_DIPLOMA_BUTTON);
        return this;
    }

    @Step("Input digital diploma code")
    public DiplomaToVillagePage inputDigitalDiplomaCode(String code) {
        input.inputWithClear(DIPLOMA_DIGITAL_CODE, code);
        return this;
    }

    @Step("Click get diploma digital code button")
    public DiplomaToVillagePage clickGetDiplomaDigitalCodeButton() {
        button.btnClick(GET_DIPLOMA_DIGITAL_CODE_BUTTON);
        return this;
    }

    @Step("Upload diploma")
    public DiplomaToVillagePage uploadDiploma(String diplomaPath) {
        input.inputWithClear(UPLOAD_DIPLOMA_IF_NO_IN_EGOV, diplomaPath);
        return this;
    }

    @Step("Upload certificate of absence of real estates")
    public DiplomaToVillagePage uploadCertificateOfAbsenceRealEstate(String certificatePath) {
        input.inputWithClear(UPLOAD_CERTIFICATE_OF_ABSENCE_OF_REAL_ESTATE, certificatePath);
        return this;
    }

    @Step("Upload employment contract")
    public DiplomaToVillagePage uploadEmploymentContract(String employmentContractPath) {
        input.inputWithClear(UPLOAD_EMPLOYMENT_CONTRACT, employmentContractPath);
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

    @Step("Input work location")
    public DiplomaToVillagePage inputWorkLocation(String workLocation) {
        input.inputWithClear(WORK_LOCATION, workLocation);
        return this;
    }

    @Step("Input work place")
    public DiplomaToVillagePage inputWorkPlace(String workPlace) {
        input.inputWithClear(WORK_PLACE, workPlace);
        return this;
    }

    @Step("Input position")
    public DiplomaToVillagePage inputPosition(String position) {
        input.inputWithClear(POSITION, position);
        return this;
    }

    @Step("Select sphere activity")
    public DiplomaToVillagePage selectSphereActivity() {
        dropDown.selectByIndex(SPHERE_ACTIVITY, 2);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click sign button")
    public DiplomaToVillagePage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }

    @Step("Input otp")
    public DiplomaToVillagePage inputOtp(String otp) {
        input.inputWithClear(TRANSFER_OTP, otp);
        return this;
    }

    @Step("Click send otp button")
    public DiplomaToVillagePage sendOtpButton() {
        button.btnClick(SEND_OTP_BUTTON);
        return this;
    }

    @Step("Click generate request button")
    public DiplomaToVillagePage sendGenerateRequestButton() {
        button.btnClick(GENERATE_REQUEST_BUTTON);
        return this;
    }


    @Step("Click news link")
    public DiplomaToVillagePage checkElemIsDisappeared() {
        move.moveToElem(CREATED_REQUEST);
        return this;
    }
}
