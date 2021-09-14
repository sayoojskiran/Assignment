package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentEditProfile {
	
	WebDriver driver;

	public StudentEditProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_lastname")
	WebElement lastnameStudent;
	
	@FindBy(id = "id_submitbutton")
	WebElement submitEditProfile;
	
	public WebElement getLastname() {
		return lastnameStudent;
	}
	
	public WebElement getSubmitButton() {
		return submitEditProfile;
	}

}
