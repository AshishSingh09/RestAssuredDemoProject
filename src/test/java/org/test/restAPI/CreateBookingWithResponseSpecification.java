package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBookingWithResponseSpecification {

    ResponseSpecification responseSpecification ;

    @BeforeClass
    public void responseSpecification()
    {
        responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200).contentType(ContentType.JSON).log().all();
    }

    @Test
    public void createBooking() {

        String body = """
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
                                 }""";

        RestAssured
                .given()
                .log().all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body(body)
                .contentType(ContentType.JSON)
                .post()
                .then().spec(responseSpecification);
    }


}
