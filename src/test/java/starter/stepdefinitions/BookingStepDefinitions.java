package starter.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import starter.trades.RecordNewBooking;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class BookingStepDefinitions {

    @Steps
    RecordNewBooking recordNewBooking;
    RequestSpecification requestSpec;
//    RequestSpecBuilder builder;
//    Map<String, Object> apiBody;

    @Given("the following new booking details: {string},{string},{string},{string},{string},{string},{string}")
    public void the_following_booking_details(String fName, String lName, String price, String dPaid, String aNeeds, String cIn, String cOut) {

        Map<String, Object> apiBody = new HashMap<>();
        if (fName != ""){
            apiBody.put("firstname", fName);
        }
        else if (lName != ""){
            apiBody.put("lastname", lName);
        }
        else if (price != ""){
            apiBody.put("totalprice", price);
        }
        else if (dPaid != ""){
            apiBody.put("depositpaid", dPaid);
        }
        else if (aNeeds != ""){
            apiBody.put("additionalneeds", aNeeds);
        }
        else if (cIn != "" || cOut != ""){
            apiBody.put("bookingdates", new HashMap<String, String>() {{
                if (cIn != ""){
                    put("checkin", cIn);}
                else if (cOut != ""){
                    put("checkout", cOut);}
            }});
        }
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(apiBody);
        builder.setContentType("application/json");
        requestSpec = builder.build();
    }
    @When("record the booking")
    public void record_the_booking() {
         recordNewBooking.postDetails(requestSpec);
    }

    @Then("the recorded booking api response code should be: {string}")
    public void the_recorded_booking_response_should_get_id(String string) {
        restAssuredThat(response -> response.statusCode(Integer.parseInt(string)));


    }
}
