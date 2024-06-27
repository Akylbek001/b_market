package steps;

import org.openqa.selenium.WebDriver;
import pages.BecomeClientPage;

public class BecomeClientSteps {
    private final BecomeClientPage becomeClientPage;

    public BecomeClientSteps(WebDriver driver) { becomeClientPage = new BecomeClientPage(driver); }

    public void openDeposit() {
        becomeClientPage
                .clickOpenDepositBlock()
                .clickOpenDepositButton();
    }

    public void becomeClientByOpenAccountForEPV() {
        becomeClientPage
                .clickAccountForEPVBlock();
    }

    public void becomeClientByOpenAccountForNDF() {
        becomeClientPage
                .clickAccountForEPVBlock();
    }

    public void verifyPhoneNumberAndIin(String phoneNumber, String iin) {
        becomeClientPage
                .inputAuthPhone(phoneNumber)
                .inputAuthIin(iin)
                .clickVerifyButton();
    }

    public void inputEmail(String email) {
        becomeClientPage
                .inputEmail(email)
                .clickAgreeToGetNewslettersCheckbox()
                .clickContinueButton();
    }

    public void confirmByOtp(String otp) {
        becomeClientPage
                .inputOtp(otp)
                .clickSendButton();
    }

    public void inputPersonalDataFirstPart(String workPlace, String workPosition, String email) {
        becomeClientPage
                .inputWorkPlace(workPlace)
                .inputWorkPosition(workPosition)
                .selectSourceOfIncome()
                .inputEmail(email);
    }

    public void selectRegAddress(String regHouse, String regApartment) {
        becomeClientPage
                .clickRegistrationAddress()
                .selectRegRegion()
                .selectRegDistrict()
                .selectRegStreet()
                .inputRegHouse(regHouse)
                .inputRegApartment(regApartment)
                .clickAddRegAddressButton();
    }

    public void selectLivingAddress(String livingHouse, String livingApartment) {
        becomeClientPage
                .clickLivingAddress()
                .selectLivingRegion()
                .selectLivingDistrict()
                .selectLivingStreet()
                .inputLivingHouse(livingHouse)
                .inputLivingApartment(livingApartment)
                .clickAddLivingAddressButton();
    }

    public void selectSameAddressCheckbox() {
        becomeClientPage
                .selectSameAddressCheckbox();
    }

    public void inputPersonalDataSecondPart(
            String birthSurname,
            String codeWord
    ) {
        becomeClientPage
                .inputBirthSurname(birthSurname)
                .inputCodeWord(codeWord)
                .clickAgreeToGetNewslettersCheckbox()
                .clickContinueButton();
    }

    public void becomeClientByOpenAccountForNFD(String authPhone, String authIin) {
        becomeClientPage
                .clickAccountForNFDBlock()
                .inputAuthPhone(authPhone)
                .inputAuthIin(authIin)
                .clickVerifyButton();
    }
}
