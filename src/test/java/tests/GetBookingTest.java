package tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import data.BookingData;

public class GetBookingTest extends BaseTest {

    @Test(priority = 2)
    public void shouldGetBooking() {

   int bookingId = BookingData.bookingId;

System.out.println("Using booking: " + bookingId);

        Response response =
                RestAssured
                        .given()
                        .relaxedHTTPSValidation()
                        .when()
                        .get("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

        String firstName =
                response.jsonPath().getString("firstname");

        Assert.assertNotNull(firstName);
    }
}
