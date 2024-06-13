package steps;

import org.openqa.selenium.WebDriver;
import pages.FeedbackPage;

public class FeedbackSteps {
    private final FeedbackPage feedbackPage;

    public FeedbackSteps(WebDriver driver) {
        feedbackPage = new FeedbackPage(driver);
    }

    public void clickContactIcon() {
        feedbackPage
                .clickContactIcon();
    }

    public void clickLeaveFeedbackIcon() {
        feedbackPage
                .clickLeaveFeedbackButton();
    }

    public void clickVideoConsultationIcon() {
        feedbackPage
                .clickVideoConsultationIcon();
    }

    public void orderCall(String lastName, String name, String iin, String phone) {
        feedbackPage
                .clickCallbackIcon()
                .selectRequestType()
                .selectRequestGoal()
                .inputLastName(lastName)
                .inputName(name)
                .inputIin(iin)
                .inputPhone(phone)
                .clickOrderCallSendButton();
    }

    public void videoConsultation(String number, String iin, String surname, String name) {
        feedbackPage
                .selectServiceType()
                .inputClientPhone(number)
                .inputClientInn(iin)
                .inputClientSurname(surname)
                .inputClientName(name)
                .clickStartVideoConsultationButton();
    }

    public void leaveFeedback(
            String lastName,
            String name,
            String sureName,
            String phone,
            String email,
            String iin,
            String text,
            String captcha
    ) {
        feedbackPage
                .inputFeedbackLastName(lastName)
                .inputFeedbackName(name)
                .inputFeedbackSurname(sureName)
                .inputFeedbackPhone(phone)
                .inputFeedbackEmail(email)
                .inputFeedbackIin(iin)
                .inputQuestionText(text)
                .inputCaptchaValue(captcha)
                .clickFeedbackSendButton();
    }

    public void fillPersonalData(
            String lastName,
            String name,
            String sureName,
            String phone,
            String email,
            String iin
    ) {
        feedbackPage
                .inputFeedbackLastName(lastName)
                .inputFeedbackName(name)
                .inputFeedbackSurname(sureName)
                .inputFeedbackPhone(phone)
                .inputFeedbackEmail(email)
                .inputFeedbackIin(iin);
    }

    public void feedbackType(String text, String captcha) {
        feedbackPage
                .clickAppealType()
                .selectProposal() // выбирается вид обращения - в данной случае - "предложение"
                .inputQuestionText(text)
                .inputCaptchaValue(captcha);
//                .clickSendButton();
    }

    public void navigateToWhatsApp() {
        feedbackPage
                .clickWhatsAppIcon();
    }

    public void navigateToTg() {
        feedbackPage
                .clickTgIcon();
    }
}
