package tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
//import org.testng.annotations.Test;

import base.BaseTest;
import data.BookingData;

public class DeleteBookingTest  extends BaseTest {

   // @Test(priority = 99)
    public void shouldDeleteBooking() {

        Response response =
                RestAssured
                        .given()
                        .relaxedHTTPSValidation()
                        .auth()
                        .preemptive()
                        .basic("admin", "password123")
                        .when()
                        .delete("https://restful-booker.herokuapp.com/booking/" + BookingData.bookingId);

        System.out.println("Deleted Booking ID: " + BookingData.bookingId);

        Assert.assertEquals(response.statusCode(), 201);
    }
}
