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


import static java.lang.Integer.*;
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
}
