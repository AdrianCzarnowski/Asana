package StepDefinitions;

import BaseTest.BaseTest;
import Model.Workspace;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.RequestBuilder;

import static java.lang.System.*;
import static java.lang.System.getProperty;

public class StepDefinitionsAsana extends BaseTest {

    private Workspace workspace;
    private RequestBuilder requestBuilder;

    @Given("I have workspace object")
    public void i_have_workspace_object() {
        out.println("i_have_workspace_object");
    }

    @When("User perform astana GET workspace operation")
    public void user_perform_astana_GET_workspace_operation() {
        response = requestBuilder.sentGetRequestWorkspace(getProperty("token"));
        out.println(getProperty("token"));
    }

    @Then("User is able to see response with workspace details")
    public void user_is_able_to_see_response_with_workspace_details() {
        out.println("user_is_able_to_see_response_with_workspace_detailss");
    }

    public String getWeatherUrlAndEndpoint(){
        return getProperty("BASE_URL");
    }
}
