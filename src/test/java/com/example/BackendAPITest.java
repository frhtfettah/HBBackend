package com.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BackendAPITest {

    @Test(description = "Check if the response code of API is 200 OK")
    public void checkResponseCode() {

        given().baseUri("https://httpbin.org/json").then().statusCode(200)
                .body("slideshow.slides[1].items[0]", equalTo("Why <em>WonderWidgets</em> are"));



    }
}
