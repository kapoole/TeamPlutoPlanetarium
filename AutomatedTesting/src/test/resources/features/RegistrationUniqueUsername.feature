Feature: RegistrationUniqueUsername

	Scenario Outline: Automated User Registration Unique Username Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a valid password and a unique username, and if the username is not unique their account should not be created
		Given the User is on the "<Create Account Page>"
		When the User enters unique <Username>
		And the User enter valid <Password>
		And the User clicks on Create Account button
		Then the User should be given alert "<Account Creation Result>"
		And should "<User Creation Redirect>"

	Examples: 
		| Create Account Page            | Username | Password                       | Account Creation Result | Account Creation Redirect     |
		| http://localhost:8080/register | Robin    | BatmanAndRobinToTheRescue20202 | User created     	   | User redirected to login page |
		| http://localhost:8080/register | Batman   | BatmanAndRobinToTheRescue20202 | User not created 	   | User remains on creation page |