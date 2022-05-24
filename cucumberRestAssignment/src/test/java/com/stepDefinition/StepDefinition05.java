package com.stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition05 {
	
	RequestSpecification httpRequest;
	Response response;
	
	@Given("Go to the home page")
	public void go_to_the_home_page() {

		RestAssured.baseURI = "https://reqres.in";
		
	}

	@When("Provide wrong URI")
	public void provide_wrong_uri() {
		response = RestAssured.given().get("g.io/api/users/10");
	}

	@Then("Validate response after wrong URI")
	public void validate_response_after_wrong_uri() {
	    
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");
		Assert.assertEquals(response.getStatusCode(), 404);
		
	}
	
	

}
