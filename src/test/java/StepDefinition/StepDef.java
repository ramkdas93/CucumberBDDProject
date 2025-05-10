package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*Child class of BaseClass*/

public class StepDef extends BaseClass{
	
	@BeforeMethod
	public void setup() {
		
		readConfig = new ReadConfig();
		
		//initialize logger
		//log = LogManager.getLogger("StepDef");
		
		System.out.println("setup method exectued");
		
		String browser = readConfig.getBrowser();	//calling getBrowser() method from ReadConfig file.
		
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					driver = new ChromeDriver();
					break;

				case "msedge":
					driver = new EdgeDriver();
					break;

				case "firefox":
					driver = new FirefoxDriver();
					break;
					
				default:
					driver = null;
					break;

				}
		
		//log.info("Setup executed...");
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		// LoginPage initialization from Page Object Class called "LoginPage"
		loginPg = new LoginPage(driver);

		// AddNewCustomerPage initialization
		addNewCustomerPg = new AddNewCustomerPage(driver);

		// SearchCustomerPg initialization
		SearchCustomerPg = new SearchCustomerPage(driver);
		
		//log.info("chrome browser launched");
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		// to open specific url
		driver = new ChromeDriver();
		driver.get(url);
		
		//log.info("url is opened");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {

		// calling the method from Page Object class "LoginPage" to perform action.
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
		
		//log.info("email address and password entered");

	}

	@When("Click on Login")
	public void click_on_login() {

		// calling the method from Page Object class "LoginPage" to perform click
		// action.
		loginPg.clickOnLoginButton();
		
		//log.info("login button is clicked");

	}

	///////////////// Login Feature method/////////////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		SoftAssert softAssert = new SoftAssert();
		// to compare expected vs actual
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			//log.warn("Login feature: Page title is matched");
			
			AssertJUnit.assertTrue(true); // pass

		} else {
			AssertJUnit.assertTrue(false); // fail
			
			//log.warn("Login feature page title isn't matched");

		}			
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		
//intentionally commented out this method to capture failed screenshot.
//to undo uncomment the TRY and CATCH method.		
		
		try {		
			Thread.sleep(2000);
			// again, calling the method from Page Object class "LoginPage"
			loginPg.clickOnLogOutButton();
			
			//log.info("user clicked on logout link");
		}
		catch(Exception e) {
			
			System.err.println("exception " + e.getMessage());

		}
	}

//	@Then("close browser")
//	public void close_browser() {
//
//		// to close the browser
//		driver.close();
//		
//		//log.info("browser closed");
//
//	}

