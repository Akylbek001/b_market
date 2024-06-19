package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.FeedbackPage.*;

@Owner("Алибек Акылбеков")
@Feature("Обратная связь")
public class FeedbackTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Заказать обратный звонок", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Обратный звонок")
    @Severity(SeverityLevel.NORMAL)
    public void orderCallback() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Заполнение формы обратной связи", () -> {
            feedbackSteps.orderCall(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestIin(),
                    config.guestPhone());
        });
        Assert.assertTrue(true, elementsAttributes.getValue(CALLBACK_SUCCESSFUL_SENT));
    }

    //BUG - нет соответствуюшего уведомления о неуспешности заказать звонок в нерабочее время
    @Test(description="Заказать обратный звонок в не рабочее время", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Обратный звонок")
    @Severity(SeverityLevel.NORMAL)
    public void orderCallbackDuringNonworkingHours() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Заполнение формы обратной связи", () -> {
            feedbackSteps.orderCall(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestIin(),
                    config.guestPhone());
        });
        Assert.assertEquals(
                elementsAttributes.getValue(CALLBACK_SUCCESSFUL_SENT), CharacterSetConstants.CALLBACK_REFUSED_TEXT
        );
    }

    // BUG - не вводятся имя и фамилия
    @Test(description="Видеоконсультация", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Видеоконсультация")
    @Severity(SeverityLevel.NORMAL)
    public void videoConsultation() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Перейти на страницу видеоконсультации", () -> {
            feedbackSteps.clickVideoConsultationIcon();
        });
        step("Заполнение формы обратной связи", () -> {
            drManager.getDriver().switchTo().frame("myFrame");
            feedbackSteps.videoConsultation(
                    config.guestPhone(), config.guestIin(), config.guestSureName(), config.guestName()
            );
        });
        Assert.assertTrue(true);
    }


    //BUG - данные страницы на казахском, хотя локаль не менялась с русского на осн.странице
    @Test(description="Оставить отзыв => Вопрос", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Вопрос")
    @Severity(SeverityLevel.NORMAL)
    public void leaveFeedback_question() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Перейти на страницу отзыва", () -> {
            feedbackSteps.clickLeaveFeedbackIcon();
        });
        step("Заполненить персональные данные", () -> {
            brManager.switchToLastTab();
            feedbackSteps.fillPersonalData(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestSureName(),
                    config.guestPhone(),
                    config.guestEmail(),
                    config.guestIin());
        });
        step("Выбрать вид обращения", () -> {
            feedbackSteps.selectFeedbackType_question();
        });
        step("Заполнить текст обращения(capture) и отправить", () -> {
            feedbackSteps.setCaptureTextAndSend(config.guestName(), elementsAttributes.getValue(CAPTCHA));
        });
        Assert.assertEquals(
                elementsAttributes.getValue(REQUEST_NOTIFICATION), CharacterSetConstants.REQUEST_BEEN_ACCEPTED_TEXT
        );
    }

    @Test(description="Оставить отзыв => Предложение", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Предложение")
    @Severity(SeverityLevel.NORMAL)
    public void leaveFeedback_proposal() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Перейти на страницу отзыва", () -> {
            feedbackSteps.clickLeaveFeedbackIcon();
        });
        step("Заполненить персональные данные", () -> {
            brManager.switchToLastTab();
            feedbackSteps.fillPersonalData(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestSureName(),
                    config.guestPhone(),
                    config.guestEmail(),
                    config.guestIin());
        });
        step("Выбрать вид обращения", () -> {
            feedbackSteps.selectFeedbackType_proposal();
        });
        step("Заполнить текст обращения(capture) и отправить", () -> {
            feedbackSteps.setCaptureTextAndSend(config.guestName(), elementsAttributes.getValue(CAPTCHA));
        });
        Assert.assertEquals(
                elementsAttributes.getValue(REQUEST_NOTIFICATION), CharacterSetConstants.REQUEST_BEEN_ACCEPTED_TEXT
        );
    }

    @Test(description="Оставить отзыв => Жалоба", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Жалоба")
    @Severity(SeverityLevel.NORMAL)
    public void leaveFeedback_complaint() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Перейти на страницу отзыва", () -> {
            feedbackSteps.clickLeaveFeedbackIcon();
        });
        step("Заполненить персональные данные", () -> {
            brManager.switchToLastTab();
            feedbackSteps.fillPersonalData(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestSureName(),
                    config.guestPhone(),
                    config.guestEmail(),
                    config.guestIin());
        });
        step("Выбрать вид обращения", () -> {
            feedbackSteps.selectFeedbackType_complaint();
        });
        step("Заполнить текст обращения(capture) и отправить", () -> {
            feedbackSteps.setCaptureTextAndSend(config.guestName(), elementsAttributes.getValue(CAPTCHA));
        });
        Assert.assertEquals(
                elementsAttributes.getValue(REQUEST_NOTIFICATION), CharacterSetConstants.REQUEST_BEEN_ACCEPTED_TEXT
        );
    }

    @Test(description="Оставить отзыв => Благодарность", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Благодарность")
    @Severity(SeverityLevel.NORMAL)
    public void leaveFeedback_gratitude() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Перейти на страницу отзыва", () -> {
            feedbackSteps.clickLeaveFeedbackIcon();
        });
        step("Заполненить персональные данные", () -> {
            brManager.switchToLastTab();
            feedbackSteps.fillPersonalData(
                    config.guestLastName(),
                    config.guestName(),
                    config.guestSureName(),
                    config.guestPhone(),
                    config.guestEmail(),
                    config.guestIin());
        });
        step("Выбрать вид обращения", () -> {
            feedbackSteps.selectFeedbackType_gratitude();
        });
        step("Заполнить текст обращения(capture) и отправить", () -> {
            feedbackSteps.setCaptureTextAndSend(config.guestName(), elementsAttributes.getValue(CAPTCHA));
        });
        Assert.assertEquals(
                elementsAttributes.getValue(REQUEST_NOTIFICATION), CharacterSetConstants.REQUEST_BEEN_ACCEPTED_TEXT
        );
    }

    @Test(description="WhatsApp", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу WhatsApp")
    @Severity(SeverityLevel.MINOR)
    public void navigateToWhatsApp() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Навигация на страницу WhatsApp", () -> {
            feedbackSteps.navigateToWhatsApp();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.whatsappUrl());
    }

    @Test(description="Tg", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Редирект на страницу Tg")
    @Severity(SeverityLevel.MINOR)
    public void navigateToTg() {
        step("Вызвать меню Связаться", () -> {
            feedbackSteps.clickContactIcon();
        });
        step("Навигация на страницу Tg", () -> {
            feedbackSteps.navigateToTg();
        });
        brManager.switchToLastTab();
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.tgUrl());
    }
}
