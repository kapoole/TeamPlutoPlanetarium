Feature: LoginExistingAccount

	Scenario Outline: Login with Existing Account Test Case
	Validating that Users can access the Home Page of the Planetarium given that they enter a Username that exists in the database and the correct password associated with their account.
		Given the User is on the "<Login Page>"
		When the User inputs "<Username>"
		And inputs "<Password>"
		And clicks the Login Button
		Then the User should "<Login Result>"
		And should redirect to "<Login Page>"

	Examples: 
		| Username | Password                       | User Created     | Login Result			       | Login Page 	        |
		| Robin    | BatmanAndRobinToTheRescue20202 | User created     | User redirected to login page | http://localhost:8080/ |
		| Batman   | BatmanAndRobinToTheRescue20202 | User not created | User remains on creation page | http://localhost:8080/ |