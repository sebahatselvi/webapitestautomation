package saha.webapi.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;



public class UsersPostTest {

    @BeforeClass
    public static void init()
    {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3000;
        RestAssured.basePath="/users";
    }

    @Test
    public void deneme()
    {
        Response response = given().when().get("/1");
        System.out.println(response.body().prettyPrint());

    }

    @Test
    public void createNewUser()
    {
        UsersInformation usersInformation=new UsersInformation();
        usersInformation.setFirst_name("Sebahat");
        usersInformation.setLast_name("Selvi");
        usersInformation.setEmail("sebahat.selvi@gmail.com");

        given()
                .contentType(ContentType.JSON)
                .when().body(usersInformation)
                .post()
                .then()
                .statusCode(201);
    }
}
