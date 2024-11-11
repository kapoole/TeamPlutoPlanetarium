Feature: DeletePlanet	
	
    Scenario: Automated Delete Planet Test Case	
    Validating that Planets can be deleted by users no matter if the Planets have any orbiting Moons or not.	
	
        Given the User is on the <Home Page>
        And	the User enter  <planet name>
        When clicks Delete Button
        And	the User see <alert message >
        When the user verify <planet own by User or not  own by User> in the list
        Then the User redirects to <Home Page>
