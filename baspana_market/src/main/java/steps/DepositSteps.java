package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositPage;

public class DepositSteps {
    private final DepositPage depositPage;
    public DepositSteps(WebDriver driver) { depositPage = new DepositPage(driver); }

    public void selectMyBankMenu() {
        depositPage
                .selectMyBankMenu();
    }

    public void selectDepositsMenu() {
        depositPage.selectDepositsMenu();
    }

    public void selectOpenedDeposit() {
        depositPage.selectOpenedDeposit();
    }

    public void clickNewDepositButton() {
        depositPage.clickNewDepositButton();
    }

    public void clickOpenBaspanaDepositButton() {
        depositPage.clickOpenBaspanaDepositButton();
    }

    public void openBaspanaDeposit() {
        depositPage
                .clickOpenDepositButton()
                .clickAgreementCheckbox()
                .clickSubmit();
    }

    public void openAqyl() {
        depositPage
                .clickOpenAqylButton()
                .clickOpenAqylContinueButton();
    }

    public void confirmBySms(String smsCode) {
        depositPage
                .clickConfirm()
                .inputSmsCode(smsCode)
                .clickSend();
    }

    public void showAvailableOperations() {
        depositPage.showAvailableOperations();
    }

    public void changeGosPrem() {
        depositPage
                .selectChangeGosPremOperation()
                .clickSelectButton();
    }

    public void terminateDeposit() {
        depositPage
                .terminateDepositOperation()
                .clickTerminateButton()
                .clickContinueTerminateButton();
    }

    public void selectCreateFamilyPackageOperation() {
        depositPage
                .createFamilyPackageOperation();
    }

    public void createFamilyPackage(String familyPackageName) {
        depositPage
                .selectDeposit()
                .clickContinueButton()
                .inputFamilyPackageName(familyPackageName)
                .clickCreateFamilyPackageButton();
    }

    public void addMemberToFamilyPackage(String invitedIin, String invitedAlternativeCode) {
        depositPage
                .clickInviteFamilyPackageMemberButton()
                .openRelationDegreeList()
                .selectRelationDegreeValue()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void relationDegreeValidation(String invitedIin, String invitedAlternativeCode) {
        depositPage
                .clickInviteFamilyPackageMemberButton()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void removeFamilyPackageMember() {
        depositPage
                .clickCancelInviteIcon()
                .clickConfirmCancelInviteButton();
    }

    public void disbandFamilyPackage() {
        depositPage
                .clickDisbandFamilyPackageButton()
                .clickConfirmDisbandFamilyPackageButton();
    }

    public void calculator() {
        depositPage
                .showDepositDetails()
                .openCalculator();
    }
}
