import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ApiTest {


    //example as given on https://automationintesting.com/restassured/lessons/setup/
    @Test
    public void myFirstRaTest(){
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

}

