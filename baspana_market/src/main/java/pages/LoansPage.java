package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoansPage extends BasePage {
    private static final By EXISTED_LOAN = By.cssSelector(".loanGritCover");
    private static final By AVAILABLE_OPERATIONS = By.cssSelector("[onclick='collapseOper()']");
    private static final By FULL_EARLY_REPAYMENT_OPERATION = By.id("full-repayment-menu-block");
    private static final By PARTIAL_EARLY_REPAYMENT_OPERATION = By.xpath("//div[@class='allOperWrap'] /div[2]");
    private static final By CHANGING_PAYMENT_DATE_OPERATION = By.xpath("//div[@class='operTxt' and text()='Изменение даты платежа']");
    private static final By SWITCHING_TO_HOME_LOAN = By.xpath("//div[@class='operTxt' and text()='Переход на жилищный заем']");
    private static final By REPLACEMENT_OF_CO_BORROWER = By.xpath("//div[@class='operTxt' and text()='Замена созаемщика']");
    private static final By EXCLUSION_OF_CO_BORROWER = By.xpath("//div[@class='operTxt' and text()='Исключение созаемщика']");
    private static final By EXTENSION_INSURANCE_CONTRACT_OPERATION = By.xpath("//div[@class='operTxt' and text()='Продление договора страхования']");
    private static final By REPLACEMENT_OF_COLLATERAL_OPERATION = By.xpath("//div[@class='operTxt' and text()='Замена залога']");

    private static final By FULL_EARLY_REPAYMENT_WITH_DEPOSIT_TERMINATION = By.xpath("//div[@id='depositChangeBlock'] /div[1] /label");
    private static final By FULL_EARLY_REPAYMENT_WITHOUT_DEPOSIT_TERMINATION = By.xpath("//div[@id='depositChangeBlock'] /div[2] /label");
    private static final By FULL_EARLY_REPAYMENT_CONTINUE_BTN = By.id("val_button");
    private static final By AGREEMENT_OF_IMPOSSIBLE_CANCEL = By.cssSelector(".container.secondcheck.checkbox");
    private static final By SIGN_FULL_EARLY_REPAYMENT_BUTTON = By.cssSelector("[data-target='#ModalToSend']");
    private static final By FULL_EARLY_REPAYMENT_OTP = By.cssSelector(".OtpBlocks--inputs");
    private static final By OTP_BUTTON = By.id("otp-button");








    public static final By INTENDED_USE_OF_LOAN_NOTIFICATION = By.id("changePaymentDayModalBody");

    public static final By CHANGING_PAYMENT_DATE_NOTIFICATION = By.id("changePaymentDayModalBody");
    private static final By AGREEMENT_CHECKBOX = By.cssSelector(".container.firstcheck.checkbox");
    private static final By VALIDATION_BUTTON = By.xpath(".validation");
    private static final By SIGN_BUTTON = By.cssSelector("[onclick='SendOtp()']");

    private static final By IIN_INPUT = By.id("searchInput");
    private static final By IIN_SEARCH_RESULT = By.id("resultContainer");
    private static final By REPLACE_CONTINUE_BUTTON = By.id("replaceStep");
    private static final By EXCEPTION_TYPE = By.cssSelector(".container-radio");
    private static final By EXCEPTION_PERSON = By.id("cobs");
    private static final By REGION = By.id("selectRegion");
    private static final By START_EXCEPTION_BUTTON = By.cssSelector("#TheStepsId button");
    private static final By REQUEST_FAMILY_INFO_BUTTON = By.cssSelector(".FamilyInfoBlock.GreyBackgroundBlocks button");







    private static final By SIGN_SCHEDULE = By.cssSelector("[data-target='#ModalToSendApplication']");
    private static final By SIGN_OTP = By.cssSelector(".OtpBlocks--inputs");
    private static final By SEND_BUTTON = By.cssSelector("onclick='GoToFifthStep()'");


    private static final By NEXT_BUTTON = By.xpath("//div[@id='StartTheApplicationsId']//div[@class='modal-footer'] /button[2]");
    private static final By COLLATERAL_FOR_CHANGE = By.id("4EDC8A84DE07D1BBCE22A726769D803F");
    private static final By START_BUTTON = By.cssSelector("[onclick='Validations()']");
    public static final By NOTIFICATION_OF_REGISTRATION = By.id("ExchangesModalToAttenttionsBody");
    public static final By SWITCHING_TO_HOME_LOAN_ACCOUNT_VALIDATION = By.cssSelector("#transitionNotAvailableOperationNotAvailable #errorTransition");
    public static final By SWITCHING_TO_HOME_LOAN_DEPOSIT_VALIDATION = By.id("errorTransition");


    private static final By EXTENSION_INSURANCE_CONTRACT_CONTINUE_BUTTON = By.xpath("//div[@class='modal fade show']//button[@class='btn btn-green']");
    private static final By ESTATE_INSURANCE_CHECKBOX = By.cssSelector("[for='estateInsurance]");
    private static final By TITLE_INSURANCE_CHECKBOX = By.cssSelector("[for='titleInsurance]");
    private static final By AGREEMENT_TO_TRANSFER_CHECKBOX = By.cssSelector("[for='consentFirst]");
    public static final By CONFIRM_AGREEMENT_BUTTON = By.id("generalInfoButton");
    public static final By UPLOAD_DOCUMENT_BUTTON = By.id("uploadDocForTwo");
    public static final By INSURANCE_OTP_INPUT = By.id("smsVerificationCodeInput");
    public static final By OTP_VERIFICATION_BUTTON = By.id("smsVerificationBtn");
    public static final By NEXT_TO_APPLICATION_BUTTON = By.id("nextToApplication");





    private static final By PARTIAL_REPAYMENT_SUM = By.cssSelector(".InputBlocks input");
    private static final By CONTINUE_BUTTON = By.cssSelector("button.validate");


    public LoansPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select existed loan")
    public LoansPage selectExistedLoan() {
        button.btnClick(EXISTED_LOAN);
        return this;
    }

    @Step("Open available operation")
    public LoansPage openAvailableOperations() {
        button.btnClick(AVAILABLE_OPERATIONS);
        return this;
    }
    @Step("Select full early repayment operation")
    public LoansPage selectFullEarlyRepaymentOperation() {
        button.btnClick(FULL_EARLY_REPAYMENT_OPERATION);
        WaitUtils.wait(1);
        return this;
    }
    @Step("Select partial early repayment operation")
    public LoansPage selectPartialEarlyRepaymentOperation() {
        button.btnClick(PARTIAL_EARLY_REPAYMENT_OPERATION);
        WaitUtils.wait(1);
        return this;
    }
    @Step("Select replacement of collateral operation")
    public LoansPage selectReplacementOfCollateralOperation() {
        move.scrollToElement(REPLACEMENT_OF_COLLATERAL_OPERATION);
        button.btnClick(REPLACEMENT_OF_COLLATERAL_OPERATION);
        return this;
    }
    @Step("Select extension insurance contract operation")
    public LoansPage selectExtensionInsuranceContractOperation() {
        move.scrollToElement(EXTENSION_INSURANCE_CONTRACT_OPERATION);
        button.btnClick(EXTENSION_INSURANCE_CONTRACT_OPERATION);
        return this;
    }
    @Step("Select changing payment date operation")
    public LoansPage selectChangingPaymentDateOperation() {
        button.btnClick(CHANGING_PAYMENT_DATE_OPERATION);
        return this;
    }
    @Step("Select switching to home loan operation")
    public LoansPage selectSwitchingToHomeLoanOperation() {
        button.btnClick(SWITCHING_TO_HOME_LOAN);
        return this;
    }
    @Step("Select replacement of co-borrower operation")
    public LoansPage selectReplacementOfCoBorrowerOperation() {
        button.btnClick(REPLACEMENT_OF_CO_BORROWER);
        return this;
    }
    @Step("Select exclusion of co-borrower operation")
    public LoansPage selectExclusionOfCoBorrowerOperation() {
        button.btnClick(EXCLUSION_OF_CO_BORROWER);
        return this;
    }



    @Step("Select full repayment with deposit termination")
    public LoansPage selectFullRepaymentWithDepositTermination() {
        button.btnClick(FULL_EARLY_REPAYMENT_WITH_DEPOSIT_TERMINATION);
        return this;
    }
    @Step("Select full repayment without deposit termination")
    public LoansPage selectFullRepaymentWithoutDepositTermination() {
        button.btnClick(FULL_EARLY_REPAYMENT_WITHOUT_DEPOSIT_TERMINATION);
        return this;
    }
    @Step("Click continue full repayment button")
    public LoansPage clickContinueFullRepaymentButton() {
        button.btnClick(FULL_EARLY_REPAYMENT_CONTINUE_BTN);
        return this;
    }
    @Step("Click second agreement checkbox")
    public LoansPage clickSecondAgreementCheckbox() {
        button.btnClick(AGREEMENT_OF_IMPOSSIBLE_CANCEL);
        return this;
    }
    @Step("Click sign full repayment button")
    public LoansPage clickSignFullRepaymentButton() {
        button.btnClick(SIGN_FULL_EARLY_REPAYMENT_BUTTON);
        return this;
    }
    @Step("Input otp")
    public LoansPage inputOtp(String otp) {
        input.inputWithClear(FULL_EARLY_REPAYMENT_OTP, otp);
        return this;
    }
    @Step("Click send otp button")
    public LoansPage clickSendOtpButton() {
        button.btnClick(OTP_BUTTON);
        return this;
    }





    @Step("Click agreement checkbox")
    public LoansPage clickAgreementCheckbox() {
        button.btnClick(AGREEMENT_CHECKBOX);
        return this;
    }
    @Step("Click validation button")
    public LoansPage clickValidationButton() {
        button.btnClick(VALIDATION_BUTTON);
        return this;
    }
    @Step("Click sign button")
    public LoansPage clickSignButton() {
        button.btnClick(SIGN_BUTTON);
        return this;
    }



    @Step("Input search iin")
    public LoansPage inputSearchIin(String iin) {
        input.inputWithClear(IIN_INPUT, iin);
        elementsAttributes.waitUntilVisible(IIN_SEARCH_RESULT);
        return this;
    }
    @Step("Click replace continue button")
    public LoansPage clickReplaceContinueButton() {
        button.btnClick(REPLACE_CONTINUE_BUTTON);
        return this;
    }
    @Step("Click select exception type")
    public LoansPage selectExceptionType() {
        button.btnClick(EXCEPTION_TYPE);
        return this;
    }
    @Step("Click select exception person")
    public LoansPage selectExceptionPerson() {
        button.btnClick(EXCEPTION_PERSON);
        return this;
    }
    @Step("Select region")
    public LoansPage selectRegion() {
        dropDown.selectByIndex(REGION, 2);
        WaitUtils.wait(2);
        return this;
    }
    @Step("Click start exception button")
    public LoansPage clickStartExceptionButton() {
        button.btnClick(START_EXCEPTION_BUTTON);
        return this;
    }
    @Step("Click request family info button")
    public LoansPage clickRequestFamilyInfoButton() {
        button.btnClick(REQUEST_FAMILY_INFO_BUTTON);
        return this;
    }



    @Step("Click extension insurance contract continue button")
    public LoansPage clickExtensionInsuranceContractContinueButton() {
        button.btnClick(EXTENSION_INSURANCE_CONTRACT_CONTINUE_BUTTON);
        return this;
    }
    @Step("Click estate insurance checkbox")
    public LoansPage clickEstateInsuranceCheckbox() {
        button.btnClick(ESTATE_INSURANCE_CHECKBOX);
        return this;
    }
    @Step("Click title insurance checkbox")
    public LoansPage clickTitleInsuranceCheckbox() {
        button.btnClick(TITLE_INSURANCE_CHECKBOX);
        return this;
    }
    @Step("Click agreement to transfer checkbox")
    public LoansPage clickAgreementToTransferCheckbox() {
        button.btnClick(AGREEMENT_TO_TRANSFER_CHECKBOX);
        return this;
    }
    @Step("Click confirm agreement button")
    public LoansPage clickConfirmAgreementButton() {
        button.btnClick(CONFIRM_AGREEMENT_BUTTON);
        return this;
    }
    @Step("Click upload document button")
    public LoansPage clickUploadDocumentButton() {
        button.btnClick(UPLOAD_DOCUMENT_BUTTON);
        return this;
    }
    @Step("Input insurance otp")
    public LoansPage inputInsuranceOtp(String otp) {
        input.inputWithClear(INSURANCE_OTP_INPUT, otp);
        return this;
    }
    @Step("Click otp verification button")
    public LoansPage clickOtpVerificationButton() {
        button.btnClick(OTP_VERIFICATION_BUTTON);
        return this;
    }
    @Step("Click continue button")
    public LoansPage clickNextToApplicationButton() {
        button.btnClick(NEXT_TO_APPLICATION_BUTTON);
        return this;
    }








    @Step("Click sign schedule button")
    public LoansPage clickSignScheduleButton() {
        button.btnClick(SIGN_SCHEDULE);
        return this;
    }

    @Step("Input sign schedule otp")
    public LoansPage inputScheduleOtp(String otp) {
        input.inputWithClear(SIGN_OTP, otp);
        return this;
    }

    @Step("Click send button")
    public LoansPage clickSendButton() {
        button.btnClick(SEND_BUTTON);
        return this;
    }

    @Step("Click next button")
    public LoansPage clickNextButton() {
        button.btnClick(NEXT_BUTTON);
        WaitUtils.wait(10);

        return this;
    }

    @Step("Select collateral for change")
    public LoansPage selectCollateralForChange() {
        button.btnClick(COLLATERAL_FOR_CHANGE);
        return this;
    }

    @Step("Click start button")
    public LoansPage clickStartButton() {
        button.btnClick(START_BUTTON);
        return this;
    }


    @Step("Input sum")
    public LoansPage inputSum(String sum) {
        input.inputWithClear(PARTIAL_REPAYMENT_SUM, sum);
        return this;
    }

    @Step("Click continue button")
    public LoansPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }
}
