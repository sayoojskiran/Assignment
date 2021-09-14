package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://test.qualicoach.org/user/editadvanced.php?id=-1']")
	WebElement addNewUser;

	@FindBy(xpath = "//a[@href='https://test.qualicoach.org/admin/user.php']")
	WebElement browseUser;
	
	public WebElement clickAddNewUser() {
		return addNewUser;
	}
	
	public WebElement browseUserList() {
		return browseUser;
	}

}
