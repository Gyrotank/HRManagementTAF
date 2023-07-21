package com.iosnasu.hrmanagementtaf.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.*;

@Log4j2
public class ApiStepDefs {
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("http://localhost:8080/").build();
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
