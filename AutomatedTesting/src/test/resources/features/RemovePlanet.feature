Scenario outline: Users should be able to remove Planets from the Planetarium

Account owner user should be able to remove/delete the planet from the list in the Planetarium

Given	the User is on the <Home Page>	
And	the User enter  <planet name>	
When	clicks Delete Button	
And	the User see <alert message >	
When	the user verify <planet own by User or not  own by User> in the list	
Then	the User redirects to <Home Page>	
