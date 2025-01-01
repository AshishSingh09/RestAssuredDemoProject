package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingAPI1 {

    public static void main(String[] args) {

        String body = """
                {
                                     "firstname" : "Jhon",
                                     "lastname" : "Lock",
                                     "totalprice" : 150,
                                     "depositpaid" : false,
                                     "bookingdates" : {
                                         "checkin" : "2025-01-01",
                                         "checkout" : "2025-02-01"
                                     },
                                     "additionalneeds" : "Dinner"
                                 }""";

        RestAssured
                .given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body(body)
                .contentType(ContentType.JSON)
                .post()
                .then().log().all().statusCode(200);


    }
}
