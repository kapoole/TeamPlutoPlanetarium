Feature: LoginExistingAccount

	Scenario Outline: Login with Existing Account Test Case
	Validating that Users can access the Home Page of the Planetarium given that they enter a Username that exists in the database and the correct password associated with their account.
		Given The user is on the login page at url <Login Page>
		When The user enters the login username "<Username>"
		And The user enters the login password "<Password>"
		And The user clicks the login button
		Then The user should see Login Result "<Login Result>" and "<Expected Message>"
		And The user should redirect to "<Redirect Result>"

	Examples: 
		| Username | Password                       | Login Page 	           | Redirect Result   | Login Result  | Expected Message                       |
		| Robin    | BatmanAndRobinToTheRescue20202 | "http://localhost:8080/" | Planetarium Login | Login Failed  | login attempt failed: please try again |
		| Batman   | I am the night                 | "http://localhost:8080/" | Home              | Login Success | N/A                                    |