package functions;

import io.restassured.path.json.JsonPath;

public class JsonOperation {
    /**
     *
     * @brief This method will be used for parsing desired json path and obtaining its value.
     *
     * @param responseBody
     *        Use the response body which is stored in result array after send request methods
     * @param parameterToBeParsed
     *        Keyword which will be parsed within the captured response body
     * @return
     *        Value of the parsed json within response body
     */
    public static String jsonParse(String responseBody, String parameterToBeParsed){
        JsonPath js = new JsonPath(responseBody);
        return js.get(parameterToBeParsed);
    }
}
