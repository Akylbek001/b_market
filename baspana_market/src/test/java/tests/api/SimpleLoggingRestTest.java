package tests.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.RestAssuredSpecs;
import tests.SimpleLoggingBaseRestTest;

import java.util.UUID;

import static io.qameta.allure.Allure.step;

@Owner("Алибек Акылбеков")
@Feature("Произвольный функционал для примера")

public class SimpleLoggingRestTest extends SimpleLoggingBaseRestTest {
    private String schemasFilePath;
    private RestAssuredSpecs specs;
    private String api;

    @BeforeClass(alwaysRun = true, description = "Инициализация дополнительных переменных")
    public void initVars2() {
//        api2 = "/api/v1/catalog/cities";
        api = "/api/v{version}/another/current-to-current/{clientCode}/check-client-by-antifraud";
        specs = new RestAssuredSpecs(schemasFilePath, api);
    }

    @Test(description = "Пример теста (проверка на соответствие json-схеме, простое логирование)", groups = {"rest", "smoke"})
    @Issue("https://jira.bm.kz/browse/QA-811")
    @Description("Пример теста на RestAssured с проверкой ответа на соответствие json-схеме и с простым логированием в Allure")
    @Severity(SeverityLevel.NORMAL)
    public void firstTest() {
        step("Вызов API " + api, () -> {
            RestAssured.given()
                    .spec(specs.commonRequestSpecification())
                    .header("Activity-Id", UUID.randomUUID().toString())
                    .when()
                    .get(api)
                    .then()
                    .spec(specs.correctJsonResponseSpecification("get"));
        });
    }
}
