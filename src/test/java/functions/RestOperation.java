package functions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static constants.constants.baseUri;

public class RestOperation {
    /**
     *
     * @brief This method will send a GET request to the specified API path and
     *        return the response code & response body.
     * @param url
     *        Path after the Base URL
     * @return
     *        Will return an array. 0th parameter of the array will be the response code.
     *        1st parameter of the array will be the response body.
     */
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
