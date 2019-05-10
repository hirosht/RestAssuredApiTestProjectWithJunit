
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApiTest {


    //example as given on https://automationintesting.com/restassured/lessons/setup/
    @Test
    public void myFirstRaTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    //example as given on https://automationintesting.com/restassured/lessons/request/
    @Test
    public void getTest() {
        Response response = given().get("https://restful-booker.herokuapp.com/ping/");
        int statusCode = response.getStatusCode();

        assertThat(statusCode, is(201));
    }

}

