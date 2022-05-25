package StepDefinitions;

import BaseTest.BaseTest;
import Model.Project;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.JsonArray;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;
import static java.lang.System.getProperty;

public class StepDefinitionsAsana extends BaseTest {




    @Given("I have projects authorization")
    public void i_have_authorization() {
        Project project = new Project(getProperty("gid"), getProperty("name"), getProperty("resources_type"));
        out.println(project);
    }

    @When("User perform astana GET projects operation")
    public void user_perform_astana_GET_workspace_operation() {
        requestSpecification = RestAssured.given().auth().oauth2(getProperty("token"));
    }

    @Then("User is able to projects GID")
    public void user_is_able_to_see_response_with_projects_details() {
        response = requestSpecification.get(getProperty("BASE_URL")+getProperty("BASE_PATH")+getProperty("ENDPOINT"));
    }

}
