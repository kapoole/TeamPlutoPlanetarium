Feature: ViewMoons

    Scenario Outline: Automated View Moons Test Case
        Given the User is logged in and on the <url> as <username> and <password>
        Then the User should see <string>

        Examples:
            | url                                 | username | password           | string    |
            | "http://localhost:8080/planetarium" | "Batman" | "I am the night"   | "2 Moons" |
            | "http://localhost:8080/planetarium" | "Robin"  | "BatmanAndRobinToTheRescue20202" | "0 Moons" |