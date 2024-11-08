Feature: ViewMoons

    Scenario: Automated View Moons Test Case
    Validating that Users can view Moons that orbit Planets which the User owns on the Home Page in a list.
        Given the User is on the "<Home Page>"
        Then the User should see "<Moons Owned By Planets the User Owns>"