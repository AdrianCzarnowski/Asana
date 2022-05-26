package helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static java.lang.System.getProperty;

public class Specification {
    protected Response response;
    public RequestSpecification requestSpecification;
    public ResponseSpecification responseSpecification;
    public RequestSpecification getRequestSpecification(){
        requestSpecification = given()
                .auth()
                .oauth2(getProperty("token"))
                .baseUri(getProperty("BASE_URL"))
                .basePath(getProperty("ENDPOINT"));
        return requestSpecification;
    }
    public RequestSpecification deleteRequestSpecification(){
        requestSpecification = given()
                .auth()
                .oauth2(getProperty("token"))
                .baseUri(getProperty("BASE_URL"))
                .basePath(getProperty("ENDPOINT")+getProperty("project_to_delete_gid"));
        return requestSpecification;
    }
    public ResponseSpecification getResponseSpecification(){
        responseSpecification = RestAssured.expect().contentType(ContentType.JSON);
        return  responseSpecification;
    }
}
