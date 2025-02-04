package org.test.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBookingWithRequestAndRespnoseSpecification {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;


    @BeforeClass
    public void requestAndResponseSpecification()
    {
         requestSpecification = RestAssured
                . given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .log().all();

         responseSpecification = RestAssured
                .expect()
                .statusCode(200)
                .contentType(ContentType.JSON)
                 .time(Matchers.lessThanOrEqualTo(500L))
                .log().all();

    }

    @Test
    public void createBooking()
    {
        String body =  """
                {
                    "firstname" : "Jim",
                    "lastname" : "Brown",
                    "totalprice" : 111,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
                """;

           RestAssured
                   .given()
                   .spec(requestSpecification)
                   .body(body)
                   .when()
                   .post()
                   .then()
                   .spec(responseSpecification);
    }
}
