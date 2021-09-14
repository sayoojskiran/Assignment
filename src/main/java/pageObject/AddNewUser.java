package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUser {
	WebDriver driver;

	public AddNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_username")
	WebElement userName;
	
	@FindBy(xpath = "//em[contains(text(),'Click to enter text')]")
	WebElement clickPassword;
	
	@FindBy(id = "id_newpassword")
	WebElement enterPassword;

	@FindBy(id = "id_firstname")
	WebElement firstNameUser;

	@FindBy(id = "id_lastname")
	WebElement lastNameUser;

	@FindBy(id = "id_email")
	WebElement emailUser;

	@FindBy(id = "id_submitbutton")
	WebElement createUser;

	public WebElement getUserName() {
		return userName;
	}
	
	public WebElement getPassword() {
		return clickPassword;
	}
	
	public WebElement enterPassword() {
		return enterPassword;
	}

	public WebElement getFirstName() {
		return firstNameUser;
	}

	public WebElement getLastName() {
		return lastNameUser;
	}

	public WebElement getEmailUser() {
		return emailUser;
	}

	public WebElement createUserButton() {
		return createUser;
	}

}
