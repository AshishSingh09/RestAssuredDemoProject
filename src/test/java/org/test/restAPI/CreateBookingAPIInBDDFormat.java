package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingAPIInBDDFormat {

    public static void main(String[] args) {

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

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .contentType(ContentType.JSON)
                    .body(body)
                    .log().all()
                .when()
                    .post()
                .then()
                    .statusCode(200)
                    .log().all();

    }
}
