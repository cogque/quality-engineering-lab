package tests;
import base.BaseTest;
import config.Endpoints;
import data.BookingData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Booking;



import org.testng.Assert;
import org.testng.annotations.Test;
import builders.BookingBuilder;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.AllureUtils;


public class CreateBookingTest extends BaseTest {

@Test(priority = 1)
@Owner("Raul Flores")
@Severity(SeverityLevel.CRITICAL)
@Description("Create booking with valid data")

public void shouldCreateBooking() {

    Booking booking =
            new BookingBuilder()
                    .withFirstname("Pedro")
                    .withLastname("Ramirez")
                    .withTotalPrice(2500)
                    //.withDepositPaid(false)
                    .withCheckin("2027-01-01")
                    .withCheckout("2027-01-15")
                    .withAdditionalNeeds("Lunch")
                    .build();

    Response response =
            RestAssured
                    .given()
                    .contentType("application/json")
                    .body(booking)
                    .when()
                    .post(Endpoints.BASE_URL + Endpoints.BOOKING);

                 AllureUtils.attachRequest(
                "Request",
                 booking);

                AllureUtils.attachResponse(
        "Response",
        response.asPrettyString());

    response.prettyPrint();
    System.out.println("Status Code = " + response.statusCode());

    Assert.assertEquals(response.statusCode(), 200);

    BookingData.bookingId =
            response.jsonPath().getInt("bookingid");

    Assert.assertTrue(BookingData.bookingId > 0);

    System.out.println("Booking ID: " + BookingData.bookingId);
}
}