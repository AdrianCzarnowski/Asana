package baseTest;

import helpers.Specification;
import model.Project;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static java.lang.System.getProperty;


public class BaseTest extends Specification {
    protected Response response;
    protected Project project;


}
