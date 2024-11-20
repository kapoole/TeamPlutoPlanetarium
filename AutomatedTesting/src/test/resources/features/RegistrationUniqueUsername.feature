Feature: RegistrationUniqueUsername

	Scenario Outline: Automated User Registration Unique Username Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a valid password and a unique username, and if the username is not unique their account should not be created
		Given the User is on the "<Create Account Page>"
		When the User inputs Registration Username of "<Username>"
		And inputs Registration Password of "<Password>"
		And clicks Create Account Button
		Then the User should see an Create Account Result Alert saying "<Expected Message>"
		And The user should redirect to "<Account Creation Redirect>"

	Examples:
		| Create Account Page            | Username   | Password                        | Expected Message                                                            | Account Creation Redirect     |
		| http://localhost:8080/register | Robin      | BatmanAndRobinToTheRescue20202  | Account created successfully with username \"\"                               | Planetarium Login             |
		| http://localhost:8080/register | Batman     | BatmanAndRobinToTheRescue20202  | Account created successfully with username \"\"    	                       | Planetarium Login             |
