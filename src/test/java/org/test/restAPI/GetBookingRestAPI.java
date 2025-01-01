package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetBookingRestAPI {

    public static void main(String[] args) {

        /*
          This is a Git Request with BDD Format
         */

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
