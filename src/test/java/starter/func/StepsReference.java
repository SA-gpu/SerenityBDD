package starter.func;

import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.WebServiceEndPoints;

public class StepsReference extends ApiOperations{

    private static final Logger log = LoggerFactory.getLogger(StepsReference.class);

    @Step("Record a new booking")
    public void postCall(RequestSpecification requestSpec){
        WebServiceEndPoints.getConfig();
        String URL = WebServiceEndPoints.URI;
        log.info("Post URL :"+ URL);
        post(requestSpec, URL);
    }

    @Step("Get a booking details")
    public void getCall(Integer id){
        WebServiceEndPoints.getConfig();
        String URL = WebServiceEndPoints.URI + "/" + id ;
        log.info("Get URL :"+ URL);
        get(URL);
    }

    @Step("Update a existing booking")
    public void updateCall(RequestSpecification requestSpec, Integer id){
        WebServiceEndPoints.getConfig();
        String URL = WebServiceEndPoints.URI + "/" + id ;
        log.info("Update URL :"+ URL);
        update(requestSpec, URL);
    }

    @Step("Delete a booking details")
    public void deleteCall(Integer id){
        WebServiceEndPoints.getConfig();
        String URL = WebServiceEndPoints.URI + "/" + id ;
        log.info("Delete URL :"+ URL);
        delete(URL);
    }
}
