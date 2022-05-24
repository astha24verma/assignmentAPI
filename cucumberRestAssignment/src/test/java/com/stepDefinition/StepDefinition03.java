package com.stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition03 {
	
	RequestSpecification httpRequest;
	Response response;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
	
	    RestAssured.baseURI = "https://reqres.in";
	    
	    httpRequest = RestAssured.given().header("content-type","application/json")
	    		.body("{\r\n"
	    				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
	    				+ "    \"password\": \"cityslicka\"\r\n"
	    				+ "}");  
	}
	
	@When("user login using credentials username and password")
	public void user_login_using_credentials_username_and_password() {
		
		response = httpRequest.post("api/login").then().extract().response();
				
	}

	

	@Then("user is navigated to Home page")
	public void user_is_navigated_to_home_page() {
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		
		
	}


}
