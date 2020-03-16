package starter.trades;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.WebServiceEndPoints;

import java.util.Map;

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
