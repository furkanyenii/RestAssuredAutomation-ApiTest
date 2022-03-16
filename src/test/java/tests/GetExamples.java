package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetExamples {

    @Test
    public void test_getSingleUser(){
        Response response = get("https://reqres.in/api/users/2");
        System.out.println("Status Code : "+response.statusCode());
        System.out.println("Response : " + response.getBody().asPrettyString());
        System.out.println("Response Type : "+response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void test_getUsersList(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
        body("data[1].id",equalTo(8));
    }

    @Test
    public void test_getResourceList(){
        baseURI = "https://reqres.in/api";
        given().
                get("/unknown").
        then().
                statusCode(200).
        body("data[0].name",equalTo("cerulean"));
    }

    @Test
    public void test_getSingleResource(){
        baseURI = "https://reqres.in/api";
        given().
                get("/unknown/2").
        then().
                statusCode(200).
        body("data.name",equalTo("fuchsia rose"));
    }

    @Test
    public void test_getDelayedResponse(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?delay=3").
        then().
                statusCode(200).
                body("data[0].first_name",equalTo("George"));
    }


}
