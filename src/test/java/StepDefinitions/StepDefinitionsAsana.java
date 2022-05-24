package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.lang.System.getProperty;

public class StepDefinitionsAsana {
    @Given("I have workspace object")
    public void i_have_workspace_object() {
        System.out.println("i_have_workspace_object");
    }

    @When("User perform astana GET workspace operation")
    public void user_perform_astana_GET_workspace_operation() {
        System.out.println("user_perform_astana_GET_workspace_operation");
    }

    @Then("User is able to see response with workspace details")
    public void user_is_able_to_see_response_with_workspace_details() {
        System.out.println("user_is_able_to_see_response_with_workspace_detailss");
    }

    public String getWeatherUrlAndEndpoint(){
        return getProperty("BASE_URL");
    }
}
