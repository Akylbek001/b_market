package steps;

import org.openqa.selenium.WebDriver;
import pages.HousingCenterPage;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;

public class HousingCenterSteps {
    private final HousingCenterPage housingCenterPage;

    public HousingCenterSteps(WebDriver driver) {
        housingCenterPage = new HousingCenterPage(driver);
    }

    public void applyRequest_selfSubmission() {
        housingCenterPage
                .clickApplyRequest()
                .clickSendButton()
                .clickAgreementCheckbox()
                .clickSignButton();
    }

    public void applyRequest_ward() {
        housingCenterPage
                .clickApplyRequest()
                .selectWardOption()
                .clickSendButton();
    }

    public void  fillWardData(String fio, String iin, String number, String issuedBy, String date, String address) {
        housingCenterPage
                .inputFio(fio)
                .inputIin(iin)
                .inputDocumentNumber(number)
                .inputDocumentIssuedBy(issuedBy)
                .inputDocumentCreatedDate(date)
                .inputAddress(address)
                .clickContinueButton();
    }

    public void sendRequest_ward() {
        housingCenterPage
                .clickWardAgreementCheckbox()
                .clickWardSignButton();
    }

    public void clickWaitingListTab() {
        housingCenterPage
                .clickWaitingListTab();
    }

    public void clickOkModalButton() {
        housingCenterPage
                .clickOkModalButton();
    }



    public void sign(String filePath, String fileForSign, String password) throws Exception {
        String alias = "RSA256";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, password.toCharArray());

            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
            byte[] data = fileForSign.getBytes();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data);

            byte[] digitalSignature = signature.sign();

            System.out.println("Данные успешно подписаны");
        }
    }
}
