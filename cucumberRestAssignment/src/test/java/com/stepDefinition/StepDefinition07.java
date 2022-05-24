package com.stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition07 {
	
	RequestSpecification httpRequest;
	Response response;
	
	@Given("Open home page to search user")
	public void open_home_page_to_search_user() {
		
		RestAssured.baseURI = "https://reqres.in";
		
	}

	@When("Provide some ID of the user")
	public void provide_some_id_of_the_user() {
		response = RestAssured.given().get("api/users/189");
	}

	@Then("Validate response for nagative scenario")
	public void validate_response_for_nagative_scenario() {
		
		Assert.assertEquals(response.getStatusCode(), 404);	
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");	

	}

}