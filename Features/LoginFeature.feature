Feature: Login

@sanity 
Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome browser 	
	When User opens URL "http://admin-demo.nopcommerce.com/login"	
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"	
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser

@regression	
Scenario Outline: Successful Login with Valid Credentials DDT
	Given User Launch Chrome browser 	
	When User opens URL "<URL>" 	
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"	
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser

Examples:
|URL|email|password|
|http://admin-demo.nopcommerce.com/login|	admin@yourstore.com | admin |
|http://admin-demo.nopcommerce.com/login|	test@yourstore.com  | admin |

	