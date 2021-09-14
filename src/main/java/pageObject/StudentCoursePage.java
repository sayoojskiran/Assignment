package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentCoursePage {

	WebDriver driver;

	public StudentCoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_submitbutton")
	WebElement enrollCourseStudent;
	
	@FindBy(xpath = "//span[contains(text(),'Sayooj-Eg-Quiz-01')]")
	WebElement selectQuiz;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement attemtQuiz;
	
	public WebElement enrollCourseButton() {
		return enrollCourseStudent;
	}
	
	public WebElement selectQuizStudent() {
		return selectQuiz;
	}
	
	public WebElement attemtQuizStudent() {
		return attemtQuiz;
	}
}
