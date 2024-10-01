package base;

import common.config.app.AppConfig;
import common.config.app.AppConfigProvider;
import common.config.env.EnvConfig;
import common.config.env.EnvConfigProvider;
import driver.BrowserManager;
import driver.DriverManager;
import driver.InitDriver;
import helpers.ElementsAttributes;
import listener.TestListener;
import lombok.extern.slf4j.Slf4j;
import navigation.Navigation;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import pages.BecomeClientPage;
import pages.LoginPage;
import pages.RegistrationPage;
import steps.*;
import steps.BecomeClientSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import steps.AccountSteps;
import steps.CertificatesSteps;
import steps.DepositSteps;

@Slf4j
@Listeners(TestListener.class)
public abstract class BaseTest{
    private WebDriver driver = InitDriver.initDriver();

    protected BrowserManager brManager;
    protected ElementsAttributes elementsAttributes;
    public DriverManager drManager;
    protected Navigation navigation;
    protected SoftAssertions softly;
    protected HeaderSteps headerSteps;
    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected RegistrationPage registrationPage;
    protected RegistrationSteps registrationSteps;
    protected BecomeClientPage becomeClientPage;
    protected BecomeClientSteps becomeClientSteps;
    protected FeedbackSteps feedbackSteps;
    protected MainSteps mainSteps;
    protected FooterSteps footerSteps;
    protected FilterSteps filterSteps;
    protected ProfileSteps profileSteps;
    protected DigitalMortgageSteps digitalMortgageSteps;
    protected CabinetSteps cabinetSteps;
    protected ProfilePage profilePage;
    protected AppConfig config;
    protected EnvConfig envConfig;
    protected DepositSteps depositSteps;
    protected DepositFamilyPackageSteps depositFamilyPackageSteps;
    protected DepositAssignmentGratuitousStep depositAssignmentGratuitousStep;
    protected AccountSteps accountSteps;
    protected CertificatesSteps certificatesSteps;
    protected GovServicesSteps govServicesSteps;
    protected AppointmentToDepartmentSteps appointmentToDepartmentSteps;
    protected FavoritesSteps favoritesSteps;
    protected GeneralSteps generalSteps;
    protected DiplomaToVillageSteps diplomaToVillageSteps;
    protected HousingCenterSteps housingCenterSteps;
    protected MortgageOnlineSteps mortgageOnlineSteps;
    protected LoansSteps loansSteps;
    protected OtauSteps otauSteps;
    protected SpecAccountSteps specAccountSteps;
    protected SpecAccountSgoSteps specAccountSgoSteps;
    protected RentSubsidyStep rentSubsidyStep;

    @BeforeSuite(alwaysRun = true, description = "Логирование старта комплекта тестов")
    public void setUp(ITestContext ctx) {
        log.info("Executing suite: {}", ctx.getSuite().getName());
    }

    @BeforeClass(alwaysRun = true, description = "Инициализация переменных")
    public void initManagers() {
        managersInit();
        pagesInit();
        stepsInit();
        configInit();
    }

    @AfterSuite(alwaysRun = true, description = "Закрытие вкладки браузера")
    public void tearDown(ITestContext ctx) {
        log.info("Finishing suite: {}", ctx.getSuite().getName());
        brManager.closeTab();
    }

    private void managersInit() {
        drManager = new DriverManager(InitDriver.initDriver());
        brManager = new BrowserManager(InitDriver.initDriver());
        elementsAttributes = new ElementsAttributes();
        navigation = new Navigation(driver);
        softly = new SoftAssertions();
        log.info("Driver manager created");
    }

    private void pagesInit() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        becomeClientPage = new BecomeClientPage(driver);
        profilePage = new ProfilePage(driver);
    }

    private void stepsInit() {
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        becomeClientSteps = new BecomeClientSteps(driver);
        mainSteps = new MainSteps(driver);
        footerSteps = new FooterSteps(driver);
        filterSteps = new FilterSteps(driver);
        profileSteps = new ProfileSteps(driver);
        digitalMortgageSteps = new DigitalMortgageSteps(driver);
        cabinetSteps = new CabinetSteps(driver);
        headerSteps = new HeaderSteps(driver);
        feedbackSteps =new FeedbackSteps(driver);
        depositSteps = new DepositSteps(driver);
        depositFamilyPackageSteps = new DepositFamilyPackageSteps(driver);
        depositAssignmentGratuitousStep = new DepositAssignmentGratuitousStep(driver);
        accountSteps = new AccountSteps(driver);
        govServicesSteps = new GovServicesSteps(driver);
        certificatesSteps = new CertificatesSteps(driver);
        appointmentToDepartmentSteps = new AppointmentToDepartmentSteps(driver);
        favoritesSteps = new FavoritesSteps(driver);
        generalSteps = new GeneralSteps(driver);
        diplomaToVillageSteps = new DiplomaToVillageSteps(driver);
        housingCenterSteps = new HousingCenterSteps(driver);
        mortgageOnlineSteps = new MortgageOnlineSteps(driver);
        loansSteps = new LoansSteps(driver);
        otauSteps =new OtauSteps(driver);
        specAccountSteps = new SpecAccountSteps(driver);
        specAccountSgoSteps = new SpecAccountSgoSteps(driver);
        rentSubsidyStep = new RentSubsidyStep(driver);
    }

    private void configInit() {
       config = AppConfigProvider.get();
       envConfig = EnvConfigProvider.get();
    }
}
