package BaseTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class BaseTest {
    protected Response response;
    public RequestSpecification requestSpecification;
    public ResponseSpecification responseSpecification;
}
