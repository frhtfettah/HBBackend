package functions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static constants.constants.baseUri;

public class RestOperation {

    public static String[] sendGetRequest(String url){

        RestAssured.baseURI = baseUri;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, url);

        int responseCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        String[] result = new String[2];
        result[0]= Integer.toString(responseCode);
        result[1]=responseBody;

        return result;
    }
}
