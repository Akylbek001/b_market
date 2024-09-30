package tests;

import base.BaseTest;
import common.utils.DatesUtils;
import common.utils.WaitUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static pages.HousingCenterPage.*;

@Owner("Алибек Акылбеков")
@Feature("Центр обеспечения жильем")
public class HousingCenterTest extends BaseTest {
    @BeforeMethod(alwaysRun = true, description = "Подготовка браузера")
    public void setUpMethod() {
        brManager.clearCache();
        navigation.gotoLoginPage();
        WaitUtils.wait(2);

        loginSteps.auth(config.userLogin(), config.userPass());
    }

    @Test(description = "Подать заявку => Самостоятельная подача", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Самостоятельная подача заявки")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_selfSubmission () {
        step("Перейти в подраздел <Общее>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("Cozh"));
        });
        step("Подать заявку", () -> {
            housingCenterSteps.applyRequest_selfSubmission();
        });
        Assert.assertEquals(elementsAttributes.getValue(NCA_LAYER_NOT_AVAILABLE), "NCALayer недоступен");
        housingCenterSteps.clickOkModalButton();
    }

    @Test(description = "Подать заявку => Представитель опекаемого", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Представитель опекаемого")
    @Severity(SeverityLevel.NORMAL)
    public void applyRequest_ward () {
        step("Перейти в подраздел <Общее>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("Cozh"));
        });
        step("Подать заявку", () -> {
            housingCenterSteps.applyRequest_ward();
        });
        step("Заполнение данных опекуна", () -> {
            housingCenterSteps.fillWardData(
                    "FIO",
                    config.clientIin(),
                    config.clientDocumentNumber(),
                    "МВД РК",
                    DatesUtils.getCurrentDate(),
                    "Almaty"
            );
        });
        step("Отправить заявку", () -> {
            housingCenterSteps.sendRequest_ward();
        });
        Assert.assertEquals(elementsAttributes.getValue(NCA_LAYER_NOT_AVAILABLE), "NCALayer недоступен");
        housingCenterSteps.clickOkModalButton();
    }

    @Test(description = "Статистика => Заявления", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Заявления")
    @Severity(SeverityLevel.NORMAL)
    public void requestsTab () {
        step("Перейти в подраздел <Статистика>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("Housing/HousingStatistics"));
        });
        Assert.assertTrue(elementsAttributes.isVisible(REQUESTS_GRAPH));
    }

    @Test(description = "Статистика => Очередники", groups = {"automated"})
    @Issue("https://jira.kz/browse/QA-")
    @Description("Очередники")
    @Severity(SeverityLevel.NORMAL)
    public void waitingListTab () {
        step("Перейти в подраздел <Статистика>", () -> {
            brManager.navigateTo(envConfig.baseUrl().concat("Housing/HousingStatistics"));
        });
        step("Вкладка Очередники", () -> {
            housingCenterSteps.clickWaitingListTab();
        });
        Assert.assertTrue(elementsAttributes.isVisible(WAITING_LIST_CATEGORY_GRAPH));
    }


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
//            housingCenterSteps.applyRequest_validateNcaLayer();
            housingCenterSteps.sign("filePath", elementsAttributes.getValue(FILE_TO_SIGN), "AkylbekovA9@#");
//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            FileInputStream fis = new FileInputStream(filePath);
//            keyStore.load(fis, "BTSDigital1@".toCharArray()); // пароль для доступа к хранилищу ключей
//            fis.close();
//            String alias = keyStore.aliases().nextElement(); // предполагаем, что в хранилище один сертификат
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
