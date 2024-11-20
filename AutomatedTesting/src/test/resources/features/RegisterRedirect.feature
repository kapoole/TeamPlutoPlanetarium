Feature: AccountRedirect

	Scenario Outline: Users should be redirected to the create account page from the login page
	Validating the create account page is accessed properly from the login page

		Given The user is on the login page at url "<Login Page>"
		When the User click the Create Account button
		Then The user should redirect to "<Redirect Result>"

	Examples: 
		| Login Page      		 | Redirect Result	 |
		| http://localhost:8080/ | Account Creation  |