package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositFamilyPackagePage extends BasePage {
    public static final By SELECT_DEPOSIT = By.cssSelector(".deposit_consolidation_step1_list_item");
    private static final By CONTINUE_BUTTON = By.id("btnNext");
    public static final By FAMILY_PACKAGE_NAME = By.id("name-input");
    private static final By CREATE_FAMILY_PACKAGE_BUTTON = By.cssSelector(".ob__btn.ob__btn__teal");
    public static final By FAMILY_PACKAGE_CREATED_TEXT = By.cssSelector(".ob__accentL.accentL");
    private static final By NAVIGATE_TO_CREATED_FAMILY_PACKAGE_BUTTON = By.cssSelector(".ob__btn.ob__btn__teal.ob__h__48px");
    public static final By CREATED_FAMILY_PACKAGE_NAME = By.cssSelector(".PackageFamilyInfoName");
    private static final By ADD_MEMBER_BUTTON = By.cssSelector(".ob__PackageFamily__Main--Participants--Add--Button");
    private static final By RELATION_DEGREE_LIST = By.id("relationship");
    private static final By INVITED_ALTERNATIVE_CODE = By.cssSelector("#alt-code.PackageFamilyToAdd__Input");
    private static final By INVITED_IIN = By.cssSelector("#iin.PackageFamilyToAdd__Input");
    public static final By SEARCHING_FAMILY_MEMBER_FIO = By.id("part-name");

    private static final By ADD_MEMBER_BUTTON_ = By.cssSelector("button#part-submit.PackageFamilyToAdd__Button");
    public static final By INVITED_MEMBER_STATUS = By.cssSelector("div.ob__PackageFamily__Main--Participants--Items > div > div > p:nth-child(1)");

    private static final By ACCEPT_INVITATION_TO_FAMILY_PACKAGE_BUTTON = By.id("btnAccept");
    private static final By INPUT_OTP = By.id("inputCode");
    private static final By CONTINUE_OTP_CONFIRMATION_BUTTON = By.id("btnContinue");
    private static final By REJECT_INVITATION_TO_FAMILY_PACKAGE_BUTTON = By.id("btnReject");
    private static final By CONFIRM_REJECT_INVITATION_BUTTON = By.id("btnRejectStage");
    public static final By REQUEST_REJECTED_NOTIFICATION = By.xpath("//div[@id='modalInviteReject'] //h5");
    public static final By REQUEST_ACCEPTED_NOTIFICATION = By.xpath("//div[@id='modalInviteSuccess'] //h5");
    public static final By REQUEST_HAS_BEEN_SENT = By.cssSelector(".ob__PackageFamily__Block--Texts .ob__bodyL");
    public static final By VALIDATION_NOTIFICATION = By.id("error-text");
    public static final By RELATION_DEGREE_NOT_SELECTED = By.id("relation-error");
    public static final By INVALID_IIN = By.id("iin-error");
    public static final By INVALID_ALT_CODE = By.id("alt-error");
    private static final By DISBAND_FAMILY_PACKAGE_BUTTON = By.cssSelector(".ob__PackageFamily__Main--Title--Close");
    private static final By CONFIRM_DISBAND_FAMILY_PACKAGE_CHECKBOX = By.cssSelector(".ob__checkbox-container");
    private static final By CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON = By.cssSelector(".modal-footer .btn.btn-primary");
    public static final By FAMILY_PACKAGE_DISBANDED = By.cssSelector("#ToFamilyPackageDisbandedModalDone .modal-title.IncludeFamilyPackageHeader");

    public static final By CANCEL_INVITE_ICON = By.id("cancelInvite");//?
    private static final By CONFIRM_CANCEL_INVITE_BUTTON = By.xpath("//button[@id='btnCancelInvite'][2]");
    private static final By SELECT_FAMILY_PACKAGE_BLOCK = By.cssSelector(".ob__PackageFamily__Block--DepositsMain");


    public DepositFamilyPackagePage(WebDriver driver) {
        super(driver);
    }

    @Step("Select deposit for package")
    public DepositFamilyPackagePage selectDepositForPackage() {
        button.btnClick(SELECT_DEPOSIT);
        return this;
    }

    @Step("Click continue button")
    public DepositFamilyPackagePage clickContinueButton() {
        button.btnClick(CONTINUE_BUTTON);
        return this;
    }

    @Step("Input family package name")
    public DepositFamilyPackagePage inputFamilyPackageName(String name) {
        input.inputWithClear(FAMILY_PACKAGE_NAME, name);
        return this;
    }

    @Step("Click create family package button")
    public DepositFamilyPackagePage clickCreateFamilyPackageButton() {
        button.btnClick(CREATE_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Click navigate to created family package button")
    public DepositFamilyPackagePage clickNavigateToCreatedFamilyPackageButton() {
        button.btnClick(NAVIGATE_TO_CREATED_FAMILY_PACKAGE_BUTTON);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click add member button")
    public DepositFamilyPackagePage clickAddMemberButton() {
        button.btnClick(ADD_MEMBER_BUTTON);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select relation degree")
    public DepositFamilyPackagePage selectRelationDegree() {
        dropDown.selectByIndex(RELATION_DEGREE_LIST, 3);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input invited iin")
    public DepositFamilyPackagePage inputInvitedIin(String invitedIin) {
        input.inputWithClear(INVITED_IIN, invitedIin);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Input invited alternative code")
    public DepositFamilyPackagePage inputInvitedAlternativeCode(String alternativeCode) {
        input.inputWithClear(INVITED_ALTERNATIVE_CODE, alternativeCode);
        return this;
    }

    @Step("Click add member button")
    public DepositFamilyPackagePage clickAddMemberButton_() {
        button.btnClick(ADD_MEMBER_BUTTON_);
        return this;
    }

    @Step("Click accept invitation button")
    public DepositFamilyPackagePage clickAcceptInvitationButton() {
        button.btnClick(ACCEPT_INVITATION_TO_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Input otp")
    public DepositFamilyPackagePage inputOtp(String otp) {
        input.inputWithClear(INPUT_OTP, otp);
        return this;
    }

    @Step("Click continue otp confirmation button")
    public DepositFamilyPackagePage clickContinueOtpConfirmationButton() {
        button.btnClick(CONTINUE_OTP_CONFIRMATION_BUTTON);
        return this;
    }

    @Step("Click reject invitation button")
    public DepositFamilyPackagePage clickRejectInvitationButton() {
        button.btnClick(REJECT_INVITATION_TO_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Click confirm rejection button")
    public DepositFamilyPackagePage clickConfirmRejectionButton() {
        button.btnClick(CONFIRM_REJECT_INVITATION_BUTTON);
        WaitUtils.wait(4);
        return this;
    }

    @Step("Click cancel invite icon")
    public DepositFamilyPackagePage clickCancelInviteIcon() {
        button.btnClick(CANCEL_INVITE_ICON);
        return this;
    }

    @Step("Click confirm cancel invite button")
    public DepositFamilyPackagePage clickConfirmCancelInviteButton() {
        button.btnClick(CONFIRM_CANCEL_INVITE_BUTTON);
        return this;
    }

    @Step("Click disband family package button")
    public DepositFamilyPackagePage clickDisbandFamilyPackageButton() {
        button.btnClick(DISBAND_FAMILY_PACKAGE_BUTTON);
        return this;
    }

    @Step("Click confirm disband family package checkbox")
    public DepositFamilyPackagePage clickConfirmDisbandFamilyPackageCheckbox() {
        button.btnClick(CONFIRM_DISBAND_FAMILY_PACKAGE_CHECKBOX);
        return this;
    }

    @Step("Click confirm disband family package button")
    public DepositFamilyPackagePage clickConfirmDisbandFamilyPackageButton() {
        button.btnClick(CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON);
        return this;
    }
}
