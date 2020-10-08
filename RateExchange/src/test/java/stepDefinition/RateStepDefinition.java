package stepDefinition;

import org.testng.Assert;
//import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import static org.hamcrest.Matchers.*;


public class RateStepDefinition {
	
	Response response;
	int statusCode;
	int var=0;
	String responseBody;
	
//Scenario -1
	@Given("^Customer have API Foreign Exchange Rates$")
	public void Customer_have_API_Foreign_Exchange_Rates() throws Throwable {
		Header h = new Header("Accept","Application/json");
		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
		System.out.println("API Launch");

	}

	@When("^Customer hit API$")
	public void Customer_hit_API() throws Throwable {
		statusCode = response.getStatusCode();
		System.out.println("Available");
	  
	}

	@Then("^the Status code comeas (\\d+)$")
	public void the_Status_code_comeas(int arg1) throws Throwable {
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
	 
	}
	
//Scenario - 2
	@Given("^API Foreign Exchange Rates$")
	public void API_Foreign_Exchange_Rates() throws Throwable {
		Header h = new Header("Accept","Application/json");
		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
		System.out.println("API Launch");
	    
	}
	
	@When("^API is Available$")
	public void API_is_Available() throws Throwable {
		responseBody = response.getBody().asString();
		System.out.println("Available");
	   
	}

	@Then("^Validate the Code$")
	public void Validate_the_Code() throws Throwable {
		JsonPath j = response.jsonPath();
		Assert.assertEquals(j.get("base"), "EUR");
		Assert.assertNotNull(responseBody);
	    
	}
	
//Scenario -3
	@Given("^Rates API For Customer$")
	public void Rates_API_For_Customer() throws Throwable {
		response = RestAssured.given().get("https://api.ratesapi.io/api/");
		System.out.println("API Launch");

	}

	@When("^An Incorrect Url$")
	public void An_Incorrect_Url() throws Throwable {
		 System.out.println("incorrect url");
		   JsonPath j = response.jsonPath();
		   Assert.assertEquals(j.get("error"), "time data 'api' does not match format '%Y-%m-%d'");
		  		
	}

	@Then("^Test the response$")
	public void Test_the_response() throws Throwable {
		response=RestAssured.given().get("https://api.ratesapi.io/api/");
		statusCode =response.getStatusCode();
		System.out.println(statusCode);
	   
	}
	
//Scenario - 4
	@Given("^Specific date Foreign Exchange Rates$")
	public void Specific_date_Foreign_Exchange_Rates() throws Throwable {
		Header h = new Header("Accept","Application/json");
		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
		System.out.println("API Launch");
	   
	}

	@When("^The API is Available$")
	public void The_API_is_Available() throws Throwable {
		statusCode = response.getStatusCode();
		System.out.println("Available");
	   
	}

	@Then("^Success Status of the Response$")
	public void Success_Status_of_the_Response() throws Throwable {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200,"Incorrect status code displayed");
		System.out.println("statusCode is Sucess");
		
	}
	
//Scenario - 5
	@Given("^Foreign Exchange rates for API$")
	public void Foreign_Exchange_rates_for_API() throws Throwable {
		Header h = new Header("Accept","Application/json");
		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
		System.out.println("API Launch");
	}

	@When("^The Response is avilable$")
	public void The_Response_is_avilable() throws Throwable {
		statusCode = response.getStatusCode();
		System.out.println(response.getBody().asString());
		System.out.println("Available");
	    
	}

	@Then("^Assert the response$")
	public void Assert_the_response() throws Throwable {
		statusCode =response.getStatusCode();
		System.out.println(statusCode);
	 
	}
	
//Scenario - 6
	@Given("^Latest Foreign Exchange Rates$")
	public void Latest_Foreign_Exchange_Rates() throws Throwable {
		response = RestAssured.given().get("https://api.ratesapi.io/api/");
		System.out.println("API Launch");

	   
	}

	@When("^Future Date Is Provided$")
	public void Future_Date_Is_Provided() throws Throwable {
		response = RestAssured.get("https://api.ratesapi.io/api/2020-12-25");
	    
	}

	@Then("^Matches for the current date$")
	public void Matches_for_the_current_date() throws Throwable {
		response = RestAssured.get("https://api.ratesapi.io/api/2020-10-08");
	  System.out.println("Success");
	  System.out.println(response.getBody().asString());
	  Assert.assertEquals(response.getStatusCode(), 200);
	}
	   
}
