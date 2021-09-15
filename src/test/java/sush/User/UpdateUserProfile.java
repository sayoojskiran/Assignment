package sush.User;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.StudentEditProfile;
import pageObject.StudentHomePage;
import pageObject.StudentProfilePage;
import sush.Admin.BaseClass;

public class UpdateUserProfile extends BaseClass {

	public static StudentHomePage stdHome;
	public static StudentProfilePage stdProfile;
	public static StudentEditProfile stdEdit;

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		driver.get(prop.getProperty("studentUrl"));
	}

	@Test(priority = 1)
	public void checkLogin() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsername().sendKeys(prop.getProperty("studentUsername"));
		loginPage.getPassword().sendKeys(prop.getProperty("studentPass"));
		loginPage.loginBtn().click();

	}

	@Test(priority = 2)
	public void updateProfile() {

		clickProfileUser();
		clickEditProfile();
		editProfileStudent();

	}

	public static void clickProfileUser() {
		stdHome = new StudentHomePage(driver);
		stdHome.getPhotoStudent().click();
		stdHome.getProfileStudent().click();
	}

	public static void clickEditProfile() {
		stdProfile = new StudentProfilePage(driver);
		stdProfile.getEditProfile().click();

	}

	public static void editProfileStudent() {
		stdEdit = new StudentEditProfile(driver);
		stdEdit.getLastname().clear();
		stdEdit.getLastname().sendKeys("User1");
		stdEdit.getSubmitButton().click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
