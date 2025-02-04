package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ExtractResponseAsString {

    public static void main(String[] args) {

        /*
          For Extracting any value from Response we can use the method extrac and then need to mention what we want to
           extract.
         */



       String responseBody = RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .contentType(ContentType.JSON)
                    .body("""
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
                    }""")
                .when()
                    .post()
                .then()
                    .extract()
                    .body()
                    .asPrettyString();

        System.out.println(responseBody);


    }
}
