package com.testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProvider09 {
	
	
	RequestSpecification httpRequest;
	Response response;

	
	@Test(dataProvider = "login")
	public void test(String username, String password) {
		
		RestAssured.baseURI = "https://reqres.in";
		
		httpRequest = RestAssured.given().log().all().header("content-type","application/json")
		    		.body("{\r\n"
		    				+ "	        \"email\": \""+ username +"\",\r\n"
		    				+ "	        \"password\": \""+ password+"\"\r\n"
		    				+ "	    }");  
		 
		response = httpRequest.post("api/login").then().extract().response();

		System.out.println("Response body : \n"+response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.getStatusCode(), 200);
	    
	}
	
	@DataProvider(name = "login")
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		
		data[0][0] = "eve.holt@reqres.in";
		data[0][1] = "cityslicka";
		
		data[1][0] = "eve.holt@reqres.in";
		data[1][1] = "pistol";
		
		data[2][0] = "eve.holt@reqres.in";
		data[2][1] = "revitria";
		
		return data;
		
	}		
		
}
		
		
		
	

