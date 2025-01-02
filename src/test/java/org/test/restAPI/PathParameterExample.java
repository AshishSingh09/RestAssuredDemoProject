package org.test.restAPI;

import io.restassured.RestAssured;

public class PathParameterExample {

    public static void main(String[] args) {

            /*
                 Hit the Get Booking API By Parameterizing the booking id

                 RestAssured Provides the method called pathparam which is used to setup or parameterize the path parameter
             */

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{basePath}/{bookingID}")
                    .pathParams("basePath","booking")
                    .pathParams("bookingID",2)
                    .log().all()
                .when()
                    .get()
                .then()
                    .log().all();

    }
}
