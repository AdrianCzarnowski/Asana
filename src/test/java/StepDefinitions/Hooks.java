package StepDefinitions;

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
    @Before(order = 2)
    public void initTitle(Scenario scenario){
        out.println("Start " + scenario.getName());
    }
    @Before(order = 2)
    public void initData(Scenario scenario){
        RestAssured.baseURI = getProperty("BASE_URL");
        RestAssured.basePath = getProperty("BASE_PATH");
        out.println("<<<<<<");
    }
    @After
    public void tearDown(Scenario scenario){
        out.println("End " + scenario.getName() + scenario.getStatus());
    }
}



