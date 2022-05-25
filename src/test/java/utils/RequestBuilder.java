package utils;

import BaseTest.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder extends BaseTest {
    public Response sentGetRequestProjects() {
        response = given()
                .spec(getRequestSpecification())
                .get();
        return response;
    }
}
