package testinium.api.test.Delete;

import com.thoughtworks.gauge.Step;
import testinium.api.test.BasePackage.BaseClass;

import static com.jayway.restassured.RestAssured.given;

public class StudentDelete extends BaseClass {

    @Step("<id> li öğrenciyi sil")
    public void deleteStudent(int id)
    {
        given()
                .when()
                .delete("/"+id)
                .then()
                .statusCode(204);
    }
}
