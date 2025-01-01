package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBookingRestAPI {

    public static void main(String[] args) {

        RestAssured
                .given()
                    .basePath("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .header("Accept", ContentType.JSON)
                    .pathParams("id", 1)
                    .log().all()
                .when()
                    .get()
                .then()
                    .statusCode(200)
                    .log().all();


    }
}
