package org.test.restAPI;

import io.restassured.RestAssured;

public class DeleteBooking_Delete {

    public static void main(String[] args) {

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{bookingID}")
                    .pathParams("bookingID",6)
                    .header("Content-Type","application/json")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .log().all()
                .when()
                    .delete()
                .then()
                    .assertThat()
                    .statusCode(201)
                    .log().all();


    }



}
