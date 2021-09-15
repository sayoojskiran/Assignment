package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sush.Admin.BaseClass;

public class StudentHomePage extends BaseClass{
	
	WebDriver driver;

	public StudentHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span/img[@class='userpicture defaultuserpic']")
	WebElement photoStudent;
	
	@FindBy(xpath = "//span[@class='menu-action-text' and text()='Profile']")
	WebElement profileStudent;
	
	@FindBy(xpath = "//button[div[text()='Sayooj-Example']]")
	WebElement findCourseStudent;
	
	@FindBy(xpath = "//div[a[p[text()='Sayooj-Course-01']]]")
	WebElement selectCourseStudent;
	
	@FindBy(xpath = "//a[p[text()='Sayooj-Course-01']]")
	WebElement selectHoveredCourse;
	
	
	public WebElement getPhotoStudent() {
		return photoStudent;
	}
	
	public WebElement getProfileStudent() {
		return profileStudent;
	}
	
	public WebElement findCourse() {
		return findCourseStudent;
	}

	public WebElement selectCourse() {
		return selectCourseStudent;
	}
	
	public WebElement selectHoveredCourseStudent() {
		return selectHoveredCourse;
	}

}
