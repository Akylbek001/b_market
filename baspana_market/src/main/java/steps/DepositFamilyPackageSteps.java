package steps;

import org.openqa.selenium.WebDriver;
import pages.DepositFamilyPackagePage;

public class DepositFamilyPackageSteps {
    private final DepositFamilyPackagePage depositFamilyPackagePage;
    public DepositFamilyPackageSteps(WebDriver driver) {
        depositFamilyPackagePage = new DepositFamilyPackagePage(driver);
    }

    public void createFamilyPackage(String familyPackageName) {
        depositFamilyPackagePage
                .selectDepositForPackage()
                .clickContinueButton()
                .inputFamilyPackageName(familyPackageName)
                .clickCreateFamilyPackageButton();
    }

    public void addMemberToFamilyPackage(String invitedIin, String invitedAlternativeCode) {
        depositFamilyPackagePage
                .clickInviteFamilyPackageMemberButton()
                .openRelationDegreeList()
                .selectRelationDegreeValue()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void relationDegreeValidation(String invitedIin, String invitedAlternativeCode) {
        depositFamilyPackagePage
                .clickInviteFamilyPackageMemberButton()
                .inputInvitedIin(invitedIin)
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .clickAddMemberButton();
    }

    public void removeFamilyPackageMember() {
        depositFamilyPackagePage
                .clickCancelInviteIcon()
                .clickConfirmCancelInviteButton();
    }

    public void disbandFamilyPackage() {
        depositFamilyPackagePage
                .clickDisbandFamilyPackageButton()
                .clickConfirmDisbandFamilyPackageButton();
    }

}
