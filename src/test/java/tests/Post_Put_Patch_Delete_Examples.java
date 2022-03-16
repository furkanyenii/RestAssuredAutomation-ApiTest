package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Post_Put_Patch_Delete_Examples {

    @Test
    public void test_Post(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request.toJSONString());


        baseURI = "https://reqres.in/api";
        given().
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }

    @Test
    public void test_Put(){
        JSONObject requestPut = new JSONObject();
        requestPut.put("name","morpheus");
        requestPut.put("job","leader");
        System.out.println(requestPut.toJSONString());


        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(requestPut.toJSONString()).
        when().
                put("/users/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_Patch(){
        JSONObject requestPatch = new JSONObject();
        requestPatch.put("name","morpheus");
        requestPatch.put("job","zion resident");
        System.out.println(requestPatch.toJSONString());


        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                body(requestPatch.toJSONString()).
        when().
                patch("/users/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test_Delete(){
        baseURI = "https://reqres.in/api";
        when().
                delete("/users/2").
        then().
                statusCode(204).
                log().all();
    }



}
