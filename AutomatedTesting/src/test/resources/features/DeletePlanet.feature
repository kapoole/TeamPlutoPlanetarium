Feature: DeletePlanet

    Scenario Outline: Automated Delete Planet Test Case
    Validating that Planets can be deleted by users if they own the Planet no matter if the Planets have any orbiting Moons or not. User should be able to remove Planet with the orbiting Moon associated with the Planet.

        Given the User is on the "<HomePage>"
        When the User enter unique "<PlanetName>"
        And clicks Delete Button
        Then the User should see delete planet alert "<DeletePlanetResult>"
        And the User should stay in homepage "<DeletePlanetRedirect>"

    Examples:
        | HomePage     | PlanetName   | DeletePlanetResult                          | DeletePlanetRedirect                    |
        | http://localhost:8080/planetarium   | Mars          | "Planet deleted successfully."               | http://localhost:8080/planetarium |
        | http://localhost:8080/planetarium   | Venus         | "Error: You do not have permission to delete this planet." | http://localhost:8080/planetarium           |
        | http://localhost:8080/planetarium  | Jupiter       | "Planet deleted successfully."              | http://localhost:8080/planetarium |
        | http://localhost:8080/planetarium   | Saturn | "Planet deleted successfully." | http://localhost:8080/planetarium |
