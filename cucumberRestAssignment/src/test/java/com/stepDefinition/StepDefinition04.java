package com.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDefinition04 {
	
    RequestSpecification httpRequest;
	Response response;
	
	@Given("user visits login page")
	public void user_visits_login_page() {
		
		RestAssured.baseURI = "https://reqres.in";
	    
	    httpRequest = RestAssured.given().log().all().header("content-type","application/json")
	    		.body("{\r\n"
	    				+ "    \"email\": \"peter@klaven\"\r\n"
	    				+ "}");  
	   
	}

	@When("user trying to login using only username")
	public void user_trying_to_login_using_only_username() {
	    
		response = httpRequest.post("api/login").then().log().all().extract().response();
				
	}

	@Then("user gets error message")
	public void user_gets_error_message() {
		 
		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusCode());
		
	}


}
