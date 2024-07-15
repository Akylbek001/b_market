package tests;

import base.BaseTest;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

import static io.qameta.allure.Allure.step;
import static pages.HousingCenterPage.FILE_TO_SIGN;

@Owner("Алибек Акылбеков")
@Feature("Центр обеспечения жильем")
public class HousingCenterTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(1);
    }
//    String filePath = System.getProperty("user.dir") + "/src/test/resources/documents/.p12";

    @Test(description = "Подать заявку => Валидация ncaLayer", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Подать заявку")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_sign () {
        step("Авторизация", () -> {
            loginSteps.auth(config.userLogin(), config.userPass());
            brManager.navigateTo(envConfig.baseUrl().concat("Cozh"));
        });
        step("Подать заявку", () -> {
            housingCenterSteps.applyRequest_validateNcaLayer();
            housingCenterSteps.sign("filePath", elementsAttributes.getValue(FILE_TO_SIGN), "AkylbekovA9@#");


//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            FileInputStream fis = new FileInputStream(filePath);
//            keyStore.load(fis, "BTSDigital1@".toCharArray()); // пароль для доступа к хранилищу ключей
//            fis.close();
//            String alias = keyStore.aliases().nextElement(); // предполагаем, что в хранилище один сертификат
//
//
//            X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
//            PublicKey publicKey = cert.getPublicKey();
//            Signature signature = Signature.getInstance("SHA256withRSA"); // указываем алгоритм
//            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, "BTSDigital1@".toCharArray()); // получаем приватный ключ
//
//            signature.initSign(privateKey);
//
//// Подписание данных
//            byte[] data = elementsAttributes.getValue(FILE_TO_SIGN).getBytes(); // данные для подписи
//            signature.update(data);
//            byte[] digitalSignature = signature.sign();
//
//            // Создание верификатора подписи
//            Signature verifier = Signature.getInstance("SHA256withRSA");
//            verifier.initVerify(publicKey);
//
//// Указание данных для проверки подписи
//            verifier.update(data); // те же данные, что использовались при подписи
//
//// Проверка подписи
//            boolean verified = verifier.verify(digitalSignature);


        });
    }
}
