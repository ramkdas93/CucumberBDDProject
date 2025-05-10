package StepDefinition;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{

	@Then("close browser")
	public void close_browser() {

		// to close the browser
		driver.close();
		
		//log.info("browser closed");

	}
}
