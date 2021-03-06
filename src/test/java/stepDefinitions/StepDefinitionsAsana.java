package stepDefinitions;

import baseTest.BaseTest;
import model.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RequestBuilder;


import java.io.File;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.getProperty;
import static org.junit.Assert.*;

public class StepDefinitionsAsana extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger("StepDefinitionsAsana.class");
    RequestBuilder requestBuilder = new RequestBuilder();
    @Given("I have project object")
    public void i_have_project_object() {
        project = new Project(getProperty("gid"), getProperty("resources_type"), getProperty("name"));
        logger.info("project created");

    }

    @When("User perform astana GET projects operation")
    public void user_perform_astana_GET_workspace_operation() {
        response = requestBuilder.sentGetRequestProjects();
    }

    @Then("User is able to projects GID")
    public void user_is_able_to_see_response_with_projects_details() {
        response
                .then()
                .spec(getResponseSpecification())
                .statusCode(parseInt(getProperty("status_code")));
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("data[0].gid"), project.getGid());
        logger.info("Unique gid: " + project.getGid());
        logger.info("Assertion passed");
    }

    @When("User perform POST request")
    public void user_perform_POST_request() {
        response = requestBuilder.sentPostRequestProjects();
    }

    @Then("New project added")
    public void new_project_added() {
        assertEquals(parseInt(getProperty("status_code_post")), response.getStatusCode());
        logger.info("Status code: " + response.getStatusCode());
    }

    @Given("I have project to delete")
    public void i_have_project_to_delete() {
        String projectGid = getProperty("project_to_delete_gid");
        logger.info("Project to delete gid: " + projectGid);
    }

    @When("User perform DELETE request")
    public void user_perform_DELETE_request() {
        response = requestBuilder.sentDeleteProjectRequest();
    }

    @Then("Project is not available")
    public void project_is_not_available() {
        assertEquals(parseInt(getProperty("status_code")), response.getStatusCode());
        logger.info("Project deleted successfully");
    }

    @Given("I have project to update")
    public void i_have_project_to_update() {
        project = new Project(getProperty("project_to_update_gid"), getProperty("resources_type"), getProperty("name"));
        logger.info(valueOf(project));
    }

    @When("User perform PUT request")
    public void user_perform_PUT_request() {
        response = requestBuilder.sentPutProjectRequest();
    }

    @Then("Project is updated")
    public void project_is_updated() {
        assertEquals(parseInt(getProperty("status_code")), response.getStatusCode());
    }


    @Given("I have project to create")
    public void iHaveProjectToCreate() {

    }

    @Given("I have data to create new project")
    public void iHaveDataToCreateNewProject() {
        File bodyRequest = new File(getProperty("body_request_json"));
        logger.info(bodyRequest.toString());
    }
}
