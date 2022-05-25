package StepDefinitions;

import BaseTest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


import static java.lang.System.*;
import static java.lang.System.getProperty;

public class StepDefinitionsAsana extends BaseTest {




    @Given("I have projects authorization")
    public void i_have_authorization() {
         requestSpecification = RestAssured.given().auth().oauth2(getProperty("token"));
    }

    @When("User perform astana GET projects operation")
    public void user_perform_astana_GET_workspace_operation() {

        response = requestSpecification.get(getProperty("BASE_URL")+getProperty("BASE_PATH")+getProperty("ENDPOINT"));

    }

    @Then("User is able to projects GID")
    public void user_is_able_to_see_response_with_workspace_details() {
        out.println("user_is_able_to_see_response_with_workspace_detailss");
    }

    public String getWeatherUrlAndEndpoint(){
        return getProperty("BASE_URL");
    }
}
