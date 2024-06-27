package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import helpers.Elements;
import helpers.Move;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.DiplomaToVillagePage.*;

@Owner("Алибек Акылбеков")
@Feature("С дипломом в село")
public class DiplomaToVillageTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Подать заявку => Акимат не готов пр", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Подать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validationAkimat () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Village"));
        });
        step("Подать заявку", () -> {
            diplomaToVillageSteps.applyRequest_validateAkimat();
            diplomaToVillageSteps.applyRequestFinish();
        });
        Assert.assertEquals(
                CharacterSetConstants.NOT_READY_TO_ACCEPT_REQUEST_TEXT,
                elementsAttributes.getValue(NOT_READY_TO_ACCEPT_REQUEST)
        );
    }

    @Test(description = "Подать заявку", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Подать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Village"));
        });
        step("Подать заявку", () -> {
            diplomaToVillageSteps.applyRequest();
            diplomaToVillageSteps.applyRequestFinish();
            diplomaToVillageSteps.applyRequestConfirm();
        });
        elementsAttributes.isVisible(REQUEST_IN_PROGRESS);
    }

    @Test(description = "Подать заявку => валидация существующей заявки", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("валидация существующей заявки")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_validateAlreadyExistedTypeOfRequest() {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Village"));
        });
        step("Подать заявку", () -> {
            diplomaToVillageSteps.applyRequest();
            diplomaToVillageSteps.applyRequestFinish();
        });
        elementsAttributes.isVisible(SAME_REQUEST_TYPE);
    }

    @Test(description = "Аннулировать заявку", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Аннулировать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void cancelRequest () {
        step("Авторизация", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Village"));
        });
        step("Аннулировать заявку", () -> {
            diplomaToVillageSteps.cancelRequest();
        });
    }
}
