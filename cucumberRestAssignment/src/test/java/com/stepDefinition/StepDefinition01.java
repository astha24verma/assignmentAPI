package com.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition01 {
	
	Response response;
	
	@Given("Navigate the home page and provide new data")
	public void navigate_the_home_page_and_provide_new_data() {
		
		RestAssured.baseURI = "https://reqres.in";
		
	}

	
	@When("Post data of new user")
	public void post_data_of_new_user() {
		
		response = RestAssured.given().body("{\r\n"
				+ "    \"name\": \"Astha\",\r\n"
				+ "    \"job\": \"Tester\"\r\n"
				+ "}").header("Content-Type", "application/json").post("api/users").then().log().all().extract().response();
	    
	}
	

	@Then("Validate the creation of new user")
	public void validate_the_creation_of_new_user() {
		
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		 
	}

}
