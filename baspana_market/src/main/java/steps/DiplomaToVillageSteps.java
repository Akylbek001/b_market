package steps;

import org.openqa.selenium.WebDriver;
import pages.DiplomaToVillagePage;

public class DiplomaToVillageSteps {

    private final DiplomaToVillagePage diplomaToVillagePage;
    public DiplomaToVillageSteps(WebDriver driver) { diplomaToVillagePage = new DiplomaToVillagePage(driver); }

    public void applyRequest_validateAkimat() {
        diplomaToVillagePage
                .clickApplyRequest()
                .selectDistrict(2)
                .selectAkimat(2);
    }

    public void applyRequestSelectRegion() {
        diplomaToVillagePage
                .clickApplyRequest()
                .selectDistrict(2)
                .selectAkimat(10);
    }

    public void applyRequestSelectRequestType() {
        diplomaToVillagePage
                .selectRequestType()
                .clickSubmitButton();
    }

    public void applyRequestConfirm() {
        diplomaToVillagePage
                .clickConfirmButton();
    }

    public void applyRequestContinue() {
        diplomaToVillagePage
                .clickConfirmPersonalDataCheckbox()
                .clickContinueButton();
    }

    public void getPassport(String code) {
        diplomaToVillagePage
                .clickGetPassportButton()
                .inputPassportDigitalCode(code)
                .clickGetPassportDigitalCodeButton();
    }

    public void getDiploma(String code) {
        diplomaToVillagePage
                .clickGetDiplomaButton()
                .inputDigitalDiplomaCode(code)
                .clickGetDiplomaDigitalCodeButton();
    }

    public void uploadDiploma(String diplomaPath) {
        diplomaToVillagePage
                .uploadDiploma(diplomaPath);
    }

    public void uploadCertificateOfAbsenceRealEstate(String certificatePath) {
        diplomaToVillagePage
                .uploadCertificateOfAbsenceRealEstate(certificatePath);
    }

    public void uploadEmploymentContract(String employmentContractPath) {
        diplomaToVillagePage
                .uploadEmploymentContract(employmentContractPath);
    }

    public void cancelRequest() {
        diplomaToVillagePage
                .selectCreatedRequest()
                .clickCancelRequest()
                .clickConfirmCancelRequestButton();
    }

    public void checkElemIsDisappeared() {
        diplomaToVillagePage
                .checkElemIsDisappeared();
    }
}
