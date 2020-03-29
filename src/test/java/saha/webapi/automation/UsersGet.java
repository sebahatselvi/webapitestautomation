package saha.webapi.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.path.json.JsonPath.from;

public class UsersGet {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void getMethod() {
        Response response = given().when().get("/users");
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

    public void getRandomUsers() {

        String responseAsString =
                when()
                        .get("https://reqres.in/api/users")
                        .then()
                        .extract().asString();
        List<Integer> albumId = from(responseAsString).get("id");
        System.out.println(albumId.size());
        Random random = new Random();
        int index = random.nextInt(albumId.size());
        System.out.println(index);
        Response response = given().when().get("http://jsonplaceholder.typicode.com/photos/" + index + "");
        System.out.println(response.body().prettyPrint());

    }


}
