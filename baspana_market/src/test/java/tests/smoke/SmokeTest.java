package tests.smoke;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.CertificatesPage.CERTIFICATE_GENERATED_NOTIFICATION;
import static pages.DepositFamilyPackagePage.SELECT_DEPOSIT;
import static pages.DepositPage.*;

@Owner("Алибек Акылбеков")
@Feature("Smoke")
public class SmokeTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="Главная -> Ипотека <Наурыз и Отау>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Ипотека Наурыз")
    @Severity(SeverityLevel.MINOR)
    public void mainPage_naurizOtauMortgage() {
        step("Авторизация", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
        });
        step("Навигация на страницу <Наурыз и Отау>", () -> {
            mainSteps.clickNaurizMortgage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("OtauNauriz"));
    }

    @Test(description="Главная -> Ипотека <Бакытты Отбасы>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Посмотреть информацию про программу Бакытты Отбасы")
    @Severity(SeverityLevel.MINOR)
    public void mainPage_happyFamilyMortgage() {
        step("Навигация на страницу Бакытты Отбасы", () -> {
            mainSteps.clickHappyFamilyMortgage();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.happyFamilyMortgagePath()));
    }

    @Test(description="Главная -> Посмотреть все гос.программы", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Посмотреть все гос.программы")
    @Severity(SeverityLevel.MINOR)
    public void mainPage_allGosPrograms() {
        step("Навигация на страницу гос.программ", () -> {
            mainSteps.clickShowAllStateProgramsButton();
        });
        Assert.assertEquals(
                brManager.getCurrUrl().substring(0, 70),
                envConfig.baseUrl().concat("pool/search?newOrSecond=new&realizeTypeNurlyZher"));
    }

    @Test(description="Главная -> Посмотреть все новостройки", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Посмотреть все новостройки")
    @Severity(SeverityLevel.MINOR)
    public void mainPage_allNewBuildings() {
        step("Навигация на страницу новостроек", () -> {
            mainSteps.clickShowAllNewBuildingsButton();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat(envConfig.newBuildings()));
    }

    @Test(description="Главная -> Посмотреть все вторичое жилье", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Посмотреть все вторичое жилье")
    @Severity(SeverityLevel.MINOR)
    public void allSecondaryHousing_fromMainPage() {
        step("Навигация на страницу вторичного жилья", () -> {
            mainSteps.clickShowAllSecondaryHousingButton();
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("pool/search?neworsecond=second"));
    }

    @Test(description="Раздел <Профиль>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Профиль")
    @Severity(SeverityLevel.NORMAL)
    public void profile() {
        step("Авторизация -> Профиль", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("profile/info"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("profile/info"));
    }

    @Test(description="Раздел <Мои заявки->Региональные программы>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Регисональные программы")
    @Severity(SeverityLevel.NORMAL)
    public void regionalPrograms() {
        step("Авторизация -> Регисональные программы", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("RegionalPrograms/ListPrograms"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("RegionalPrograms/ListPrograms"));
    }

    @Test(description="Раздел <С дипломом в село>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("С дипломом в село")
    @Severity(SeverityLevel.NORMAL)
    public void diplomaToVillage() {
        step("Авторизация -> С дипломом в село", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Village"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Village"));
    }

    @Test(description="Раздел <Цифровая ипотека>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Цифровая ипотека")
    @Severity(SeverityLevel.NORMAL)
    public void digitalMortgage() {
        step("Авторизация -> Цифровая ипотека", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("DigitalMortgage"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("DigitalMortgage"));
    }

    @Test(description="Раздел <Субсидирование аренды>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Субсидирование аренды")
    @Severity(SeverityLevel.NORMAL)
    public void rentSubsidy() {
        step("Авторизация -> Субсидирование аренды", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("RentSubsidy"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("RentSubsidy"));
    }

    @Test(description="Раздел <Счета>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Счета")
    @Severity(SeverityLevel.NORMAL)
    public void account() {
        step("Авторизация -> Счета", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyAccounts"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Cabinet/MyAccounts"));
    }

    @Test(description="Текущий счет", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Текущий счет")
    @Severity(SeverityLevel.NORMAL)
    public void currentAccount() {
        step("Авторизация -> Текущий счет", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("CurrentAccount"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("CurrentAccount"));
    }

    @Test(description="Текущий счет -> Операция <Перевод между своими счетами>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Перевод между своими счетами")
    @Severity(SeverityLevel.CRITICAL)
    public void currentAccount_transferBetweenYourAccounts() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("CurrentAccount/TransferToDeposit"));
        });
        Assert.assertEquals(
                brManager.getCurrUrl(), envConfig.baseUrl().concat("CurrentAccount/TransferToDeposit")
        );
    }

    //функционал на бою временно отключен
    @Test(description="Текущий счет -> Операция <Перевод клиенту Отбасы банк>", groups = {"automated"}, enabled = false)
    @Issue("https://jira.kz/browse/QA-")
    @Description("Перевод в другой банк")
    @Severity(SeverityLevel.CRITICAL)
    public void currentAccount_transferToOtbasyClient() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("CurrentAccount/TransferToOtbasy"));
        });
        Assert.assertEquals(
                brManager.getCurrUrl(), envConfig.baseUrl().concat("CurrentAccount/TransferToOtbasy")
        );
    }

    @Test(description="Текущий счет -> Операция <Перевод в другой банк>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Перевод в другой банк")
    @Severity(SeverityLevel.CRITICAL)
    public void currentAccount_transferToAnotherBank() {
        step("Авторизация -> Мои Счета", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("CurrentAccount/TransferToAnotherBank"));
        });
        Assert.assertEquals(
                brManager.getCurrUrl(), envConfig.baseUrl().concat("CurrentAccount/TransferToAnotherBank")
        );
    }

    @Test(description="Раздел <Депозиты>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Депозиты")
    @Severity(SeverityLevel.NORMAL)
    public void deposit() {
        step("Авторизация -> Депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Cabinet/MyDeposits"));
    }

    @Test(description="Депозиты -> Операция <Присвоить гос.премию>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Депозиты -> Гос.премия")
    @Severity(SeverityLevel.CRITICAL)
    public void deposit_gosPrem() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Присвоить гос.премию", () -> {
            depositSteps.changeGosPrem_smoke();
        });
        Assert.assertEquals(
                "Присвоение признака премии государства", elementsAttributes.getValue(GOS_PREM_MODAL_TITLE)
        );
    }

    @Test(description="Депозиты -> Операция <Расторжение>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Расторжение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void terminateDeposit() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Расторгнуть", () -> {
            depositSteps.terminateDeposit_smoke();
        });
        elementsAttributes.waitUntilVisible(TERMINATE_DEPOSIT_BUTTON);
    }

    @Test(description="Депозиты -> Операция <Изменить условия депозита>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Изменить условия депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void changeDepositConditions() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectSecondDeposit_prod();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Изменить условия депозита", () -> {
            depositSteps.changeDepositConditions_smoke();
        });
        elementsAttributes.waitUntilVisible(CHANGE_DETAILS_BUTTON);
    }

    @Test(description="Депозиты -> Операция <Создать семейный пакет>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Создать семейный пакет")
    @Severity(SeverityLevel.NORMAL)
    public void createFamilyPackage() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Создать семейный пакет>", () -> {
            depositSteps.selectCreateFamilyPackageOperation();
        });
        elementsAttributes.waitUntilVisible(SELECT_DEPOSIT);
    }

    @Test(description="Депозиты -> Операция <Деление депозита>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Деление депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositDivision() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Деление депозита", () -> {
            depositSteps.depositDivisionOperation();
        });
        elementsAttributes.waitUntilVisible(DIVIDE_BUTTON);
    }

    @Test(description="Объединение депозита", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Объединение депозита")
    @Severity(SeverityLevel.CRITICAL)
    public void depositPooling() {
        step("Авторизация -> Мои депозиты", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cabinet/MyDeposits"));
        });
        step("Выбрать открытый депозит", () -> {
            depositSteps.selectOpenedDeposit();
        });
        step("Показать доступные операции", () -> {
            depositSteps.showAvailableOperations();
        });
        step("Выбрать операцию <Объединение депозита>", () -> {
            depositSteps.uniteDepositOperation();
        });
        elementsAttributes.waitUntilVisible(SELECT_DEPOSITS_BUTTON);
    }

    @Test(description="Раздел <Справки>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Справки")
    @Severity(SeverityLevel.NORMAL)
    public void certificate() {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Inquiry"));
    }

    @Test(description = "Справки -> Выписка о депозите за весь период", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о депозите")
    @Severity(SeverityLevel.NORMAL)
    public void getDepositStatement_forEntirePeriod () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
        step("Получить справку", () -> {
            certificatesSteps.selectDepositCertificate();
            certificatesSteps.fillRequiresData();
            certificatesSteps.selectEntirePeriod();
            certificatesSteps.getCertificateForWhile();
        });
        Assert.assertEquals(
                CharacterSetConstants.STATEMENT_HAS_BEEN_GENERATED,
                elementsAttributes.getValue(CERTIFICATE_GENERATED_NOTIFICATION)
        );
    }

    @Test(description = "Справки -> Выписка о ссудной задолженности", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Выписка о ссудной задолженности")
    @Severity(SeverityLevel.NORMAL)
    public void getLoanDebtCertificate () {
        step("Авторизация -> Справки", () -> {
            loginSteps.auth("77473239832", "Brv_28978206!");
            brManager.navigateTo(envConfig.baseUrl().concat("Inquiry"));
        });
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

    @Test(description="Раздел <Займы>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Займы")
    @Severity(SeverityLevel.NORMAL)
    public void loan() {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77473239832", "Brv_28978206!");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Loan"));
    }

    @Test(description="Займы => Операция <Полное досрочное погашение>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Полное досрочное погашение")
    @Severity(SeverityLevel.NORMAL)
    public void fullEarlyRepayment () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77473239832", "Brv_28978206!");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectThirdLoan();
            loansSteps.openAvailableOperations_onProd();
            loansSteps.fullEarlyRepaymentOperation_smoke();
        });
    }

    @Test(description="Займы => Операция <Частичное досрочное погашение>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Успешно")
    @Severity(SeverityLevel.NORMAL)
    public void partialEarlyRepayment () {
        step("Авторизация -> Займы", () -> {
            loginSteps.auth("77473239832", "Brv_28978206!");
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations_onProd();
            loansSteps.partialEarlyRepaymentOperation();
        });
    }

    @Test(description="Раздел <Кабинет>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Кабинет")
    @Severity(SeverityLevel.NORMAL)
    public void cabinet() {
        step("Авторизация -> Кабинет", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("cabinet"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("cabinet"));
    }

    @Test(description="Раздел <Гос.услуги>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Гос.услуги")
    @Severity(SeverityLevel.NORMAL)
    public void gosService() {
        step("Авторизация -> Гос.услуги", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("StateApplication"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("StateApplication"));
    }

    @Test(description="Раздел <Центр обеспечения жильем>", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Центр обеспечения жильем")
    @Severity(SeverityLevel.NORMAL)
    public void housingCenter() {
        step("Авторизация -> Центр обеспечения жильем", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cozh"));
        });
        Assert.assertEquals(brManager.getCurrUrl(), envConfig.baseUrl().concat("Cozh"));
    }
}
