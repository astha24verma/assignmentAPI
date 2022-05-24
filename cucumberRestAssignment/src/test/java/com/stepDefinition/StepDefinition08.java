package com.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition08 {
	
	RequestSpecification httpRequest;
	Response response;
	
	
	@Given("user is on register page")
	public void user_is_on_register_page() {
	    

		 RestAssured.baseURI = "https://reqres.in";
	}

	@When("user registers using email and password")
	public void user_registers_using_email_and_password() {
		 httpRequest = RestAssured.given().log().all().header("content-type","application/json")
		    		.body("{\r\n"
		    				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
		    				+ "    \"password\": \"pistol\"\r\n"
		    				+ "}");  
		 
		response = httpRequest.post("api/register").then().extract().response();
	}

	@Then("validate the outcome after request")
	public void validate_the_outcome_after_request() {
//		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
//		Assert.assertEquals(response.getStatusCode(), 400);
		
		System.out.println(response.getBody().asPrettyString());

	}

}
