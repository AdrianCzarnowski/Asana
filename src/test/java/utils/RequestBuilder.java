package utils;

import baseTest.BaseTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger("RequestBuilder.class");
    public Response sentGetRequestProjects() {
        response = given()
                .spec(getRequestSpecification())
                .get();
        logger.info("Get request specification send");
        return response;
    }
//    public Response sentPostRequestProjects() {
//
//        String bodyRequest = "{\n" +
//                "  \"data\": {\n" +
//                "    \"archived\": false,\n" +
//                "    \"color\": \"light-green\",\n" +
//                "    \"current_status\": {\n" +
//                "      \"author\": {\n" +
//                "        \"name\": \"Greg Sanchez\"\n" +
//                "      },\n" +
//                "      \"color\": \"green\",\n" +
//                "      \"created_by\": {\n" +
//                "        \"name\": \"Greg Sanchez\"\n" +
//                "      },\n" +
//                "      \"html_text\": \"<bodyRequest>The project <strong>is</strong> moving forward according to plan...</bodyRequest>\",\n" +
//                "      \"text\": \"The project is moving forward according to plan...\",\n" +
//                "      \"title\": \"Status Update - Jun 15\"\n" +
//                "    },\n" +
//                "    \"current_status_update\": {\n" +
//                "      \"title\": \"Status Update - Jun 15\"\n" +
//                "    },\n" +
//                "    \"custom_fields\": {\n" +
//                "      \"4578152156\": \"Not Started\",\n" +
//                "      \"5678904321\": \"On Hold\"\n" +
//                "    },\n" +
//                "    \"default_view\": \"calendar\",\n" +
//                "    \"due_date\": \"2019-09-15\",\n" +
//                "    \"due_on\": \"2019-09-15\",\n" +
//                "    \"followers\": \"12345,23456\",\n" +
//                "    \"html_notes\": \"<bodyRequest>These are things we need to purchase.</bodyRequest>\",\n" +
//                "    \"is_template\": false,\n" +
//                "    \"name\": \"Stuff to buy\",\n" +
//                "    \"notes\": \"These are things we need to purchase.\",\n" +
//                "    \"owner\": \"12345\",\n" +
//                "    \"public\": false,\n" +
//                "    \"start_on\": \"2019-09-14\",\n" +
//                "    \"team\": \"12345\"\n" +
//                "  }\n";
//        response = given()
//                .contentType("application/json").when().body(bodyRequest).post();
//        logger.info("POST response: " + response.prettyPrint());
//        return response;
//    }
}
