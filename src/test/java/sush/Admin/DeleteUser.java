package sush.Admin;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.DeleteUserPage;
import pageObject.LoginPage;
import pageObject.SearchPage;
import pageObject.UserPage;

public class DeleteUser extends BaseClass {

	public static SearchPage searchPage;
	public static Select dropDown;
	public static UserPage userPage;
	public static DeleteUserPage deleteUserPage;

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		driver.get(prop.getProperty("adminUrl"));
	}

	@Test(priority = 1)
	public void checkLogin() {
		String actultitle = driver.getTitle();
		String searchPageTitle = "Qualicoach: Administration: Search";
		if (!(actultitle.equalsIgnoreCase(searchPageTitle))) {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.getUsername().sendKeys(prop.getProperty("adminUsername"));
			loginPage.getPassword().sendKeys(prop.getProperty("adminPswd"));
			loginPage.loginBtn().click();
		}
	}

	@Test(priority = 2)
	public void deleteUser() {

		users();
		clickBrowseUser();
		deleteSearchUser();

	}

	public static void users() {
		searchPage = new SearchPage(driver);
		searchPage.usersTab().click();
	}

	public static void clickBrowseUser() {
		userPage = new UserPage(driver);
		userPage.browseUserList().click();
	}

	public static void deleteSearchUser() {
		deleteUserPage = new DeleteUserPage(driver);
		deleteUserPage.getSearchName().sendKeys(prop.getProperty("nameToDelete"));
		deleteUserPage.clickAddFilter().click();
		deleteUserPage.clickDeleteUser().click();
		deleteUserPage.confirmDeleteUser().click();

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
