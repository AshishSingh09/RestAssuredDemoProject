package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBookingAPI {

    public static void main(String[] args) {


        /*
          To Hit any API Request we need to divide in three parts .
          1. Build the request
          2. Hit the request and get the response
          3. Validate the response
         */

        // 1. Build a Request
        RequestSpecification requestSpecification = RestAssured.given().log().all();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");

        requestSpecification.body("""
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
                }""");

        requestSpecification.contentType(ContentType.JSON);

        // 2. Hit Request and get the Response
        Response response = requestSpecification.post();

        // 3. Validate the Response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }
}
