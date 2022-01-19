package com.luxoft.steps;

import com.luxoft.dto.Example;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MyStepDefsRest {
    private RequestSpecification requestSpecification;
    private Response response;

    @Given("create request to {string}")
    public void createRequestTo(String arg0) {
        requestSpecification = given().baseUri(arg0);
    }

    @When("I send request to {string} with parameter {string}")
    public void iSendRequestToWithParameter(String arg0, String arg1) {
        response = requestSpecification.pathParam("posts", arg0)
                .pathParam("id", arg1)
                .when().get("{posts}/{id}");
    }

    @Then("status code is {int}")
    public void statusCodeIs(int arg0) {
        response.then().statusCode(arg0);
    }

    @Then("response contains {string}")
    public void responseContains(String arg0) {
        System.out.println(response.asString());
        Assertions.assertTrue(response.asString().contains(arg0));
    }

    @Then("response contains data")
    public void responseContainsData(DataTable table) {
        Example example = response.as(Example.class);
        Map<String,String> dt = table.asMap(String.class, String.class);
        assertAll(
                ()->assertThat(example.getId(), equalTo(Integer.parseInt(dt.get("id")))),
                ()->assertThat(example.getUserId(), equalTo(Integer.parseInt(dt.get("userId")))),
                ()->assertThat(example.getTitle(), equalTo(dt.get("title")))

        );
    }
}
