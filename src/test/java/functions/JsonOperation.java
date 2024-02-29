package functions;

import io.restassured.path.json.JsonPath;

public class JsonOperation {

    public static String jsonParse(String responseBody, String parameterToBeParsed){
        JsonPath js = new JsonPath(responseBody);
        return js.get(parameterToBeParsed);
    }
}
