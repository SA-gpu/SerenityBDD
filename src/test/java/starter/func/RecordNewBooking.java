package starter.func;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.WebServiceEndPoints;

public class RecordNewBooking {

    @Step("Record a new booking")
    public void postDetails(RequestSpecification requestSpec) {
        WebServiceEndPoints.getConfig();
        String getUrl = WebServiceEndPoints.URI;

        SerenityRest.given()
                .spec(requestSpec)
                .when()
                .post(getUrl);
    }
}
