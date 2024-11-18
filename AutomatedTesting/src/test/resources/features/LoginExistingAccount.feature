Feature: LoginExistingAccount

	Scenario Outline: Login with Existing Account Test Case
	Validating that Users can access the Home Page of the Planetarium given that they enter a Username that exists in the database and the correct password associated with their account.
		Given The user is on the login page at url "<Login Page>"
		When The user enters the login username "<Username>"
		When The user enters the login password "<Password>"
		When The user clicks the login button
		Then An alert should appear saying "<Login Result>"
#		When the User inputs "<Username>"
#		And inputs "<Password>"
#		And clicks the Login Button
#		Then the User should "<Login Result>"
#		And should redirect to "<Login Page>"

	Examples: 
		| Login Page            | Username | Password                       | Login Result		           |
		| http://localhost:8080 | Robin    | BatmanAndRobinToTheRescue20202 | Login successful             |
		| http://localhost:8080 | Batman   | BatmanAndRobinToTheRescue20202 | Invalid username or password |