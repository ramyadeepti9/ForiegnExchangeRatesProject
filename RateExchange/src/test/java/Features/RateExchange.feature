Feature: Exhange Rates


	Scenario: Verify for latest foreign Exchanges Rates

	Given Customer have API Foreign Exchange Rates 
	When Customer hit API
	Then the Status code comeas 200
	

	Scenario:
	
	Given  API Foreign Exchange Rates
	When API is Available
	Then Validate the Code
	
	
	Scenario:
	
	Given Rates API For Customer
	When An Incorrect Url
	Then Test the response
	
	
	Scenario:
	 Given Specific date Foreign Exchange Rates
	 When The API is Available
	 Then Success Status of the Response
	 
	 
	 Scenario:
	 Given Foreign Exchange rates for API
	 When The Response is avilable
	 Then Assert the response
	 
	 
	 Scenario:
	 Given Latest Foreign Exchange Rates
	 When Future Date Is Provided
	 Then Matches for the current date
	
	
	
	 