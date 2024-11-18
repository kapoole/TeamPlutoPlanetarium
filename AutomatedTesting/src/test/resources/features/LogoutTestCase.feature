Feature: LogoutAccount

	Scenario Outline: Logout with Existing Account Test Case
	Validating that Users can use the Logout Button on the Home Page to logout and go back to the Login Page.
		Given the User is on the "<Home Page>"
		When the User clicks the Logout Button
		Then the User should redirect to <Login Page>

	Examples: 
		| Home Page     			 | Login Page             |
		| http://localhost:8080/home | http://localhost:8080/ |