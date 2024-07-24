package pages;

import common.utils.WaitUtils;
import common.wrappers.SecretText;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



@Slf4j
public class CabinetPage extends BasePage {
    private static final By PROFILE_MENU = By.xpath("//img[@src='/Images-baspana/profile.svg']");
    private static final By ONLINE_MORTGAGE = By.cssSelector("[href='/OnlineMortgage/Videocall']");

    private static final By MY_REQUESTS_MENU = By.cssSelector("#myState.menu-item");
    private static final By WITH_DIPLOMA_TO_VILLAGE = By.xpath(
            "//div[@class='menu-list'] //*[contains(text(), 'С дипломом в село')]"
    );

    private static final By DIGITAL_MORTGAGE_MENU = By.cssSelector("[href='/DigitalMortgage']");
    private static final By MY_BANK_MENU = By.xpath("//div[@id='menuList'] /a[@id='menu2']");
    private static final By DEPOSITS = By.xpath(
            "//div[@class='menu-list']//*[contains(text(), 'Депозиты')]"
    );
    private static final By LOANS = By.xpath(
            "//div[@class='menu-list']//*[contains(text(), 'Займы')]"
    );
    private static final By ACCOUNTS = By.xpath(
            "//div[@class='menu-list']//*[contains(text(), 'Счета')]"
    );
    private static final By CERTIFICATES = By.xpath(
            "//div[@class='menu-list']//*[text() = 'Справки']"
    );
    private static final By APPOINTMENT_TO_DEPARTMENT_MENU = By.xpath(
            "//div[@class='menu-list']//*[text() = 'Запись в отделение']"
    );
    private static final By HOUSING_CENTER_MENU = By.cssSelector(".nav-box .hpc.menu-item");

    private static final By GOV_SERVICES_MENU = By.cssSelector(".menu-item #StateCertificate");
    private static final By GOV_SERVICES_CERTIFICATES = By.cssSelector("[href='/StateApplication']");
    private static final By ADD_EDIT_EMAIL_BUTTON = By.cssSelector("#ProfilesEmailsId div");
    private static final By EMAIL_INPUT = By.cssSelector(".form.profiles_emails");
    private static final By SAVE_EMAIL_BUTTON = By.xpath("//a[@id='ProfilesEmailsSavesId'] /div");
    public static final By PROFILE_EMAIL = By.id("profileEmail");
    private static final By CHANGE_PASSWORD_BUTTON = By.cssSelector("[data-target='#collapseChangePassword']");
    public static final By OLD_PASSWORD_INPUT = By.id("old-password");
    public static final By NEW_PASSWORD_INPUT = By.id("new-password");
    public static final By CONFIRM_PASSWORD_INPUT = By.id("confirm-password");
    public static final By CHANGE_PASSWORD_SUBMIT_BUTTON = By.id("changePassSubmit");
    public static final By CHANGE_PASSWORD_RESULT = By.id("changePassResult");

    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click profile menu")
    public CabinetPage clickProfileMenu() {
        button.btnClick(PROFILE_MENU);
        return this;
    }

    @Step("Click online mortgage block")
    public CabinetPage clickOnlineMortgageBlock() {
        button.btnClick(ONLINE_MORTGAGE);
        return this;
    }

    @Step("Select myBank menu")
    public CabinetPage selectMyBankMenu() {
        move.scrollToElement(MY_BANK_MENU);
        button.btnClick(MY_BANK_MENU);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Select deposits menu")
    public CabinetPage selectDepositsMenu() {
        button.btnClick(DEPOSITS);
        return this;
    }

    @Step("Select loans menu")
    public CabinetPage selectLoansMenu() {
        button.btnClick(LOANS);
        return this;
    }

    @Step("Select account menu")
    public CabinetPage selectAccountsMenu() {
        button.btnClick(ACCOUNTS);
        return this;
    }

    @Step("Select certificates menu")
    public CabinetPage selectCertificatesMenu() {
        move.scrollToElement(CERTIFICATES);
        button.btnClick(CERTIFICATES);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select government services menu")
    public CabinetPage selectGovServicesMenu() {
        move.scrollToElement(GOV_SERVICES_MENU);
        button.btnClick(GOV_SERVICES_MENU);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select government services certifications menu")
    public CabinetPage selectGovServicesCertificatesMenu() {
        button.btnClick(GOV_SERVICES_CERTIFICATES);
        return this;
    }

    @Step("Select digital mortgage menu")
    public CabinetPage selectDigitalMortgageMenu() {
        move.scrollToElement(DIGITAL_MORTGAGE_MENU);
        button.btnClick(DIGITAL_MORTGAGE_MENU);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select appointment to department menu")
    public CabinetPage selectAppointmentToDepartmentMenu() {
        move.scrollToElement(APPOINTMENT_TO_DEPARTMENT_MENU);
        button.btnClick(APPOINTMENT_TO_DEPARTMENT_MENU);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click add email button")
    public CabinetPage clickAddEditEmailButton() {
        button.btnClick(ADD_EDIT_EMAIL_BUTTON);
        return this;
    }

    @Step("Input email")
    public CabinetPage inputEmail(String email) {
        input.inputWithClear(EMAIL_INPUT, email);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click save email button")
    public CabinetPage clickSaveEmailButton() {
        button.btnClick(SAVE_EMAIL_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click change password button")
    public CabinetPage clickChangePasswordButton() {
        button.btnClick(CHANGE_PASSWORD_BUTTON);
        return this;
    }

    @Step("Input old password")
    public CabinetPage inputOldPassword(String oldPassword) {
        input.inputWithClear(OLD_PASSWORD_INPUT, oldPassword);
        return this;
    }

    @Step("Input new password")
    public CabinetPage inputNewPassword(String newPassword) {
        input.inputWithClear(NEW_PASSWORD_INPUT, newPassword);
        return this;
    }

    @Step("Input confirm password")
    public CabinetPage inputConfirmPassword(String newPassword) {
        input.inputWithClear(CONFIRM_PASSWORD_INPUT, newPassword);
        return this;
    }

    @Step("Click change password submit button")
    public CabinetPage clickChangePasswordSubmitButton() {
        button.btnClick(CHANGE_PASSWORD_SUBMIT_BUTTON);
        return this;
    }
}
