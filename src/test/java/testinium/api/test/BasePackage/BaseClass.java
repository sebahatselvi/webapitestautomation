package testinium.api.test.BasePackage;

import com.jayway.restassured.RestAssured;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterStep;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeStep;
import testinium.api.test.Get.StudentsGetMethods;

import java.util.logging.Logger;

public class BaseClass {

    protected final static java.util.logging.Logger logger = Logger.getLogger(String.valueOf(StudentsGetMethods.class));

    @BeforeScenario
    public static void beforeScenario() {
        System.out.println("---------------------- SENARYO BAŞLADI ----------------------\n");


    }
    @BeforeStep
    public void beforeStep()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/student";
    }

    @AfterStep
    public void setAfterStep()
    {

    }
    @AfterScenario
    public static void afterScenario() {

        System.out.println("\n ---------------------- SENARYO BİTTİ ----------------------");
    }

}
