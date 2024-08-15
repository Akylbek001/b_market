package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositFamilyPackagePage extends BasePage {
    private static final By SELECT_DEPOSIT = By.cssSelector(".deposit_consolidation_step1_list_item");
    private static final By CONTINUE_BUTTON = By.id("btnNext");
    private static final By FAMILY_PACKAGE_NAME = By.id("inptFPName");
    private static final By CREATE_FAMILY_PACKAGE_BUTTON = By.id("btnCreate");
    public static final By CREATED_FAMILY_PACKAGE_NAME = By.xpath("//h2");
    private static final By INVITE_FAMILY_PACKAGE_MEMBER_BUTTON = By.cssSelector("[data-target='#modalInvite']");//?
    private static final By RELATION_DEGREE_LIST = By.cssSelector(".col-4 div.select");
    private static final By RELATION_DEGREE_VALUE = By.cssSelector("ul.select-options li[rel='SPOS']");
    private static final By INVITED_IIN = By.id("inputInviteIIN");
    private static final By INVITED_ALTERNATIVE_CODE = By.id("inputInviteAlterCode");
    public static final By INVALID_INVITED_MEMBER_ALTERNATIVE_CODE_NOTIFICATION = By.cssSelector("label#modalNotificationBody");
    private static final By ADD_MEMBER_BUTTON = By.id("btnAddMember");
    public static final By ADDED_FAMILY_MEMBER_FIO = By.xpath("//div[@class='family-members'][2] //div[@class='col-sm-4'] /h6");
    private static final By CANCEL_INVITE_ICON = By.id("cancelInvite");//?
    private static final By CONFIRM_CANCEL_INVITE_BUTTON = By.xpath("//button[@id='btnCancelInvite'][2]");
    public static final By DISBAND_FAMILY_PACKAGE_BUTTON = By.cssSelector("[data-target='#modalDisbandFP']");//?
    private static final By CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON = By.id("btnCreateFP");
    public static final By MAIN_DEPOSIT_AMOUNT = By.cssSelector(".sum");



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

    @Step("Click invite family package member button")
    public DepositFamilyPackagePage clickInviteFamilyPackageMemberButton() {
        button.btnClick(INVITE_FAMILY_PACKAGE_MEMBER_BUTTON);
        return this;
    }

    @Step("Open relation degree list")
    public DepositFamilyPackagePage openRelationDegreeList() {
        button.btnClick(RELATION_DEGREE_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select relation degree")
    public DepositFamilyPackagePage selectRelationDegreeValue() {
        button.btnClick(RELATION_DEGREE_VALUE);
        return this;
    }

    @Step("Input invited iin")
    public DepositFamilyPackagePage inputInvitedIin(String invitedIin) {
        input.inputWithClear(INVITED_IIN, invitedIin);
        return this;
    }

    @Step("Input invited alternative code")
    public DepositFamilyPackagePage inputInvitedAlternativeCode(String alternativeCode) {
        input.inputWithClear(INVITED_ALTERNATIVE_CODE, alternativeCode);
        return this;
    }

    @Step("Click add member button")
    public DepositFamilyPackagePage clickAddMemberButton() {
        button.btnClick(ADD_MEMBER_BUTTON);
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

    @Step("Click confirm disband family package button")
    public DepositFamilyPackagePage clickConfirmDisbandFamilyPackageButton() {
        button.btnClick(CONFIRM_DISBAND_FAMILY_PACKAGE_BUTTON);
        return this;
    }
}
