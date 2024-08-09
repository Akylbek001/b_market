package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedbackPage extends BasePage {
    private static final By CONTACTS_LOCATOR = By.id("imgTest");
    private static final By CALLBACK_LOCATOR = By.id("call-back--item");
    private static final By VIDEO_CONSULTATION = By.id("video-call--item");
    private static final By WHATSAPP = By.id("whatsapp--item");
    private static final By TG = By.id("telegram--item");

    private static final By REQUEST_TYPE_LIST = By.id("form_dropdown_type_picker");
    private static final By REQUEST_GOAL_LIST = By.id("form_dropdown_vopros_type");

    public static final By SERVICE_TYPE = By.xpath("//select[@class='form-select']");
    public static final By PHONE = By.xpath("//input[@name='phone']");
    public static final By IIN = By.xpath("//input[@name='iin']");
    public static final By SURNAME = By.xpath("//div[@class='row']//input[@name='surname']");
    public static final By NAME = By.xpath("//div[@class='row']//input[@name='name']");
    private static final By START_VIDEO_CONSULTATION_BUTTON = By.xpath("//*[text()='Начать видеозвонок']");

    private static final By CALLBACK_LAST_NAME_INPUT = By.id("lastname");
    private static final By CALLBACK_NAME_INPUT = By.id("name");
    private static final By CALLBACK_IIN_INPUT = By.id("iin");
    private static final By CALLBACK_PHONE_INPUT = By.id("phone");
    private static final By ORDER_CALL_SEND_BUTTON = By.xpath("//*[text()='Отправить']");
    private static final By FEEDBACK_SEND_BUTTON = By.xpath("//*[text()='Жіберу']");

    public static final By CALLBACK_SUCCESSFUL_SENT = By.id("getCallbackLongTitle");

    private static final By LEAVE_FEEDBACK_BUTTON = By.xpath("//img[@src='/Images-baspana/email.svg']");
    private static final By FEEDBACK_LAST_NAME_INPUT = By.xpath("//*[label='Тегі']/input");
    private static final By FEEDBACK_NAME_INPUT = By.xpath("//*[label='Аты']/input");
    private static final By FEEDBACK_SURNAME_INPUT = By.xpath("//*[label='Әкесінің аты']/input");
    private static final By FEEDBACK_PHONE_INPUT = By.xpath("//*[label='Телефон']/input");
    private static final By FEEDBACK_EMAIL_INPUT = By.xpath("//*[label='E-mail']/input");
    private static final By FEEDBACK_IIN_INPUT = By.xpath("//*[label='ЖСН']/input");
    private static final By FEEDBACK_QUESTION = By.xpath("//*[label='Сіздің сұрағыңыз']/textarea");

    private static final By APPEAL_TYPE_LIST = By.xpath("//span[@class='p-dropdown-label p-inputtext' and text()='Сұрақ']");
    private static final By QUESTION = By.xpath("//*[text()='Сұрақ']");
    private static final By PROPOSAL = By.xpath("//*[text()='Ұсыныс']");
    private static final By COMPLAINT = By.xpath("//*[text()='Шағым']");
    private static final By GRATITUDE = By.xpath("//*[text()='Алғыс']");
    private static final By WITHDRAWAL_COMPLAINT_APPEAL = By.xpath("//*[text()='Шағымды/өтінішті кері қайтарып алу']");
    private static final By FLOODS = By.xpath("//*[text()='Су тасқыны']");

    public static final By CAPTCHA = By.xpath("//span[@class='captcha']");
    private static final By CAPTCHA_VALUE_INPUT = By.xpath("//*[label='Мәтінді енгізіңіз']/input");
    public static final By REQUEST_NOTIFICATION = By.cssSelector(".tw-text-center");


    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click contact button")
    public FeedbackPage clickContactIcon() {
        button.btnClick(CONTACTS_LOCATOR);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click collBack icon")
    public FeedbackPage clickCallbackIcon() {
        button.btnClick(CALLBACK_LOCATOR);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click video consultation icon")
    public FeedbackPage clickVideoConsultationIcon() {
        button.btnClick(VIDEO_CONSULTATION);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Select service type")
    public FeedbackPage selectServiceType() {
        dropDown.selectByIndex(SERVICE_TYPE, 3);
        button.btnClick(SERVICE_TYPE);  //попробовать без этого клика
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input phone number")
    public FeedbackPage inputClientPhone(String phoneNumber) {
        input.inputWithClear(PHONE, phoneNumber);
        return this;
    }

    @Step("Input client inn")
    public FeedbackPage inputClientInn(String iin) {
        input.inputWithClear(IIN, iin);
        return this;
    }

    @Step("Input client surname")
    public FeedbackPage inputClientSurname(String surname) {
        input.inputWithClear(SURNAME, surname);
        return this;
    }

    @Step("Input client name")
    public FeedbackPage inputClientName(String name) {
        input.inputWithClear(NAME, name);
        return this;
    }

    @Step("Click whatsApp icon")
    public FeedbackPage clickWhatsAppIcon() {
        button.btnClick(WHATSAPP);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click telegram icon")
    public FeedbackPage clickTgIcon() {
        button.btnClick(TG);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Click start video consultation button")
    public FeedbackPage clickStartVideoConsultationButton() {
        button.btnClick(START_VIDEO_CONSULTATION_BUTTON);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select request type")
    public FeedbackPage selectRequestType() {
        dropDown.selectByIndex(REQUEST_TYPE_LIST, 1);
        return this;
    }

    @Step("Select request goal")
    public FeedbackPage selectRequestGoal() {
        dropDown.selectByIndex(REQUEST_GOAL_LIST, 0);
        return this;
    }

    @Step("Input last name")
    public FeedbackPage inputLastName(String userLastName) {
        input.inputWithClear(CALLBACK_LAST_NAME_INPUT, userLastName);
        return this;
    }

    @Step("Input name")
    public FeedbackPage inputName(String name) {
        input.inputWithClear(CALLBACK_NAME_INPUT, name);
        return this;
    }

    @Step("Input iin")
    public FeedbackPage inputIin(String iin) {
        input.inputWithClear(CALLBACK_IIN_INPUT, iin);
        return this;
    }

    @Step("Input phone")
    public FeedbackPage inputPhone(String phone) {
        input.inputWithClear(CALLBACK_PHONE_INPUT, phone);
        return this;
    }

    @Step("Click order call send button")
    public FeedbackPage clickOrderCallSendButton() {
        button.btnClick(ORDER_CALL_SEND_BUTTON);
        WaitUtils.wait(2);
        return this;
    }

    @Step("Click feedback send button")
    public FeedbackPage clickFeedbackSendButton() {
        button.btnClick(FEEDBACK_SEND_BUTTON);
        WaitUtils.wait(2);
        return this;
    }


    @Step("Click leave feedback button")
    public FeedbackPage clickLeaveFeedbackButton() {
        button.btnClick(LEAVE_FEEDBACK_BUTTON);
        return this;
    }

    @Step("Input feedback last name")
    public FeedbackPage inputFeedbackLastName(String lastName) {
        input.inputWithClear(FEEDBACK_LAST_NAME_INPUT, lastName);
        return this;
    }

    @Step("Input feedback name")
    public FeedbackPage inputFeedbackName(String name) {
        input.inputWithClear(FEEDBACK_NAME_INPUT, name);
        return this;
    }

    @Step("Input feedback surname")
    public FeedbackPage inputFeedbackSurname(String surname) {
        input.inputWithClear(FEEDBACK_SURNAME_INPUT, surname);
        return this;
    }

    @Step("Input feedback phone")
    public FeedbackPage inputFeedbackPhone(String phone) {
        input.inputWithClear(FEEDBACK_PHONE_INPUT, phone);
        return this;
    }

    @Step("Input feedback email")
    public FeedbackPage inputFeedbackEmail(String email) {
        input.inputWithClear(FEEDBACK_EMAIL_INPUT, email);
        return this;
    }

    @Step("Input feedback iin")
    public FeedbackPage inputFeedbackIin(String iin) {
        input.inputWithClear(FEEDBACK_IIN_INPUT, iin);
        return this;
    }

    @Step("Click appeal type")
    public FeedbackPage clickAppealType() {
        move.scrollToElement(APPEAL_TYPE_LIST);
        button.btnClick(APPEAL_TYPE_LIST);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select question")
    public FeedbackPage selectQuestion() {
        button.btnClick(QUESTION);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select proposal")
    public FeedbackPage selectProposal() {
        button.btnClick(PROPOSAL);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select complaint")
    public FeedbackPage selectComplaint() {
        button.btnClick(COMPLAINT);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select gratitude")
    public FeedbackPage selectGratitude() {
        button.btnClick(GRATITUDE);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select gratitude")
    public FeedbackPage selectWithdrawalComplaintAppeal() {
        button.btnClick(WITHDRAWAL_COMPLAINT_APPEAL);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Select floods")
    public FeedbackPage selectFloods() {
        button.btnClick(FLOODS);
        WaitUtils.wait(1);
        return this;
    }

    @Step("Input question text")
    public FeedbackPage inputQuestionText(String questionText) {
        input.inputWithClear(FEEDBACK_QUESTION, questionText);
        return this;
    }

    @Step("Input captcha value")
    public FeedbackPage inputCaptchaValue(String captcha) {
        input.inputWithClear(CAPTCHA_VALUE_INPUT, captcha);
        WaitUtils.wait(1);
        return this;
    }
}
