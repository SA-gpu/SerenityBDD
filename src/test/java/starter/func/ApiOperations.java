package starter.func;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.WebServiceEndPoints;

public class ApiOperations {
    private static final Logger log = LoggerFactory.getLogger(ApiOperations.class);

    @Step("Record a new booking")
    public void postDetails(RequestSpecification requestSpec) {

        log.info("Body from Request Specification :"+ requestSpec.toString());
        WebServiceEndPoints.getConfig();
        String getUrl = WebServiceEndPoints.URI;

        SerenityRest.given()
                .spec(requestSpec)
                .when()
                .post(getUrl);
    }

    @Step("Get a booking details")
    public void getDetails(Integer id) {

        WebServiceEndPoints.getConfig();
        String getUrl = WebServiceEndPoints.URI + "/" + id ;
        log.info("Get URL :"+ getUrl);

        SerenityRest.given()
                .when()
                .get(getUrl);
    }

    @Step("Delete a booking details")
    public void deleteDetails(Integer id) {

        WebServiceEndPoints.getConfig();
        String getUrl = WebServiceEndPoints.URI + "/" + id ;
        log.info("Delete URL :"+ getUrl);

        SerenityRest.given()
                .auth().preemptive().basic("admin","password123")
                .when()
                .delete(getUrl);
    }

    @Step("Update a existing booking")
    public void updateDetails(RequestSpecification requestSpec, Integer id) {

        WebServiceEndPoints.getConfig();
        String getUrl = WebServiceEndPoints.URI + "/" + id ;
        log.info("Update URL :"+ getUrl);

        SerenityRest.given()
                .auth().preemptive().basic("admin","password123")
                .spec(requestSpec)
                .when()
                .put(getUrl);
    }
}
