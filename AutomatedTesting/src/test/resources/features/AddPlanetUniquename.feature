Scenario Outline: Add Planet to Planetarium  Unique name Test Case

Validating that Users can add Planets to the Planetarium as long as a Planet with that name does not already exist in the database.

Given	the User is on the <Home Page>	
When	the User enter unique <planet name>	
And	    clicks on Submit button	
And	    the User see <alert message >	
Then	the user verify <planet added or not added> in the list	
And	    the User redirects to <Home Page>	
