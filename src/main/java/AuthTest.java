import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {

    @Test
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
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
