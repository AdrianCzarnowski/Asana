package StepDefinitions;

import BaseTest.BaseTest;
import Model.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import utils.RequestBuilder;


import static java.lang.System.getProperty;
import static org.junit.Assert.*;

public class StepDefinitionsAsana extends BaseTest {

    RequestBuilder requestBuilder = new RequestBuilder();
    @Given("I have project object")
    public void i_have_project_object() {
        project = new Project(getProperty("gid"), getProperty("resources_type"), getProperty("name"));


    }

    @When("User perform astana GET projects operation")
    public void user_perform_astana_GET_workspace_operation() {
        response = requestBuilder.sentGetRequestProjects();
    }

    @Then("User is able to projects GID")
    public void user_is_able_to_see_response_with_projects_details() {
        response
                .then()
                .spec(getResponseSpecification());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("data[0].gid"), project.getGid());
    }
}
