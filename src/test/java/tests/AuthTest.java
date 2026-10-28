package tests;
import base.BaseTest;
import config.Endpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
public class AuthTest extends BaseTest {

    @Test(priority = 1)
    @Owner("Raul Flores")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Generate authentication token")
    public void shouldGenerateToken() {

        String body = """
                {
                  "username": "admin",
                  "password": "password123"
                }
                """;

        Response response =
                
                   RestAssured
        .given()
        .relaxedHTTPSValidation()
        .contentType("application/json")
                        .body(body)
                        .when()
                        .post(Endpoints.BASE_URL + Endpoints.AUTH);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
