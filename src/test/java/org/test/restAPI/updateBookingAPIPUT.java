package org.test.restAPI;

import io.restassured.RestAssured;

public class updateBookingAPIPUT {

    public static void main(String[] args) {

        String body = """
                {
                    "firstname" : "Ashish",
                    "lastname" : "Gopal",
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
                    .basePath("booking/1")
                    .header("Content-Type","application/json")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body(body)
                    .log().all()
                .when()
                    .put()
                .then()
                    .log().all();

    }
}
