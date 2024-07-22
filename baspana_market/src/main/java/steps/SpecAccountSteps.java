package steps;

import org.openqa.selenium.WebDriver;
import pages.SpecAccountPage;

public class SpecAccountSteps {
    private final SpecAccountPage specAccountPage;
    public SpecAccountSteps(WebDriver driver) {
        specAccountPage = new SpecAccountPage(driver);
    }


    public void selectSpecAccount() {
        specAccountPage
                .selectSpecAccount();
    }

    public void openSpecAccountOperations() {
        specAccountPage
                .openSpecAccountOperations();
    }

    public void transferToDepositOperation() {
        specAccountPage
                .selectTransferToDepositOperation();
    }

    public void selectTransferToRentOperation() {
        specAccountPage
                .selectTransferToRentOperation();
    }

    public void openRecipientTypeList() {
        specAccountPage
                .openRecipientTypeList();
    }

    public void selectIndividualRecipientType() {
        specAccountPage
                .selectIndividual();
    }

    public void selectRERecipientType() {
        specAccountPage
                .selectLegalEntity();
    }

    public void inputRecipientInfo_individual(String iin, String iban) {
        specAccountPage
                .inputIin(iin)
                .inputIban(iban);
    }

    public void inputRecipientInfo_RE(String bin, String iban) {
        specAccountPage
                .inputIin(bin)
                .inputIban(iban);
    }

    public void inputRecipientIban(String iban) {
        specAccountPage
                .inputIban(iban);
    }

    public void indicateSign_withContractNumber(String date) {
        specAccountPage
                .clickWithNumberSwitch()
                .inputContractDate(date);
    }

    public void indicateSign_withoutContractNumber(String contractNumber, String date) {
        specAccountPage
                .inputContractNumber(contractNumber)
                .inputContractDate(date);
    }

    public void inputSumToTransfer_forIndividual(String sumToTransfer) {
        specAccountPage
                .inputSumToTransfer_forIndividual(sumToTransfer);
    }

    public void inputSumToTransfer_forRE(String sumToTransfer) {
        specAccountPage
                .inputSumToTransfer_forRE(sumToTransfer);
    }

    public void acceptAgreementAndTransfer() {
        specAccountPage
                .clickAgreement()
                .clickSendTransferButton();
    }

    public void transferToMortgageOperation() {
        specAccountPage
                .selectTransferToMortgageOperation();
    }




}
