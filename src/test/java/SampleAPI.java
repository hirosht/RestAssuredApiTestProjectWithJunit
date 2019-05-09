import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class SampleAPI {

    @Test
    public void makeSureThatGoogleIsUp() {
        Response response = given().when().get("https://www.google.com");
        System.out.println("Response Code : "+response.statusCode());
        System.out.println("Response : "+response.asString());
        Assert.assertEquals(response.statusCode(), 200,"Response Status");

    }

    @Test
    public void postRequest(){
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "sdimpleu6ser2dd2011wepo");
        requestParams.put("Password", "password1");
        requestParams.put("Email",  "sample2e6e26d9ewpo@gmail.com");

        request.body(requestParams.toString());
        Response response = request.post("/register");
        System.out.println("Response : "+response.asString());

        int statusCode = response.getStatusCode();
        System.out.println("The Status Code : "+statusCode);
        //System.out.println("Response : "+response.body().asString());
       // Assert.assertEquals(statusCode, "201");
        //String successCode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");

    }
}

