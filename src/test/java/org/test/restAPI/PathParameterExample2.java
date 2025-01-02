package org.test.restAPI;

import io.restassured.RestAssured;

public class PathParameterExample2 {

    public static void main(String[] args) {

            /*
                 Hit the Get Booking API By Parameterizing the booking id
                 Here in the example we are going to use inline parameter , HTTP Method(Get, Post, Put, Delete) are overloaded method
                 Where we can send URL Along with pathparam values which works on index basis
             */

        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("https://restful-booker.herokuapp.com/{basePath}/{bookingID}","booking",4)
                .then()
                    .log().all();

    }
}
