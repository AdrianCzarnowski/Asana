package stepDefinitions;

import configuration.config.App;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static java.lang.System.*;


public class Hooks {

    private static App app;

    @Before(order = 1)
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        app = new App();
    }


    @After
    public void tearDown(Scenario scenario){
        out.println("End " + scenario.getName() + scenario.getStatus());
    }
}



