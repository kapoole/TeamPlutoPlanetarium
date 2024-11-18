Feature: DeleteMoons

    Scenario Outline: Automated Delete Moon Test Case
        Given the User is logged in and on the <url> as <username> and <password>
        When the User selects Moon from the Dropdown
        And inputs <moonName>
        And clicks Delete Button
        Then the User should see <deleteMoonResult> and <expectedMessage>
        And should <redirectionResult>

        Examples:
            | url                                 | username | password         | moonName     | deleteMoonResult        | expectedMessage                              | redirectionResult         |
            | "http://localhost:8080/planetarium" | "Batman" | "I am the night" | "TesterMoon" | "Alert"                 | "Failed to delete moon with name TesterMoon" | "User stays on Home Page" |
            | "http://localhost:8080/planetarium" | "Batman" | "I am the night" | "Luna"       | "Moon Deleted"          | "M/A"                                        | "User stays on Home Page"            |

        Examples:
            | url                                 | username | password                         | moonName     | deleteMoonResult        | expectedMessage                              | redirectionResult         |
            | "http://localhost:8080/planetarium" | "Batman" | "I am the night"  | "Titan"      | "Alert"                 | "Failed to delete moon with name TesterMoon" | "User stays on Home Page" |
            | "http://localhost:8080/planetarium" | "Batman"  | "I am the night"                | "Titan"      | "Moon Deleted"          | "N/A"                                        | "User stays on Home Page" |




