package saha.webapi.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;

public class BaseTest {

    @BeforeClass
    public static void init() {

       // RestAssured.baseURI = "https://reqres.in/api";
        baseURI="localhost:8080/";
        port=8080;
        basePath="/student";
    }

    @Test
    public void getMethod() {
        Response response = given().when().get("/list");
        System.out.println(response.body().prettyPrint());
        Assert.assertEquals("status code doğrulanmadı", 200, response.statusCode());

    }

    @Test
    public void getMethodStatusCodeControl() {
        Response response = given().when().get("/users");
        response.then().statusCode(200);

    }

    @Test
    public void getUsersId() {
        Response response = given().when().get("/users/1");
        System.out.println(response.prettyPeek());
        System.out.println(response.statusCode());
    }

    @Test
    public void getUsersParam() {
        Response response = given()
                .param("id", "1")
                .when()
                .get("/users");

        System.out.println(response.prettyPeek());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
    }

    @Test

    public void testJsonPath1() {

        String responseAsString =
                when()
                        .get("http://jsonplaceholder.typicode.com/photos")
                        .then()
                        .extract().asString();
        List<Integer> albumId = from(responseAsString).get("id");
        Random random = new Random();
        int index = random.nextInt(albumId.size());
        System.out.println(index);
        Response response = given().when().get("http://jsonplaceholder.typicode.com/photos/" + index + "");
        System.out.println(response.body().prettyPrint());

    }


}
