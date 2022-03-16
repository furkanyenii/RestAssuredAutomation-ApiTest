package tests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoginExample {

    @Test
    public void test_loginSuccessful(){
        baseURI = "https://reqres.in/api";

        JSONObject loginRequest = new JSONObject();
        loginRequest.put("email","eve.holt@reqres.in");
        loginRequest.put("password","cityslicka");
        System.out.println(loginRequest.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(loginRequest.toJSONString()).
        when().
                post("/login").
        then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test_loginUnSuccessful(){
        baseURI = "https://reqres.in/api";

        JSONObject loginRequest = new JSONObject();
        loginRequest.put("email","peter@klaven");
        System.out.println(loginRequest.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(loginRequest.toJSONString()).
        when().
                post("/login").
        then()
                .statusCode(400)
                .log().all();
    }

}
