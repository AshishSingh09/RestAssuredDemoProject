package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateBooking_Patch {

    public static void main(String[] args) {

             RestAssured
                     .given()
                         .baseUri("https://restful-booker.herokuapp.com/")
                         .basePath("booking/1")
                         .contentType(ContentType.JSON)
                         .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                         .body("""
                                 {
                                     "firstname" : "Baby",
                                     "lastname" : "Brown"
                                 }
                                 """)
                         .log().all()
                     .when()
                         .patch()
                     .then()
                         .assertThat()
                         .statusCode(200)
                         .log().all();


    }

}
