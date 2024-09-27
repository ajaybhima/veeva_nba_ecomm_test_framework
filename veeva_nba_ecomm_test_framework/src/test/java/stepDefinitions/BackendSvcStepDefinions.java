package stepDefinitions;

import com.veeva.nba.utils.FileReadWriteUtils;
import groovy.json.JsonParser;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

public class BackendSvcStepDefinions {
        @Given("^User builds a request with \"([^\"]*)\" and \"([^\"]*)\" and Triggers POST call and validate response$")
        public void requestBuildAndTrigger(String userName, String userJob){

                RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
                requestSpecBuilder.setBaseUri(FileReadWriteUtils.readDataFromPropertiesFile("./test.properties","BaseUrl"));
                requestSpecBuilder.setBaseUri(FileReadWriteUtils.readDataFromPropertiesFile("./test.properties","BasePath"));

                RequestSpecification requestSpecification = requestSpecBuilder.build();

                requestSpecification.contentType("application/json");




                requestSpecification.body("{\"name\": \""+userName+"\" \"job\": \""+userJob+"\"}");

                Response response = RestAssured.given().spec(requestSpecification).log().uri().post();

                System.out.println(response.getBody().toString());


        }

}
