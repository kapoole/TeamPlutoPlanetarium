Feature: RegistrationCharacterLimit

	Scenario Outline: User Registration Username/Password 30 character Limit Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a username and password that meet the character limit requirement, and if they don't their account should not be created
		Given the User is on the "<Create Account Page>"
		When the User inputs "<Username>"
		And inputs "<Password>"
		And clicks Create Account Button
		Then the User should see an Alert saying "<Account Creation Result>"
		And should "<Account Creation Redirect>"

	Examples: 
		| Create Account Page            | Username                        | Password                        | Account Creation Result | Account Creation Redirect     |
		| http://localhost:8080/register | (no values)                     | (no value)                      | User created            | User redirected to login page |
		| http://localhost:8080/register | (no values)                     | GordonIsMyHeroForeverGoodMan11  | User created       	   | User redirected to login page |
		| http://localhost:8080/register | (no values)                     | LexLuthorIsSchemingAgainOhNo!!! | User not created    	   | User remains on creation page |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  | (no value)                      | User created        	   | User redirected to login page |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  | GordonIsMyHeroForeverGoodMan11  | User created        	   | User redirected to login page |
		| http://localhost:8080/register | BatmanAndRobinToTheRescue20202  | LexLuthorIsSchemingAgainOhNo!!! | User not created        | User remains on creation page |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 | (no value)                      | User not created        | User remains on creation page |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 | GordonIsMyHeroForeverGoodMan11  | User not created        | User remains on creation page |
		| http://localhost:8080/register | JokerAndRiddlerAreAtItAgain1010 | LexLuthorIsSchemingAgainOhNo!!! | User not created        | User remains on creation page |
