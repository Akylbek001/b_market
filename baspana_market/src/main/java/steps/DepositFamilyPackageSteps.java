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
                .inputFamilyPackageName(familyPackageName)
                .clickCreateFamilyPackageButton();
    }

    public void clickNavigateToCreatedFamilyPackageButton() {
        depositFamilyPackagePage
                .clickNavigateToCreatedFamilyPackageButton();
    }

    public void addMemberToFamilyPackage(String invitedAlternativeCode, String invitedIin) {
        depositFamilyPackagePage
                .clickAddMemberButton()
                .selectRelationDegree()
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .inputInvitedIin(invitedIin);
    }

    public void addMemberToFamilyPackage_validateRelationDegree(String invitedIin, String invitedAlternativeCode) {
        depositFamilyPackagePage
                .clickAddMemberButton()
                .inputInvitedAlternativeCode(invitedAlternativeCode)
                .inputInvitedIin(invitedIin);
    }

    public void clickAddMemberButton_() {
        depositFamilyPackagePage
                .clickAddMemberButton_();
    }

    public void clickAcceptInvitationButton(String otp) {
        depositFamilyPackagePage
                .clickAcceptInvitationButton()
                .inputOtp(otp)
                .clickContinueOtpConfirmationButton();
    }

    public void clickRejectInvitationButton() {
        depositFamilyPackagePage
                .clickRejectInvitationButton()
                .clickConfirmRejectionButton();
    }



    public void removeFamilyPackageMember() {
        depositFamilyPackagePage
                .clickCancelInviteIcon()
                .clickConfirmCancelInviteButton();
    }

    public void disbandFamilyPackage() {
        depositFamilyPackagePage
                .clickDisbandFamilyPackageButton()
                .clickConfirmDisbandFamilyPackageCheckbox()
                .clickConfirmDisbandFamilyPackageButton();
    }
}
