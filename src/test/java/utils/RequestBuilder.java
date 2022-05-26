package utils;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static io.restassured.RestAssured.given;
import static java.lang.System.*;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("RequestBuilder.class");
    public Response sentGetRequestProjects() {
        response =
        given()
                .spec(getRequestSpecification())
                .get();
        logger.info("Get request specification send");
        return response;
    }
    public Response sentPostRequestProjects() {
        requestSpecification =
        given()
                .spec(getRequestSpecification());
        response =
                requestSpecification
                        .body(new File(getProperty("body_request_json")))
                        .post();
        logger.info("POST response: " + response.prettyPrint());
        return response;
    }
    public Response sentDeleteProjectRequest(){
        requestSpecification=
                given()
                        .spec(deleteOrPutRequestSpecification(getProperty("project_to_delete_gid")));
        response =
                requestSpecification.when().delete();
        logger.info("Delete response: " + response.prettyPrint());
        return response;
    }
    public Response sentPutProjectRequest(){
        requestSpecification=
                given()
                        .spec(deleteOrPutRequestSpecification(getProperty("project_to_update_gid")));
        response =
                requestSpecification
                        .body(new File(getProperty("body_request_json")))
                        .put();
        logger.info("Update response: " + response.prettyPrint());
        return response;
    }

}
