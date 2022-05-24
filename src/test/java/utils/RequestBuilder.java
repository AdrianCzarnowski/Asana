package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.lang.System.*;

public class RequestBuilder {

    public Response sentGetRequestWorkspace(String token){
        Response response = given()
                .auth().oauth2(token)
                .when()
                .get("/workspaces");
        return response;
    }
}
