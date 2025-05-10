package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement emailAddress;
	
	@FindBy(id = "search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath = "//*[contains(@class, 'dataTable')]")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")	//finding total tableRows
	List<WebElement> tableRows;	//more than one elements so need List
	
	//@FindBy(xpath  = "//*[@id='customers-grid']//tbody/tr[1]/td")	//finding total tableColumns
	//List<WebElement> tableColumns; //more than one elements so need List
	
	@FindBy(id = "SearchFirstName")
	WebElement firstName;
	
	@FindBy(id = "SearchLastName")
	WebElement lastName;
	
	
	
	
	//actions methods to perform for above web elements
	
	public void enterEmailAdd(String email) {
		
		emailAddress.sendKeys(email);
	}
	
	public void clickOnSearchButton() {
		
		searchBtn.click();
	}
	
	public boolean searchCustomerByEmail(String expectedEmail) {
		
		//initially boolean would be false
		boolean found = false;
		
		//total number of rows
		int totalRows = tableRows.size();
		
		
		//iterate all the rows of the grid
		for(int i = 1; i <= totalRows; i++) {	// i = 1 means starting from 2nd row skipping header
			
			WebElement webElementEmail = ldriver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			
			String actualEmailAdd =  webElementEmail.getText();
			
			//verification
			if(actualEmailAdd.equals(expectedEmail)) {
				
				found = true;
			}
			
		}
		
		return found;
	}
	
	//////////////////Search Customer By Name////////////////////////
	
	//action method to enter first name
	public void enterFirstName(String firstNameText) {
		
		firstName.sendKeys(firstNameText);
	}
	
	//action method to enter last name
	public void enterLastName(String lastNameText) {
		
		firstName.sendKeys(lastNameText);
	}
	
	public boolean searchCustomerByName(String name) {
		
		//initially boolean would be false
		boolean found = false;
		
		//total number of rows
		int totalRows = tableRows.size();
		
		
		//iterate all the rows of the grid
		for(int i = 1; i <= totalRows; i++) {	// i = 1 means starting from 2nd row skipping header
			
			WebElement webElementName = ldriver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			
			String actualName =  webElementName.getText();
			
			//verification
			if(actualName.equals(name)) {
				
				found = true;
				break;
			}
			
		}
		
		return found;
	}
	
}
