Feature: AddPlanet

    Scenario: Automated Add Planet Test Case
    Validate the planet added in the Planetarium have not more than 30 characters and should have unique name.Validating that Users are able to add Planets they discover to the Planetarium as long as the name of the Planet they add is not longer than 30 characters long.

        Given the User is on the <Home Page>
        When the User enter new <planet name> with no more than 30 characters	
        And	clicks on Submit button	
        Then the User see <alert message >	
        And	the user verify <planet added or not added> in the list	
        And	the User redirects to <Home Page>	

 