Feature: Viiv Connect POD testing.

	#Background:
	#	Given User navigates to https://staging.pullthrough.tools/viiv/Login.aspx
		
	Scenario: Verify that user is able to Login with valid credentials
	
		Given User should navigate to "https://www.google.co.in"
		
		When User enter email "rajesh.kondapi@sagarsoft.in" and click on submit
		
		When User fetches the token from email "rajesh.kondapi@sagarsoft.in" and "Krajesh1234!!"		
		
		And User should enter valid token
		
		Then User Clicks on verify button