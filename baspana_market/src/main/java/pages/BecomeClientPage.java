package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BecomeClientPage extends BasePage {

//    private static final By BECOME_CLIENT_BUTTON = By.xpath(
//            "//*[@class='general-info-about-accession'] //*[@class='btn-submit text-center'] / button"
//    );

    private static final By BECOME_CLIENT_BUTTON = By.xpath(
            "//div[@class='general-info-about-accession'] //button[contains(text(), 'Стать клиентом ')]"
    );

    private static final By DEPOSIT_BLOCK = By.xpath("//a[@onclick='StartDepositOpen()']");
    private static final By CHILD_FUND_BLOCK = By.xpath("//a[@onclick='StartOpenChildFund()']");
    private static final By PENSION_BLOCK = By.xpath("//a[@onclick='StartOpenPensionAccount()']");
    private static final By AUTH_PHONE = By.id("AutorizationPhone");
    private static final By AUTH_IIN = By.id("AutorizationIinId");
    private static final By VERIFY_BUTTON = By.id("PhoneVerifyButton");
    public static final By REFUSE_TEXT = By.xpath("//div[@id='NextSteps'] //p");
    public static final By INVALID_IIN_TEXT = By.cssSelector("p[class='errtexts']");
    public static final By OPEN_DEPOSIT_BUTTON = By.xpath("//button[@onclick='PhoneVerification()']");

    public BecomeClientPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click become client button")
    public BecomeClientPage becomeClientButton() {
        WaitUtils.wait(1);
        button.btnClick(BECOME_CLIENT_BUTTON);
        return this;
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
        elementsAttributes.waitUntilExist(REFUSE_TEXT);
        WaitUtils.wait(2);
        return this;
    }
}
