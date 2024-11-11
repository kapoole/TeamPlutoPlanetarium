Scenario outline: Delete Planet from Planetarium Does Planet Have Moons Test Case

Validating that Planets can be deleted by users no matter if the Planets have any orbiting Moons or not.

Given	the User is on the <Home Page>	
And	    the <User> <Owns> <Planet>	
And	    the <Planet> <Owns> <Moons>	
When	the User selects Planet in dropdown	
When	the User inputs <Planet>	
And	    clicks Delete Button	
Then	the <Planet> should be <Deleted>	
And	    the <Moons> Owned by Planet should be <Deleted>	
And	    the User <stays on> the <Home Page>	
