package test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BackendAPITest {

    @Test(description = "Check if the response code of API is 200 OK")
    public void checkResponseCode() {

        ExtractableResponse<Response> body = given().baseUri("https://httpbin.org").when().get("/json").then()
                .statusCode(200)
                .body("slideshow.slides[1].items[0]", equalTo("Why <em>WonderWidgets</em> are great"))
                .body("slideshow.slides[1].items[1]", equalTo("Who <em>buys</em> WonderWidgets"))
                .extract();

        String newBody = body.asString();

        System.out.println(newBody);


    }
}
