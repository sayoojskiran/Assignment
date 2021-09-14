package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage {

	WebDriver driver;

	public DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_realname")
	WebElement searchName;

	@FindBy(id = "id_addfilter")
	WebElement addFilter;

	@FindBy(xpath = "//td[a[text()='Sayooj TestUser']]/following-sibling::td/a/img[@title='Delete']") // a[text()='SayoojTestUser'] Doubt here
	WebElement clickDelete;

	@FindBy(xpath = "//input[@type='submit' and @value='Delete']")
	WebElement confirmDelete;

	public WebElement getSearchName() {
		return searchName;
	}

	public WebElement clickAddFilter() {
		return addFilter;
	}

	public WebElement clickDeleteUser() {
		return clickDelete;
	}

	public WebElement confirmDeleteUser() {
		return confirmDelete;
	}

}
