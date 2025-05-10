package StepDefinition;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

/*Parent Class*/

public class BaseClass {
	
	/* commonly used functions, methods and variables */
	
	
		// creating a WebDriver Object--> declared public so we can use it in all
		// methods.
		public static WebDriver driver;

		// to use page object class inside Step Definition file, need to create an
		// object of Page Object class called "LoginPage".
		// declared public so we can use it in all methods.
		public LoginPage loginPg;

		// need to create an object Page Object Class called "AddNewCustomerPage"
		public AddNewCustomerPage addNewCustomerPg;

		// need to create an object Page Object Class called "SearchCustomerPage"
		public SearchCustomerPage SearchCustomerPg;
		
		//create an object of Logger class
		//public static Logger log;
		
		//instantiating ReadConfig class
		public ReadConfig readConfig;
		
		// to generate random Email Id
		public String generateEmailId() { 
			
			return (RandomStringUtils.randomAlphabetic(5));
		}
	
	
}
