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
                .inputBin(bin)
                .inputIban_RE(iban);
    }

    public void inputRecipientInfo_RE_loanRepayment(String bin, String iban) {
        specAccountPage
                .inputBin_loanRepayment(bin)
                .inputIban_RE(iban);
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

    public void indicateSign_withContractNumber_re(String date) {
        specAccountPage
                .clickWithNumberSwitch_re()
                .inputContractDate_re(date);
    }

    public void indicateSign_withoutContractNumber(String contractNumber, String date) {
        specAccountPage
                .inputContractNumber(contractNumber)
                .inputContractDate(date);
    }

    public void indicateSign_withoutContractNumber_RE(String contractNumber, String date) {
        specAccountPage
                .inputContractNumber_re(contractNumber)
                .inputContractDate_re(date);
    }

    public void inputSumToTransfer_forIndividual(String sumToTransfer) {
        specAccountPage
                .inputSumToTransfer_forIndividual(sumToTransfer);
    }

    public void inputSumToTransfer_forRE(String sumToTransfer) {
        specAccountPage
                .inputSumToTransfer_re(sumToTransfer);
    }

    public void acceptAgreementAndTransfer() {
        specAccountPage
                .clickAgreement()
                .clickSendTransferButton();
    }

    public void acceptAgreementAndTransfer_forRE() {
        specAccountPage
                .clickAgreement_re()
                .clickSendTransferButton_re();
    }

    public void transferToMortgageOperation() {
        specAccountPage
                .selectTransferToMortgageOperation();
    }




}