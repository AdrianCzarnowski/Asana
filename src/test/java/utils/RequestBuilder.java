package utils;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static java.lang.System.*;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("RequestBuilder.class");
    public Response sentGetRequestProjects() {
        response = given()
                .spec(getRequestSpecification())
                .get();
        logger.info("Get request specification send");
        return response;
    }
    public Response sentPostRequestProjects() {

        String bodyRequest = "{\n" +
                "  \"data\": {\n" +
                "    \"color\": \"light-red\",\n" +
                "    \"name\": \"Adrian\",\n" +
                "    \"team\": \"1202329452716104\"\n" +
                "  }\n" +
                " }\n";

        requestSpecification = given().spec(getRequestSpecification());
        response = requestSpecification.body(bodyRequest).post();
        logger.info("POST response: " + response.prettyPrint());
        return response;
    }
}
