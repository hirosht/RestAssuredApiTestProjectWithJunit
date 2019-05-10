
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.AuthPayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ApiTest {


    /**
     * This test project is build with reference to the https://automationintesting.com/restassured/course/ to helpout with the RestAssured API Testing
     */

    //example as given on https://automationintesting.com/restassured/lessons/setup/
    @Test
    public void myFirstRaTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    //example as given on https://automationintesting.com/restassured/lessons/request/
    @Test
    public void sendingAnHttpRequest() {
        Response response = given().get("https://restful-booker.herokuapp.com/ping/");
        int statusCode = response.getStatusCode();

        assertThat(statusCode, is(201));
    }

    //example as given on https://automationintesting.com/restassured/lessons/headers/
    @Test
    public void sendingHttpHeaders() {
        Header acceptHeader = new Header("accept", "application/json");

        Response response = given()
                .header(acceptHeader)
                .get("https://restful-booker.herokuapp.com/booking/1");

        int statusCode = response.getStatusCode();

        assertThat(statusCode, is(200));

    }

    // example as given on https://automationintesting.com/restassured/lessons/response/
    @Test
    public void readingAnHttpResponse() {
        Response response = given().get("https://restful-booker.herokuapp.com/booking/1");
        String responseBody = response.getBody().print();

        assertThat(responseBody, containsString("Breakfast"));

    }

    // example as given on https://automationintesting.com/restassured/lessons/response/
    @Test
    public void deSerializingResponseBody() {
        Response response = given().get("https://restful-booker.herokuapp.com/booking/1");
        BookingResponse responseBody = response.as(BookingResponse.class);
        String additionalneeds = responseBody.getAdditionalneeds();

        assertThat(additionalneeds, is("Breakfast"));

    }

    // example as given on https://automationintesting.com/restassured/lessons/payload/
    @Test
    public void sendingAnHttpRequestPayload() {

        AuthPayload authPayload = new AuthPayload("admin", "password123");

        Response response = given()
                .body(authPayload) //passing the authPayload object with credentials
                .contentType("application/json")
                .post("https://restful-booker.herokuapp.com/auth");

        String authResponse = response.getBody().print();

        assertThat(authResponse, containsString("token"));

    }
}

