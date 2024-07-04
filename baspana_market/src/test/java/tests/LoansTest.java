package tests;

import base.BaseTest;
import common.consts.CharacterSetConstants;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.LoansPage.NOTIFICATION_OF_REGISTRATION;

@Owner("Алибек Акылбеков")
@Feature("Займы")
public class LoansTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }

    @Test(description="", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void changeCollateral_ () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.partialEarlyRepaymentOperation("124000");
        });
    }

    @Test(description="", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    public void changeCollateral_validateRegistration () {
        step("Авторизация -> Запись в отдление", () -> {
            loginSteps.auth(config.loanClient_login(), config.loanClient_password());
            brManager.navigateTo(envConfig.baseUrl().concat("Loan"));
        });
        step("Заполнить форму", () -> {
            loansSteps.selectExistedLoan();
            loansSteps.openAvailableOperations();
            loansSteps.selectReplacementOfCollateralOperation();
        });
        Assert.assertEquals(
                "Ваш залогодатель не зарегестрирован. Зарегистрируйтесь и попробуйте еще e.",
                elementsAttributes.getValue(NOTIFICATION_OF_REGISTRATION)
        );
    }
}
