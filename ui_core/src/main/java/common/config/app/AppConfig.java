package common.config.app;

import common.wrappers.SecretText;
import org.aeonbits.owner.Config;
@Config.Sources({"classpath:application.properties"})
public interface AppConfig extends Config {

    @Key("loanClient.login")
    String loanClient_login();

    @Key("loanClient.password")
    String loanClient_password();

    @Key("specAccount.login")
    String specAccount_login();

    @Key("specAccount.password")
    String specAccount_password();


    @Key("client.fullName")
    String clientFullName();

    @Key("client.login")
    String clientLogin();

    @Key("client.password")
    String clientPassword();

    @Key("client.invalidLogin")
    String clientInvalidLogin();

    @Key("client.invalidPassword")
    String clientInvalidPassword();

    @Key("client.iin")
    String clientIin();

    @Key("client.invalidIin")
    String clientInvalidIin();

    @Key("client.documentNumber")
    String clientDocumentNumber();

    @Key("client.email")
    String clientEmail();





    @Key("client_for_password_recovery.login")
    String client_for_password_recovery_login();

    @Key("client_for_password_recovery.invalidLogin")
    String client_for_password_recovery_invalidLogin();

    @Key("client_for_password_recovery.newLogin")
    String client_for_password_recovery_newLogin();

    @Key("client_for_password_recovery.newPassword")
    String client_for_password_recovery_newPassword();

    @Key("client_for_password_recovery.invalidPassword")
    String client_for_password_recovery_invalidPassword();

    @Key("client_for_password_recovery.document")
    String client_for_password_recovery_document();

    @Key("client_for_password_recovery.alternativeCode")
    String client_for_password_recovery_alternativeCode();

    @Key("client_for_password_recovery.invalidDocument")
    String client_for_password_recovery_invalidDocument();

    @Key("client_for_password_recovery.iin")
    String client_for_password_recovery_iin();





    @Key("guest.login")
    String guestLogin();

    @Key("guest.password")
    String guestPassword();

    @Key("guest.invalidLogin")
    String guestInvalidLogin();

    @Key("guest.invalidPassword")
    String guestInvalidPassword();

    @Key("guest.email")
    String guestEmail();

    @Key("guest.newEmail")
    String guestNewEmail();

    @Key("guest.fakeName")
    String guestFakeName();





    @Key("client_for_.login")
    String client_for_login();

    @Key("client_for_.password")
    String client_for_password();

    @Key("client_for_.newPassword")
    String client_for_newPassword();

    @Key("client_for_.newEmail")
    String client_for_newEmail();




    @Key("sms.code")
    String smsCode();

    @Key("user.login")
    String userLogin();

    @Key("user.fakeLogin")
    String userFakeLogin();

    @Key("user.pass")
    String userPass();

    @Key("user.fakePass")
    String userFakePass();

//    @Key("client.documentNumber")
//    String clientDocumentNumber();

    @Key("client.alternativeCode")
    String clientAlternativeCode();

    @Key("client.iban")
    String clientIban();

    @Key("user.iin")
    String userIin();

    @Key("user.email")
    String userEmail();

    @Key("invalidFormat.iin")
    String invalidFormatIin();

    @Key("user.invalidIin")
    String userInvalidIin();

//    @Key("client.newEmail")
//    String clientNewEmail();

    @Key("client.invalidEmail")
    String clientInvalidEmail();

    @Key("client.invalidPass")
    String clientInvalidPass();

    @Key("user.newPassword")
    String userNewPassword();

    @Key("mortgage.amount")
    String mortgageAmount();

    @Key("familyDeposit.name")
    String familyDepositName();

    @Key("sum.ToTransfer")
    String sumToTransfer();



    @Key("guest.name")
    String guestName();

//    @Key("guest.fakeName")
//    String guestFakeName();

    @Key("guest.lastName")
    String guestLastName();

    @Key("guest.sureName")
    String guestSureName();

    @Key("guest.iin")
    String guestIin();

    @Key("guest.phone")
    String guestPhone();

//    @Key("guest.email")
//    String guestEmail();

    @Key("guest.pass")
    String guestPass();

//    @Key("guest.invalidPass")
//    String guestInvalidPass();

    @Key("price.from")
    String priceFrom();

    @Key("price.to")
    String priceTo();
}
