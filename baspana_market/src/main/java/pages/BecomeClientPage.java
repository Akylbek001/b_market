package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BecomeClientPage extends BasePage {
    private static final By DEPOSIT_BLOCK = By.cssSelector("[onclick='StartDepositOpen()']");
    private static final By CHILD_FUND_BLOCK = By.cssSelector("[onclick='StartOpenChildFund()']");
    private static final By PENSION_BLOCK = By.cssSelector("[onclick='StartOpenPensionAccount()']");

    private static final By AUTH_PHONE = By.id("AutorizationPhone");
    private static final By AUTH_IIN = By.id("AutorizationIinId");
    private static final By VERIFY_BUTTON = By.id("PhoneVerifyButton");
    private static final By OTP = By.id("CodeSmsId");
    private static final By SEND_BUTTON = By.id("VerifyPhone");

    private static final By WORK_PLACE = By.id("WorkPlace");
    private static final By WORK_POSITION = By.id("WorkPosition");
    private static final By SOURCE_OF_INCOME = By.id("IncomeSourceCode");
    private static final By EMAIL = By.cssSelector("#Email");

    public static final By REGISTRATION_ADDRESS = By.id("EgovRegFullAddress");
    private static final By REGISTER_REGION = By.id("registration-first-level-select");
    private static final By REGISTER_DISTRICT = By.id("registration-second-level-select");
    private static final By REGISTER_STREET = By.id("registration-third-level-select");
    private static final By REGISTER_HOUSE = By.id("registration-house");
    private static final By REGISTER_APARTMENT = By.id("registration-apartment");
    private static final By ADD_REGISTRATION_ADDRESS_BUTTON = By.id("add-registration-address");
    private static final By SAME_ADDRESS_CHECKBOX = By.cssSelector(".btn-onoff");

    public static final By LIVING_ADDRESS = By.id("EgovLiveFullAddress");
    private static final By LIVING_REGION = By.id("living-first-level-select");
    private static final By LIVING_DISTRICT = By.id("living-second-level-select");
    private static final By LIVING_STREET = By.id("living-third-level-select");
    private static final By LIVING_HOUSE = By.id("living-house");
    private static final By LIVING_APARTMENT = By.id("living-apartment");
    private static final By ADD_LIVING_ADDRESS_BUTTON = By.id("add-living-address");

    private static final By BIRTH_SURNAME = By.id("BirthSurname");
    private static final By CODE_WORD = By.id("Codeword");
    private static final By AGREE_TO_RECEIVE_NEWSLETTERS = By.cssSelector(".container-bank");
    private static final By CONTINUE_BUTTON = By.cssSelector(".agreement_and_cont button");

    public static final By REFUSE_TEXT = By.cssSelector("#NextSteps p");
    public static final By INVALID_IIN_TEXT = By.cssSelector("[class='errtexts']");
    public static final By OPEN_DEPOSIT_BUTTON = By.cssSelector("[onclick='PhoneVerification()']");
    public static final By BIOMETRY_CHECK_FAILED = By.id("failed-error-custom-message");

    public BecomeClientPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click open deposit block")
    public BecomeClientPage clickOpenDepositBlock() {
        button.btnClick(DEPOSIT_BLOCK);
        return this;
    }

    @Step("Click open deposit button")
    public BecomeClientPage clickOpenDepositButton() {
        button.btnClick(OPEN_DEPOSIT_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click account for NFD block")
    public BecomeClientPage clickAccountForNFDBlock() {
        button.btnClick(CHILD_FUND_BLOCK);
        return this;
    }

    @Step("Click account for EPV block")
    public BecomeClientPage clickAccountForEPVBlock() {
        button.btnClick(PENSION_BLOCK);
//        WaitUtils.wait(10);
        return this;
    }

    @Step("Input Auth phone")
    public BecomeClientPage inputAuthPhone(String authPhone) {
        input.inputWithClear(AUTH_PHONE, authPhone);
        return this;
    }

    @Step("Input Auth iin")
    public BecomeClientPage inputAuthIin(String authIin) {
        input.inputWithClear(AUTH_IIN, authIin);
        return this;
    }

    @Step("Click verify button")
    public BecomeClientPage clickVerifyButton() {
        button.btnClick(VERIFY_BUTTON);
//        elementsAttributes.waitUntilVisible(REFUSE_TEXT);
        WaitUtils.wait(5);
        return this;
    }

    @Step("Input otp")
    public BecomeClientPage inputOtp(String otp) {
        input.inputWithClear(OTP, otp);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click send button")
    public BecomeClientPage clickSendButton() {
        button.btnClick(SEND_BUTTON);
        return this;
    }

    @Step("Input workplace")
    public BecomeClientPage inputWorkPlace(String workplace) {
        input.inputWithClear(WORK_PLACE, workplace);
        return this;
    }

    @Step("Input work position")
    public BecomeClientPage inputWorkPosition(String workPosition) {
        input.inputWithClear(WORK_POSITION, workPosition);
        return this;
    }

    @Step("Select source of income")
    public BecomeClientPage selectSourceOfIncome() {
        dropDown.selectByIndex(SOURCE_OF_INCOME, 1);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input email")
    public BecomeClientPage inputEmail(String email) {
        input.inputWithClear(EMAIL, email);
        return this;
    }

//----------------------------------------------------------------------------------------------------------------------
    @Step("Click registration address")
    public BecomeClientPage clickRegistrationAddress() {
        button.btnClick(REGISTRATION_ADDRESS);
        return this;
    }

    @Step("Select region")
    public BecomeClientPage selectRegRegion() {
        dropDown.selectByIndex(REGISTER_REGION, 5);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select district")
    public BecomeClientPage selectRegDistrict() {
        dropDown.selectByIndex(REGISTER_DISTRICT, 2);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select street")
    public BecomeClientPage selectRegStreet() {
        dropDown.selectByIndex(REGISTER_STREET, 3);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input registration house")
    public BecomeClientPage inputRegHouse(String regHouse) {
        input.inputWithClear(REGISTER_HOUSE, regHouse);
        return this;
    }

    @Step("Input registration apartment")
    public BecomeClientPage inputRegApartment(String regApartment) {
        input.inputWithClear(REGISTER_APARTMENT, regApartment);
        return this;
    }

    @Step("Click add register address button")
    public BecomeClientPage clickAddRegAddressButton() {
        button.btnClick(ADD_REGISTRATION_ADDRESS_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

//----------------------------------------------------------------------------------------------------------------------
    @Step("Click living address")
    public BecomeClientPage clickLivingAddress() {
        button.btnClick(LIVING_ADDRESS);
        return this;
    }

    @Step("Select living region")
    public BecomeClientPage selectLivingRegion() {
        dropDown.selectByIndex(LIVING_REGION, 5);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select living district")
    public BecomeClientPage selectLivingDistrict() {
        dropDown.selectByIndex(LIVING_DISTRICT, 2);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select living street")
    public BecomeClientPage selectLivingStreet() {
        dropDown.selectByIndex(LIVING_STREET, 3);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input living house")
    public BecomeClientPage inputLivingHouse(String regHouse) {
        input.inputWithClear(LIVING_HOUSE, regHouse);
        return this;
    }

    @Step("Input living apartment")
    public BecomeClientPage inputLivingApartment(String regApartment) {
        input.inputWithClear(LIVING_APARTMENT, regApartment);
        return this;
    }

    @Step("Click add living address button")
    public BecomeClientPage clickAddLivingAddressButton() {
        button.btnClick(ADD_LIVING_ADDRESS_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

//----------------------------------------------------------------------------------------------------------------------

    @Step("Select same address checkbox")
    public BecomeClientPage selectSameAddressCheckbox() {
        button.btnClick(SAME_ADDRESS_CHECKBOX);
        return this;
    }

    @Step("Input birth surname")
    public BecomeClientPage inputBirthSurname(String birthSurname) {
        input.inputWithClear(BIRTH_SURNAME, birthSurname);
        return this;
    }

    @Step("Input codeword")
    public BecomeClientPage inputCodeWord(String codeWord) {
        input.inputWithClear(CODE_WORD, codeWord);
        return this;
    }

    @Step("Click agree to get newsletters checkbox")
    public BecomeClientPage clickAgreeToGetNewslettersCheckbox() {
        move.scrollToElement(AGREE_TO_RECEIVE_NEWSLETTERS);
        button.btnClick(AGREE_TO_RECEIVE_NEWSLETTERS);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click continue button")
    public BecomeClientPage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        WaitUtils.wait(5);
        return this;
    }
}
