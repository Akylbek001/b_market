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

        loginSteps.auth(config.loanClient_login(), config.loanClient_password());
        brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
    }

    @Test(description = "Выписка о наличии всех счетов", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Все счета")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate_allAccounts () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps.selectAllAccounts();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о наличии текущего счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate_currentAccount () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps.selectCurrentAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о наличии ЕПВ счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("ЕПВ счет")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate_EPVAccount () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps.selectEPVAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о наличии социального счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Социальный счет")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate_socialAccount () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps.selectSpecialAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о наличии депозитного счета", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Депозитный счет")
    @Severity(SeverityLevel.NORMAL)
    public void getAccountAvailabilityCertificate_depositAccount () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountAvailabilityCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps.selectDepositAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о ссудной задолженности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о ссудной задолженности")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanDebtCertificate () {
        step("Получить справку", () -> {
            certificatesSteps.selectLoanDebtCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.CERTIFICATE_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Выписка о депозите за весь период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о депозите")
    @Severity(SeverityLevel.NORMAL)
    public void getDepositStatement_forEntirePeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectDepositCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificateForWhile();
            WaitUtils.wait(10);
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о депозите за указанный период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о депозите")
    @Severity(SeverityLevel.NORMAL)
    public void getDepositStatement_forSpecifiedPeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectDepositCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION),
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за весь период => текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void getCurrentAccountStatement_forEntirePeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectCurrentAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за выбранный период => текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void getCurrentAccountStatement_forSpecifiedPeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectCurrentAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за весь период => ЕПВ счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("ЕПВ счет")
    @Severity(SeverityLevel.NORMAL)
    public void getEPVAccountStatement_forEntirePeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectEPVAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за выбранный период => ЕПВ счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("ЕПВ счет")
    @Severity(SeverityLevel.NORMAL)
    public void getEPVAccountStatement_forSpecifiedPeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectEPVAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за весь период => спец. счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("спец. счет")
    @Severity(SeverityLevel.NORMAL)
    public void getSpecialAccountStatement_forEntirePeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectSpecialAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка о счете за выбранный период => соц. счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("соц. счет")
    @Severity(SeverityLevel.NORMAL)
    public void getSpecialAccountStatement_forSpecifiedPeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectAccountCertificate();
            certificatesSteps.openAccountsList();
            certificatesSteps._selectSpecialAccount();
            certificatesSteps.selectCertificateLanguage();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
        Assert.assertTrue(elementsAttributes.isPresent(GENERATED_CERTIFICATE));
    }

    @Test(description = "Выписка по займу за весь период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка по займу")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanStatementCertificate_forEntirePeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectLoanStatementCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Выписка по займу за выбранный период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка по займу")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanStatementCertificate_forSpecifiedPeriod () {
        step("Получить справку", () -> {
            certificatesSteps.selectLoanStatementCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.selectSpecifiedPeriod();
            certificatesSteps.getCertificate();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Выписка по графику погашения займа", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка по графику погашения")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanRepaymentScheduleStatement () {
        step("Получить справку", () -> {
            certificatesSteps.selectLoanRepaymentScheduleCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }
}
