Feature: LogoutAccount

	Scenario Outline: Logout with Existing Account Test Case
	Validating that Users can use the Logout Button on the Home Page to logout and go back to the Login Page.
		Given the User is logged in and on the "<Home Page>" as "<username>" and "<password>"
		When The user clicks the Logout Button
		Then The user should redirect to "<Redirect Result>"

	Examples: 
		| Home Page                         | username  | password       | Redirect Result   |
		| http://localhost:8080/planetarium | Batman    | I am the night | Planetarium Login |