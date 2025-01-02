package org.test.restAPI;

import groovy.transform.stc.POJO;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class PathParameterExample4 {

    public static void main(String[] args) {

            /*
                 Hit the Get Booking API By Parameterizing the booking id

                 RestAssured Provides the method called pathparam which is overloaded method , If we have multiple
                 path parameter we can create a Map and provide the value in in Key Value Pair and later we can pass
                 that map into pathparam method.
             */

        Map<String,Object> pathParameter = new HashMap<String, Object>();
        pathParameter.put("basePath","booking");
        pathParameter.put("bookingID",7);

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{basePath}/{bookingID}")
                    .pathParams(pathParameter)
                    .log().all()
                .when()
                    .get()
                .then()
                    .log().all();

    }
}