//////////////////////Add new Customer///////////////////	

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		String actualTitle = addNewCustomerPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		// comparing expected vs. actual by SoftAssert
		SoftAssert softAssert = new SoftAssert();

		if (actualTitle.equals(expectedTitle)) {
			
			//log.info("user can view dashboard test passed");

			AssertJUnit.assertTrue(true);
			
		} else {
			
			AssertJUnit.assertTrue(false);
			
			//log.warn("user can view dashboard test failed");

		}

	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {

		try {
			// calling methods from page object class called "AddNewCustomerPage"
			addNewCustomerPg.clickOnCustomerMenu();
			
			//log.info("customer menu clicked");

			Thread.sleep(2000);
			
		} catch (Exception e) {
			
			System.err.println("exception " + e.getMessage());
		}

	}

	@When("User click on Customers Menu Item")
	public void user_click_on_customers_menu_item() {

		try {
			addNewCustomerPg.clickOnCustomersMenuItem();
			
			//log.info("customer menu item clicked");

			Thread.sleep(2000);
			
		} catch (Exception e) {
			System.err.println("exception " + e.getMessage());
		}

	}

	@When("click on Add new button")
	public void click_on_add_new_button() {

		try {
			
			addNewCustomerPg.clickOnAddNew();
			
			//log.info("clicked on add new button");

		} catch (Exception e) {
			
			System.err.println("exception " + e.getMessage());
		}

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		// we need to do verification here using expected vs. actual
		SoftAssert softAssert = new SoftAssert();
		String actualTitle = addNewCustomerPg.getPageTitle();
		String expectTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectTitle)) {
			
			//log.info("user can view add new customer page- passed");

			AssertJUnit.assertTrue(true); // pass
			
		} else {

			AssertJUnit.assertTrue(false); // fail
			
			//log.warn("user can view add new customer page- failed");

		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		try {
			
			//addNewCustomerPg.enterEmail("rkd132@gmail.com");
			addNewCustomerPg.enterEmail(generateEmailId() + "@gmail.com");	//created dynamic email ID
			addNewCustomerPg.enterPassword("test1");
			addNewCustomerPg.enterFirstName("Ram");
			addNewCustomerPg.enterLastName("Das");
			addNewCustomerPg.enterGender("Male");
			addNewCustomerPg.enterCompanyName("MY STUDIO");
			addNewCustomerPg.enterAdminContent("Admin content");
			addNewCustomerPg.enterManagerOfVendor("Vendor 1");
			
			//log.info("customer information entered");
			
		} catch (Exception e) {
			
			System.err.println("exception " + e.getMessage());
		}
	}

	@When("click on Save button")
	public void click_on_save_button() {

		try {

			addNewCustomerPg.clickOnSave();
			
			//log.info("clicked on save button");
			
		} catch (Exception e) {
			
			System.err.println("exception " + e.getMessage());
		}

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		SoftAssert softAssert = new SoftAssert();

		if (bodyTagText.contains(expectedConfirmationMsg)) {

			AssertJUnit.assertTrue(true); // pass
			
			//log.info("user can view confirmation message- passed");
			
		} else {
			
			//log.warn("user can view confirmatoin message- failed");
			
			AssertJUnit.assertTrue(false); // fail	
		}
	}

	///////////////////// Search Customer////////////////////////
	@When("Enter customer Email")
	public void enter_customer_email() {
		try {
			
			SearchCustomerPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
			
			//log.info("Email address entered");
			
		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());
		}
	}

	@When("Click on search button")
	public void click_on_search_button() {

		try {

			SearchCustomerPg.clickOnSearchButton();
			
			//log.info("clicked on search button");
			
			Thread.sleep(2000);
			
		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {

		try {
			// verification
			SoftAssert softAssert = new SoftAssert();
			String expectedEmail = "victoria_victoria@nopCommerce.com";

			if (SearchCustomerPg.searchCustomerByEmail(expectedEmail) == true) {

				AssertJUnit.assertTrue(true);
				
			//	log.info("user should found email in the search table- passed");
				
			} else {
				
				//log.info("user should found email in the search table- failed");

				AssertJUnit.assertTrue(false);
				
			}
		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}
	}

	//////////////////// Search Customer by Name///////////////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {

		try {

			SearchCustomerPg.enterFirstName("Victoria");

		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {

		try {

			SearchCustomerPg.enterLastName("Terces");

		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {

		try {
			// verification
			SoftAssert softAssert = new SoftAssert();
			String expectedName = "Victoria Terces";

			if (SearchCustomerPg.searchCustomerByName(expectedName) == true) {

				AssertJUnit.assertTrue(true);
			} else {
				AssertJUnit.assertTrue(false);
			}
			
		} catch (Exception e) {

			System.err.println("exception " + e.getMessage());

		}

	}
	
	@AfterMethod
	public void teardown(Scenario sc) {
		
		System.out.println("Tear Down method executed");
		
		
		if(sc.isFailed() == true) {
			
			String filePath = System.getProperty("user.dir");
			
			//to capture screenshot using interface called TakesScreenshot
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			
			//call getScreenshotAs() method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//move image file to new destination
			File DestFile = new File(filePath + "/Screenshot/failedScreenshot.png");
			
			try {
				
				//copy file at the destination
				FileUtils.copyFile(SrcFile, DestFile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
			
			
		driver.quit();
	}

}
