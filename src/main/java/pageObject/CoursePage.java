package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
	WebDriver driver;

	public CoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://test.qualicoach.org/course/management.php']") //div[@class='span9']//a[contains(text(),'Manage courses and categories')]
	WebElement manageCC;

	public WebElement manageCourseCategory() {
		return manageCC;
	}

}
