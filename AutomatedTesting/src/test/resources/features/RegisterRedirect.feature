Feature: AccountRedirect

	Scenario Outline: Users should be redirected to the create account page from the login page
	Validating the create account page is accessed properly from the login page
		Given The user is on the "<Login Page>"
		When the User click the Create Account button
		Then the User should redirect to "<Create Account Page>"

	Examples: 
		| Login Page      		 | Create Account		 		  |
		| http://localhost:8080/ | http://localhost:8080/register |