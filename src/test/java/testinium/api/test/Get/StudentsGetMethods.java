package testinium.api.test.Get;

import com.jayway.restassured.response.Response;
import com.thoughtworks.gauge.Step;
import org.junit.Test;
import testinium.api.test.BasePackage.BaseClass;

import java.util.List;
import java.util.Random;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;

public class StudentsGetMethods extends BaseClass {


    //given().
    // set cookies, add auth, adding parameters, setting header info
    //when().
    //get, post,put,delete
    //then()
    //validate status code, extract response, extract headers, cookies, extract the response body


    @Step("Bütün öğrencilerin listesini getir")
    public void deneme() {

        Response response= given().
                when().
                get("/list");

        response.then().statusCode(200);
        logger.info("Öğrenci listesi başarıyla getirildi");
    }

    @Step("ID' si <id> olan öğrencinin bilgilerini getir")
    public void getStudentInfoWithId(int id)
    {
        Response response=given()
                .when()
                .get("/"+id);
        response.then().statusCode(200);
        logger.info(response.body().prettyPrint());

    }

    @Step("<program> bölümündeki öğrencilerin tamamını getir")
    public void getStudentWithProgramName(String program)
    {
        Response response=given()
                .param("programme",program)
                .when()
                .get("/list");
        response.then().statusCode(200);
        logger.info(response.body().prettyPrint());
    }

    @Step("<program> bölümündeki öğrencilerin ilk <limit> tanesini getir")
    public void getStudentWithProgramNameLimit(String program, int limit)
    {
        Response response=given()
                .param("programme",program)
                .param("limit",limit)
                .when()
                .get("/list");
        response.then().statusCode(200);
        logger.info(response.body().prettyPrint());
    }


  @Step("Rastgele bir öğrencinin bilgilerini getir")
    public void getRandomUsers() {

        String responseAsString =
                when()
                        .get("/list")
                        .then()
                        .extract().asString();
        List<Integer> albumId = from(responseAsString).get("id");
        System.out.println(albumId.size());
        Random random = new Random();
        int index = random.nextInt(albumId.size());
        System.out.println(index);
        Response response = given().when().get("/" + index + "");
        System.out.println(response.body().prettyPrint());

    }

}
