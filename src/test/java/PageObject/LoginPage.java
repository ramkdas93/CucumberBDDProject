package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver; // local WedDriver

	public LoginPage(WebDriver rDriver) { // Remote WebDriver

		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}

	// to identify all the Web Elements inside Login Page
	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//*[@class = 'button-1 login-button']")
	WebElement LoginBtn;

	//@FindBy(linkText = "Logout") 
	@FindBy(xpath = "//*[text()= 'Logout']")
	WebElement logout;

	// to perform necessary actions on above Web Elements will be done in this page object.

	public void enterEmail(String emailAdd) { // to enter email need a String parameter
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) { // to enter password need a String parameter
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		LoginBtn.click(); // to perform a click action.
	}

	public void clickOnLogOutButton() {
		logout.click(); // to perform a click action.

	}
}
