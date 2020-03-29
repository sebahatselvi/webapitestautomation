package testinium.api.test.Post;

import com.jayway.restassured.http.ContentType;
import com.thoughtworks.gauge.Step;
import testinium.api.test.BasePackage.BaseClass;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class StudentPost extends BaseClass {

    @Step("Yeni öğrenci kaydı ekle")
    public void yeniOgrenci()
    {
        ArrayList courses=new ArrayList();
        courses.add("c#");
        courses.add("java");
        courses.add("c++");

        StudentInformation studentInformation=new StudentInformation();
        studentInformation.setFirstName("sebahat");
        studentInformation.setLastName("Selvi");
        studentInformation.setEmail("sebahat.selvi@gmail.com");
        studentInformation.setProgramme("Electronics Science");
        studentInformation.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .body(studentInformation)
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
