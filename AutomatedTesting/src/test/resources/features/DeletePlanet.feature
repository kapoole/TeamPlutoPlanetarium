Feature: DeletePlanet

    Scenario Outline: Automated Delete Planet Test Case
    Validating that Planets can be deleted by users if they own the Planet no matter if the Planets have any orbiting Moons or not. User should be able to remove Planet with the orbiting Moon associated with the Planet.

        Given the User is logged in and on the <url> as <username> and <password>
        When the User selects Planet from the Dropdown
        And inputs Planet Name <PlanetName>
        And clicks Delete Button
        Then the User should see Delete Planet Result of <DeletePlanetResult> and <ExpectedMessage>
        And should Delete Planet Redirect of <DeletePlanetRedirect>


        # Planet Exists
        Examples:
            | url                                   | username | password         | PlanetName      | DeletePlanetResult  | ExpectedMessage                             | DeletePlanetRedirect      |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Jupiter"       | "Planet Deleted"    | "Mars"                                      | "User stays on Home Page" |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Venus"         | "Alert"             | "Failed to delete Planet with name Venus"   | "User stays on Home Page" |

        # Planet Owned by User
        Examples:
            | url                                   | username | password         | PlanetName      | DeletePlanetResult  | ExpectedMessage                             | DeletePlanetRedirect      |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Jupiter"       | "Planet Deleted"    | "Mars"                                      | "User stays on Home Page" |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Mercury"       | "Alert"             | "Failed to delete Planet with name Mercury" | "User stays on Home Page" |

        # Planet Has Moons
        Examples:
            | url                                   | username | password         | PlanetName      | DeletePlanetResult  | ExpectedMessage                             | DeletePlanetRedirect      |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Jupiter"       | "Planet Deleted"    | "Mars"                                      | "User stays on Home Page" |
            | "http://localhost:8080/planetarium"   | "Batman" | "I am the night" | "Mars"          | "Planet Deleted"    | "Mars"                                      | "User stays on Home Page" |