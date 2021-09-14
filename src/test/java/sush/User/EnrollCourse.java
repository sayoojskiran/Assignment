package sush.User;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.StudentCoursePage;
import pageObject.StudentHomePage;
import sush.Admin.BaseClass;

public class EnrollCourse extends BaseClass {
	
	public static StudentHomePage stdHome;
	public static StudentCoursePage stdEnroll;

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		driver.get(prop.getProperty("studentUrl"));
	}

	@Test(priority = 1)
	public void checkLogin() {
		String actultitle = driver.getTitle();
		String searchPageTitle = "Qualicoach: Administration: Search";
		if (!(actultitle.equalsIgnoreCase(searchPageTitle))) {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.getUsername().sendKeys(prop.getProperty("studentUsername"));
			loginPage.getPassword().sendKeys(prop.getProperty("studentPass"));
			loginPage.loginBtn().click();
		}
	}

	@Test(priority = 2)
	public void enroll() throws InterruptedException {

		scrollBy(0, 1500);
		getToCourse();
		enrollAndAttempt();
		

	}
	
	public static void getToCourse() throws InterruptedException {
		stdHome = new StudentHomePage(driver);
		stdHome.findCourse().click();
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.moveToElement(stdHome.selectCourse()).build().perform();
		Thread.sleep(3000);
		stdHome.selectHoveredCourseStudent().click();
		
	}
	
	public static void enrollAndAttempt() throws InterruptedException {
		stdEnroll = new StudentCoursePage(driver);
		stdEnroll.enrollCourseButton().click();
		stdEnroll.selectQuizStudent().click();
		stdEnroll.attemtQuizStudent().click();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
