Feature: DeleteMoons

    Scenario: Automated Delete Moon Test Case
    Validating that Users can delete Moons from the Planetarium given that the inputted Moon name exists
    in the database and that the User owns the Planet that the given Moon is orbiting.
        #Given the User is on the "<Home Page>"
        Given the User is logged in and on the "http://localhost:8080/planetarium"
        When the User selects "Moon" from the Dropdown
        And inputs "TesterMoon"
        And clicks Delete Button
        Then the User should see an Alert saying "Moon Not Created"
        And should "User stays on Home Page"


