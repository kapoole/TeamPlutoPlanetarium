Feature: RegistrationCharacterLimit

	Scenario Outline: User Registration Username/Password 30 character Limit Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a username and password that meet the character limit requirement, and if they don't their account should not be created
		Given the User is on the "<Create Account Page>"
		When the User inputs Registration Username of "<Username>"
		And inputs Registration Password of "<Password>"
		And clicks Create Account Button
		Then the User should see an Create Account Result Alert saying "<Expected Message>"
		And The user should redirect to "<Account Creation Redirect>"

	Examples: 
		| Create Account Page            | Username                        | Password                        | Expected Message                                                            | Account Creation Redirect     |
		| http://localhost:8080/register |                                 |                                 | Account created successfully with username \"\"                               | Planetarium Login             |
		| http://localhost:8080/register |                                 | GordonIsMyHeroForeverGoodMan11  | Account created successfully with username \"\"    	                       | Planetarium Login             |
		| http://localhost:8080/register |                                 | LexLuthorIsSchemingAgainOhNo!!! | Account creation failed with username \"\"   	                               | Account Creation              |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  |                                 | Account created successfully with username \"BatmanAndRobinToTheRescue20202\" | Planetarium Login             |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  | GordonIsMyHeroForeverGoodMan11  | Account created successfully with username \"BatmanAndRobinToTheRescue20202\" | Planetarium Login             |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  | LexLuthorIsSchemingAgainOhNo!!! | Account creation failed with username \"BatmanAndRobinToTheRescue20202\"      | Account Creation              |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 |                                 | Account creation failed with username \"JokerAndRiddlerAreAtItAgain1010\"     | Account Creation              |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 | GordonIsMyHeroForeverGoodMan11  | Account creation failed with username \"JokerAndRiddlerAreAtItAgain1010\"     | Account Creation              |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 | LexLuthorIsSchemingAgainOhNo!!! | Account creation failed with username \"JokerAndRiddlerAreAtItAgain1010\"     | Account Creation              |
