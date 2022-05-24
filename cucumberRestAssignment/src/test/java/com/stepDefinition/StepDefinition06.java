package com.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//https://www.exchangerate-api.com/docs/historical-data-requests
public class StepDefinition06 {
	
	RequestSpecification httpRequest;
	Response response;
	
	@Given("API to test")
	public void api_to_test() {
	    
	}

	@When("posted with future date information")
	public void posted_with_future_date_information() {
	    
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
	    
	}

}
