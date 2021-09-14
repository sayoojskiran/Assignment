package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentProfilePage {
	
	WebDriver driver;

	public StudentProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Edit profile')]")
	WebElement editProfile;
	
	public WebElement getEditProfile() {
		return editProfile;
	}

}
