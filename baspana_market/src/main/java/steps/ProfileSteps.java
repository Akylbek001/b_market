package steps;

import org.openqa.selenium.WebDriver;
import pages.ProfilePage;

public class ProfileSteps {
    private final ProfilePage profilePage;

    public ProfileSteps(WebDriver driver) {
        profilePage = new ProfilePage(driver);
    }

    public void editPhoneNumber(String phoneNumber) {
        profilePage
                .clickPhoneNumber()
                .inputPhoneNumber(phoneNumber);
    }

    public void editIdentification() {
        profilePage
                .clickIdentification();
    }

    public void editPersonalData(String workPosition) {
        profilePage
                .clickPersonalData()
                .clickEditDataButton()
                .inputNewWorkPosition(workPosition);
    }

    public void editPersonalDataOperation() {
        profilePage
                .clickPersonalData()
                .clickEditDataButton();
    }

    public void setNewEmail(String newEmail) {
        profilePage
                .clickChangeEmail()
                .inputNewEmail(newEmail)
                .clickChangeEmailButton();
    }

    public void inputCurrentAndNewPassword(String oldPassword, String newPassword, String confirmNewPassword) {
        profilePage
                .clickChangePassword()
                .inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .repeatNewPassword(confirmNewPassword);
    }

    public void confirmPasswordChange() {
        profilePage
                .clickChangePasswordButton();
    }
}
