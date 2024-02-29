package src;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static src.Base.baseUri;

public class Rest {


    public static String sendGetRequest(String URL){

        ExtractableResponse<Response> body = given().baseUri(baseUri).when().get(URL).then()
                .statusCode(200)
                .body("slideshow.slides[1].items[0]", equalTo("Why <em>WonderWidgets</em> are great"))
                .body("slideshow.slides[1].items[1]", equalTo("Who <em>buys</em> WonderWidgets"))
                .extract();
        String bodyasd = body.toString();
return bodyasd;



    }

}
