package tests;

import base.BaseTest;
import builders.BookingBuilder;
import config.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Booking;
import utils.AllureUtils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import io.qameta.allure.Allure;


public class CreateBookingNegativeTest extends BaseTest {


   @DataProvider(name = "invalidBookings")
public Object[][] invalidBookings() {

    return new Object[][]{
            {"Empty Name", "", 1000},
            {"Null Name", null, 1000},
            {"Negative Price", "Pedro", -100}
    };
}

@Test(dataProvider = "invalidBookings")
public void shouldValidateInvalidBookings(
        String scenario,
        String firstName,
        int totalPrice) {

    System.out.println("Scenario: " + scenario);

    Booking booking =
            new BookingBuilder()
                    .withFirstname(firstName)
                    .withTotalPrice(totalPrice)
                    .build();

                    AllureUtils.attachRequest(
                    "Request",
                        booking);

    Response response =
            RestAssured
                    .given()
                    .contentType("application/json")
                    .body(booking)
                    .when()
                    .post(Endpoints.BASE_URL + Endpoints.BOOKING);

                    AllureUtils.attachResponse(
                "Response",
                    response.asPrettyString());

    response.prettyPrint();

   
    System.out.println(
            "Firstname: " + firstName +
            " | Price: " + totalPrice +
            " | Status: " + response.statusCode());
}
}

    /*@Test(priority = 6)
    @Owner("Raul Flores")
@Severity(SeverityLevel.NORMAL)
@Description("Create booking with negative price")
    public void shouldCreateBookingWithNegativePrice() {

        Booking booking =
                new BookingBuilder()
                        .withTotalPrice(-100)
                        .build();

        Response response =
                RestAssured
                        .given()
                        .contentType("application/json")
                        .body(booking)
                        .when()
                        .post(Endpoints.BASE_URL + Endpoints.BOOKING);

        response.prettyPrint();

       System.out.println(
        "Negative Price Status Code = "
                + response.statusCode());

        Assert.assertEquals(
                response.statusCode(),
                200);
    }*/

    /*@Test(priority = 7)
    @Owner("Raul Flores")
@Severity(SeverityLevel.CRITICAL)
@Description("Validate API behavior when firstname is null")
public void shouldCreateBookingWithNullFirstName() {

    Booking booking =
            new BookingBuilder()
                    .withFirstname(null)
                    .build();

    Response response =
            RestAssured
                    .given()
                    .contentType("application/json")
                    .body(booking)
                    .when()
                    .post(Endpoints.BASE_URL + Endpoints.BOOKING);

    response.prettyPrint();

    
    System.out.println(
            "Null First Name Status Code = "
                    + response.statusCode());

    Assert.assertEquals(response.statusCode(), 500);
}
}*/