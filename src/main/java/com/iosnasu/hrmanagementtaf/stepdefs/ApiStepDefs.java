package com.iosnasu.hrmanagementtaf.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.*;

@Log4j2
@CucumberContextConfiguration
public class ApiStepDefs {
    private final String baseUrl = System.getProperty("baseUrl");
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(baseUrl).build();
    Response response;

    @When("User sends GET request to {}")
    public void userSendsGetRequestToHome(final String endpoint) {
        response = given().spec(requestSpecification).log().all()
                .get(endpoint).then().log().status().extract().response();
    }

    @Then("User receives status code of {int}")
    public void userReceivesStatusCode(final int statusCode) {
        response.then().statusCode(statusCode);
    }
}
