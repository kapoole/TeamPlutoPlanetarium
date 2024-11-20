Feature: ViewPlanets

  Scenario Outline: Automated View Planets Test Case
    Given the User is logged in and on the <url> as <username> and <password>
    Then the User should see "<Number of Planets>" Planets

    Examples:
      | url                                 | username | password                         | Number of Planets    |
      | "http://localhost:8080/planetarium" | "Batman" | "I am the night"                 | 2                    |
      | "http://localhost:8080/planetarium" | "Robin"  | "BatmanAndRobinToTheRescue20202" | 0                    |