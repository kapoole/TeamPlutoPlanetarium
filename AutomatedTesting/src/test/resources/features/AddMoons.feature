#Feature: AddMoons
#
#    Scenario Outline: Automated Add Moon Test Case
#        Given the User is logged in and on the <url> as <username> and <password>
#        When the User selects Moon from the Dropdown
#        And inputs Moon Name <moonName>
#        And inputs Orbited Planet ID of <orbitedPlanetID>
#        And inputs Image of <imageFile>
#        And clicks the Submit Moon Button
#        Then the User should see <addMoonResult> and <expectedMessage>>
#        Examples:
#            | url                                 | username | password         | moonName    | orbitedPlanetID     | imageFile    | addMoonResult        | expectedMessage |
#            | "http://localhost:8080/planetarium" | "Batman" | "I am the night" | "Io"        | "1"                 | ""           | "Moon Created"       | "Io"            |
