package com.stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition02 {
	
	Response response;
	
	@Given("Navigate to the home page")
	public void visite_the_home_page() {
		
		RestAssured.baseURI = "https://reqres.in";
		
	}

	@When("Provide the ID of the user")
	public void provide_the_id_of_the_user() {

		response = RestAssured.given().get("api/users/10");
	}

	@Then("Validate positive response code and output")
	public void validate_positive_response_code() {
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	
		
		
	}


}
