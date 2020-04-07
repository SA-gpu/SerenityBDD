package starter.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import starter.func.StepsReference;
import starter.func.Response;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class StepDefinitions {

    @Steps
    StepsReference stepReferences;

    @Steps
    Response bookingResponse;

    RequestSpecification requestSpec;
//    RequestSpecBuilder builder;
//    Map<String, Object> apiBody;

    @Given("the following new booking details: {string},{string},{string},{string},{string},{string},{string}")
    public void bookingDetails(String fName, String lName, String price, String dPaid, String aNeeds, String cIn, String cOut) {

        Map<String, Object> apiBody = new HashMap<>();
        if (fName != ""){
            apiBody.put("firstname", fName);
        }
        if (lName != ""){
            apiBody.put("lastname", lName);
        }
        if (price != ""){
            apiBody.put("totalprice", price);
        }
        if (dPaid != ""){
            apiBody.put("depositpaid", dPaid);
        }
        if (aNeeds != ""){
            apiBody.put("additionalneeds", aNeeds);
        }
        if (cIn != "" || cOut != ""){
            apiBody.put("bookingdates", new HashMap<String, String>() {{
                if (cIn != ""){
                    put("checkin", cIn);}
                if (cOut != ""){
                    put("checkout", cOut);}
            }});
        }
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(apiBody);
        builder.setContentType("application/json");
        requestSpec = builder.build();
    }

    @When("record the booking")
    public void addBooking() {
        stepReferences.postCall(requestSpec);
    }

    @When("Get the booking details on id")
    public void getBookingDetails() {
        Integer id = Response.extractJsonData("bookingid");
        stepReferences.getCall(id);
    }

    @When("Delete booking details")
    public void deleteBookingDetails() {
        Integer id = Response.extractJsonData("bookingid");
        stepReferences.deleteCall(id);
    }

    @When("update the booking")
    public void updateTheBooking() {
        Integer id = Response.extractJsonData("bookingid");
        stepReferences.updateCall(requestSpec, id);
    }

    @Then("the recorded booking api response code should be: {string}")
    public void recordedBookingResponse(String string) {
        restAssuredThat(response -> response.statusCode(Integer.parseInt(string)));
    }
}
