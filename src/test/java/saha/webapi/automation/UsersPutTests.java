package saha.webapi.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.path.json.JsonPath.from;

public class UsersPutTests {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
        RestAssured.basePath = "/users";
    }

    @Test
    public void updateUser() {
        UsersInformation usersInformation = new UsersInformation();
        usersInformation.setFirst_name("Sebahat");
        usersInformation.setLast_name("Sebolenzo");
        usersInformation.setEmail("selvi.34@gmail.com");

        given()
                .contentType(ContentType.JSON)
                .when().body(usersInformation)
                .patch("/16")
                .then()
                .statusCode(200);
    }

}
