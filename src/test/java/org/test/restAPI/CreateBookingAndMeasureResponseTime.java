package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBookingAndMeasureResponseTime {

    RequestSpecification requestSpecification ;

    @BeforeClass
    public void setupRequestSpecification()
    {
         requestSpecification = RestAssured.given();
         requestSpecification.baseUri("https://restful-booker.herokuapp.com/")
                 .contentType(ContentType.JSON)
                 .log().all();
    }


    @Test
    public void createBooking()
    {
        String body = """
                {
                    "firstname" : "Jim",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;

         Response response =   RestAssured
                .given()
                    .spec(requestSpecification)
                    .basePath("booking")
                    .body(body)
                .when()
                   .post();

        long responseTimeinMilisecond =  response.time();
        System.out.println("Time in ms" + ":" + responseTimeinMilisecond);
    }
}
