package StepDefinitions;

import config.App;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;



public class Hook {

    private static App app;

    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        app = new App();
    }
    @Before
    public void initTitle(Scenario scenario){
        System.out.println("Start " + scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario){
        System.out.println("End " + scenario.getName() + scenario.getStatus());
    }
}



