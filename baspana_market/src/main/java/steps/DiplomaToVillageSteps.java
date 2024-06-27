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

    public void applyRequest() {
        diplomaToVillagePage
                .clickApplyRequest()
                .selectDistrict(2)
                .selectAkimat(10);
    }

    public void applyRequestFinish() {
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
                .clickAgreementCheckbox()
                .clickContinueButton();
    }

//    public void getDocuments() {
//        diplomaToVillagePage
//                .clickGetPassportButton();
//    }

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
