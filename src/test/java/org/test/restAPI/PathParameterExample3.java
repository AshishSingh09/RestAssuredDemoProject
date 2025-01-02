package org.test.restAPI;

import io.restassured.RestAssured;

public class PathParameterExample3 {

    public static void main(String[] args) {

            /*
                 Hit the Get Booking API By Parameterizing the booking id
                 Here in the example we are going to use inline parameter and pathparam method , HTTP Method(Get, Post, Put, Delete) are overloaded method
                 Where we can send URL Along with pathparam values which works on index basis.

                 Priority :
                 1. Pathparam method will get prioritize first -- i.e's whatever value will be present in pathparam method will get set at first
                 2. Inline parameter will take the remaing value.

             */

        RestAssured
                .given()
                    .log().all()
                    .pathParams("basePath","booking")
                .when()
                    .get("https://restful-booker.herokuapp.com/{basePath}/{bookingID}",6,"token")
                .then()
                    .log().all();

    }
}
