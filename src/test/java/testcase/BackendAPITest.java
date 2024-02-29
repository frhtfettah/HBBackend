package testcase;

import functions.JsonOperation;
import functions.RestOperation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.constants.*;
import static org.testng.Assert.assertEquals;

public class BackendAPITest {

    @Test(description = "Check if the response code of API is 200 OK")
    public void checkResponseCode() {
        String[] response = RestOperation.sendGetRequest(path);

        assertEquals(response[0], statusCodeOK);
    }

    @Test(description = "Check if the response body of API is correct")
    public void checkResponseBody() {
        String[] response = RestOperation.sendGetRequest(path);

        Boolean isEmpty = response[1].toString().isBlank();
        Assert.assertEquals(isEmpty, false);
        String firstLine = JsonOperation.jsonParse(response[1], "slideshow.slides[1].items[0]");
        Assert.assertEquals(firstLine, apiResponseCheckFirst);
        String secondLine = JsonOperation.jsonParse(response[1], "slideshow.slides[1].items[1]");
        Assert.assertEquals(secondLine, apiResponseCheckSecond);
    }
}
