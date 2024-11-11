Scenario Outline: Add Planet  30 character Limit Requirement Test Case

user should be able to add a new planet to the Planetarium But the Planet Name field should have a maximum character limit of 30
So that planet names are concise and fit well within the display

Given	the User is on the <Home Page>	
When	the User enter <planet name> with no more than 30 characters	
And	    clicks on Submit button	
Then	the User see <alert message >	
And	    the user verify <planet added or not added> in the list	
And	    the User redirects to <Home Page>	
		
