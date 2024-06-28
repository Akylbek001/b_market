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
import static pages.CertificatesPage.GENERATED_CERTIFICATE;

@Owner("Алибек Акылбеков")
@Feature("Справки")
public class CertificateTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description = "Выписка о наличии счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о наличии счета")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            mainSteps.clickProfileIcon();
            cabinetSteps.selectMyBankMenu();
            cabinetSteps.selectCertificatesMenu();
        });
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.getAccountCertificate();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Выписка о ссудной задолженности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о ссудной задолженности")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanDebtCertificate () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectLoanDebtCertificate();
            certificatesSteps.getLoanDebtCertificate();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Выписка о депозите за весь период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о депозите")
    @Severity(SeverityLevel.NORMAL)
    public void getDepositCertificate_forEntirePeriod () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.client_for_password_recovery_login(),
                    config.client_for_password_recovery_newPassword()
            );
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectDepositCertificate();
            certificatesSteps.getDepositCertificate();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о депозите за указанный период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о депозите")
    @Severity(SeverityLevel.NORMAL)
    public void getDepositCertificate_forSpecifiedPeriod () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectDepositCertificate();
            certificatesSteps.getDepositCertificate();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION),
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за весь период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о счете ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountCertificate_forEntirePeriod () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectEPVAccountCertificate();
            certificatesSteps.getEPVAccountCertificate();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за выбранный период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о счете ЕПВ")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountCertificate_forSpecifiedPeriod () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectEPVAccountCertificate();
            certificatesSteps.getEPVAccountCertificate();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_GENERATED_TEXT,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }
}
