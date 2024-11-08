Feature: ViewMoons

    Scenario: Automated Add Moon Test Case
    Validating that Users can add moons to the Planetarium given that the Moon name does not already exists
    in the Planetarium database, that the Orbiting Planet ID does exist in the Planetarium database, that the
    User adding this moons is also the owner of the Orbiting Planet, that the Moon name does not exceed 30 characters,
    that the Moon can be uploaded with or without an image file.
        Given the User is on the <Home Page>"
        When the User selects "<Moon>" from the Dropdown
        And inputs "<Moon Name>"
        And inputs "<Orbited Planet ID>"
        And inputs "<Image File>"
        And clicks the Submit Moon Button
        Then the User should see an Alert saying "<Add Moon Result>"
        And should <stay> on the "<Home Page>"