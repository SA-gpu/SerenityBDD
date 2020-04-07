package starter.func;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiOperations {
    private static final Logger log = LoggerFactory.getLogger(ApiOperations.class);

    static void post(RequestSpecification requestSpec, String URL) {

        SerenityRest.given()
                .spec(requestSpec)
                .when()
                .post(URL);
    }

    static void get(String getUrl) {

        SerenityRest.given()
                .when()
                .get(getUrl);
    }

    static void delete(String getUrl) {

        SerenityRest.given()
                .auth().preemptive().basic("admin","password123")
                .when()
                .delete(getUrl);
    }

    static void update(RequestSpecification requestSpec, String URL) {

        SerenityRest.given()
                .auth().preemptive().basic("admin","password123")
                .spec(requestSpec)
                .when()
                .put(URL);
    }
}
