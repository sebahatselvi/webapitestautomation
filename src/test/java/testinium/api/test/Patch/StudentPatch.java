package testinium.api.test.Patch;

import com.jayway.restassured.http.ContentType;
import com.thoughtworks.gauge.Step;
import testinium.api.test.BasePackage.BaseClass;
import testinium.api.test.Post.StudentInformation;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class StudentPatch extends BaseClass {

    @Step("Ogrenci guncelle (patch)")
    public void updateStudent() {
        ArrayList courses = new ArrayList();
        courses.add("c#");
        courses.add("java");

        StudentInformation studentInformation = new StudentInformation();
        studentInformation.setFirstName("sebahat");
        studentInformation.setLastName("Selvi");
        studentInformation.setEmail("sebahat.selvi@gmail.com");
        studentInformation.setProgramme("Electronics Science");
        studentInformation.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .body(studentInformation)
                .when()
                .patch("/101")
                .then()
                .statusCode(200);

    }
}
