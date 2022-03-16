package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RegisterExample {

    @Test
    public void test_registerSuccessful(){
        baseURI = "https://reqres.in/api";

        JSONObject registerRequest = new JSONObject();
        registerRequest.put("email","eve.holt@reqres.in");
        registerRequest.put("password","pistol");
        System.out.println(registerRequest.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(registerRequest.toJSONString()).
        when().
                post("/register").
        then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_registerUnSuccessful(){
        baseURI = "https://reqres.in/api";

        JSONObject registerRequest = new JSONObject();
        registerRequest.put("email","sydney@fife");
        System.out.println(registerRequest.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(registerRequest.toJSONString()).
        when().
                post("/register").
        then()
                .statusCode(400)
                .log().all();

    }
}
