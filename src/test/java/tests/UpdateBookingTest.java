package tests;
import base.BaseTest;

import data.BookingData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UpdateBookingTest extends BaseTest {

    @Test(priority = 3)
    public void shouldUpdateBooking() {

        String body = """
                {
                    "firstname" : "RaulUpdated",
                    "lastname" : "FloresUpdated",
                    "totalprice" : 2000,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2026-11-01",
                        "checkout" : "2026-11-10"
                    },
                    "additionalneeds" : "Lunch"
                }
                """;

        Response response =
                RestAssured
                        .given()
                        .relaxedHTTPSValidation()
                        .auth()
                        .preemptive()
                        .basic("admin", "password123")
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .put("https://restful-booker.herokuapp.com/booking/" + BookingData.bookingId);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

        String firstName =
                response.jsonPath().getString("firstname");

        Assert.assertEquals(firstName, "RaulUpdated");
    }
}