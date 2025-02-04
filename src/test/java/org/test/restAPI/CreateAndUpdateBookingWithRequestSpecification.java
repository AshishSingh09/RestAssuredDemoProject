package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAndUpdateBookingWithRequestSpecification {

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

        RestAssured
                .given()
                    .spec(requestSpecification)
                    .basePath("booking")
                    .body(body)
                .when()
                    .post()
                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test
    public void updateBooking()
    {
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
                    .spec(requestSpecification)
                    .basePath("booking/1")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body(body)
                .when()
                    .put()
                .then()
                    .log().all();
    }


}
