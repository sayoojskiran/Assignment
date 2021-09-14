package sush.Admin;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.AddNewUser;
import pageObject.LoginPage;
import pageObject.SearchPage;
import pageObject.UserPage;

public class CreateUser extends BaseClass {

	public static SearchPage searchPage;
	public static Select dropDown;
	public static UserPage userPage;
	public static AddNewUser addNewUser;

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
	public void createUser() {

		users();
		clickAddNewUser();
		createNewUser();

	}

	public static void users() {
		searchPage = new SearchPage(driver);
		searchPage.usersTab().click();
	}

	public static void clickAddNewUser() {
		userPage = new UserPage(driver);
		userPage.clickAddNewUser().click();
	}

	public static void createNewUser() {
		addNewUser = new AddNewUser(driver);
		addNewUser.getUserName().sendKeys(prop.getProperty("userName"));
		addNewUser.getPassword().click();
		addNewUser.enterPassword().sendKeys(prop.getProperty("passWord"));
		addNewUser.getFirstName().sendKeys(prop.getProperty("firstName"));
		addNewUser.getLastName().sendKeys(prop.getProperty("lastName"));
		addNewUser.getEmailUser().sendKeys(prop.getProperty("email"));
		scrollBy(0, 900);
		addNewUser.createUserButton().click();

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
