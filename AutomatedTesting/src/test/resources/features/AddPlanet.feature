Feature: AddPlanet

    Scenario Outline: Automated Add Planet Test Case
    Validate the planet added in the Planetarium have not more than 30 characters and should have unique name.Validating that Users are able to add Planets they discover to the Planetarium as long as the name of the Planet they add is not longer than 30 characters long.

        Given the User is on the "<HomePage>"
        When the User enter  "<PlanetName>"
        And clicks on Submit button
        Then the User should see alert "<AddPlanetResult>"
        And the User should Redirect "<AddPlanetRedirect>"

    Examples:
        | HomePage     | PlanetName                  | AddPlanetResult                                | AddPlanetRedirect                        |
        | http://localhost:8080/planetarium   | Jupiter                      | "Planet added successfully."                   | http://localhost:8080/planetarium  |
        | http://localhost:8080/planetarium  | A_Very_Long_Planet_Name_Exceeding_30 | "Error: Planet name cannot exceed characters limit." | http://localhost:8080/planetarium                |
        | http://localhost:8080/planetarium   | Earth                        | "Error: Planet name must be unique."            | http://localhost:8080/planetarium                |
        | http://localhost:8080/planetarium   | Saturn                       | "Planet added successfully."                    | http://localhost:8080/planetarium  |