package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

public WebDriver ldriver;
	
	//constructor
	public AddNewCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	//Find web elements on the Customers web page section
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuItem;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	@FindBy(xpath= "//input[@id = 'Email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//div[@class = 'k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;
	
//	@FindBy(xpath = "//li[contains(text(),'Registered')]")
//	WebElement ListItemRegistered;
	
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	
	@FindBy(id = "Gender_Male")
	WebElement MaleGender;
	
	@FindBy(id = "Gender_Female")
	WebElement FemaleGender;
	
	@FindBy(xpath = "//input[@id = 'FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id = 'LastName']")
	WebElement txtLastName;
	
//	@FindBy(xpath = "//input[@id='DateOfBirth']")
//	WebElement txtDob;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	
	//Action Methods for web elements
	
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		
		lnkCustomers_menu.click();
	}
	
	public void clickOnCustomersMenuItem() {
		
		lnkCustomers_menuItem.click();
	}
	
	public void clickOnAddNew() {
		
		btnAddnew.click();
	}
	
	public void enterEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void enterFirstName(String firstName) {
		
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		
		txtLastName.sendKeys(lastName);
	}
	
//	public void enterDob(String dob) {
//		
//		txtDob.sendKeys(dob);
//	}
	
	public void enterCompanyName(String compName) {
		
		txtCompanyName.sendKeys(compName);
	}
	
	public void enterAdminContent(String content) {
		
		txtAdminContent.sendKeys(content);
	}
	
	public void enterManagerOfVendor(String value) {
		
		Select drop = new Select(dropdownVendorMgr);
		drop.selectByVisibleText(value);
				
	}
	
	public void enterGender(String gender) {
		
		if(gender.equals("Male")) {
			
			MaleGender.click();
		}
		else if (gender.equals("Female")){
			
			FemaleGender.click();
		}
		else {
			
			//set it by default
			MaleGender.click();
		}
		
	}
	
	public void clickOnSave() {
		
		btnSave.click();
	}
	
}
