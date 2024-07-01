package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalMortgagePage extends BasePage {

    private static final By DIGITAL_MORTGAGE_BLOCK = By.cssSelector("[href='/Prequalification/PriorApproval']");
    private static final By VIDEO_CALL_BLOCK = By.cssSelector(".digital-mortgage [href='/Home/VideosConsultacia/']");
    private static final By I_CONFIRMED_BUTTON = By.cssSelector("button.btn-success");
    private static final By START_BUTTON = By.cssSelector(".btn-success");

    public DigitalMortgagePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click digital mortgage block")
    public DigitalMortgagePage clickDigitalMortgageBlock() {
        button.btnClick(DIGITAL_MORTGAGE_BLOCK);
        return this;
    }

    @Step("Click start button")
    public DigitalMortgagePage clickStartButton() {
        button.btnClick(START_BUTTON);
        elementsAttributes.waitUntilVisible(I_CONFIRMED_BUTTON);
        return this;
    }

    @Step("Click i confirmed button")
    public DigitalMortgagePage clickIConfirmedButton() {
        button.btnClick(I_CONFIRMED_BUTTON);
        return this;
    }

    @Step("Click video call block")
    public DigitalMortgagePage clickVideoCallBlock() {
        button.btnClick(VIDEO_CALL_BLOCK);
        return this;
    }
}
