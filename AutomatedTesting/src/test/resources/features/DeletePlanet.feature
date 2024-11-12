Feature: DeletePlanet

    Scenario: Automated Delete Planet Test Case
    Validating that Planets can be deleted by users if they own the Planet no matter if the Planets have any orbiting Moons or not. User should be able to remove Planet with the orbiting Moon associated with the Planet.

        Given the User is on the "<Home Page>"
        When the User enter "<Planet Name>"
        And clicks Delete Button
        Then the User should see alert "<Add Planet Result>"
        And the User should  "<Delete Planet Redirect>"
