package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/iamramkdas/eclipse-workspace/Cucumber_Framework/Features/LoginFeature.feature", "/Users/iamramkdas/eclipse-workspace/Cucumber_Framework/Features/Customers.feature"},
		
		//(to run all the feature files)
		
		glue = "StepDefinition",
		
		dryRun = false,	//	to map stepDefinition file with feature file (test will not execute).
		
		monochrome = true,	//to show output in readable format
		
		tags = "@sanity",	//scenarios under @sanity tag will be executed
		
		plugin = {//"pretty", "html:target/cucumber-reports/addNewCustmReport.html", 
				"pretty", "html:target/cucumber-reports/report_html.html"}	//creating html report
		)


public class Run extends AbstractTestNGCucumberTests{

	/* This class will be empty */
}
