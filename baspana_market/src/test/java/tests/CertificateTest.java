package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.CertificatesPage.CERTIFICATE_GENERATED_NOTIFICATION;

@Owner("Алибек Акылбеков")
@Feature("Справки")
public class CertificateTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Справка о наличии счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Справка о наличии счета")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectCertificatesMenu();
        });
        step("Получить справку", () -> {
            certificatesSteps.getAccountCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Справка о ссудной задолженности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Справка о ссудной задолженности")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanDebtCertificate () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(
                    config.client_for_password_recovery_login(), config.client_for_password_recovery_newPassword()
            );;
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.getLoanDebtCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }
}
